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
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import de.lieleisoft.chemievolumetrie.R;


public class BerechnungActivity extends Activity {
	/*****************************************
	 ********* Variablen Deklaration *********
	 *****************************************/
	
	double[] arrEinwaage   = new double[10+1];
	double[] arrVerbrauch  = new double[10+1];
	double[] arrEingabe	   = new double[4+1];
	double[] arrGehalt     = new double[8+1];
	double[] arrGehaltasis = new double[8+1];
	double[] arrGehaltTS   = new double[8+1];
	
	double dblGehaltasis = 0;
	double dblGehaltTS   = 0;
	double dblSpeicher   = 0;
	double dblRSD        = 0;
	double dblBW         = 0;
	double dblVorlage	 = 0;
	int intAnzahl        = 0;
		
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.berechnung);

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
		
       	// Zugang zur Konfigurationsdatei ("Preferences") herstellen
   		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());		
   		
   		// **************************************************************************************
		// *** Werte aus Konfigurationsdatei ("Preferences") auslesen und in Arrays eintragen ***
   		// **************************************************************************************

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
   		//********* Auslesen der Eingaben 								*********
   		//********* Eingabe_1 = Volumetrischer Faktor					*********
   		//********* Eingabe_2 = Molarität der Maßlösung ohne Titer		*********
   		//********* Eingabe_3 = Titer der Maßlösung mit Titer			*********
   		//********* Eingabe_4 = Molarität der Maßlösung mit Titer		*********
   		//***********************************************************************
	    
	    for (int x=1; x<=4; x++)
	    { 
	    	strWert = prefs.getString("Eingabe_"+x, "0");
	     	
	    	if(strWert.equals("") == false)
	    	{
	   			arrEingabe[x]  = Double.parseDouble(strWert);																	
	    	}
	    }
	    //************************************************
		//********* Berechnung des Gehalts ***************
	    //************************************************
		
		AnzahlStellen = prefs.getInt("NachkommastellenGehalt", 2);
		
		strRücktitration = prefs.getString("Rücktitration","nein");
		
		strDirekteT = prefs.getString("DirekteT","ja");
		
		strVorlage = prefs.getString("Vorlage","0");
		
		if (strVorlage.equals("") == false) // hier wird verhindert, das bei einem versehentlichen Aufruf ohne Eingabe
		{									// der Vorlage, ein "" in ein dbl umgewandelt wird.
			dblVorlage = Double.parseDouble(strVorlage);
		}
		else
		{
			dblVorlage = 0;
		}
		
		strBW = prefs.getString("DBW","0");
		dblBW = Double.parseDouble(strBW);
	
		intAnzahl = 0;
		dblRSD = 0;
		dblGehaltasis = 0;
		
		for (int x=1; x<=8; x++)
		{	
			// Id wird ermittelt
			int resId = getResources().getIdentifier("tvGehalt"+x, "id", getPackageName());
					
			// Das Feld der Objektvariable wird über die Id gesucht
			TextView tv = (TextView) findViewById(resId);
			
			// Leere Felder werden ausgeblendet
			if (arrEinwaage[x] == 0)
			{										
				tv.setVisibility(View.GONE);
			}
			else
			{
				intAnzahl = intAnzahl + 1;
				
				//*************************************											// arrEingabe[1] = Faktor
				//******** Berechnung as is ***********											// arrEingabe[2] = Molarität der Maßlösung ohne Titer
				//*************************************											// arrEingabe[3] = Titer der Maßlösung mit Titer
																								// arrEingabe[4] = Molarität der Maßlösung mit Titer
				if (strRücktitration == "ja")
				{
					if(strDirekteT == "ja")
					{																
						if(strVorlage == "0")
						{
							arrGehalt[x] = (((dblBW - arrVerbrauch[x]) * arrEingabe[3] * arrEingabe[1]) / (arrEinwaage[x] * 10)); // RT+ , DT+ , VL-
						}
						else
						{
							arrGehalt[x] = (((dblVorlage - (dblBW - arrVerbrauch[x])) * arrEingabe[3] * arrEingabe[1]) / (arrEinwaage[x] * 10)); // RT+ , DT+ , VL+
						}
					}
					/*  ************ Berechnung noch unvollständig ************
					
					else
					{
						if(strVorlage == "0")
						{
							arrGehalt[x] = (((dblBW - arrVerbrauch[x]) * arrEingabe[3] * arrEingabe[1]) / (arrEinwaage[x] * 10)); // RT+ , DT- , VL-
						}
						else
						{
							arrGehalt[x] = (((dblVorlage - (dblBW - arrVerbrauch[x])) * arrEingabe[3] * arrEingabe[1]) / (arrEinwaage[x] * 10)); // RT+ , DT- , VL+
						}
					}
					*/
				}
				else
				{
					if(strDirekteT == "ja")														
					{																			
						if(strVorlage == "0")
						{
							arrGehalt[x] = (((arrVerbrauch[x] - dblBW) * arrEingabe[3] * arrEingabe[1]) / (arrEinwaage[x] * 10)); // RT- , DT+ , VL-
						}
						else
						{
							arrGehalt[x] = (((dblVorlage - (arrVerbrauch[x] - dblBW)) * arrEingabe[3] * arrEingabe[1]) / (arrEinwaage[x] * 10)); // RT- , DT+ , VL+
						}
					}
					/*  ************ Berechnung noch unvollständig ************
					
					else
					{
						if(strVorlage == "0")
						{
							arrGehalt[x] = (((arrVerbrauch[x] - dblBW) * arrEingabe[3] * arrEingabe[1]) / (arrEinwaage[x] * 10)); // RT- , DT- , VL-
						}
						else
						{
							arrGehalt[x] = (((dblVorlage - (arrVerbrauch[x] - dblBW)) * arrEingabe[3] * arrEingabe[1]) / (arrEinwaage[x] * 10)); // RT- , DT- , VL+
						}
					}	
					*/
				}
				
				//***************************************
				//******** Berechnung Ø as is ***********
				//***************************************
				
				
				if (Double.isInfinite(arrGehalt[x])) 
				{
					arrGehalt[x] = 0;
				}
				
				// Berechnung des Durchschnittgehaltes
				
				dblGehaltasis = dblGehaltasis + arrGehalt [x];
								
				// Runden des Gehaltes
				
				arrGehaltasis[x] = ActivityTools.fktRunden(arrGehalt[x], AnzahlStellen);

				tv.setText("Gehalt Pr."+ (x) +" = " + ActivityTools.fktDoubleToStringFormat(arrGehaltasis[x], AnzahlStellen)+ "% as is");				
			} // else if (arrEinwaage[x] == 0)
			
	    } // for (int x=1; x<=8; x++)
		
		// Ø Gehalt errechnen
		
		dblGehaltasis = dblGehaltasis / intAnzahl;
		
		// Vorbereitung für TS vor dem Runden
		
		dblSpeicher = dblGehaltasis;
		
		// Anzeige Ø Gehalt
		TextView tv = (TextView) findViewById(R.id.tvGehalt);
		tv.setText("Ø Gehalt = " + ActivityTools.fktDoubleToStringFormat(dblGehaltasis, AnzahlStellen) + "% as is");
		
		// Berechnung der Relativen Standardabweichung

		AnzahlStellen = prefs.getInt("NachkommastellenRSD", 2);
		
		for (int x=1; x<=8; x++)
		{
			if (arrEinwaage[x] != 0)
			{
				dblRSD = dblRSD + (Math.pow((arrGehalt[x] - dblSpeicher),2));
			}
		}
		
		if (intAnzahl >= 2)
		{
			dblRSD = ((Math.sqrt(dblRSD / (intAnzahl-1))) * 100) / dblSpeicher;
		
			// Anzeige RSD		
			TextView rsd = (TextView) findViewById(R.id.tvRSD);
			rsd.setText("RSD = " + ActivityTools.fktDoubleToStringFormat(dblRSD, AnzahlStellen) + "%");
		}
		else 
		{
			TextView rsd = (TextView) findViewById(R.id.tvRSD);
			rsd.setText("");
		}
		
	} // onResume
		
	public void btnBerechneTS(View v)
	{		
		double dblWasser = 0;
		int AnzahlStellen;
		
       	// Zugang zur Konfigurationsdatei ("Preferences") herstellen
   		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());		

   		AnzahlStellen = prefs.getInt("NachkommastellenGehalt", 2);

		EditText etWasser = (EditText) findViewById(R.id.edWasser);
		String strWasser = etWasser.getText().toString();
		if (strWasser.equals("") == false) 
		{
			dblWasser = Double.parseDouble(strWasser);
		}
		
		for (int x=1; x<=8; x++)
		{	
			// Id wird ermittelt
			int resId = getResources().getIdentifier("tvGehalt"+x, "id", getPackageName());
					
			// Das Feld der Objektvariable wird über die Id gesucht
			TextView tv = (TextView) findViewById(resId);
			
			if (arrEinwaage[x] == 0)
			{										
				tv.setVisibility(View.GONE);;
			}	
			else	
			{	
				if (dblWasser == 0)
				{
					tv.setText("Gehalt Pr."+ x +" = " + ActivityTools.fktDoubleToStringFormat(arrGehaltasis[x], AnzahlStellen)+ "% as is");
					
					// Ø Gehalt as is
					tv = (TextView) findViewById(R.id.tvGehalt);
					tv.setText("Ø Gehalt = " + ActivityTools.fktDoubleToStringFormat(dblGehaltasis, AnzahlStellen) + "% as is");
				}
				else
				{	
					// neue Berechnung auf TS
				
					arrGehaltTS [x] = arrGehalt [x] * 100 / (100 - dblWasser);			
				
					tv.setText("Gehalt Pr."+ x +" = " + ActivityTools.fktDoubleToStringFormat(arrGehaltTS[x], AnzahlStellen)+ "% TS");													
				
					// Ø Gehalt
					
					dblGehaltTS = dblSpeicher * 100 / (100 - dblWasser);
					
					// Anzeige Ø Gehalt
					tv = (TextView) findViewById(R.id.tvGehalt);
					tv.setText("Ø Gehalt = " + ActivityTools.fktDoubleToStringFormat(dblGehaltTS, AnzahlStellen) + "% TS");
				}								
			}
		} // for (int x=1; x<=8; x++)		

		// numerische Tastatur explizit ausschalten 
		InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(etWasser.getWindowToken(), 0);		
	} // btnBerechneTS
	
	
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
                System.exit(0);
                
            default:
                return super.onOptionsItemSelected(item);
        }
    }
} // BerechnungActivity
