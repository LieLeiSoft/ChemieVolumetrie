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
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import de.lieleisoft.chemievolumetrie.R;

public class FettkennzahlenActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     	setContentView(R.layout.fettkennzahlen);	
     	
		// Activity registrieren, damit sie später an zentraler Stelle (Hauptmenue) geschlossen werden kann
	    ActivityRegistry.register(this);
    }
    
    /** wird ausgeführt, wenn Activicty angezeigt wird */
	@Override
	public void onResume() {
		super.onResume();
		
		// bestimmte Einträge aus Konfigurationsdatei ("Preferences") entfernen
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		
   		String strTextSize = prefs.getString("TG_Fettkennzahlen", "12");
   		String strButtonhoehe = prefs.getString("BH_Fettkennzahlen", "200");
   		
   		int intTextSize = Integer.parseInt(strTextSize);
   		int intButtonhoehe = Integer.parseInt(strButtonhoehe);
   		
		for (int x=1; x<=16; x++)															 
		{
	    	int resId = getResources().getIdentifier("button"+x, "id", getPackageName());
	        TextView tv = (TextView) findViewById(resId);
	        
	        // Höhe der Textview wird über Layout-Parameter eingestellt, weil "tv.setHeight(intButtonhoehe);" scheinbar ab Android 5 NICHT mehr funktioniert :-( 
	        LayoutParams params = (LayoutParams) tv.getLayoutParams();
	        params.height = intButtonhoehe;
	        tv.setLayoutParams(params);	        
     
	        tv.setTextSize(intTextSize);
		}    		
		
	} // onResume
	
    public void btn_SZ_EP(View v)
    {
        // Zugang zur Konfigurationsdatei ("Preferences") herstellen
     	SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
     	SharedPreferences.Editor prefEditor = prefs.edit(); 
     	             
     	prefEditor.putString("Routine", "41");
    	prefEditor.apply();		       
    	
    	Intent myIntent = new Intent(v.getContext(), EinwaageActivity.class);
                   
        // verhindern, dass die Activity ein weiteres Mal geöffnet wird, wenn sie bereits geöffnet wurde
        myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

		// Activity aufrufen
        startActivity(myIntent);
    }
    
    public void btn_SZ_USP(View v)
    {
        // Zugang zur Konfigurationsdatei ("Preferences") herstellen
     	SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
     	SharedPreferences.Editor prefEditor = prefs.edit(); 
     	             
     	prefEditor.putString("Routine", "42");
    	prefEditor.apply();		       
    	
    	Intent myIntent = new Intent(v.getContext(), EinwaageActivity.class);
                   
        // verhindern, dass die Activity ein weiteres Mal geöffnet wird, wenn sie bereits geöffnet wurde
        myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

		// Activity aufrufen
        startActivity(myIntent);
    }

    public void btn_EZ_USP(View v)
    {
        // Zugang zur Konfigurationsdatei ("Preferences") herstellen
     	SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
     	SharedPreferences.Editor prefEditor = prefs.edit(); 
     	             
     	prefEditor.putString("Routine", "43");
    	prefEditor.apply();		       
    	
    	Intent myIntent = new Intent(v.getContext(), EinwaageActivity.class);
                   
        // verhindern, dass die Activity ein weiteres Mal geöffnet wird, wenn sie bereits geöffnet wurde
        myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

		// Activity aufrufen
        startActivity(myIntent);
    }
    
    public void btn_OHZ_EP_A(View v)
    {
        // Zugang zur Konfigurationsdatei ("Preferences") herstellen
     	SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
     	SharedPreferences.Editor prefEditor = prefs.edit(); 
     	             
     	prefEditor.putString("Routine", "44");
    	prefEditor.apply();		       
    	
    	Intent myIntent = new Intent(v.getContext(), AcidValueActivity.class);
                   
        // verhindern, dass die Activity ein weiteres Mal geöffnet wird, wenn sie bereits geöffnet wurde
        myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

		// Activity aufrufen
        startActivity(myIntent);
    }
    
    public void btn_OHZ_USP_AV(View v)
    {
        // Zugang zur Konfigurationsdatei ("Preferences") herstellen
     	SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
     	SharedPreferences.Editor prefEditor = prefs.edit(); 
     	             
     	prefEditor.putString("Routine", "45");
    	prefEditor.apply();		       
    	
    	Intent myIntent = new Intent(v.getContext(), AcidValueActivity.class);
                   
        // verhindern, dass die Activity ein weiteres Mal geöffnet wird, wenn sie bereits geöffnet wurde
        myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

		// Activity aufrufen
        startActivity(myIntent);
    }
    
    public void btn_OHZ_EP_B(View v)
    {
        // Zugang zur Konfigurationsdatei ("Preferences") herstellen
     	SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
     	SharedPreferences.Editor prefEditor = prefs.edit(); 
     	             
     	prefEditor.putString("Routine", "46");
    	prefEditor.apply();		       
    	
    	Intent myIntent = new Intent(v.getContext(), EinwaageActivity.class);
                   
        // verhindern, dass die Activity ein weiteres Mal geöffnet wird, wenn sie bereits geöffnet wurde
        myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

		// Activity aufrufen
        startActivity(myIntent);
    }
    
    public void btn_OHZ_USP(View v)
    {
        // Zugang zur Konfigurationsdatei ("Preferences") herstellen
     	SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
     	SharedPreferences.Editor prefEditor = prefs.edit(); 
     	             
     	prefEditor.putString("Routine", "47");
    	prefEditor.apply();		       
    	
    	Intent myIntent = new Intent(v.getContext(), EinwaageActivity.class);
                   
        // verhindern, dass die Activity ein weiteres Mal geöffnet wird, wenn sie bereits geöffnet wurde
        myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

		// Activity aufrufen
        startActivity(myIntent);
    }
    
    public void btn_IZ_EP(View v)
    {
        // Zugang zur Konfigurationsdatei ("Preferences") herstellen
     	SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
     	SharedPreferences.Editor prefEditor = prefs.edit(); 
     	             
     	prefEditor.putString("Routine", "48");
    	prefEditor.apply();		       
    	
    	Intent myIntent = new Intent(v.getContext(), EinwaageActivity.class);
                   
        // verhindern, dass die Activity ein weiteres Mal geöffnet wird, wenn sie bereits geöffnet wurde
        myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

		// Activity aufrufen
        startActivity(myIntent);
    }
    
    public void btn_IZ_USP(View v)
    {
        // Zugang zur Konfigurationsdatei ("Preferences") herstellen
     	SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
     	SharedPreferences.Editor prefEditor = prefs.edit(); 
     	             
     	prefEditor.putString("Routine", "49");
    	prefEditor.apply();		       
    	
    	Intent myIntent = new Intent(v.getContext(), EinwaageActivity.class);
                   
        // verhindern, dass die Activity ein weiteres Mal geöffnet wird, wenn sie bereits geöffnet wurde
        myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

		// Activity aufrufen
        startActivity(myIntent);
    }
    
    public void btn_POZ_EP_A(View v)
    {
        // Zugang zur Konfigurationsdatei ("Preferences") herstellen
     	SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
     	SharedPreferences.Editor prefEditor = prefs.edit(); 
     	             
     	prefEditor.putString("Routine", "50");
    	prefEditor.apply();		       
    	
    	Intent myIntent = new Intent(v.getContext(), EinwaageActivity.class);
                   
        // verhindern, dass die Activity ein weiteres Mal geöffnet wird, wenn sie bereits geöffnet wurde
        myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

		// Activity aufrufen
        startActivity(myIntent);
    }
    
    public void btn_POZ_USP(View v)
    {
        // Zugang zur Konfigurationsdatei ("Preferences") herstellen
     	SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
     	SharedPreferences.Editor prefEditor = prefs.edit(); 
     	             
     	prefEditor.putString("Routine", "51");
    	prefEditor.apply();		       
    	
    	Intent myIntent = new Intent(v.getContext(), EinwaageActivity.class);
                   
        // verhindern, dass die Activity ein weiteres Mal geöffnet wird, wenn sie bereits geöffnet wurde
        myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

		// Activity aufrufen
        startActivity(myIntent);
    }
    
    public void btn_POZ_EP_B(View v)
    {
        // Zugang zur Konfigurationsdatei ("Preferences") herstellen
     	SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
     	SharedPreferences.Editor prefEditor = prefs.edit(); 
     	             
     	prefEditor.putString("Routine", "52");
    	prefEditor.apply();		       
    	
    	Intent myIntent = new Intent(v.getContext(), EinwaageActivity.class);
                   
        // verhindern, dass die Activity ein weiteres Mal geöffnet wird, wenn sie bereits geöffnet wurde
        myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

		// Activity aufrufen
        startActivity(myIntent);
    }
    
    public void btn_VZ_EP(View v)
    {
        // Zugang zur Konfigurationsdatei ("Preferences") herstellen
     	SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
     	SharedPreferences.Editor prefEditor = prefs.edit(); 
     	             
     	prefEditor.putString("Routine", "53");
    	prefEditor.apply();		       
    	
    	Intent myIntent = new Intent(v.getContext(), EinwaageActivity.class);
                   
        // verhindern, dass die Activity ein weiteres Mal geöffnet wird, wenn sie bereits geöffnet wurde
        myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

		// Activity aufrufen
        startActivity(myIntent);
    }
    
    public void btn_VZ_USP(View v)
    {
        // Zugang zur Konfigurationsdatei ("Preferences") herstellen
     	SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
     	SharedPreferences.Editor prefEditor = prefs.edit(); 
     	             
     	prefEditor.putString("Routine", "54");
    	prefEditor.apply();		       
    	
    	Intent myIntent = new Intent(v.getContext(), EinwaageActivity.class);
                   
        // verhindern, dass die Activity ein weiteres Mal geöffnet wird, wenn sie bereits geöffnet wurde
        myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

		// Activity aufrufen
        startActivity(myIntent);
    }
    
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
           		prefEditor.putString("Einstellungen", "2");
           		prefEditor.apply();
            	intent = new Intent(this, EinstellungenActivity.class);
            	intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            	startActivity(intent);
                return true;
             
            case R.id.menu_Hilfe:
            	intent = new Intent(this, HilfeActivity.class);
            	intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            	intent.putExtra("Kapitel", "Fettkennzahlen");
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
}