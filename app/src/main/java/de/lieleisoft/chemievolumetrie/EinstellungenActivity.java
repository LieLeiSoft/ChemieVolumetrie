package de.lieleisoft.chemievolumetrie;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;
import de.lieleisoft.chemievolumetrie.R;

public class EinstellungenActivity extends Activity {
		
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     	setContentView(R.layout.einstellungen);	     
  
		// Activity registrieren, damit sie später an zentraler Stelle (Hauptmenue) geschlossen werden kann
	    ActivityRegistry.register(this);
     	
 				
    } // onCreate

    /** wird ausgeführt, wenn Activicty angezeigt wird */
    @Override
    public void onResume() {
    	super.onResume();
    	    	
       	// Zugang zur Konfigurationsdatei ("Preferences") herstellen
   		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());		
		
   		String strTextGroesse;
   		String strButtonhoehe;
   		String strEinstellungen;
   		TextView tv;
   		TextView tv1;
   		TextView tv2;
   		
   		strEinstellungen = prefs.getString("Einstellungen", "20");
   		
   		int intEinstellungen = Integer.parseInt(strEinstellungen);

   		switch (intEinstellungen) {
   		
   	   	// **********************************************************************
   	   	// ***************** Einstellungen im Hauptmenue ************************
   	   	// **********************************************************************
   		case 1:		
   	   		strTextGroesse = prefs.getString("TG_Hauptmenue", "16");
   	   		strButtonhoehe = prefs.getString("BH_Hauptmenue", "130");
   	   		
   			tv = (TextView) findViewById(R.id.TextView07); 
   			tv.setVisibility(View.GONE);
   			tv = (TextView) findViewById(R.id.TextView03); 
   			tv.setVisibility(View.GONE);
   			tv = (TextView) findViewById(R.id.Button03); 
   			tv.setVisibility(View.GONE);
   			tv = (TextView) findViewById(R.id.Gehalt); 
   			tv.setVisibility(View.GONE);
   			tv = (TextView) findViewById(R.id.Button04); 
   			tv.setVisibility(View.GONE);
   			tv = (TextView) findViewById(R.id.TextView05); 
   			tv.setVisibility(View.GONE);
   			tv = (TextView) findViewById(R.id.Button06); 
   			tv.setVisibility(View.GONE);
   			tv = (TextView) findViewById(R.id.RSD); 
   			tv.setVisibility(View.GONE);
   			tv = (TextView) findViewById(R.id.Button05); 
   			tv.setVisibility(View.GONE);
   			
   	   		tv1 = (TextView) findViewById(R.id.TextSize2);
   	   		tv1.setText(strTextGroesse);
   	        
   	    	tv2 = (TextView) findViewById(R.id.Buttonhoehe2);
   	    	tv2.setText(strButtonhoehe);
   	    	break;
   	    	
   	    // **********************************************************************
   	   	// ****************** Einstellungen bei den Fettkennzahlen **************
   	   	// **********************************************************************
   		case 2:		
   	   		strTextGroesse = prefs.getString("TG_Fettkennzahlen", "13");
   	   		strButtonhoehe = prefs.getString("BH_Fettkennzahlen", "125");
   	   		
   			tv = (TextView) findViewById(R.id.TextView07); 
   			tv.setVisibility(View.GONE);
   			tv = (TextView) findViewById(R.id.TextView03); 
   			tv.setVisibility(View.GONE);
   			tv = (TextView) findViewById(R.id.Button03); 
   			tv.setVisibility(View.GONE);
   			tv = (TextView) findViewById(R.id.Gehalt); 
   			tv.setVisibility(View.GONE);
   			tv = (TextView) findViewById(R.id.Button04); 
   			tv.setVisibility(View.GONE);
   			tv = (TextView) findViewById(R.id.TextView05); 
   			tv.setVisibility(View.GONE);
   			tv = (TextView) findViewById(R.id.Button06); 
   			tv.setVisibility(View.GONE);
   			tv = (TextView) findViewById(R.id.RSD); 
   			tv.setVisibility(View.GONE);
   			tv = (TextView) findViewById(R.id.Button05); 
   			tv.setVisibility(View.GONE);
   			
   	   		tv1 = (TextView) findViewById(R.id.TextSize2);
   	   		tv1.setText(strTextGroesse);
   	        
   	    	tv2 = (TextView) findViewById(R.id.Buttonhoehe2);
   	    	tv2.setText(strButtonhoehe);
   	    	break;
   	    	
   	    // **********************************************************************
   	   	// ****************** Einstellungen bei der Molmasse ********************
   	   	// **********************************************************************
   		case 3:			
   	   		strTextGroesse = prefs.getString("TG_Molmasse", "13");
   	   		strButtonhoehe = prefs.getString("BH_Molmasse", "125");
   	   		
   			tv = (TextView) findViewById(R.id.TextView07); 
   			tv.setVisibility(View.GONE);
   			tv = (TextView) findViewById(R.id.TextView03); 
   			tv.setVisibility(View.GONE);
   			tv = (TextView) findViewById(R.id.Button03); 
   			tv.setVisibility(View.GONE);
   			tv = (TextView) findViewById(R.id.Gehalt); 
   			tv.setVisibility(View.GONE);
   			tv = (TextView) findViewById(R.id.Button04); 
   			tv.setVisibility(View.GONE);
   			tv = (TextView) findViewById(R.id.TextView05); 
   			tv.setVisibility(View.GONE);
   			tv = (TextView) findViewById(R.id.Button06); 
   			tv.setVisibility(View.GONE);
   			tv = (TextView) findViewById(R.id.RSD); 
   			tv.setVisibility(View.GONE);
   			tv = (TextView) findViewById(R.id.Button05); 
   			tv.setVisibility(View.GONE);
   		
   	   		tv1 = (TextView) findViewById(R.id.TextSize2);
   	   		tv1.setText(strTextGroesse);
   	        
   	    	tv2 = (TextView) findViewById(R.id.Buttonhoehe2);
   	    	tv2.setText(strButtonhoehe);
   	    	break;
   	     	
   	   	// **********************************************************************
   	   	// ******************* Einstellungen bei den Berechnungen ***************
   	    // **********************************************************************
   		case 20:
   			
   			
   			int intGehalt = prefs.getInt("NachkommastellenGehalt", 2);
   			int intRSD = prefs.getInt("NachkommastellenRSD", 2);
   	   		
   			String strGehalt = Integer.toString((int) intGehalt);
   			String strRSD = Integer.toString((int) intRSD);
   			
   			tv = (TextView) findViewById(R.id.TextView06); 
   			tv.setVisibility(View.GONE);
   			tv = (TextView) findViewById(R.id.TextSize1); 
   			tv.setVisibility(View.GONE);
   			tv = (TextView) findViewById(R.id.button1); 
   			tv.setVisibility(View.GONE);
   			tv = (TextView) findViewById(R.id.TextSize2); 
   			tv.setVisibility(View.GONE);
   			tv = (TextView) findViewById(R.id.button2); 
   			tv.setVisibility(View.GONE);
   			tv = (TextView) findViewById(R.id.Buttonhoehe1); 
   			tv.setVisibility(View.GONE);
   			tv = (TextView) findViewById(R.id.Button01); 
   			tv.setVisibility(View.GONE);
   			tv = (TextView) findViewById(R.id.Buttonhoehe2); 
   			tv.setVisibility(View.GONE);
   			tv = (TextView) findViewById(R.id.Button02); 
   			tv.setVisibility(View.GONE);
   			
   	   		tv1 = (TextView) findViewById(R.id.Gehalt);
   	   		tv1.setText(strGehalt);
   	        
   	    	tv2 = (TextView) findViewById(R.id.RSD);
   	    	tv2.setText(strRSD);
   	    	break;
   		}
    	
    } // onResume
    
	/** wird ausgeführt, wenn zu einer anderen Activicty gewechselt wird */
	@Override
	public void onPause() {
		super.onPause();
		
       	// Zugang zur Konfigurationsdatei ("Preferences") herstellen
   		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
   		SharedPreferences.Editor prefEditor = prefs.edit();

   		String strEinstellungen;
   		TextView tv1;
   		TextView tv2;
   		
   		strEinstellungen = prefs.getString("Einstellungen", "20");
   		int intEinstellungen = Integer.parseInt(strEinstellungen);
   		
   		switch (intEinstellungen) {
   		
   	// **********************************************************************
   	// ***************** Einstellungen im Hauptmenue ************************
   	// **********************************************************************
   		case 1:
   	   		tv1 = (TextView) findViewById(R.id.TextSize2);       
   	        prefEditor.putString("TG_Hauptmenue", tv1.getText().toString());
   	        
   	    	tv2 = (TextView) findViewById(R.id.Buttonhoehe2);
   	    	prefEditor.putString("BH_Hauptmenue", tv2.getText().toString());
   	    	prefEditor.apply();
   	    	break;
   	    	
   	// **********************************************************************
   	// ****************** Einstellungen bei den Fettkennzahlen **************
   	// ********************************************************************** 	    	
   		case 2:			
   	   		tv1 = (TextView) findViewById(R.id.TextSize2);       
   	        prefEditor.putString("TG_Fettkennzahlen", tv1.getText().toString());
   	        
   	    	tv2 = (TextView) findViewById(R.id.Buttonhoehe2);
   	    	prefEditor.putString("BH_Fettkennzahlen", tv2.getText().toString());
   	    	prefEditor.apply();
   	    	break;
   	    	
   	// **********************************************************************
   	// ****************** Einstellungen bei der Molmasse ********************
   	// **********************************************************************
   		case 3:			
   	   		tv1 = (TextView) findViewById(R.id.TextSize2);       
   	        prefEditor.putString("TG_Molmasse", tv1.getText().toString());
   	        
   	    	tv2 = (TextView) findViewById(R.id.Buttonhoehe2);
   	    	prefEditor.putString("BH_Molmasse", tv2.getText().toString());
   	    	prefEditor.apply();
   	    	break;
   	    	
   	// **********************************************************************
   	// ******************* Einstellungen bei den Berechnungen ***************
   	// **********************************************************************
   		case 20:
   	   		tv1 = (TextView) findViewById(R.id.Gehalt); 
   	   		String strGehalt = tv1.getText().toString();
   	   		int intGehalt = Integer.parseInt(strGehalt);
   	        prefEditor.putInt("NachkommastellenGehalt", intGehalt);
   	        
   	    	tv2 = (TextView) findViewById(R.id.RSD);
   	   		String strRSD = tv2.getText().toString();
   	   		int intRSD = Integer.parseInt(strRSD);
   	    	prefEditor.putInt("NachkommastellenRSD", intRSD);
   	    	prefEditor.apply();
   	    	break;
   		case 99:	
   			break;
   		}	    	
	} // onPause
    
	// ***********************************************************************************************
	// ***********************************************************************************************
	// ***********************************************************************************************
	
	
	public void btnGehaltMinus(View v)
    {
		TextView tv;
     	String strEingabe;
     	int intEingabe;
     	
 		tv = (TextView) findViewById(R.id.Gehalt);
		strEingabe = tv.getText().toString();
     	intEingabe = Integer.parseInt(strEingabe);

     	if (intEingabe >=1)
     	{
     		intEingabe = intEingabe - 1;
     	}
     	
 		strEingabe = Integer.toString((int) intEingabe);
 		tv.setText(strEingabe);
    }
    
    public void btnGehaltPlus(View v)
    {
		TextView tv;
     	String strEingabe;
     	int intEingabe;
     	
 		tv = (TextView) findViewById(R.id.Gehalt);
 		strEingabe = tv.getText().toString(); 
     	intEingabe = Integer.parseInt(strEingabe);

     	if (intEingabe <=4)
     	{
     		intEingabe = intEingabe + 1;
     	}
     	
 		strEingabe = Integer.toString((int) intEingabe);
 		tv.setText(strEingabe);
    }	
    
	public void btnRSDMinus(View v)
    {
		TextView tv;
     	String strEingabe;
     	int intEingabe;
     	
 		tv = (TextView) findViewById(R.id.RSD);
		strEingabe = tv.getText().toString();
     	intEingabe = Integer.parseInt(strEingabe);

     	if (intEingabe >=1)
     	{
     		intEingabe = intEingabe - 1;
     	}
     	
 		strEingabe = Integer.toString((int) intEingabe);
 		tv.setText(strEingabe);
    }
    
    public void btnRSDPlus(View v)
    {
		TextView tv;
     	String strEingabe;
     	int intEingabe;
     	
 		tv = (TextView) findViewById(R.id.RSD);
 		strEingabe = tv.getText().toString(); 
     	intEingabe = Integer.parseInt(strEingabe);

     	if (intEingabe <=4)
     	{
     		intEingabe = intEingabe + 1;
     	}
     	
 		strEingabe = Integer.toString((int) intEingabe);
 		tv.setText(strEingabe);
    }
	public void btnMinus(View v)
    {
     	TextView tv;
     	int intEingabe;
     	String strEingabe;
    	
    	tv = (TextView) findViewById(R.id.TextSize2);
    	strEingabe = tv.getText().toString();
    	intEingabe = Integer.parseInt(strEingabe);
    	
     	if (intEingabe >=11)
     	{
     		intEingabe = intEingabe - 1;
     	}
    	
    	strEingabe = Integer.toString((int) intEingabe);
    	
    	tv.setText(strEingabe);
    }
    
    public void btnPlus(View v)
    {
     	TextView tv;
     	int intEingabe;
     	String strEingabe;
    	
    	tv = (TextView) findViewById(R.id.TextSize2);
    	strEingabe = tv.getText().toString();
    	intEingabe = Integer.parseInt(strEingabe);
    	
     	if (intEingabe <=29)
     	{
     		intEingabe = intEingabe + 1;
     	}
    	
    	strEingabe = Integer.toString((int) intEingabe);
    	
    	tv.setText(strEingabe);
    }	
    
	public void btnButtonhoeheMinus(View v)
    {
     	TextView tv;
     	int intEingabe;
     	String strEingabe;
    	
    	
    	tv = (TextView) findViewById(R.id.Buttonhoehe2);
    	strEingabe = tv.getText().toString();
    	intEingabe = Integer.parseInt(strEingabe);
     	
    	if (intEingabe >=100)
     	{
    	intEingabe = intEingabe - 10;
     	}
    	
    	strEingabe = Integer.toString((int) intEingabe);

    	tv.setText(strEingabe);
    }
    
    public void btnButtonhoehePlus(View v)
    {
     	TextView tv;
     	int intEingabe;
     	String strEingabe;
    	
    	tv = (TextView) findViewById(R.id.Buttonhoehe2);
    	strEingabe = tv.getText().toString();
    	intEingabe = Integer.parseInt(strEingabe);
    	
     	if (intEingabe <=500)
     	{
    	intEingabe = intEingabe + 10;
     	}
     	
    	strEingabe = Integer.toString((int) intEingabe);

    	tv.setText(strEingabe);
    }
    

} // Public Class   