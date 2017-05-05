package de.lieleisoft.chemievolumetrie;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import de.lieleisoft.chemievolumetrie.R;

public class EinwaageActivity extends Activity  implements OnFocusChangeListener  {
	
	int intRoutineID; /* Globale Variable! */
	
	/** wird ausgef�hrt, wenn Activicty erstellt wird */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.einwaage);       

	    EditText et;

    	// Activity registrieren, damit sie sp�ter an zentraler Stelle (Hauptmenue) geschlossen werden kann
	    ActivityRegistry.register(this);
	    
		// Eingabefelder mit Listener verbinden
    	for (int intFeldNr=1; intFeldNr<=7; intFeldNr++) {
    		int resId = getResources().getIdentifier("Einwaage_"+(intFeldNr), "id", getPackageName());
		    et = (EditText) findViewById(resId);
	        et.setOnFocusChangeListener(this);
	        
    	}
    	
        et = (EditText) findViewById(R.id.Einwaage_9);
        et.setOnFocusChangeListener(this);
        et.requestFocus();		// Cursor in erstes Eingabefeld setzen 
        
	} // onCreate

	/** wird ausgef�hrt, wenn Activicty angezeigt wird */
	@Override
	public void onResume() {
		super.onResume();
		
    	EditText et;
    	TextView tv;
    	String strEinwaage;
    	int resId;	
    	int intVisible;
	    
		// Werte aus Konfigurationsdatei ("Preferences") auslesen und in Arrays eintragen
   		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());		

   		// Hier wird das Eingabefeld in der EinwaageActivity ausgelesen
   		// Routine = Name der Variable, 1 wird gesetzt falls keine Vorgabe	    			    	
   		String strRoutineID = prefs.getString("Routine", "1");

   		intRoutineID = Integer.parseInt(strRoutineID);
   		
    	// ***********************************************************************
	    // Hier wird gepr�ft, welcher Button in der Activity Inhalt gedr�ckt wurde.
    	// ***********************************************************************
		
		tv = (TextView) findViewById(R.id.tvUrtiter);
		et = (EditText) findViewById(R.id.Einwaage_9);		
		
       	if (intRoutineID == 1) 
       	{
       		intVisible = View.VISIBLE;
        	tv.setText(R.string.Gehalt_Urtiter);
        	et.setHint(R.string.Urtiter);
    	}       	
       	else
       	{
       		intVisible = View.GONE;
       	}

    	et.setVisibility(intVisible); 
    	tv.setVisibility(intVisible);       	
    	  	 
	    for (int x=1; x<=9; x++)
	    {
	   		strEinwaage = prefs.getString("Einwaage_"+x, "0");
	    	
	   		if (strEinwaage.equals("0") == false)
	   		{
	    		resId = getResources().getIdentifier("Einwaage_"+x, "id", getPackageName());
	           	et = (EditText) findViewById(resId);
	           	
	    		et.setText(strEinwaage);
	   		}
	    } 
	} // onResume

	/** wird ausgef�hrt, wenn zu einer anderen Activicty gewechselt wird */
	@Override
	public void onPause() {
		super.onPause();

    	EditText et;
    	String Eingabetext;
		
	    // Inhalt der Eingabefelder "Einwaage_xx" wird in Konfigurationsdatei ("Preferences") gespeichert

       	// Zugang zur Konfigurationsdatei ("Preferences") herstellen
   		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
   		SharedPreferences.Editor prefEditor = prefs.edit();
       	
	    for (int x=1; x<=9; x++)
	    {
    		int resId = getResources().getIdentifier("Einwaage_"+x, "id", getPackageName());
           	et = (EditText) findViewById(resId);
           	
           	
    	    Eingabetext = et.getText().toString();
           	if (Eingabetext.equals("") == true) {
           		Eingabetext = "0";
           	}  	           	
       		prefEditor.putString("Einwaage_"+x, Eingabetext);
	    }
	    prefEditor.apply();	    		
	} // onPause
	
    // Implement the onFocusChange callback
	// Felder einblenden
    public void onFocusChange(View v, boolean hasFocus) {
    	EditText et;
    	TextView tv;
		int CurrentID = v.getId();
		switch (CurrentID) {
		case R.id.Einwaage_1:
	    	et = (EditText) findViewById(R.id.Einwaage_2);
			et.setVisibility(View.VISIBLE);
	    	tv = (TextView) findViewById(R.id.tvEW2);
			tv.setVisibility(View.VISIBLE);
			break;
		case R.id.Einwaage_2:			
			et = (EditText) findViewById(R.id.Einwaage_3);
			et.setVisibility(View.VISIBLE);
	    	tv = (TextView) findViewById(R.id.tvEW3);
			tv.setVisibility(View.VISIBLE);
			break;
		case R.id.Einwaage_3:			
	    	et = (EditText) findViewById(R.id.Einwaage_4);
			et.setVisibility(View.VISIBLE);
	    	tv = (TextView) findViewById(R.id.tvEW4);
			tv.setVisibility(View.VISIBLE);
			break;
		case R.id.Einwaage_4:			
	    	et = (EditText) findViewById(R.id.Einwaage_5);
			et.setVisibility(View.VISIBLE);
	    	tv = (TextView) findViewById(R.id.tvEW5);
			tv.setVisibility(View.VISIBLE);
			break;
		case R.id.Einwaage_5:			
	    	et = (EditText) findViewById(R.id.Einwaage_6);
			et.setVisibility(View.VISIBLE);
	    	tv = (TextView) findViewById(R.id.tvEW6);
			tv.setVisibility(View.VISIBLE);
			break;
		case R.id.Einwaage_6:			
	    	et = (EditText) findViewById(R.id.Einwaage_7);
			et.setVisibility(View.VISIBLE);
	    	tv = (TextView) findViewById(R.id.tvEW7);
			tv.setVisibility(View.VISIBLE);
			break;
		case R.id.Einwaage_7:			
	    	et = (EditText) findViewById(R.id.Einwaage_8);
			et.setVisibility(View.VISIBLE);
	    	tv = (TextView) findViewById(R.id.tvEW8);
			tv.setVisibility(View.VISIBLE);
			break;
		case R.id.Einwaage_9:
			if ((hasFocus == false) && (intRoutineID == 1))
			{
				String Eingabetext;

	       		et = (EditText) findViewById(R.id.Einwaage_9);
			    Eingabetext = et.getText().toString();
		       	if (Eingabetext.equals("") == true)
		       	{
	    	       	// Hier wird der Urtiter auf 100 gesetzt oder der Titer auf 1.0000, wenn er nicht eingegeben wird
	    	      
		       		et.setText("100");
		       			
		       		// **************************************       		
		       		// *** Hier wird ein Toast ausgegeben ***
		       		// ************************************** 		       		
		       		String text = "\n   Der Gehalt vom Urtiter   \n   wurde auf 100% gesetzt!   \n"; 
		       		Toast Meldung = Toast.makeText(this, text, Toast.LENGTH_SHORT);
		       		Meldung.setGravity(Gravity.TOP, 0, 0);
		       		Meldung.show();
		       	} // if (Eingabetext.equals("") == true)  	           					
			} // if (hasFocus == false) 
			break;
		}		
    } // onFocusChange
    
	@SuppressWarnings("static-access")
	
	
	
	// ******************************************************************************************
	// ******************* Button Weiter ********************************************************
	// ******************************************************************************************

	
	
	public void btnWeiter(View v) {
    	EditText et;
    	String Eingabetext;
    	boolean Eingabe_OK;
    	
    	Eingabe_OK = true;
    	
		// Cursor in erstes Eingabefeld setzen und numerische Tastatur einschalten 
	    et = (EditText) findViewById(R.id.Einwaage_1);
		et.requestFocus();
		InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.showSoftInput(et, InputMethodManager.SHOW_FORCED);

       	if (Eingabe_OK == true) 
       	{		    	
        	// Hier wird gepr�ft, ob in dem ersten Einwaage Eingabefeld (Einwaage 1) ein Wert steht
    		
           	et = (EditText) findViewById(R.id.Einwaage_1);  
    	    Eingabetext = et.getText().toString();
           	if (Eingabetext.equals("") == true) 
           	{
           		// **************************************       		
           		// *** Hier wird ein Toast ausgegeben ***
           		// **************************************        		
           		String text = "\n   Bitte Einwaage eingeben!   \n"; 
           		Toast Meldung = Toast.makeText(this, text, Toast.LENGTH_LONG);
           		Meldung.setGravity(Gravity.TOP, 0, 0);
           		Meldung.show();
           		et.requestFocus();
           		Eingabe_OK = false;
           	}
       	}
       	
       	if (Eingabe_OK == true) 
       	{		    	
        	// Hier wird gepr�ft, ob in irgendeiner Eingabe eine "0" steht    		
    	    for (int intEW=1; intEW<=9; intEW++)
    	    {    	    	
    			// Id wird ermittelt
    			int resId = getResources().getIdentifier("Einwaage_"+intEW, "id", getPackageName());
    					
    			// Das Feld der Objektvariable wird �ber die Id gesucht
    	    	et = (EditText) findViewById(resId);  

    	    	if (et.VISIBLE == View.VISIBLE) 
    	    	{
    	    		Eingabetext = et.getText().toString();
        	    	if (Eingabetext.equals("0") == true) 
	    	    	{
	    	    		// **************************************       		
	    	    		// *** Hier wird ein Toast ausgegeben ***
	    	    		// **************************************        		
	    	    		String text = "\n   Bitte keine 0 eingeben!   \n"; 
	    	    		Toast Meldung = Toast.makeText(this, text, Toast.LENGTH_LONG);
	    	    		Meldung.setGravity(Gravity.TOP, 0, 0);
	    	    		Meldung.show();
	    	    		et.requestFocus();
	    	       		Eingabe_OK = false;
	    	    		break;
	    	    	}
    	    	}
           	}
       	}

	    if (Eingabe_OK == true) 
       	{		    	 
	   		switch (intRoutineID)
	   		{
	   		// ********* kein Aufruf der VorlageActivity ***********
	   		case 1:
	   		case 2:
	   		case 3:
	   		case 41:
	   		case 42:			
		    	Intent myIntent = new Intent(this, TiterEingabenActivity.class);
	       		myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
	       		startActivity(myIntent);
	       		break;
	       	// ********* Aufruf der VorlageActivity ***********
	   		case 43:			
	   		case 44:			
	   		case 45:			
	   		case 46:
	   		case 47:			
	   		case 48:
	   		case 49:			
	   		case 50:
	   		case 51:			
	   		case 52:
	   		case 53:			
	   		case 54:	
		    	myIntent = new Intent(this, VolumetrieVorlageActivity.class);
	       		myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
	       		startActivity(myIntent);
	       		break;
	   		}
       	} 
    } // btnWeiter
	
	
    // Eingabefelder zur�cksetzen
    public void btnClear(View v) {
    	EditText et;
    	TextView tv;
    	 
    	for (int x=1; x<=9; x++)
    	{  
	    	int resId = getResources().getIdentifier("Einwaage_"+(x), "id", getPackageName());
	    	et = (EditText) findViewById(resId);
	    	et.setText("");
    	}
    	for (int x=1; x<=9; x++)
    	{  
	    	int resId = getResources().getIdentifier("Einwaage_"+(x), "id", getPackageName());
	    	et = (EditText) findViewById(resId);
	    	et.setText("");
    	}

		// vorerst nicht ben�tigte Eingabefelder wieder ausblenden		
		if(intRoutineID == 1)
		{
	    	for (int intFeldNr=2; intFeldNr<=8; intFeldNr++)
	    	{
				// Cursor in erstes Eingabefeld setzen und numerische Tastatur einschalten 
		    	et = (EditText) findViewById(R.id.Einwaage_9);
				et.requestFocus();
				InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.showSoftInput(et, InputMethodManager.SHOW_FORCED);
	    		
	    		int resId = getResources().getIdentifier("Einwaage_"+(intFeldNr), "id", getPackageName());
			    et = (EditText) findViewById(resId);
		        et.setVisibility(View.INVISIBLE);
	    		int resId2 = getResources().getIdentifier("tvEW"+(intFeldNr), "id", getPackageName());
			    tv = (TextView) findViewById(resId2);
				tv.setVisibility(View.INVISIBLE);
	    	} 
		}
		else // (intRoutineID == 3)
		{
	    	for (int intFeldNr=3; intFeldNr<=8; intFeldNr++)
	    	{
				// Cursor in erstes Eingabefeld setzen und numerische Tastatur einschalten 
		    	et = (EditText) findViewById(R.id.Einwaage_1);
				et.requestFocus();
				InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.showSoftInput(et, InputMethodManager.SHOW_FORCED);
				
	    		int resId = getResources().getIdentifier("Einwaage_"+(intFeldNr), "id", getPackageName());
			    et = (EditText) findViewById(resId);
		        et.setVisibility(View.INVISIBLE);
	    		int resId2 = getResources().getIdentifier("tvEW"+(intFeldNr), "id", getPackageName());
			    tv = (TextView) findViewById(resId2);
				tv.setVisibility(View.INVISIBLE);
	    	} 
		}
} // btnClear
	
	/********************************************
	 ************** Menue Button ****************
	 ********************************************/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu3, menu);
        return true;
    }   
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	Intent intent = null;
    	
    	// Tastatur ausblenden
    	InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
    	imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
    	    	
        switch (item.getItemId()) 
        {
        	case R.id.menu_Einstellungen:
           		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
           		SharedPreferences.Editor prefEditor = prefs.edit();
           		prefEditor.putString("Einstellungen", "99");
           		prefEditor.apply();
            	intent = new Intent(this, EinstellungenActivity.class);
            	intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            	startActivity(intent);
                return true;
             
            case R.id.menu_Hilfe:
            	intent = new Intent(this, HilfeActivity.class);
            	intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            	intent.putExtra("Kapitel", "Einwaage");
            	startActivity(intent);
                return true;
                
            case R.id.menu_Impressum:
            	intent = new Intent(this, ImpressumActivity.class);
            	intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            	startActivity(intent);
                return true;
                
            case R.id.menu_Menue:
            	ActivityRegistry.finishAll();
            	intent = new Intent(this, HauptmenueActivity.class);
            	intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            	startActivity(intent);
                return true;
                
            case R.id.menu_Aus:	
                ActivityRegistry.finishAll();
                finish(); 
                System.exit(0);
                
            default:
                return super.onOptionsItemSelected(item);
        }
    }     
} // class EinwaageActivity

