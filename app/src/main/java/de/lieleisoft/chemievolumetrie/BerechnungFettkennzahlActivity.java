package de.lieleisoft.chemievolumetrie;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import de.lieleisoft.chemievolumetrie.R;


public class BerechnungFettkennzahlActivity extends Activity {
	
		
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.berechnungtiter);

		// Activity registrieren, damit sie später an zentraler Stelle (Hauptmenue) geschlossen werden kann
	    ActivityRegistry.register(this);
	} // onCreate
	
	@Override
	public void onResume() {
		super.onResume();
		
		/*****************************************
		 ********* Variablen Deklaration *********
		 *****************************************/
		
		double[] arrEinwaage = new double[10+1];
		double[] arrVerbrauch = new double[10+1];
		double[] arrFettkennzahl = new double[14+1];
		
		double dblFettkennzahl = 0;
		double dblSpeicher = 0;
		double dblRSD = 0;
		double dblBW = 0;
		double dblSZ;
		double dblTiter;
		double dblFreeAcid;
		double dblEwFreeAcid;
		
		int AnzahlStellen;
		int intAnzahl = 0;
		
		TextView tv;
		
		String strWert;
		String strBW;
		String strFettkennzahl = null;
		String strTiter;
		String strSZ;
		String strFreeAcid;
		String strEwFreeAcid;

		// Werte aus Konfigurationsdatei ("Preferences") auslesen und in Arrays eintragen
   		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
   		
   		String strRoutineID = prefs.getString("Routine", "1");
   		int intRoutineID = Integer.parseInt(strRoutineID);
   		
		tv = (TextView) findViewById(R.id.tvBerechnungTiter);
		tv.setText("Berechnung Fettkennzahl"); 
	
   	
   		//***********************************************************************
   		//********* Auslesen der Einwaagen  *************************************
   		//***********************************************************************
   		
   		for (int x=1; x<=8; x++)
	    {
	    	strWert = prefs.getString("Einwaage_"+x, "0");
	    	arrEinwaage[x]  = Double.parseDouble(strWert);	 	     	
	    }

   		//***********************************************************************
   		//********* Auslesen der Verbräuche *************************************
   		//***********************************************************************
   		
	    for (int x=1; x<=8; x++)
	    { 
	    	strWert = prefs.getString("Verbrauch_"+x, "0");
	    	if(strWert.equals("null") == false)
	    	{
	    		arrVerbrauch[x] = Double.parseDouble(strWert);
	    	}
	    	else
	    	{
	    		arrVerbrauch[x] = 0;
	    	}		     	
	    }	
		

		
   		//***********************************************************************
   		//**************** Auslesen der Säurezahl *******************************
   		//***********************************************************************
		
		strSZ = prefs.getString("Saeurezahl", "0");
		dblSZ = Double.parseDouble(strSZ);
		
   		//***********************************************************************
   		//******************* Auslesen Free Acid für OHZ USP ********************
   		//***********************************************************************
		
		strFreeAcid = prefs.getString("FreeAcid", "0");
		dblFreeAcid = Double.parseDouble(strFreeAcid);
		strEwFreeAcid = prefs.getString("EinwaageFreeAcid", "1");
		dblEwFreeAcid = Double.parseDouble(strEwFreeAcid);
   		
   		//***********************************************************************
   		//********* Auslesen der Nachkommastellen *******************************
   		//***********************************************************************
		
		AnzahlStellen = prefs.getInt("NachkommastellenGehalt", 2);
		
   		//***********************************************************************
   		//******************* Auslesen des Titers *******************************
   		//***********************************************************************
		
		strTiter = prefs.getString("Eingabe_3", "1");
		dblTiter = Double.parseDouble(strTiter);
		
   		//***********************************************************************
   		//********* Auslesen des Blindwertes ************************************
   		//***********************************************************************
		
		strBW = prefs.getString("DBW","0");
				
		if(strBW.equals("") == false)
		{
			dblBW = Double.parseDouble(strBW);
		}
		else
		{
			dblBW = 0;
		}
		
   		//***********************************************************************
   		//********* Anzeige der Ausgabefelder ***********************************
   		//***********************************************************************
		
		for (int x=1; x<=8; x++)
		{	
			int resId = getResources().getIdentifier("tvGehalt"+x, "id", getPackageName());
			tv = (TextView) findViewById(resId);
			
			if (arrEinwaage [x] == 0)
			{										
				tv.setVisibility(View.GONE);
			}
			else
			{
				intAnzahl = intAnzahl + 1;
				
				
		// ***********************************************************************
		// *********************** Berechnung ************************************
		// ***********************************************************************
				
				switch (intRoutineID) {	
				case 41: // ******** Säurezahl EP ********
					arrFettkennzahl[x] = (5.610 * arrVerbrauch[x] * dblTiter) / arrEinwaage[x]; 
					tv.setText(R.string.SZEP);
					strFettkennzahl = tv.getText().toString();
					break;
				case 42: // ******** Säurezahl USP ********			
					arrFettkennzahl[x] = (56.11 * arrVerbrauch[x] * dblTiter * 0.1) / arrEinwaage[x]; 
					tv.setText(R.string.SZUSP);
					strFettkennzahl = tv.getText().toString();
					break;
				case 43: // ******** Esterzahl USP ********			
					arrFettkennzahl[x] = (56.11 * (dblBW - arrVerbrauch[x]) * dblTiter * 0.5) / arrEinwaage[x]; 
					tv.setText(R.string.EZUSP);
					strFettkennzahl = tv.getText().toString();
					break;
				case 44: // ******** Hydroxylzahl EP - Methode A ********			
					arrFettkennzahl[x] = ((28.05 * (dblBW - arrVerbrauch[x]) * dblTiter) / arrEinwaage[x]) + dblSZ; 
					tv.setText(R.string.OHZEPA);
					strFettkennzahl = tv.getText().toString();
					break;
				case 45: // ******** Hydroxylzahl USP - mit Acid Value ********			
					arrFettkennzahl[x] = ((56.11 * 0.5 * dblTiter) / arrEinwaage[x]) * (dblBW - arrVerbrauch[x]) + dblSZ; 
					tv.setText(R.string.OHZUSPmitAV);
					strFettkennzahl = tv.getText().toString();
					break;
				case 46: // ******** Hydroxylzahl EP - Methode B ********			
					arrFettkennzahl[x] = ((5.610 * (arrVerbrauch[x] - dblBW) * dblTiter) / arrEinwaage[x]); 
					tv.setText(R.string.OHZEPB);
					strFettkennzahl = tv.getText().toString();
					break;
				case 47: // ******** Hydroxylzahl USP - ohne Acid Value ********			
					arrFettkennzahl[x] = ((56.11 * 0.5 * dblTiter) / arrEinwaage[x]) * (dblBW + ((arrEinwaage[x] * dblFreeAcid) / dblEwFreeAcid) - arrVerbrauch[x]); 
					tv.setText(R.string.OHZUSPohneAV);
					strFettkennzahl = tv.getText().toString();
					break;
				case 48: // ******** Iodzahl EP ********			
					arrFettkennzahl[x] = (1.269 * (dblBW - arrVerbrauch[x]) * dblTiter) / arrEinwaage[x]; 
					tv.setText(R.string.IZEP);
					strFettkennzahl = tv.getText().toString();
					break;
				case 49: // ******** Iodzahl USP ********			
					arrFettkennzahl[x] = (126.90 * (dblBW - arrVerbrauch[x]) * 0.1 * dblTiter) / ( 10 * arrEinwaage[x]);
					tv.setText(R.string.IZUSP);
					strFettkennzahl = tv.getText().toString();
					break;
				case 50: // ******** Peroxidzahl EP - Methode A ********			
					arrFettkennzahl[x] = (10 * (arrVerbrauch[x] - dblBW) * dblTiter) / arrEinwaage[x]; 
					tv.setText(R.string.POZEPA);
					strFettkennzahl = tv.getText().toString();
					break;
				case 51: // ******** Peroxidzahl USP ********			
					arrFettkennzahl[x] = (1000 * (arrVerbrauch[x] - dblBW) * 0.01 * dblTiter) / arrEinwaage[x];
					tv.setText(R.string.POZUSP);
					strFettkennzahl = tv.getText().toString();
					break;
				case 52: // ******** Peroxidzahl EP - Methode B ********			
					arrFettkennzahl[x] = (1000 * (dblBW - arrVerbrauch[x]) * 0.01 * dblTiter) / arrEinwaage[x];
					tv.setText(R.string.POZEPB);
					strFettkennzahl = tv.getText().toString();
					break;
				case 53: // ******** Verseifungszahl EP ********			
					arrFettkennzahl[x] = (28.05 * (dblBW - arrVerbrauch[x]) * dblTiter) / arrEinwaage[x]; 
					tv.setText(R.string.VZEP);
					strFettkennzahl = tv.getText().toString();
					break;
				case 54: // ******** Verseifungszahl USP ********			
					arrFettkennzahl[x] = (56.11 * (dblBW - arrVerbrauch[x]) * dblTiter *0.5) / arrEinwaage[x]; 
					tv.setText(R.string.VZUSP);
					strFettkennzahl = tv.getText().toString();
					break;
				}

				// *************************************************
				// ****** Berechnung Durchschnitt *************
				// *************************************************
				
				if (Double.isInfinite(arrFettkennzahl[x])) 
				{
					arrFettkennzahl[x] = 0;
				}
				// Summe Fettkennzahl
				dblFettkennzahl = dblFettkennzahl + arrFettkennzahl [x];	
		
				tv.setText(strFettkennzahl+ " "+ x +" = " +  ActivityTools.fktDoubleToStringFormat(arrFettkennzahl[x], AnzahlStellen));
			} // else if (arrEinwaage[x] == 0)
	    } // for (int x=1; x<=8; x++)
		
		// Ø Fettkennzahl errechnen
		
		dblFettkennzahl = dblFettkennzahl / intAnzahl;			
		dblSpeicher = dblFettkennzahl;
		
		if (intRoutineID == 41 || intRoutineID == 42)
		{		
			SharedPreferences.Editor prefEditor = prefs.edit(); 
			     	             
			prefEditor.putString("Saeurezahl", Double.toString(dblFettkennzahl));
			prefEditor.apply();
		}
		
		// Anzeige Ø Fettkennzahl
		tv = (TextView) findViewById(R.id.tvGehalt);
		String strFettkennzahlwert = ActivityTools.fktDoubleToStringFormat(dblFettkennzahl, AnzahlStellen);
		tv.setText("Ø " + strFettkennzahl + " = " + strFettkennzahlwert);
	
		// Berechnung der Relativen Standardabweichung

		AnzahlStellen = prefs.getInt("NachkommastellenRSD", 2);
		
		for (int x=1; x<=8; x++)
		{
			if (arrVerbrauch[x] != 0)
			{
				dblRSD = dblRSD + (Math.pow((arrFettkennzahl[x] - dblSpeicher),2));
			}
		}
		
		if (intAnzahl >= 2)
		{
			dblRSD = ((Math.sqrt(dblRSD / (intAnzahl-1))) * 100) / dblSpeicher;
		
			// Anzeige RSD		
			TextView rsd = (TextView) findViewById(R.id.tvRSD);
			rsd.setText("RSD = " +  ActivityTools.fktDoubleToStringFormat(dblRSD, AnzahlStellen) + "%");
		}
		else 
		{
			TextView rsd = (TextView) findViewById(R.id.tvRSD);
			rsd.setText("");
		}
		
	} // onResume

	/********************************************
	 ************** Menue Button ****************
	 ********************************************/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu, menu);
        return true;
    }   
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	Intent intent = null;
   
        switch (item.getItemId()) 
        {
        	case R.id.menu_Einstellungen:
           		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
           		SharedPreferences.Editor prefEditor = prefs.edit();
           		prefEditor.putString("Einstellungen", "20");
           		prefEditor.apply();
            	intent = new Intent(this, EinstellungenActivity.class);
            	intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            	startActivity(intent);
                return true;
             
            case R.id.menu_Hilfe:
            	intent = new Intent(this, HilfeActivity.class);
            	intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            	intent.putExtra("Kapitel", "Berechnung");
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
} // BerechnungFettkennzahlActivity
