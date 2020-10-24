package de.lieleisoft.chemievolumetrie;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import de.lieleisoft.chemievolumetrie.R;

public class VolumetrieBWActivity extends Activity implements OnFocusChangeListener{
	/** wird ausgeführt, wenn Activicty erstellt wird */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.volumetriebw);

		// Activity registrieren, damit sie später an zentraler Stelle (Hauptmenue) geschlossen werden kann
	    ActivityRegistry.register(this);
	    
	    EditText et;
	    
		// Eingabefelder mit Listener verbinden
    	for (int intFeldNr=1; intFeldNr<=7; intFeldNr++)
    	{
    		int resId = getResources().getIdentifier("BW_"+(intFeldNr), "id", getPackageName());
		    et = (EditText) findViewById(resId);
	        et.setOnFocusChangeListener(this);
    	}  
	} // onCreate

	/** wird ausgeführt, wenn Activicty angezeigt wird */
	@Override
	public void onResume() {
		super.onResume();
		
    	EditText et;
    	String strBW;
    	int resId;
    	
    	// Werte aus Konfigurationsdatei ("Preferences") auslesen
    	SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());		
		    
	    for (int x=1; x<=8; x++)
	    {
	   		strBW = prefs.getString("BW_"+x, "null");
	    	
	   		if (strBW.equals("null") == false)
	   		{   			
	    		resId = getResources().getIdentifier("BW_"+x, "id", getPackageName());
	           	et = (EditText) findViewById(resId);
	    		et.setText(strBW);
	   		}
	    }
	    
	   	// Cursor in drittes Eingabefeld setzen, bei Auswahl Titer
   	   	et = (EditText) findViewById(R.id.BW_2);
   	   	et.requestFocus();
   		   	
    	// Numerische Tastatur einschalten
	    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.showSoftInput(et, InputMethodManager.SHOW_FORCED); 
		
	} // onResume

	/** wird ausgeführt, wenn zu einer anderen Activicty gewechselt wird */
	@Override
	public void onPause() {
		super.onPause();
		
    	EditText et;
    	String Eingabetext;

	    // Inhalt der Eingabefelder "BW_xx" wird in Konfigurationsdatei ("Preferences") gespeichert

       	// Zugang zur Konfigurationsdatei ("Preferences") herstellen
   		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
   		SharedPreferences.Editor prefEditor = prefs.edit();
       	
	    for (int x=1; x<=8; x++)
	    {
    		int resId = getResources().getIdentifier("BW_"+x, "id", getPackageName());
           	et = (EditText) findViewById(resId);
    	    Eingabetext = et.getText().toString();
           	if (Eingabetext.equals("") == true) {
           		Eingabetext = "null";
           	}  	 
       		prefEditor.putString("BW_"+x, Eingabetext);
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
		case R.id.BW_1:
	    	tv = (TextView) findViewById(R.id.tvVBBW2);
			tv.setVisibility(View.VISIBLE);
	    	et = (EditText) findViewById(R.id.BW_2);
			et.setVisibility(View.VISIBLE);
			break;
		case R.id.BW_2:	
	    	tv = (TextView) findViewById(R.id.tvVBBW3);
			tv.setVisibility(View.VISIBLE);
	    	et = (EditText) findViewById(R.id.BW_3);
			et.setVisibility(View.VISIBLE);
			break;
		case R.id.BW_3:		
	    	tv = (TextView) findViewById(R.id.tvVBBW4);
			tv.setVisibility(View.VISIBLE);
	    	et = (EditText) findViewById(R.id.BW_4);
			et.setVisibility(View.VISIBLE);
			break;
		case R.id.BW_4:	
	    	tv = (TextView) findViewById(R.id.tvVBBW5);
			tv.setVisibility(View.VISIBLE);
	    	et = (EditText) findViewById(R.id.BW_5);
			et.setVisibility(View.VISIBLE);
			break;
		case R.id.BW_5:	
	    	tv = (TextView) findViewById(R.id.tvVBBW6);
			tv.setVisibility(View.VISIBLE);
	    	et = (EditText) findViewById(R.id.BW_6);
			et.setVisibility(View.VISIBLE);
			break;
		case R.id.BW_6:		
	    	tv = (TextView) findViewById(R.id.tvVBBW7);
			tv.setVisibility(View.VISIBLE);
	    	et = (EditText) findViewById(R.id.BW_7);
			et.setVisibility(View.VISIBLE);
			break;
		case R.id.BW_7:		
	    	tv = (TextView) findViewById(R.id.tvVBBW8);
			tv.setVisibility(View.VISIBLE);
	    	et = (EditText) findViewById(R.id.BW_8);
			et.setVisibility(View.VISIBLE);
			break;
		}
    } // onFocusChange
	
	// ****************************
	// *** zur Proben-Titration ***
	// ****************************
	
	public void btnWeiter(View v)
	{ 
		Intent myIntent = new Intent(this, VolumetrieActivity.class);

		myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

		startActivity(myIntent);
	}

	public void btnClear(View v) {	
		EditText V;
		
        // Eingabefelder zurücksetzen
		for (int x=1; x<=8; x++)
		{  
	    	int resId = getResources().getIdentifier("BW_"+(x), "id", getPackageName());
	    	V = (EditText) findViewById(resId);
	    	V.setText("");
		}		
		
   			// Cursor in erstes Eingabefeld setzen
   	    	V = (EditText) findViewById(R.id.BW_1);
   	    	V.requestFocus();
																											
		InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.showSoftInput(V, InputMethodManager.SHOW_FORCED);
		
		// vorerst nicht benötigte Eingabefelder wieder ausblenden
		EditText et;
		TextView tv;
    	for (int intFeldNr=3; intFeldNr<=8; intFeldNr++)
    	{
    		int resId = getResources().getIdentifier("tvVBBW"+(intFeldNr), "id", getPackageName());
		    tv = (TextView) findViewById(resId);
	        tv.setVisibility(View.INVISIBLE);
	        
    		resId = getResources().getIdentifier("BW_"+(intFeldNr), "id", getPackageName());
		    et = (EditText) findViewById(resId);
	        et.setVisibility(View.INVISIBLE);
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
            	intent.putExtra("Kapitel", "Verbrauch");
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
} // class VolumetrieActivity
