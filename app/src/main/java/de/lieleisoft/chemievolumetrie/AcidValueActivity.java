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

public class AcidValueActivity extends Activity {
	
	/*************************************************************
	 ** onCreate wird ausgeführt, wenn Activicty erstellt wird ***
	 *************************************************************/
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.acid_value);       
    
		// Activity registrieren, damit sie später an zentraler Stelle (Hauptmenue) geschlossen werden kann
	    ActivityRegistry.register(this);

	    // Cursor in erstes Eingabefeld setzen 
	    EditText et;
        et = (EditText) findViewById(R.id.AcidValue);
        et.requestFocus();
	    
	} // onCreate

	/***************************************************************
	 ** onResume wird ausgeführt, wenn Activicty angezeigt wird  ***
	 ***************************************************************/
	
	@Override
	public void onResume() {
		super.onResume();
 		
		
		
		// Werte aus Konfigurationsdatei ("Preferences") auslesen und in Arrays eintragen
   		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());	
   		
   		String strSZ = prefs.getString("Saeurezahl", "");
   		
		if(strSZ.equals("") == true)
		{
			TextView tv;
			tv =(TextView) findViewById(R.id.TextAlteSZ);
			tv.setVisibility(View.INVISIBLE);
		}
		
    	EditText et;	      
    	et = (EditText) findViewById(R.id.AcidValue);
    	et.setText(strSZ);
		et.requestFocus();
		
	
	} // onResume

	/*******************************************************************************
	 ** onPause wird ausgeführt, wenn zu einer anderen Activicty gewechselt wird ***
	 *******************************************************************************/
	
	@Override
	public void onPause() {
		super.onPause();

		EditText et;
    	String Eingabetext;
		
	    // Inhalt der Eingabefelder "Einwaage_xx" wird in Konfigurationsdatei ("Preferences") gespeichert

       	// Zugang zur Konfigurationsdatei ("Preferences") herstellen
   		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
   		SharedPreferences.Editor prefEditor = prefs.edit();
       	
   		et = (EditText) findViewById(R.id.AcidValue);
   		Eingabetext = et.getText().toString();
	 	           	
	    prefEditor.putString("Saeurezahl", Eingabetext);
	    prefEditor.apply();	   
	    
	} // onPause
		
	public void btnWeiter(View v) 
	{
    	EditText et;
    	String Eingabetext;
  
     	et = (EditText) findViewById(R.id.AcidValue);  
     	Eingabetext = et.getText().toString();

       	if (Eingabetext.equals("") == true)
       	{
   			et.setText("0");
   				
   			// **************************************       		
   			// *** Hier wird ein Toast ausgegeben ***
   			// **************************************        		
   			String text = "\n   Die Säurezahl   \n   wurden auf 0 gesetzt!   \n"; 
   			Toast Meldung = Toast.makeText(this, text, Toast.LENGTH_LONG);
   			Meldung.setGravity(Gravity.TOP, 0, 0);
   			Meldung.show();
       	}
       	
		Intent myIntent = new Intent(this, EinwaageActivity.class);
		myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
		startActivity(myIntent);
       	
    } // btnWeiter
	

    // Eingabefelder zurücksetzen
    public void btnClear(View v) {
    	
    	EditText et;	      
    	et = (EditText) findViewById(R.id.AcidValue);
    	et.setText("");
		et.requestFocus();
		
		TextView tv;
		tv =(TextView) findViewById(R.id.TextAlteSZ);
		tv.setVisibility(View.INVISIBLE);
		
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
            	intent.putExtra("Kapitel", "Titereingaben");
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

