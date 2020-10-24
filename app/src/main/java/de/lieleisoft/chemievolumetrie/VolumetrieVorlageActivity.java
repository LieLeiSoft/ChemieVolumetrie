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
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import de.lieleisoft.chemievolumetrie.R;

public class VolumetrieVorlageActivity extends Activity {
	/** wird ausgeführt, wenn Activicty erstellt wird */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.volumetrie_vorlage);

		// Activity registrieren, damit sie später an zentraler Stelle (Hauptmenue) geschlossen werden kann
	    ActivityRegistry.register(this);
	
	} // onCreate

	/** wird ausgeführt, wenn Activicty angezeigt wird */
	@Override
	public void onResume() {
		super.onResume();
		
    	String strTitrationsart;
    	String Eingabetext;
    	TextView tv;
    	
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

   		String strRoutineID = prefs.getString("Routine", "1");
   		int intRoutineID = Integer.parseInt(strRoutineID);
   		
   		if (intRoutineID >= 41)
   		{
   	    	// Numerische Tastatur ausschalten
   	    	getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
   	    	
   			tv = (TextView) findViewById(R.id.btnClear);
   			tv.setVisibility(View.INVISIBLE);
   			tv = (TextView) findViewById(R.id.btnTitrationsart);
   			tv.setVisibility(View.GONE);
   			tv = (TextView) findViewById(R.id.tvTitrationsart);
   			tv.setVisibility(View.GONE);
   			tv = (TextView) findViewById(R.id.Vorlage);
   			tv.setVisibility(View.GONE);
   			tv = (TextView) findViewById(R.id.tvVorlagevolumen);
   			tv.setText("Je nach gewählter Methode\ngenaues Volumen\nder Vorlage beachten!");
   		}
   		else
   		{
   	    	// Numerische Tastatur einschalten
   			getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE); 
   			
   			strTitrationsart = prefs.getString("DirekteT", "ja");
   			if (strTitrationsart == "ja")
   	    	{
   	    		Eingabetext = "Direkte Titration";
   	    	}
   	    	    	
   	    	else
   	    	{
   	    		Eingabetext = "Inverse Titration";	
   	    	}
   	    	
   	    	
   	    	tv = (TextView) findViewById(R.id.tvTitrationsart);
   	    	tv.setText(Eingabetext);
   		}
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
       	
   		et = (EditText) findViewById(R.id.Vorlage);

   		Eingabetext = et.getText().toString();
   		     	             
   		prefEditor.putString("Vorlage", Eingabetext); // (Name und Wert) der Konfigurationsdatei
   		prefEditor.apply();

	    
	} // onPause
	
	
	// ****************************
	// *** zur Proben-Titration ***
	// ****************************
	
	public void btnWeiter(View v)
	{
		EditText et;
		String Eingabetext;
		
		int intRoutineID;
		
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
 
		String strRoutineID = prefs.getString("Routine", "1");
		intRoutineID = Integer.parseInt(strRoutineID);

		et = (EditText) findViewById(R.id.Vorlage);  
	    Eingabetext = et.getText().toString();
	    
       	if ((Eingabetext.equals("") == true) && (intRoutineID == 2)) // hier wird geprüft, ob ein Wert eingegeben wurde und Routine 2 ausgewählt wurde.
       	{
       		// **************************************       		
       		// *** Hier wird ein Toast ausgegeben ***
       		// **************************************        		
       		String text = "\n   Bitte Volumen der Vorlage eingeben!   \n"; 
       		Toast Meldung = Toast.makeText(this, text, Toast.LENGTH_LONG);
       		Meldung.setGravity(Gravity.TOP, 0, 0);
       		Meldung.show();
       		et.requestFocus();
       	} 
       	else
    	{ 
    		if (intRoutineID == 1 || intRoutineID == 3)
    		{
    			Intent myIntent = new Intent(this, VolumetrieActivity.class);
    			myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
    			startActivity(myIntent);
    		}
    		else
    		{
           		Intent myIntent = new Intent(this, TiterEingabenActivity.class);
        		myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        		startActivity(myIntent);
        	}	
    	}
	}
	
	

	
	// ****************************
	// *** Titrationsart ***
	// ****************************
	
	public void btnTitrationsart(View v)
	{ 		
		//AlertDialog.Builder builder = new AlertDialog.Builder(this);
		AlertDialog.Builder builder = new AlertDialog.Builder(VolumetrieVorlageActivity.this);
		builder.setTitle("Direkte oder \nInverse Titration?");
		builder.setMessage("Bei der direkten Titration wird die zu prüfende Lösung vorgelegt und mit der bekannten Maßlösung direkt titriert (Normalzustand). "
				+ "Bei der inversen Titration wird hingegen eine abgemessene Menge an Maßlösung mit der zu prüfenden Lösung titriert.");
		
		builder.setPositiveButton
			("Direkte Titration",
				new DialogInterface.OnClickListener()
				{
					public void onClick(DialogInterface dialog, int id)
					{
						SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());		
						SharedPreferences.Editor prefEditor = prefs.edit();
						prefEditor.putString("DirekteT", "ja"); 
						prefEditor.apply();
										
						dialog.dismiss();
						
						TextView tv;
				    	tv = (TextView) findViewById(R.id.tvTitrationsart);
				    	tv.setText("Direkte Titration");	
					}		
				}
			);
		
		builder.setNegativeButton
			("Inverse Titration",
				new DialogInterface.OnClickListener()
				{
					public void onClick(DialogInterface dialog, int id)
					{	
						SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());		
						SharedPreferences.Editor prefEditor = prefs.edit();
						prefEditor.putString("DirekteT", "nein"); 
						prefEditor.apply();
										
						dialog.dismiss();	
						
						TextView tv;
				    	tv = (TextView) findViewById(R.id.tvTitrationsart);
				    	tv.setText("Inverse Titration");
					}	
				}
			);
		AlertDialog dialog = builder.create();
		dialog.show();
		
	} // btn Titrationsart
	
	
	// *****************
	// *** zur Hilfe ***
	// *****************
	
	public void btnOnClickHilfe(View v)
	{       	
			// aufzurufende Activity ("BerechnungActivity") einrichten
			Intent myIntent = new Intent(this, HilfeActivity.class);
			
	        // verhindern, dass die Activity ein weiteres Mal geöffnet wird, wenn sie bereits geöffnet wurde
	        myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
	
	        // als Parameter wird der Name des anzuzeigenen Hilfe-Kapitels übergeben
	        myIntent.putExtra("Kapitel", "Vorlage");

			// Activity aufrufen
	        startActivity(myIntent);
	             	
	} // btnOnClickHilfe
	
	public void btnClear(View v) {	
			
        // Eingabefelder zurücksetzen
 
			EditText et;
			et = (EditText) findViewById(R.id.Vorlage);
			// String Eingabetext = et.getText().toString();
			et.setText("");
			
																									
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
            	intent.putExtra("Kapitel", "Vorlage");
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
} // class VolumetrieVorlageActivity
