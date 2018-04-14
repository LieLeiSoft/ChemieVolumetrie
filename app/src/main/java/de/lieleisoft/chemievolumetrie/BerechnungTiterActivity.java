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


public class BerechnungTiterActivity extends Activity {
	
	/*****************************************
	 ********* Variablen Deklaration *********
	 *****************************************/
	
	double[] arrEinwaage = new double[10+1];
	double[] arrVerbrauch = new double[10+1];
	double[] arrEingabe = new double[4+1];
	double[] arrTiter = new double[8+1];


	double dblTiter = 0;
	double dblSpeicher = 0;
	double dblRSD = 0;
	double dblBW = 0;
	double dblVorlage = 0;
	int intAnzahl = 0;
		
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
		
		String strWert;
		String strBW;
		String strVorlage;
		String strDirekteT;
		String strRücktitration;
		int AnzahlStellen;

		// Werte aus Konfigurationsdatei ("Preferences") auslesen und in Arrays eintragen
   		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
   		
   		String strRoutineID = prefs.getString("Routine", "1");
   		int intRoutineID = Integer.parseInt(strRoutineID);
   		
   		//***********************************************************************
   		//********* Auslesen der Einwaagen nur bei Urtiter **********************
   		//***********************************************************************
   		
   		
   		if (intRoutineID == 1)              // Titration mit Urtiter
   		{
   			for (int x=1; x<=9; x++)
   			{
   				strWert = prefs.getString("Einwaage_"+x, "0");
   				arrEinwaage[x]  = Double.parseDouble(strWert);
   			}
   		}
   		
   		//***********************************************************************
   		//********* Auslesen der Eingaben 								*********
   		//********* Eingabe_1 = Volumetrischer Faktor					*********
   		//********* Eingabe_2 = Molarität der Maßlösung ohne Titer		*********
   		//********* Eingabe_3 = Titer der Maßlösung mit Titer			*********
   		//********* Eingabe_4 = Molarität der Maßlösung mit Titer		*********
   		//***********************************************************************
   		
   		for (int x=1; x<=4; x++)      // Titration mit anderer Maßlösung
   		{
   			strWert = prefs.getString("Eingabe_"+x, "0"); 				
   			
	    	if(strWert.equals("") == false)
	    	{
	   			arrEingabe[x]  = Double.parseDouble(strWert);														
	    	}
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
		
		intAnzahl = 0;
		dblRSD = 0;
		dblTiter = 0;
		
   		//***********************************************************************
   		//********* Auslesen der Nachkommastellen *******************************
   		//***********************************************************************
		
		AnzahlStellen = prefs.getInt("NachkommastellenGehalt", 2);
		
   		//***********************************************************************
   		//********* Auslesen der Rüccktitration *********************************
   		//***********************************************************************
		
		strRücktitration = prefs.getString("Rücktitration","nein");
		
   		//***********************************************************************
   		//********* Auslesen der Vorlage ****************************************
   		//***********************************************************************
		
		strVorlage = prefs.getString("Vorlage","0");
		
    	if (strVorlage.equals("") == false)	
    	{
    		dblVorlage = Double.parseDouble(strVorlage);
    	}
    	    	
    	else
    	{
    		dblVorlage = 0;	
    	}
		
   		//***********************************************************************
   		//********* Auslesen der Titrationsart **********************************
   		//***********************************************************************
    	
		strDirekteT = prefs.getString("DirekteT","ja");
		
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
			// Id wird ermittelt
			int resId = getResources().getIdentifier("tvGehalt"+x, "id", getPackageName());
					
			// Das Feld der Objektvariable wird über die Id gesucht
			TextView tv = (TextView) findViewById(resId);
			
			// Leere Felder werden ausgeblendet
			
			if ((intRoutineID == 1 && arrEinwaage [x] == 0) || (intRoutineID == 2 && arrVerbrauch[x] == 0))
			{										
				tv.setVisibility(View.GONE);
			}
			else
			{
				intAnzahl = intAnzahl + 1;
				
				
				// *************************************************
				// ****** Berechnung Titer mit Urtiter *************
				// *************************************************
				
				if (intRoutineID == 1 )
				{															
					if (strRücktitration =="ja")
					{
						arrTiter[x] = (arrEinwaage[x] * arrEinwaage[9] * 10) / ((dblBW - arrVerbrauch[x]) * arrEingabe [1]); // ohne Vorlage mit RT
					}
					else
					{
						arrTiter[x] = (arrEinwaage[x] * arrEinwaage[9] * 10) / ((arrVerbrauch[x] - dblBW) * arrEingabe [1]); // ohne Vorlage ohne RT
					}
				}
				
				// ***************************************************
				// ****** Berechnung Titer mit Maßlösung *************
				// ***************************************************
				
				if (intRoutineID == 2 )
				{																		// Eingabe_1 = Volumetrischer Faktor
					if (strRücktitration =="ja")										// 1 Eingabe_2 = Molarität der Maßlösung ohne Titer
					{																	// 2 Eingabe_3 = Titer der Maßlösung mit Titer
						if (strDirekteT == "ja")										// 3 Eingabe_4 = Molarität der Maßlösung mit Titer
						{
							arrTiter[x] = (dblVorlage * arrEingabe [3] * arrEingabe [4]) / ((dblBW - arrVerbrauch[x]) * arrEingabe [2]);  // Direkte Titration + RT
						}
						else
						{
							arrTiter[x] = ((dblBW - arrVerbrauch[x]) * arrEingabe [3] * arrEingabe [4]) / (dblVorlage * arrEingabe [2]);  // Inverse Titration + RT
						}
					}
					else
					{
						if (strDirekteT == "ja")	
						{
							arrTiter[x] = (dblVorlage * arrEingabe [3] * arrEingabe [4]) / ((arrVerbrauch[x] - dblBW) * arrEingabe [2]);  // Direkte Titration ohne RT
						}
						else
						{
							arrTiter[x] = ((arrVerbrauch[x] - dblBW) * arrEingabe [3] * arrEingabe [4]) / (dblVorlage * arrEingabe [2]);  // Inverse Titration ohne RT
						}
					}
					
				}	
				
				// *************************************************
				// ****** Berechnung Titerdurchschnitt *************
				// *************************************************
				
				if (Double.isInfinite(arrTiter[x])) 
				{
					arrTiter[x] = 0;
				}
				// Summe Titer
				dblTiter = dblTiter + arrTiter [x];								
				tv.setText("Titer "+ x +" = " +  ActivityTools.fktDoubleToStringFormat(arrTiter[x], 4));
			} // else if (arrEinwaage[x] == 0)
	    } // for (int x=1; x<=8; x++)
		
		// Ø Titer errechnen
		
		dblTiter = dblTiter / intAnzahl;			
		dblSpeicher = dblTiter;
		
		// Anzeige Ø Titer
		TextView tv = (TextView) findViewById(R.id.tvGehalt);
		String strTiter = ActivityTools.fktDoubleToStringFormat(dblTiter, 4);
		tv.setText("Ø Titer = " + strTiter);
	
		// Berechnung der Relativen Standardabweichung

		AnzahlStellen = prefs.getInt("NachkommastellenRSD", 2);
		
		for (int x=1; x<=8; x++)
		{
			if (arrVerbrauch[x] != 0)
			{
				dblRSD = dblRSD + (Math.pow((arrTiter[x] - dblSpeicher),2));
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
} // BerechnungTiterActivity
