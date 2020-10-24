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

public class List_Masslsg_Activity extends Activity {
	//List<Map<String, String>> massanalyseListe = new ArrayList<Map<String,String>>();
	ArrayList<String> MassanalyseListe = new ArrayList<String>();
	
	String[][] arrMassanalyse = new String[20][4];
	int intZeileNr_max = 0;

	// 2 Spalten pro Eintrag:
	// Spalte 0: Bezeichnung der Maßanalyse
	// Spalte 1: Maßlösung

	private void erstelle_Liste_Massanalyse() {		
		int intZeileNr = 0;

		arrMassanalyse[intZeileNr][0] = "Acidimetrie";
		arrMassanalyse[intZeileNr][1] = "Salzsäure";

		intZeileNr++;
		arrMassanalyse[intZeileNr][0] = "Acidimetrie";
		arrMassanalyse[intZeileNr][1] = "Salpetersäure";

		intZeileNr++;
		arrMassanalyse[intZeileNr][0] = "Acidimetrie";
		arrMassanalyse[intZeileNr][1] = "Schwefelsäure";
		
		intZeileNr++;
		arrMassanalyse[intZeileNr][0] = "Acidimetrie";
		arrMassanalyse[intZeileNr][1] = "Essigsäure";

		intZeileNr++;
		arrMassanalyse[intZeileNr][0] = "Alkalimetrie";
		arrMassanalyse[intZeileNr][1] = "Kalilauge";

		intZeileNr++;
		arrMassanalyse[intZeileNr][0] = "Alkalimetrie";
		arrMassanalyse[intZeileNr][1] = "Natronlauge";

		intZeileNr++;
		arrMassanalyse[intZeileNr][0] = "Alkalimetrie";
		arrMassanalyse[intZeileNr][1] = "Ammoniakwasser";
		
		intZeileNr++;
		arrMassanalyse[intZeileNr][0] = "Argentometrie - 1";
		arrMassanalyse[intZeileNr][1] = "Silbernitrat";
		
		intZeileNr++;
		arrMassanalyse[intZeileNr][0] = "Argentometrie - 2";
		arrMassanalyse[intZeileNr][1] = "Natriumchlorid";
		
		intZeileNr++;
		arrMassanalyse[intZeileNr][0] = "Argentometrie - 3";
		arrMassanalyse[intZeileNr][1] = "Ammoniumthiocyanat";
		
		intZeileNr++;
		arrMassanalyse[intZeileNr][0] = "Bromatometrie";
		arrMassanalyse[intZeileNr][1] = "Kaliumbromat";

        intZeileNr++;
		arrMassanalyse[intZeileNr][0] = "Cerimetrie";
		arrMassanalyse[intZeileNr][1] = "Cer(IV)-sulfat";

		intZeileNr++;
		arrMassanalyse[intZeileNr][0] = "Chromatometrie";
		arrMassanalyse[intZeileNr][1] = "Kaliumdichromat";

		intZeileNr++;
		arrMassanalyse[intZeileNr][0] = "Chromometrie";
		arrMassanalyse[intZeileNr][1] = "Chrom(II)-sulfat";
		
		intZeileNr++;
		arrMassanalyse[intZeileNr][0] = "Iodometrie";
		arrMassanalyse[intZeileNr][1] = "Kaliumtriiodid (I2)";

		intZeileNr++;
		arrMassanalyse[intZeileNr][0] = "Iodometrie";
		arrMassanalyse[intZeileNr][1] = "Natriumthiosulfat";

		intZeileNr++;
		arrMassanalyse[intZeileNr][0] = "Komplexometrie";
		arrMassanalyse[intZeileNr][1] = "Natrium-EDTA (Titriplex)";
		
		intZeileNr++;
		arrMassanalyse[intZeileNr][0] = "Permanganometrie";
		arrMassanalyse[intZeileNr][1] = "Kaliumpermanganat";
		
		intZeileNr++;
		arrMassanalyse[intZeileNr][0] = "Titanometrie";
		arrMassanalyse[intZeileNr][1] = "Titan(III)-chlorid";

		intZeileNr_max = intZeileNr;
	} // erstelle_Liste_arrMassanalyse
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_masslsg);

		// Activity registrieren, damit sie später an zentraler Stelle (Hauptmenue) geschlossen werden kann
	    ActivityRegistry.register(this);
		
    	erstelle_Liste_Massanalyse();
		
		initList();

	    // Die ListView-Komponente kommt aus dem Layout
	    ListView lv = (ListView) findViewById(R.id.lvMassanalyseListe);

		ListAdapter listenAdapter = new ArrayAdapter<String> (this, android.R.layout.simple_list_item_1, MassanalyseListe);
		
		lv.setAdapter(listenAdapter);
    
	    // hier wird festgelegt, was passieren soll, wenn der Anwender eine Zeile anklickt:
	    lv.setOnItemClickListener(new AdapterView.OnItemClickListener()
	    	{
	         public void onItemClick(AdapterView<?> parentAdapter, View view, int position, long id) {
	        	
	        	SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
	           	SharedPreferences.Editor prefEditor = prefs.edit(); 
	        	 
	        	String strGewaehlteMasslsg;
	        	String strGewaehlteMassanalyse = null;
	        	 
	         	for (int zeile=0; zeile<=intZeileNr_max; zeile++) 
	         	{    		
	         		TextView clickedView = (TextView) view;
	         		strGewaehlteMasslsg = clickedView.getText().toString();
	         		
	         		if (strGewaehlteMasslsg.equals(arrMassanalyse[zeile][1]))
	         		{
	         			strGewaehlteMassanalyse = arrMassanalyse[zeile][0];
	         			
	         			prefEditor.putString("GewaehlteMassanalyse", strGewaehlteMassanalyse);
	         			prefEditor.apply();	
	         			break;
	         		}
	      		}
	        	 
	        	Intent myIntent = new Intent(List_Masslsg_Activity.this, Konz_Masslsg_Activity.class);
				myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
				startActivity(myIntent);
				
	         } // onItemClick
	    }); // setOnItemClickListener	    
	} // onCreate
	
	/*******************************************************************************
	 *********************************** List View *********************************
	 *******************************************************************************/	
	
	public void initList() {
		String strMassloesung;
		int zeile;
		
		strMassloesung = "";
    	for (zeile=0; zeile<=intZeileNr_max; zeile++) {    		
    		strMassloesung = strMassloesung + arrMassanalyse[zeile][1] + ", ";
			MassanalyseListe.add(arrMassanalyse[zeile][1]);
  		}
    	strMassloesung = strMassloesung.substring(0, strMassloesung.length()-2); // überflüssiges ", " am Ende des Strings entfernen
	}
} // HilfeActivity
