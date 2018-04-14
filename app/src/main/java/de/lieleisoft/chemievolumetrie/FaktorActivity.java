package de.lieleisoft.chemievolumetrie;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import de.lieleisoft.chemievolumetrie.R;

public class FaktorActivity extends Activity {
	
	/*************************************************************
	 ** onCreate wird ausgeführt, wenn Activicty erstellt wird ***
	 *************************************************************/
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.faktorbestimmung);       
    
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
	String strMolmasse;
	String strMolaritaet;
	String Eingabetext;
	Double dblMolaritaet;
		
	SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
	
	strMolmasse = prefs.getString("Molmasse_Substanz", "");	
	
	strMolaritaet = prefs.getString("Molaritaet", "");
	
	if (strMolaritaet.equals("") == false)
	{
		dblMolaritaet = Double.parseDouble(strMolaritaet);
		dblMolaritaet = ActivityTools.fktRunden(dblMolaritaet, 4);
		strMolaritaet = Double.toString(dblMolaritaet);
		et = (EditText) findViewById(R.id.etMolaritaet);
		et.setText(strMolaritaet);
	}

	if (strMolmasse.equals("") == false)
	{
		et = (EditText) findViewById(R.id.etMolmasse);
		et.setText(strMolmasse);
	}

    et = (EditText) findViewById(R.id.etMolaritaet);
    Eingabetext = et.getText().toString();
        
    if (Eingabetext.equals("") == true)
    {
        	et.requestFocus();
    }
    
	et = (EditText) findViewById(R.id.etMolmasse);
    Eingabetext = et.getText().toString();
        
    if (Eingabetext.equals("") == true)
    {
        	et.requestFocus();
    }
    
	} // onResume

	/*******************************************************************************
	 ** onPause wird ausgeführt, wenn zu einer anderen Activicty gewechselt wird ***
	 *******************************************************************************/
	
	@Override
	public void onPause() {
		super.onPause();
		
		EditText et;
		String strMolmasse;
		String strMolaritaet;
		String strFaktor;
		Double dblMolmasse;
		Double dblMolaritaet;
		Double dblFaktor;
	
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		SharedPreferences.Editor prefEditor = prefs.edit();
		
		et = (EditText) findViewById(R.id.etMolmasse);
		strMolmasse = et.getText().toString();
		
		if (strMolmasse.equals("") == false) 
		{
			dblMolmasse = Double.parseDouble(strMolmasse);
			
			et = (EditText) findViewById(R.id.etMolaritaet);
			strMolaritaet = et.getText().toString();
			
			if (strMolaritaet.equals("") == false) 
			{
				dblMolaritaet = Double.parseDouble(strMolaritaet);
				
				dblFaktor = dblMolmasse * dblMolaritaet;
				strFaktor = Double.toString(dblFaktor);

				prefEditor.putString("Eingabe_1", strFaktor);
			}
			else
			{
				prefEditor.putString("Eingabe_1", "");
			}
		}
		else
		{
			prefEditor.putString("Eingabe_1", "");	
		}
		prefEditor.apply();
	} // onPause
	
	/*******************************************************************************
	 *************************** Button Molmasse ***********************************
	 *******************************************************************************/
	
	public void btnMolmasse(View v) 
	{
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		final SharedPreferences.Editor prefEditor = prefs.edit(); 

		prefEditor.putInt("btnSZ_0", 0);
		prefEditor.putInt("Runde_Klammer_auf", 0);
		prefEditor.putFloat("Molmasse_Runde_Klammer", 0);
		prefEditor.putFloat("Molmasse", 0);
		
		prefEditor.apply();
		
		AlertDialog.Builder builder = new AlertDialog.Builder(FaktorActivity.this);
		builder.setTitle("Volumetrischer Faktor aus der Molmasse");
		builder.setMessage("Achtung! Der Faktor kann nur aus der Molmasse berechnet werden, wenn sicher ist, daß die Molmasse der gesuchten Substanz zu"
				+ " 100% von der Maßlösung umgesetzt wird!");
		builder.setPositiveButton 
		(" Faktor berechnen",
				new DialogInterface.OnClickListener()
				{
					public void onClick(DialogInterface dialog, int id)
					{
						prefEditor.putString("Molmasse_Substanz", "Wert");
						prefEditor.apply();
						
						Intent myIntent = new Intent(FaktorActivity.this, MolmassenActivity.class);
						myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
						startActivity(myIntent);
						
						dialog.dismiss();
					}		
				}
		);
				
		builder.setNegativeButton
		("Faktor eingeben",
				new DialogInterface.OnClickListener()
				{
					public void onClick(DialogInterface dialog, int id)
					{												
						EditText et;
						et = (EditText) findViewById(R.id.etMolmasse);
						et.setText("");
						
						dialog.dismiss();	
					}	
				}
		);
		AlertDialog dialog = builder.create();
		dialog.show();

	}	
	
	/*******************************************************************************
	 *************************** Button Molaritaet *********************************
	 *******************************************************************************/	
	public void btnMolaritaet(View v) 
	{	
		Intent myIntent = new Intent(this, MolaritaetActivity.class);
		myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
		startActivity(myIntent);
	}	
	
	
	/*******************************************************************************
	 ******************************* Button Zurück *********************************
	 *******************************************************************************/	
	
	public void btnZurueck(View v) 
	{
		Intent myIntent = new Intent(this, TiterEingabenActivity.class);
		myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
		startActivity(myIntent);
	}	
	
	
	/*******************
	 **** btn Clear ****
	 *******************/
    
    // Eingabefelder zurücksetzen
    public void btnClear(View v) 
    {
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		SharedPreferences.Editor prefEditor = prefs.edit();
		prefEditor.putString("Molmasse_Substanz", "");
		prefEditor.putString("Molaritaet", "");
		
		prefEditor.apply();
		
    	EditText et;
    	 
    	et = (EditText) findViewById(R.id.etMolmasse);
    	et.setText("");
		
    	et = (EditText) findViewById(R.id.etMolaritaet);
    	et.setText("");
    	
		// Cursor in erstes Eingabefeld setzen und numerische Tastatur einschalten 
    	et = (EditText) findViewById(R.id.etMolmasse);
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
            	intent.putExtra("Kapitel", "Faktor");
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

