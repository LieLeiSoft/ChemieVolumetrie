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
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;
import de.lieleisoft.chemievolumetrie.R;

public class MolaritaetActivity extends Activity {
	
	/*************************************************************
	 ** onCreate wird ausgeführt, wenn Activicty erstellt wird ***
	 *************************************************************/
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.molaritaetbestimmung);       
    
		// Activity registrieren, damit sie später an zentraler Stelle (Hauptmenue) geschlossen werden kann
	    ActivityRegistry.register(this);
		
	} // onCreate

	/***************************************************************
	 ** onResume wird ausgeführt, wenn Activicty angezeigt wird  ***
	 ***************************************************************/
	
	@Override
	public void onResume() {
		super.onResume();
 	
	EditText et;
	String strMolaritaetEG;
	String Eingabetext;
	int resId;
	
		
	SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

    for (int x=1; x<=5; x++)
    {
    	strMolaritaetEG = prefs.getString("MolaritaetEG_"+x, "");
    	resId = getResources().getIdentifier("MolaritaetEG_"+x, "id", getPackageName());
        et = (EditText) findViewById(resId);
        
    	if (strMolaritaetEG.equals("") == false)
    	{ 
    		et.setText(strMolaritaetEG);
    	}
    }
    
    // *************************************************************************************
    // ********* Hier wird der Cursor in das nächste leere Eingabefeld gesetzt. ************
    // *************************************************************************************
   
    for (int x=5; x>=1; x--)
    {
    	resId = getResources().getIdentifier("MolaritaetEG_"+x, "id", getPackageName());
        et = (EditText) findViewById(resId);
        Eingabetext = et.getText().toString();
        
        if (Eingabetext.equals("") == true)
        {
        	et.requestFocus();
        }
    }

    // *************************************************************************************


	} // onResume

	/*******************************************************************************
	 ** onPause wird ausgeführt, wenn zu einer anderen Activicty gewechselt wird ***
	 *******************************************************************************/
	
	@Override
	public void onPause() {
		super.onPause();
		
	 	EditText et;
    	String Eingabetext;
    	String strMolaritaet;
    	int intEingabefelder = 0;
    	int intRoutineID;
    	double dblMolaritaet;
    	double[] arrEingabe = new double[6]; // Erzeugt 5 Felder, keine 6!

   		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
   		SharedPreferences.Editor prefEditor = prefs.edit();
       	
	    for (int x=1; x<=5; x++)
	    {	    	
	    	int resId = getResources().getIdentifier("MolaritaetEG_"+x, "id", getPackageName());
           	et = (EditText) findViewById(resId);
    	    Eingabetext = et.getText().toString();
         	
    	    if(Eingabetext.equals("") == false)
    	    {
    	    	arrEingabe[x] = Double.parseDouble(Eingabetext);
    	    }
    	    else
    	    {
    	    	if (x == 4 && intEingabefelder == 0)
    	    	{
    				et.setText("100");
    				arrEingabe[4] = 100;
    				
    				// **************************************       		
    				// *** Hier wird ein Toast ausgegeben ***
    				// **************************************        		
    				String text = "\n   Die Substanzreinheit   \n   wurde auf 100 gesetzt!   \n"; 
    				Toast Meldung = Toast.makeText(this, text, Toast.LENGTH_LONG);
    				Meldung.setGravity(Gravity.TOP, 0, 0);
    				Meldung.show();
    	    	}
    	    	else
    	    	{
    	    		intEingabefelder = 1;
    	    	}
    	    }
	    }

    	if (intEingabefelder == 0)
    	{
    		dblMolaritaet = ((arrEingabe[2] * (arrEingabe[4] / 100)) / (arrEingabe[1] * arrEingabe[3] * 0.001)) * arrEingabe[5];
    		
    	    strMolaritaet = Double.toString(dblMolaritaet);

    	    String strRoutineID = prefs.getString("Routine", "1");
    	    intRoutineID = Integer.parseInt(strRoutineID);

    	    
    	    if(intRoutineID == 2)
    	    {
        	    prefEditor.putString("Eingabe_4", strMolaritaet); 
        	    prefEditor.apply();
    	    }
    	    else // intRoutineID == 1 && 3
    	    {
        	    prefEditor.putString("Molaritaet", strMolaritaet); 
        	    prefEditor.apply();
    	    }

    	}
    	else
    	{
    		strMolaritaet = "";
    		
    	    prefEditor.putString("Molaritaet", strMolaritaet); 
    	    prefEditor.apply();
    	}
    	
	} // onPause
	
	/*******************************************************************************
	 *************************** Button Molmasse ***********************************
	 *******************************************************************************/
	
	public void btnMM(View v) 
	{

		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		SharedPreferences.Editor prefEditor = prefs.edit(); 

		prefEditor.putInt("btnSZ_0", 0);
		prefEditor.putInt("Runde_Klammer_auf", 0);
		prefEditor.putFloat("Molmasse_Runde_Klammer", 0);
		prefEditor.putFloat("Molmasse", 0);
		prefEditor.putString("MolaritaetEG_1", "Wert");
		prefEditor.apply();
		
		Intent myIntent = new Intent(MolaritaetActivity.this, MolmassenActivity.class);
		myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
		startActivity(myIntent);

	}	
		
	/*******************************************************************************
	 ******************************* Button Zurück *********************************
	 *******************************************************************************/	
	
	public void btnZurueck(View v) 
	{
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		SharedPreferences.Editor prefEditor = prefs.edit(); 
		
		prefEditor.putInt("TiterNichtAngeben", 1); // (Name und Wert) der Konfigurationsdatei
		prefEditor.apply();

		
		int intRoutineID;

		String strRoutineID = prefs.getString("Routine", "1");
		intRoutineID = Integer.parseInt(strRoutineID);
		

		if(intRoutineID == 2)
		{
			Intent myIntent = new Intent(this, TiterEingabenActivity.class);
			myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
			startActivity(myIntent);
		}
		else // (intRoutineID == 1 && 3)
		{
			Intent myIntent = new Intent(this, FaktorActivity.class);
			myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
			startActivity(myIntent);
		}
	}	

	/*******************
	 **** btn Clear ****
	 *******************/
    
    // Eingabefelder zurücksetzen
    public void btnClear(View v) 
    {
    	EditText et;
    	int resId;
    			
    	for (int x=1; x<=5; x++)
        {			
       		resId = getResources().getIdentifier("MolaritaetEG_"+x, "id", getPackageName());
           	et = (EditText) findViewById(resId);
       		et.setText("");
        }
	
		// Cursor in erstes Eingabefeld setzen und numerische Tastatur einschalten 
    	et = (EditText) findViewById(R.id.MolaritaetEG_1);
		et.requestFocus();
		InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.showSoftInput(et, InputMethodManager.SHOW_FORCED);		
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
            	intent.putExtra("Kapitel", "Molaritaet");
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

