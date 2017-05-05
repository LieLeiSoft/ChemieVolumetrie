package de.lieleisoft.chemievolumetrie;

import java.util.ArrayList;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import de.lieleisoft.chemievolumetrie.R;

public class List_Stoff_Activity extends Activity {
	
	//List<Map<String, String>> StoffListe = new ArrayList<Map<String,String>>();
	ArrayList<String> StoffListe = new ArrayList<String>();
	
	// Stoff-Tabelle:
	// 2 Spalten pro Eintrag:
	// Spalte 0: Faktor (mg/mL)
	// Spalte 1: gesuchter Stoff
	String[][] arrStoff = new String[70][5];
	int intZeileNr_max = 0;

	/*************************************************************
	 ** onCreate wird ausgeführt, wenn Activicty erstellt wird ***
	 *************************************************************/
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.list_stoff); 
	    
		// Activity registrieren, damit sie später an zentraler Stelle (Hauptmenue) geschlossen werden kann
	    ActivityRegistry.register(this);
	    
	    String strGewaehlteMassanalyse = null;
	    TextView tv;
	    
	    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
	    strGewaehlteMassanalyse = prefs.getString("GewaehlteMassanalyse", strGewaehlteMassanalyse);
	    
	    tv = (TextView) findViewById(R.id.tvGewMassanalyse);
	    tv.setText(strGewaehlteMassanalyse);

	    
	    // Stoff-Tabelle wird in extra Klassen-Modul erstellt, weil sehr umfangreich (über 1.600 Zeilen Code!)
	    clsErstelle_Liste_Stoff.erstelle_Liste_Stoff(getBaseContext(), arrStoff);
	    intZeileNr_max = clsErstelle_Liste_Stoff.intZeileNr_max;
		
		initList();

	    // Die ListView-Komponente kommt aus dem Layout
	    ListView lv = (ListView) findViewById(R.id.lvStoffListe);

		ListAdapter listenAdapter = new ArrayAdapter<String> (this, android.R.layout.simple_list_item_1, StoffListe);
		
		lv.setAdapter(listenAdapter);
    
	    // hier wird festgelegt, was passieren soll, wenn der Anwender eine Zeile anklickt:
	    lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
	         public void onItemClick(AdapterView<?> parentAdapter, View view, int position, long id) {
		        	
	        	SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		        SharedPreferences.Editor prefEditor = prefs.edit(); 
		        	 
		        String strGewaehlterStoff = null;
		        	 
		        for (int zeile=0; zeile<=intZeileNr_max; zeile++) 
		        {    		
		         	TextView clickedView = (TextView) view;
		         	strGewaehlterStoff = clickedView.getText().toString();
		         		
		         	if (strGewaehlterStoff.equals(arrStoff[zeile][1]))
		         	{
	         			strGewaehlterStoff = arrStoff[zeile][0];
	         			
	         			double dblFaktor = Double.parseDouble(strGewaehlterStoff);
	         			         		    	
	         		    String strNormalitaet = prefs.getString("Eingabe_4", "");
	         		    double dblNormalitaet = Double.parseDouble(strNormalitaet);
	         		    	
	         		    // ********* Berechnung *********
	         		    	
	         		    dblFaktor = dblFaktor * dblNormalitaet;
	         		    
	         		    String strFaktor = Double.toString(dblFaktor);
	         		
	         			prefEditor.putString("Eingabe_1", strFaktor); // Faktor!
	         			prefEditor.apply();	
	         			break;
		         	}
		        } 
		    
		        Intent myIntent = new Intent(List_Stoff_Activity.this, TiterEingabenActivity.class);
				myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
				startActivity(myIntent);
	
	         } // onItemClick
	    }); // setOnItemClickListener	
	
	} // onCreate

	
	/*******************************************************************************
	 *********************************** List View *********************************
	 *******************************************************************************/	
	public void initList() 
	{
		String strStoff;
		int zeile;
		
		strStoff = "";
    	for (zeile=0; zeile<=intZeileNr_max; zeile++) {    		
    		strStoff = strStoff + arrStoff[zeile][1] + ", ";
			StoffListe.add(arrStoff[zeile][1]);
  		}
    	strStoff = strStoff.substring(0, strStoff.length()-2); // überflüssiges ", " am Ende des Strings entfernen
    }     
}