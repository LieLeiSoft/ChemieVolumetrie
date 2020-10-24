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
import android.widget.TextView;
import android.widget.Toast;
import de.lieleisoft.chemievolumetrie.R;

public class Konz_Masslsg_Activity extends Activity {
	
	/*************************************************************
	 ** onCreate wird ausgeführt, wenn Activicty erstellt wird ***
	 *************************************************************/
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.titereingaben);  
	    
	    TextView tv;
	     
	    tv = (TextView) findViewById(R.id.btnWeiter);
	    tv.setText("Weiter");
	    tv = (TextView) findViewById(R.id.Faktor);
	    tv.setVisibility(View.GONE);
        tv = (TextView) findViewById(R.id.Eingabe_1);
	    tv.setVisibility(View.GONE);
	    tv = (TextView) findViewById(R.id.btnFaktor);
	    tv.setVisibility(View.GONE);
	    tv = (TextView) findViewById(R.id.Masslsg_unbekannter_Titer);
	    tv.setVisibility(View.GONE);
	    tv = (TextView) findViewById(R.id.Eingabe_2);
	    tv.setVisibility(View.GONE);
	    tv = (TextView) findViewById(R.id.btnMassLsgVorlage);
	    tv.setVisibility(View.GONE);
	    tv = (TextView) findViewById(R.id.Masslsg_bekannter_Titer);
	    tv.setText("Normalität der Maßlösung");
	    tv = (TextView) findViewById(R.id.btnMassLsgTitrant);
	    tv.setVisibility(View.GONE);
	    tv = (TextView) findViewById(R.id.Eingabe_3);
	    tv.setVisibility(View.GONE);

		// Activity registrieren, damit sie später an zentraler Stelle (Hauptmenue) geschlossen werden kann
	    ActivityRegistry.register(this);
		
	} // onCreate

	/***************************************************************
	 ** onResume wird ausgeführt, wenn Activicty angezeigt wird  ***
	 ***************************************************************/
	
	@Override
	public void onResume() {
		super.onResume();
 	
	TextView tv;
	String strNormalitaet;

	
    // ************************************************************************************
    // ********* Die Normalität der Masslösung wird angezeigt (falls vorhanden) ***********
    // ************************************************************************************
   	
	SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

   	strNormalitaet = prefs.getString("Eingabe_4", "");    
    tv = (TextView) findViewById(R.id.Eingabe_4);
    tv.setText(strNormalitaet);
        
    if (strNormalitaet.equals("") == false)
    { 
        tv = (TextView) findViewById(R.id.Eingabe_4);
        tv.setText(strNormalitaet);
    }
    
	} // onResume

	/*******************************************************************************
	 ** onPause wird ausgeführt, wenn zu einer anderen Activicty gewechselt wird ***
	 *******************************************************************************/
	
	@Override
	public void onPause() {
		super.onPause();
		
	// ******************************************************************************************************
	// ********* Die Normalität der Masslösung wird ausgelesen und gespeichert (falls vorhanden *************
	// ******************************************************************************************************
	
	EditText et;
	String strNormalitaet;	
	
	SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
	SharedPreferences.Editor prefEditor = prefs.edit();
	   
	et = (EditText) findViewById(R.id.Eingabe_4);
	strNormalitaet = et.getText().toString();
	
    if (strNormalitaet.equals("") == false)
    {  	
    	prefEditor.putString("Eingabe_4", strNormalitaet); // (Name und Wertname)
    	prefEditor.apply();
    }

	} // onPause
		
		
	/*******************************************************************************
	 ******************************* Button Weiter *********************************
	 *******************************************************************************/	
	
	public void btnWeiter(View v) 
	{
	 	EditText et;
    	String strNormalitaet;
    	
    	et = (EditText) findViewById(R.id.Eingabe_4);

    	strNormalitaet = et.getText().toString();
    	
    	if(strNormalitaet.equals("") == true)
    	{
    		// **************************************       		
			// *** Hier wird ein Toast ausgegeben ***
			// **************************************        		
			String text = "\n   Bitte die Normalität  \n   eingeben!   \n"; 
			Toast Meldung = Toast.makeText(this, text, Toast.LENGTH_LONG);
			Meldung.setGravity(Gravity.TOP, 0, 0);
			Meldung.show();
    	}
    	
		else 
		{
			Intent myIntent = new Intent(this, List_Stoff_Activity.class);
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
    	
    	et = (EditText) findViewById(R.id.Eingabe_4);
        et.setText("");	
        
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

