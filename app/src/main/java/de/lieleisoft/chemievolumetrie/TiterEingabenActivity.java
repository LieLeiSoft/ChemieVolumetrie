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

public class TiterEingabenActivity extends Activity {
	
	/*************************************************************
	 ** onCreate wird ausgeführt, wenn Activicty erstellt wird ***
	 *************************************************************/
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.titereingaben);       
    
		// Activity registrieren, damit sie später an zentraler Stelle (Hauptmenue) geschlossen werden kann
	    ActivityRegistry.register(this);

	    // Cursor in erstes Eingabefeld setzen 
	    EditText et;
        et = (EditText) findViewById(R.id.Eingabe_1);
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
   		
   		int intRoutineID;
   		int intTiterNichtAngeben;
   		int resId;
   		String strDirekteT;
   		TextView tv;
   		TextView tv1;
   		EditText et;
   		String strEingabe;
   		String strTiter;
   		Double dblEingabe;
   		
   		String strRoutineID = prefs.getString("Routine", "1");
   		intRoutineID = Integer.parseInt(strRoutineID);
   		
   		intTiterNichtAngeben = prefs.getInt("TiterNichtAngeben", 0);
   		
   		strDirekteT = prefs.getString("DirekteT", "ja");
   		strTiter = prefs.getString("TiterFürGehalt", "");
   		
	    for (int x=1; x<=4; x++)
	    {
	    	strEingabe = prefs.getString("Eingabe_"+x, "");

	    	if (strEingabe.equals("") == false) // Wenn ein Wert drin steht
	    	{
	    		dblEingabe = Double.parseDouble(strEingabe);
	    		dblEingabe = ActivityTools.fktRunden(dblEingabe, 4);
	    		strEingabe = Double.toString(dblEingabe);

	    		resId = getResources().getIdentifier("Eingabe_"+x, "id", getPackageName());
	    		et = (EditText) findViewById(resId);
	    		et.setText(strEingabe);
	    		if(x==4)
	    		{
	    	   		if (intTiterNichtAngeben == 1)
	    	   		{
	    	   			tv = (TextView) findViewById(R.id.Eingabe_3);
	    	        	tv.setVisibility(View.INVISIBLE);
	    	   		}
	    		}
	    		
	    		if(x==1)
	    		{
	       			tv = (TextView) findViewById(R.id.btnFaktor);
	            	tv.setVisibility(View.INVISIBLE);
	    		}
	    		
	    	}
	    	else
	    	{
	    		if(x==1)
	    		{
	       			tv = (TextView) findViewById(R.id.btnFaktor);
	            	tv.setVisibility(View.VISIBLE);
	    		}
	    		
	    		if(x==3)
	    		{
	    			if(strTiter.equals("") == false)
	    			{
	    				strEingabe = strTiter;
	    			}
	    		}
	    		
	    		resId = getResources().getIdentifier("Eingabe_"+x, "id", getPackageName());
	    		et = (EditText) findViewById(resId);
	    		et.setText("");
	    	}
	    }
   		
   		if (intRoutineID == 1)	// Titerbestimmung mit Urtiter
    	{
   			tv = (TextView) findViewById(R.id.Masslsg_unbekannter_Titer);
        	tv.setVisibility(View.GONE);
        	tv = (TextView) findViewById(R.id.Eingabe_2);
        	tv.setVisibility(View.GONE);
        	tv.setFocusableInTouchMode(false);
        	tv = (TextView) findViewById(R.id.Masslsg_bekannter_Titer);
        	tv.setVisibility(View.GONE);
        	tv = (TextView) findViewById(R.id.Eingabe_3);
        	tv.setVisibility(View.GONE);
        	tv.setFocusableInTouchMode(false);
        	tv = (TextView) findViewById(R.id.btnMassLsgVorlage);
        	tv.setVisibility(View.GONE);
        	tv = (TextView) findViewById(R.id.Eingabe_4);
        	tv.setVisibility(View.GONE);
        	tv.setFocusableInTouchMode(false);
        	tv = (TextView) findViewById(R.id.btnMassLsgTitrant);
        	tv.setVisibility(View.GONE);
    	}
    	
    	if (intRoutineID == 2)	// Titerbestimmung mit Maßlösung
    	{	
            tv = (TextView) findViewById(R.id.Faktor);
            tv.setVisibility(View.GONE);
            tv = (TextView) findViewById(R.id.Eingabe_1);
            tv.setVisibility(View.GONE);
        	tv.setFocusableInTouchMode(false);
            tv = (TextView) findViewById(R.id.btnFaktor);
            tv.setVisibility(View.GONE);
            tv = (TextView) findViewById(R.id.btnMassLsgVorlage);
            tv.setVisibility(View.INVISIBLE);
            
            if (strDirekteT == "nein")
            {
            	tv = (TextView) findViewById(R.id.Masslsg_unbekannter_Titer);
            	tv.setText(R.string.Masslsg_als_Titrant);
            	tv = (TextView) findViewById(R.id.Masslsg_bekannter_Titer);
            	tv.setText(R.string.Masslsg_als_Vorlage);
            }
            else
            {
            	tv = (TextView) findViewById(R.id.Masslsg_unbekannter_Titer);
            	tv.setText(R.string.Masslsg_als_Vorlage);
            	tv = (TextView) findViewById(R.id.Masslsg_bekannter_Titer);
            	tv.setText(R.string.Masslsg_als_Titrant);
            }
    	} 
    	
    	if (intRoutineID == 3)	// Gehalt Titration
    	{
    		tv = (TextView) findViewById(R.id.Masslsg_unbekannter_Titer);
            tv.setVisibility(View.GONE);
            tv = (TextView) findViewById(R.id.Eingabe_2);
            tv.setVisibility(View.GONE);
        	tv.setFocusableInTouchMode(false);
        	tv = (TextView) findViewById(R.id.Eingabe_4);
        	tv.setVisibility(View.GONE);
        	tv.setFocusableInTouchMode(false);
        	tv = (TextView) findViewById(R.id.btnMassLsgVorlage);
        	tv.setVisibility(View.GONE);
        	tv = (TextView) findViewById(R.id.btnMassLsgTitrant);
        	tv.setVisibility(View.GONE);

            tv = (TextView) findViewById(R.id.Masslsg_bekannter_Titer);
            tv.setText(R.string.Massloesung_Titer);
            
            if (strTiter.equals("") == false)
            {
            	//tv = (TextView) findViewById(R.id.Eingabe_3);
            	//tv.setText(strTiter);
            }
    	}
    	
    	if (intRoutineID >= 4) // Fettkennzahlen
    	{
    		tv = (TextView) findViewById(R.id.Masslsg_unbekannter_Titer);
            tv.setVisibility(View.GONE);
            tv = (TextView) findViewById(R.id.btnFaktor);
            tv.setVisibility(View.GONE);
            tv = (TextView) findViewById(R.id.Eingabe_1);
            tv.setVisibility(View.GONE);
            tv = (TextView) findViewById(R.id.Eingabe_2);
            tv.setVisibility(View.GONE);
        	tv.setFocusableInTouchMode(false);
        	tv = (TextView) findViewById(R.id.Eingabe_4);
        	tv.setVisibility(View.GONE);
        	tv.setFocusableInTouchMode(false);
        	tv = (TextView) findViewById(R.id.btnMassLsgVorlage);
        	tv.setVisibility(View.GONE);
        	tv = (TextView) findViewById(R.id.btnMassLsgTitrant);
        	tv.setVisibility(View.GONE);

            tv = (TextView) findViewById(R.id.Masslsg_bekannter_Titer);
            tv.setText(R.string.Massloesung_Titer);
            
            if (strTiter.equals("") == false)
            {
            	//tv = (TextView) findViewById(R.id.Eingabe_3);
            	//tv.setText(strTiter);
            }

            tv = (TextView) findViewById(R.id.Text);
            tv1 = (TextView) findViewById(R.id.Faktor);
        
            switch (intRoutineID) 
            {
            	case 41:
            		tv.setText(R.string.SZEP);
            		tv1.setText(R.string.KOH01);
            		break;
            	case 42:
            		tv.setText(R.string.SZUSP);
            		tv1.setText(R.string.KOH01);
            		break;
            	case 43:
            		tv.setText(R.string.EZUSP);
            		tv1.setText(R.string.HCL05);
            		break;
            	case 44:
            		tv.setText(R.string.OHZEPA);
            		tv1.setText(R.string.ethKOH05);
            		break;
            	case 45:
            		tv.setText(R.string.OHZUSPmitAV);
            		tv1.setText(R.string.ethKOH05);
            		break;
            	case 46:
            		tv.setText(R.string.OHZEPB);
            		tv1.setText(R.string.Perchlor01);
            		break;
            	case 47:
            		tv.setText(R.string.OHZUSPohneAV);
            		tv1.setText(R.string.ethKOH05);
            		break;
            	case 48:
            		tv.setText(R.string.IZEP);
            		tv1.setText(R.string.Na2S2O301);
            		break;
            	case 49:
            		tv.setText(R.string.IZUSP);
            		tv1.setText(R.string.Na2S2O301);
            		break;
            	case 50:
            		tv.setText(R.string.POZEPA);
            		tv1.setText(R.string.Na2S2O3001);
            		break;
            	case 51:
            		tv.setText(R.string.POZUSP);
            		tv1.setText(R.string.Na2S2O3001);
            		break;
            	case 52:
            		tv.setText(R.string.POZEPB);
            		tv1.setText(R.string.Na2S2O3001);
            		break;
            	case 53:
            		tv.setText(R.string.VZEP);
            		tv1.setText(R.string.HCL05);
            		break;
            	case 54:
            		tv.setText(R.string.VZUSP);
            		tv1.setText(R.string.HCL05);
            		break;
            }		
        }	// else Fettkennzahlen	
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
       	
	    for (int x=1; x<=4; x++)
	    {
		    int resId = getResources().getIdentifier("Eingabe_"+x, "id", getPackageName());
	        et = (EditText) findViewById(resId);
	    	Eingabetext = et.getText().toString();
	 	           	
	    	prefEditor.putString("Eingabe_"+x, Eingabetext);
	    }
	    prefEditor.apply();	   
	    
	} // onPause
	
	public void btnFaktor(View v) 
	{	
		// aufzurufende Activity ("BerechnungActivity") einrichten
		Intent myIntent = new Intent(this, List_Masslsg_Activity.class);

		// verhindern, dass die Activity ein weiteres Mal geöffnet wird, wenn sie bereits geöffnet wurde
		myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

		// Activity aufrufen
		startActivity(myIntent);
	}	
	
	public void btnMassLsg(View v) 
	{	
		// aufzurufende Activity ("BerechnungActivity") einrichten
		Intent myIntent = new Intent(this, MolaritaetActivity.class);

		// verhindern, dass die Activity ein weiteres Mal geöffnet wird, wenn sie bereits geöffnet wurde
		myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

		// Activity aufrufen
		startActivity(myIntent);
	}
	
	public void btnWeiter(View v) 
	{
    	EditText et;
    	EditText et2;
    	String Eingabetext;
    	String Eingabetext2;
    	
		// Cursor in erstes Eingabefeld setzen und numerische Tastatur einschalten 
	    /* et = (EditText) findViewById(R.id.Eingabe_1);
		et.requestFocus();
		InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.showSoftInput(et, InputMethodManager.SHOW_FORCED);
		*/
   		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());		
   		int intRoutineID;

   		String strRoutineID = prefs.getString("Routine", "1");
   		intRoutineID = Integer.parseInt(strRoutineID);

   		switch (intRoutineID)									
   		{
   		case 1:	
   	       	et = (EditText) findViewById(R.id.Eingabe_1);  
   		    Eingabetext = et.getText().toString();
   	       	if (Eingabetext.equals("") == true)
   	       	{
   	           	// **************************************       		
   	           	// *** Hier wird ein Toast ausgegeben ***
   	           	// **************************************        		
   	           	String text = "\n   Bitte noch den   \n   volumetrischen   \n   Faktor eingeben!   \n"; 
   	           	Toast Meldung = Toast.makeText(this, text, Toast.LENGTH_LONG);
   	           	Meldung.setGravity(Gravity.TOP, 0, 0);
   	           	Meldung.show();
   	           	et.requestFocus();
   	       	}	
   	       	else
   	       	{
				Intent myIntent = new Intent(this, VolumetrieActivity.class);
				myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
				startActivity(myIntent);
   	       	}	
   	       		
   			break;  
   		case 2:
       		et = (EditText) findViewById(R.id.Eingabe_2);  
       		Eingabetext = et.getText().toString();
       		et2 = (EditText) findViewById(R.id.Eingabe_4);  
       		Eingabetext2 = et2.getText().toString();
       		
       		if ((Eingabetext.equals("") == true) && (Eingabetext2.equals("") == true))
       		{
   				et.setText("1.0");
   				et2.setText("1.0");
   				
   				// **************************************       		
   				// *** Hier wird ein Toast ausgegeben ***
   				// **************************************        		
   				String text = "\n   Die Stoffmengenkonzentrationen   \n   wurden beide auf 1.0000 gesetzt!   \n"; 
   				Toast Meldung = Toast.makeText(this, text, Toast.LENGTH_LONG);
   				Meldung.setGravity(Gravity.TOP, 0, 0);
   				Meldung.show();
   				
      			et = (EditText) findViewById(R.id.Eingabe_3);  
      			et.requestFocus();
       		}
       		else
       		{
           		et = (EditText) findViewById(R.id.Eingabe_2);  
           		Eingabetext = et.getText().toString();
           		if (Eingabetext.equals("") == true)
           		{	
           			// **************************************       		
           			// *** Hier wird ein Toast ausgegeben ***
           			// **************************************        		
           			String text = "\n   Bitte noch die Stoffmengenkonzentration der zu   \n   bestimmenden Maßlösung eingeben!   \n"; 
           			Toast Meldung = Toast.makeText(this, text, Toast.LENGTH_LONG);
           			Meldung.setGravity(Gravity.TOP, 0, 0);
           			Meldung.show();
           			et.requestFocus();
           		}
           		else
           		{
       				if (Eingabetext2.equals("") == true)
       				{	
       					// **************************************       		
       					// *** Hier wird ein Toast ausgegeben ***
       					// **************************************        		
       					String text = "\n   Bitte noch die Stoffmengenkonzentration der   \n   bekannten Maßlösung eingeben!   \n"; 
       					Toast Meldung = Toast.makeText(this, text, Toast.LENGTH_LONG);
       					Meldung.setGravity(Gravity.TOP, 0, 0);
       					Meldung.show();
       					et.requestFocus();
       				}
       				else
       				{
              			et = (EditText) findViewById(R.id.Eingabe_3);  
               			Eingabetext = et.getText().toString();
               			if (Eingabetext.equals("") == true)
               			{	
               				et.setText("1.0000");
               				
               				// **************************************       		
               				// *** Hier wird ein Toast ausgegeben ***
               				// **************************************        		
               				String text = "\n   Der Titer der bekannten Maßlösung   \n   wurde auf 1.0000 gesetzt!   \n"; 
               				Toast Meldung = Toast.makeText(this, text, Toast.LENGTH_LONG);
               				Meldung.setGravity(Gravity.TOP, 0, 0);
               				Meldung.show();

           					Intent myIntent = new Intent(this, VolumetrieActivity.class);
           					myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
           					startActivity(myIntent);
               			}
               			else
               			{
           					Intent myIntent = new Intent(this, VolumetrieActivity.class);
           					myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
           					startActivity(myIntent);
               			}
       				}
           		}
       		}
       		break;
   		case 3:
           	et = (EditText) findViewById(R.id.Eingabe_1);  
    	    Eingabetext = et.getText().toString();
           	if (Eingabetext.equals("") == true)
           	{
               	// **************************************       		
               	// *** Hier wird ein Toast ausgegeben ***
               	// **************************************        		
               	String text = "\n   Bitte noch den volumetrischen Faktor   \n   der Maßlösung eingeben!   \n"; 
               	Toast Meldung = Toast.makeText(this, text, Toast.LENGTH_LONG);
               	Meldung.setGravity(Gravity.TOP, 0, 0);
               	Meldung.show();
               	et.requestFocus();
           	} 
           	else
           	{
       			et = (EditText) findViewById(R.id.Eingabe_3);  
       			Eingabetext = et.getText().toString();
       			if (Eingabetext.equals("") == true)
       			{	
       				et.setText("1.0000");
       				
       				// **************************************       		
       				// *** Hier wird ein Toast ausgegeben ***
       				// **************************************        		
       				String text = "\n   Der Titer der bekannten Maßlösung   \n   wurde auf 1.0000 gesetzt!   \n"; 
       				Toast Meldung = Toast.makeText(this, text, Toast.LENGTH_LONG);
       				Meldung.setGravity(Gravity.TOP, 0, 0);
       				Meldung.show();

   					Intent myIntent = new Intent(this, VolumetrieActivity.class);
   					myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
   					startActivity(myIntent);
       			}
       			else
       			{
   					Intent myIntent = new Intent(this, VolumetrieActivity.class);
   					myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
   					startActivity(myIntent);
       			}
           	}
           	break;
   		} // switch (RoutineID)
   		
        if (intRoutineID >= 4)
        {
       		et = (EditText) findViewById(R.id.Eingabe_3);  
       		Eingabetext = et.getText().toString();
       		if (Eingabetext.equals("") == true)
       		{	
       			et.setText("1.0000");
       				
       			// **************************************       		
       			// *** Hier wird ein Toast ausgegeben ***
       			// **************************************        		
       			String text = "\n   Der Titer der bekannten Maßlösung   \n   wurde auf 1.0000 gesetzt!   \n"; 
       			Toast Meldung = Toast.makeText(this, text, Toast.LENGTH_LONG);
       			Meldung.setGravity(Gravity.TOP, 0, 0);
       			Meldung.show();

   				if(intRoutineID == 41 || intRoutineID == 42) // Bei Säurezahl EP/USP kein BW
   				{
   					Intent myIntent = new Intent(this, VolumetrieActivity.class);
   					myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
   					startActivity(myIntent);
   				}
   				else
   				{
   					Intent myIntent = new Intent(this, VolumetrieBWActivity.class);
   					myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
   					startActivity(myIntent);
   				}
       		}
       		else
       		{
   				if(intRoutineID == 41 || intRoutineID == 42) // Bei Säurezahl EP/USP kein BW
   				{
   					Intent myIntent = new Intent(this, VolumetrieActivity.class);
   					myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
   					startActivity(myIntent);
   				}
   				else
   				{
   					Intent myIntent = new Intent(this, VolumetrieBWActivity.class);
   					myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
   					startActivity(myIntent);
   				}
       		}
        }
    } // btnWeiter
	

    // Eingabefelder zurücksetzen
    public void btnClear(View v) {
    	
   		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());		
		SharedPreferences.Editor prefEditor = prefs.edit(); 

   		String strRoutineID = prefs.getString("Routine", "1");
    	   		
    	EditText et;
    	 
    	for (int x=1; x<=4; x++)
    	{  
	    	int resId = getResources().getIdentifier("Eingabe_"+(x), "id", getPackageName());
	    	et = (EditText) findViewById(resId);
	    	et.setText("");
    	}
    	
   		if ((strRoutineID.equals("1") && strRoutineID.equals("3")) == true)	// Titerbestimmung mit Urtiter
    	{
   	    	TextView tv;
   			tv = (TextView) findViewById(R.id.btnFaktor);
   	        tv.setVisibility(View.VISIBLE);
    	}
   		
   		if ((strRoutineID.equals("2")) == true)
   		{
   	    	TextView tv;
   			tv = (TextView) findViewById(R.id.Eingabe_3);
   	        tv.setVisibility(View.VISIBLE);
   	        
   			prefEditor.putInt("TiterNichtAngeben", 0);
   			prefEditor.apply();
   		}
    	        
		// Cursor in erstes Eingabefeld setzen und numerische Tastatur einschalten 
    	et = (EditText) findViewById(R.id.Eingabe_1);
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

