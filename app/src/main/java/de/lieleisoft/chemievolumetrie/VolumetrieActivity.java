package de.lieleisoft.chemievolumetrie;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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


public class VolumetrieActivity extends Activity implements OnFocusChangeListener{

	/*************************************************************
	 ** onCreate wird ausgeführt, wenn Activicty erstellt wird ***
	 *************************************************************/
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.volumetrie);
	    
    	// Activity registrieren, damit sie später an zentraler Stelle (Hauptmenue) geschlossen werden kann
	    ActivityRegistry.register(this);
	    
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		
   		int intRoutineID;
   		TextView tv;
   		
   		String strRoutineID = prefs.getString("Routine", "1");
   		intRoutineID = Integer.parseInt(strRoutineID);

	    
   		if(intRoutineID == 2)
   		{
   			EditText et;
	    
   			// Eingabefelder mit Listener verbinden
   			for (int intFeldNr=1; intFeldNr<=7; intFeldNr++)
   			{
   				int resId = getResources().getIdentifier("Verbrauch_"+(intFeldNr), "id", getPackageName());
   				et = (EditText) findViewById(resId);
   				et.setOnFocusChangeListener(this);
   			}
   		}
   		if(intRoutineID == 1 || intRoutineID == 2 || intRoutineID >= 4)    // Button Vorlage wird bei allen Routinen außer Gehalt ausgeblendet
   		{
        	tv = (TextView) findViewById(R.id.btnVorlage);
        	tv.setVisibility(View.INVISIBLE);
   		}
	    
   		if(intRoutineID == 41 || intRoutineID == 42) // Button Blindwert wird bei den Routinen Säurezahl EP/USP gelöscht
   		{
        	tv = (TextView) findViewById(R.id.btnVorlage);
        	tv.setVisibility(View.GONE);
   			tv = (TextView) findViewById(R.id.btnBlindwerte);
        	tv.setVisibility(View.GONE);
   		}
	} // onCreate

	
	/***************************************************************
	 ** onResume wird ausgeführt, wenn Activicty angezeigt wird  ***
	 ***************************************************************/
	
	@Override
	public void onResume() {
		super.onResume();

    	EditText et;
    	TextView tv;
    	String strBW;
    	String strVorlage;
    	String strVerbrauch;
    	String strDirekteT;
    	String strEinwaage;
    	String Eingabetext;
    	int resId;
    	int resId2;
    	int intAnzahl=0;
    	double[] arrBW = new double[8+1];
    	double dblDBW=0;
    	double dblVorlage=0;
	    
		// Werte aus Konfigurationsdatei ("Preferences") auslesen und in Arrays eintragen
    	SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());		
	    
    	//****************************************************************************************
    	//********************* Auswahl Ausgabetext für Titrationsart ****************************
    	//****************************************************************************************
    	
    	strDirekteT = prefs.getString("DirekteT", "ja"); 
    	
    	if (strDirekteT.equals("ja") == true)	
    	{
    		Eingabetext = "   Direkte Titration";
    	}
    	    	
    	else
    	{
    		Eingabetext = "   Inverse Titration";
    	}
  
    	
    	tv = (TextView) findViewById(R.id.tvTitrationsart);
    	tv.setTextSize(15);
    	tv.setText(Eingabetext);
    	
    	
    	//****************************************************************************************
    	//********************* Auswahl Ausgabetext für Vorlage **********************************
    	//****************************************************************************************
    	
    	strVorlage = prefs.getString("Vorlage", ""); 
    	
    	
    	
    	if (strVorlage.equals("") == true)	
    	{
    		Eingabetext = " ohne Vorlage";
    	}
    	    	
    	else
    	{
    		dblVorlage = Double.parseDouble(strVorlage);
    		Eingabetext = " Vorlage = " + ActivityTools.fktDoubleToStringFormat(dblVorlage, 3) + "ml";	
    	}
    	
    	
    	tv = (TextView) findViewById(R.id.tvVorlage);
    	tv.setTextSize(15);
    	tv.setText(Eingabetext);

    	
    	//****************************************************************************************
    	//********************* Auswahl Ausgabetext für Blindwert ********************************
    	//****************************************************************************************
    	
    	for (int x=1; x<=8; x++)
	    { 
	    	strBW = prefs.getString("BW_"+x, "null");
	    	if (strBW.equals("null") == false)
	    	{
	    		intAnzahl = intAnzahl +1;	// Auch bei einer strBW = "0" zählt er +1
	    		arrBW[x] = Double.parseDouble(strBW);
	    		dblDBW = dblDBW + arrBW[x];
	    	}
	    }  
	    
    	dblDBW = dblDBW / intAnzahl;
    	strBW = Double.toString(dblDBW);
    	
    	if (intAnzahl == 0)
    	{
    		Eingabetext = " ohne Blindwerte";
    		strBW = "0";	// hier wird der strBW wieder auf "0" gesetzt, wenn kein BW gesetzt
    						// wichtig für die Berechnung, sonst ist strBW = NaN und der Gehalt= 0!
    	}
    	    	
    	else
    	{
    		Eingabetext = " Ø BW= " + ActivityTools.fktDoubleToStringFormat(dblDBW, 3) + "ml";	
    	}
    	
    	SharedPreferences.Editor prefEditor = prefs.edit();
    	prefEditor.putString("DBW", strBW); 
   		int intRoutineID;
   		
   		String strRoutineID = prefs.getString("Routine", "1");
   		intRoutineID = Integer.parseInt(strRoutineID);

    	prefEditor.apply();
    	
    	tv = (TextView) findViewById(R.id.tvDBW);
    	tv.setTextSize(15);
    	tv.setText(Eingabetext);
    	
    	// ***************************************************
    	// *** Hier werden die Probenverbräuche ausgelesen ***
    	// *** und auf dem Display angezeigt.              ***
    	// ***************************************************
    	
	    for (int x=1; x<=8; x++)
	    {
	   		strVerbrauch = prefs.getString("Verbrauch_"+x, "null");
	    	
	   		if (strVerbrauch.equals("null") == false)
	   		{   			
	    		resId = getResources().getIdentifier("Verbrauch_"+x, "id", getPackageName());
	           	et = (EditText) findViewById(resId);
	    		et.setText(strVerbrauch);
	   		}
	    }
	    
	    if(intRoutineID != 2)
   		{
   			for (int x=1; x<=8; x++)
   			{
   				strEinwaage = prefs.getString("Einwaage_"+x, "0");
   				resId = getResources().getIdentifier("Verbrauch_"+x, "id", getPackageName());
   				et = (EditText) findViewById(resId);
   				resId2 = getResources().getIdentifier("tvVB"+x, "id", getPackageName());
   				tv = (TextView) findViewById(resId2);
	    	
   				if (strEinwaage.equals("0") == false)
   				{   			
   					et.setVisibility(View.VISIBLE);
   					et.setFocusable(true);
   					tv.setVisibility(View.VISIBLE);
   				}
   				else
   				{   			
   					et.setVisibility(View.INVISIBLE);
   					et.setFocusable(false);
   					tv.setVisibility(View.INVISIBLE);
   				}
   			}
   		}
	    
	    
	    
	    
	    // ***************************************************************
	   	// *** Cursor in drittes Eingabefeld setzen, bei Auswahl Titer ***
	    // ***************************************************************
	    
   	   	et = (EditText) findViewById(R.id.Verbrauch_1);
   	   	et.requestFocus();
   		   	
   	   	// ***************************************
    	// *** Numerische Tastatur einschalten ***
   	   	// ***************************************
   	   	
	    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.showSoftInput(et, InputMethodManager.SHOW_FORCED);    	
   		
	} // onResume
	
	
	/*******************************************************************************
	 ** onPause wird ausgeführt, wenn zu einer anderen Activicty gewechselt wird ***
	 *******************************************************************************/
	
	@Override
	public void onPause() {
		super.onPause();

	    // Inhalt der Eingabefelder "Verbrauch_xx" wird in Konfigurationsdatei ("Preferences") gespeichert

       	// Zugang zur Konfigurationsdatei ("Preferences") herstellen
   		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
   		SharedPreferences.Editor prefEditor = prefs.edit();
       	
   		schreibeKonfig(prefEditor);
	    	
    	prefEditor.apply();
    	
	} // onPause
	
    // Implement the onFocusChange callback
	// Felder einblenden
    public void onFocusChange(View v, boolean hasFocus) {
    	EditText et;
		int CurrentID = v.getId();
		switch (CurrentID) {
		case R.id.Verbrauch_1:
	    	et = (EditText) findViewById(R.id.Verbrauch_2);
			et.setVisibility(View.VISIBLE);
			break;
		case R.id.Verbrauch_2:			
	    	et = (EditText) findViewById(R.id.Verbrauch_3);
			et.setVisibility(View.VISIBLE);
			break;
		case R.id.Verbrauch_3:			
	    	et = (EditText) findViewById(R.id.Verbrauch_4);
			et.setVisibility(View.VISIBLE);
			break;
		case R.id.Verbrauch_4:			
	    	et = (EditText) findViewById(R.id.Verbrauch_5);
			et.setVisibility(View.VISIBLE);
			break;
		case R.id.Verbrauch_5:			
	    	et = (EditText) findViewById(R.id.Verbrauch_6);
			et.setVisibility(View.VISIBLE);
			break;
		case R.id.Verbrauch_6:			
	    	et = (EditText) findViewById(R.id.Verbrauch_7);
			et.setVisibility(View.VISIBLE);
			break;
		case R.id.Verbrauch_7:			
	    	et = (EditText) findViewById(R.id.Verbrauch_8);
			et.setVisibility(View.VISIBLE);
			break;
		}
    } // onFocusChange
    
	public void btnBerechnung(View v)
	{       	
		EditText et;
		String Eingabetext;
		
		// *****************************************************
		// *** Hier wird geprüft, ob in dem ersten Verbrauch ***
		// *** Eingabefeld (Verbrauch 1) ein Wert steht.     ***
		// *****************************************************
    	
       	et = (EditText) findViewById(R.id.Verbrauch_1);  
	    Eingabetext = et.getText().toString();
       	if (Eingabetext.equals("") == true)
       	{
       		// **************************************       		
       		// *** Hier wird ein Toast ausgegeben ***
       		// **************************************        		
       		String text = "\n   Bitte Verbrauch eingeben!   \n"; 
       		Toast Meldung = Toast.makeText(this, text, Toast.LENGTH_LONG);
       		Meldung.setGravity(Gravity.TOP, 0, 0);
       		Meldung.show();
       		et.requestFocus();
       	} 
       	else {  		
       		
       	   	// ***************************************
        	// *** Numerische Tastatur ausschalten ***
       	   	// ***************************************
       		
    		InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
    		imm.hideSoftInputFromWindow(et.getWindowToken(), 0);

    		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
       		SharedPreferences.Editor prefEditor = prefs.edit();
    		
    		String strRoutineID = prefs.getString("Routine", "1");
    		final int intRoutineID = Integer.parseInt(strRoutineID);

    		prefEditor.apply();
    		
    		String strHoherBW = "0";
		    String strVerbrauch;
		    String strBW;
		    double dblVerbrauch = 0;
		    double dblBW = 0;		   
		    
		    schreibeKonfig(prefEditor);
		    
			strBW = prefs.getString("DBW","0");
			dblBW = Double.parseDouble(strBW);
			
			for (int x=1; x<=8; x++)
		 	{
		   		strVerbrauch = prefs.getString("Verbrauch_"+x, "null");
		   		
		   		if(strVerbrauch.equals("null") == false)
		   		{		   	
		   			dblVerbrauch = Double.parseDouble(strVerbrauch);
		   			if (dblVerbrauch < dblBW) {strHoherBW = "1";}
		   		}		   				   				   				   				   				   					   					   				   
	   		}
			if (strHoherBW.equals("1") == true && intRoutineID <= 3)
			{		
				//AlertDialog.Builder builder = new AlertDialog.Builder(this);
				AlertDialog.Builder builder = new AlertDialog.Builder(VolumetrieActivity.this);
				builder.setTitle("Ist dies eine Rücktitration ?");
				builder.setMessage("Bei einigen Proben ist der Verbrauch kleiner, als der Ø Verbrauch vom Blindwert bzw. das Volumen der Vorlage. Sollen die Proben vom Ø Blindwert bzw. Vorlagevolumen abgezogen werden?");
				builder.setPositiveButton("Ja",
						new DialogInterface.OnClickListener()
							{
								public void onClick(DialogInterface dialog, int id)
								{
						    		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());		
									SharedPreferences.Editor prefEditor = prefs.edit();
									prefEditor.putString("Rücktitration", "ja"); 
									prefEditor.apply();
									
									if (intRoutineID == 3)
									{
										// aufzurufende Activity ("BerechnungActivity") einrichten
										Intent myIntent = new Intent(VolumetrieActivity.this, BerechnungActivity.class);
									
										// verhindern, dass die Activity ein weiteres Mal geöffnet wird, wenn sie bereits geöffnet wurde
										myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
							
										// Activity aufrufen
										startActivity(myIntent);
										
										dialog.dismiss();
									}
									else
									{
										// aufzurufende Activity ("BerechnungTiterActivity") einrichten
										Intent myIntent = new Intent(VolumetrieActivity.this, BerechnungTiterActivity.class);
									
										// verhindern, dass die Activity ein weiteres Mal geöffnet wird, wenn sie bereits geöffnet wurde
										myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
							
										// Activity aufrufen
										startActivity(myIntent);
										
										dialog.dismiss();
									}
								}		
							});
				builder.setNegativeButton("Nein",
						new DialogInterface.OnClickListener()
							{
								public void onClick(DialogInterface dialog, int id)
								{	
						    		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());		
									SharedPreferences.Editor prefEditor = prefs.edit();
									prefEditor.putString("Rücktitration", "nein"); 
									prefEditor.apply();

									
									if (intRoutineID == 3)
									{
										// aufzurufende Activity ("BerechnungActivity") einrichten
										Intent myIntent = new Intent(VolumetrieActivity.this, BerechnungActivity.class);
									
										// verhindern, dass die Activity ein weiteres Mal geöffnet wird, wenn sie bereits geöffnet wurde
										myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
							
										// Activity aufrufen
										startActivity(myIntent);
										
										dialog.dismiss();
									}
									else
									{
										// aufzurufende Activity ("BerechnungTiterActivity") einrichten
										Intent myIntent = new Intent(VolumetrieActivity.this, BerechnungTiterActivity.class);
									
										// verhindern, dass die Activity ein weiteres Mal geöffnet wird, wenn sie bereits geöffnet wurde
										myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
							
										// Activity aufrufen
										startActivity(myIntent);
										
										dialog.dismiss();
									}
								}
							});
				AlertDialog dialog = builder.create();
				dialog.show();
			}
			else
			{
				prefEditor.putString("Rücktitration", "nein"); 
				prefEditor.apply();
				
				if (intRoutineID == 3)
				{
					// aufzurufende Activity ("BerechnungActivity") einrichten
					Intent myIntent = new Intent(VolumetrieActivity.this, BerechnungActivity.class);
				
					// verhindern, dass die Activity ein weiteres Mal geöffnet wird, wenn sie bereits geöffnet wurde
					myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
		
					// Activity aufrufen
					startActivity(myIntent);
				}
				else
				{
					if (intRoutineID >= 4) // Fettkennzahlen
					{
						// aufzurufende Activity ("BerechnungFettkennzahlActivity") einrichten
						Intent myIntent = new Intent(VolumetrieActivity.this, BerechnungFettkennzahlActivity.class);
					
						// verhindern, dass die Activity ein weiteres Mal geöffnet wird, wenn sie bereits geöffnet wurde
						myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
			
						// Activity aufrufen
						startActivity(myIntent);
					}
					else
					{
						// aufzurufende Activity ("BerechnungTiterActivity") einrichten
						Intent myIntent = new Intent(VolumetrieActivity.this, BerechnungTiterActivity.class);
					
						// verhindern, dass die Activity ein weiteres Mal geöffnet wird, wenn sie bereits geöffnet wurde
						myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
			
						// Activity aufrufen
						startActivity(myIntent);
					}
				}
			}
       	}
	} // btnBerechnung
	
	// ******************************
	// *** zur Blindwert Activity ***
	// ******************************
	
	public void btnBlindwerte(View v)
	{
		// aufzurufende Activity ("BerechnungActivity") einrichten
		Intent myIntent = new Intent(this, VolumetrieBWActivity.class);
		
        // verhindern, dass die Activity ein weiteres Mal geöffnet wird, wenn sie bereits geöffnet wurde
        myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

		// Activity aufrufen
        startActivity(myIntent);	             	
	} // btnBerechnung
	
	// ******************************
	// *** zur Vorlage Activity ***
	// ******************************
	
	String strText;
	

	public void btnVorlage(View v)
	{
   		// aufzurufende Activity ("BerechnungActivity") einrichten
   		Intent myIntent = new Intent(this, VolumetrieVorlageActivity.class);
   			
   	    // verhindern, dass die Activity ein weiteres Mal geöffnet wird, wenn sie bereits geöffnet wurde
   	    myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

   	    // Activity aufrufen
   	    startActivity(myIntent);	             	 
   	}
		

	
	
	// ******************************************
	// *** Alle Eingabefelder werden gelöscht ***
	// ******************************************
	
	public void btnClear(View v) {	
		EditText V;
		
        // Eingabefelder zurücksetzen
		for (int x=1; x<=8; x++)
		{  
	    	int resId = getResources().getIdentifier("Verbrauch_"+x, "id", getPackageName());
	    	V = (EditText) findViewById(resId);
	    	V.setText("");
		}		

		V = (EditText) findViewById(R.id.Verbrauch_1);
   	    V.requestFocus();
   	    
		InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.showSoftInput(V, InputMethodManager.SHOW_FORCED);
		/*
		// vorerst nicht benötigte Eingabefelder wieder ausblenden
		EditText et;
    	for (int intFeldNr=3; intFeldNr<=8; intFeldNr++)
    	{
    		int resId = getResources().getIdentifier("Verbrauch_"+(intFeldNr), "id", getPackageName());
		    et = (EditText) findViewById(resId);
	        et.setVisibility(View.INVISIBLE);
    	}
		*/
    } // btnClear
	
	
	// *****************************************************
	// *** Verbrauch wird in die Konfig Datei eingelesen ***
	// *****************************************************
	
	private void schreibeKonfig(SharedPreferences.Editor prefEditor)
	{
    	EditText et;
    	String Eingabetext;

    	for (int x=1; x<=8; x++)
	    {
			int resId = getResources().getIdentifier("Verbrauch_"+x, "id", getPackageName());
	       	et = (EditText) findViewById(resId);
		    Eingabetext = et.getText().toString();
	       	if (Eingabetext.equals("") == true) {
	       		Eingabetext = "null";
	       	}  	           	
	   		prefEditor.putString("Verbrauch_"+x, Eingabetext);
	    }
    	prefEditor.apply();
	} // schreibeKonfig	
	
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
