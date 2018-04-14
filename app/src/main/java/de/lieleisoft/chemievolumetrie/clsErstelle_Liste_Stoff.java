package de.lieleisoft.chemievolumetrie;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class clsErstelle_Liste_Stoff {
	public static int intZeileNr_max = 0;
	
	public static void erstelle_Liste_Stoff(Context context, String[][] arrStoff) {		
		int intZeileNr = 0;
	    String strGewaehlteMassanalyse;
	    
	    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
	    
	    strGewaehlteMassanalyse = prefs.getString("GewaehlteMassanalyse", "");
		
	    if(strGewaehlteMassanalyse.equals("Acidimetrie"))
	    {
			arrStoff[intZeileNr][0] = "98.675";
			arrStoff[intZeileNr][1] = "BaCO3";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "85.677";
			arrStoff[intZeileNr][1] = "Ba(OH)2";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "22.005";
			arrStoff[intZeileNr][1] = "CO2";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "30.005";
			arrStoff[intZeileNr][1] = "CO3";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "50.045";
			arrStoff[intZeileNr][1] = "CaCO3";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "28.040";
			arrStoff[intZeileNr][1] = "CaO";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "37.047";
			arrStoff[intZeileNr][1] = "F(OH)2";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "69.107";
			arrStoff[intZeileNr][1] = "K2CO3";
            arrStoff[intZeileNr][2] = "Methylorange";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "100.12";
			arrStoff[intZeileNr][1] = "KHCO3";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "56.109";
			arrStoff[intZeileNr][1] = "KOH";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "36.946";
			arrStoff[intZeileNr][1] = "Li2CO3";
            arrStoff[intZeileNr][2] = "Methylorange";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "14.941";
			arrStoff[intZeileNr][1] = "Li2O";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "42.157";
			arrStoff[intZeileNr][1] = "MgCO3";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "20.152";
			arrStoff[intZeileNr][1] = "MgO";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "14.007";
			arrStoff[intZeileNr][1] = "N";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "77.73";
			arrStoff[intZeileNr][1] = "N 5,55";
            arrStoff[intZeileNr][3] = "Gelatine";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "87.54";
			arrStoff[intZeileNr][1] = "N 6,25";
            arrStoff[intZeileNr][3] = "Eiweiß";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "89.22";
			arrStoff[intZeileNr][1] = "N 6,37";
            arrStoff[intZeileNr][3] = "Casein";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "17.031";
			arrStoff[intZeileNr][1] = "NH3";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "18.039";
			arrStoff[intZeileNr][1] = "NH4";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "53.492";
			arrStoff[intZeileNr][1] = "NH4Cl";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "80.044";
			arrStoff[intZeileNr][1] = "NH4NO3";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "35.046";
			arrStoff[intZeileNr][1] = "NH4OH";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "66.068";
			arrStoff[intZeileNr][1] = "(NH4)2SO4";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "19.069";
			arrStoff[intZeileNr][1] = "Na2B4O7 x 10H2O";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "52.994";
			arrStoff[intZeileNr][1] = "Na2CO3";
            arrStoff[intZeileNr][2] = "Methylorange";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "71.010";
			arrStoff[intZeileNr][1] = "Na2CO3 x 2H2O";
            arrStoff[intZeileNr][2] = "Methylorange";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "143.07";
			arrStoff[intZeileNr][1] = "Na2CO3 x 10H2O";
            arrStoff[intZeileNr][2] = "Methylorange";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "84.007";
			arrStoff[intZeileNr][1] = "NaHCO3";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "30.990";
			arrStoff[intZeileNr][1] = "Na2O";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "39.997";
			arrStoff[intZeileNr][1] = "NaOH";			
	    }
	    
	    if(strGewaehlteMassanalyse.equals("Alkalimetrie"))
	    {
			arrStoff[intZeileNr][0] = "8.9938";
			arrStoff[intZeileNr][1] = "Al";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "16.994";
			arrStoff[intZeileNr][1] = "Al2O3";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "10.81";
			arrStoff[intZeileNr][1] = "B";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "34.809";
			arrStoff[intZeileNr][1] = "B2O3";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "61.832";
			arrStoff[intZeileNr][1] = "H3BO3";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "80.912";
			arrStoff[intZeileNr][1] = "HBr";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "46.026";
			arrStoff[intZeileNr][1] = "HCOOH";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "60.053";
			arrStoff[intZeileNr][1] = "CH3COOH";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "59.045";
			arrStoff[intZeileNr][1] = "CH3COO";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "45.018";
			arrStoff[intZeileNr][1] = "(COOH)2";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "63.033";
			arrStoff[intZeileNr][1] = "(COOH)2 x 2H2O";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "128.13";
			arrStoff[intZeileNr][1] = "KHC2O4";
            arrStoff[intZeileNr][2] = "Phenolphthalein";
            arrStoff[intZeileNr][3] = "Kaliumoxalat";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "75.044";
			arrStoff[intZeileNr][1] = "C4H6O6";
            arrStoff[intZeileNr][3] = "Weinsäure";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "188.18";
			arrStoff[intZeileNr][1] = "KHC4H4O6";
            arrStoff[intZeileNr][3] = "Tartrat";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "122.12";
			arrStoff[intZeileNr][1] = "C6H5COOH";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "204.23";
			arrStoff[intZeileNr][1] = "KHC8H4O4";
            arrStoff[intZeileNr][2] = "Phenolphthalein";
            arrStoff[intZeileNr][3] = "Kaliumhydrogenphthalat";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "82.045";
			arrStoff[intZeileNr][1] = "Ca(NO3)2";
            arrStoff[intZeileNr][3] = "nach Arnd";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "35.453";
			arrStoff[intZeileNr][1] = "Cl";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "36.461";
			arrStoff[intZeileNr][1] = "HCl";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "20.006";
			arrStoff[intZeileNr][1] = "HF";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "127.91";
			arrStoff[intZeileNr][1] = "HI";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "175.91";
			arrStoff[intZeileNr][1] = "HIO3";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "191.91";
			arrStoff[intZeileNr][1] = "HIO4";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "63.013";
			arrStoff[intZeileNr][1] = "HNO3";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "69.491";
			arrStoff[intZeileNr][1] = "NH2OH x HCl";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "84.995";
			arrStoff[intZeileNr][1] = "NaNO3";
            arrStoff[intZeileNr][3] = "nach Arnd";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "120.06";
			arrStoff[intZeileNr][1] = "NaHSO4";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "1.347";
			arrStoff[intZeileNr][1] = "P";
            arrStoff[intZeileNr][2] = "Phenolphthalein";
            arrStoff[intZeileNr][3] = "über Ammoniummolybdatophosphat";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "97.995";
			arrStoff[intZeileNr][1] = "H3PO4";
            arrStoff[intZeileNr][2] = "Methylorange";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "94.971";
			arrStoff[intZeileNr][1] = "PO4";
            arrStoff[intZeileNr][2] = "Methylorange";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "70.972";
			arrStoff[intZeileNr][1] = "P2O5";
            arrStoff[intZeileNr][2] = "Methylorange";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "48.998";
			arrStoff[intZeileNr][1] = "H3PO4";
            arrStoff[intZeileNr][2] = "Phenolphthalein";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "47.486";
			arrStoff[intZeileNr][1] = "PO4";
            arrStoff[intZeileNr][2] = "Phenolphthalein";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "35.486";
			arrStoff[intZeileNr][1] = "P2O5";
            arrStoff[intZeileNr][2] = "Phenolphthalein";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "40.029";
			arrStoff[intZeileNr][1] = "SO3";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "48.029";
			arrStoff[intZeileNr][1] = "SO4";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "96.060";
			arrStoff[intZeileNr][1] = "S2O8";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "82.074";
			arrStoff[intZeileNr][1] = "H2SO3";
            arrStoff[intZeileNr][2] = "Methylorange";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "49.037";
			arrStoff[intZeileNr][1] = "H2SO4";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "24.015";
			arrStoff[intZeileNr][1] = "H2[SiF6]";
            arrStoff[intZeileNr][3] = "nach Sahlbom und Hinrichsen";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "72.046";
			arrStoff[intZeileNr][1] = "H2[SiF6]";
            arrStoff[intZeileNr][3] = "nach Treadwell";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "65.125";
			arrStoff[intZeileNr][1] = "SnCl4";
            arrStoff[intZeileNr][2] = "Methylorange";
	    }
	    
	    if(strGewaehlteMassanalyse.equals("Argentometrie - 1"))
	    {
            arrStoff[intZeileNr][0] = "104.12";
			arrStoff[intZeileNr][1] = "BaCl2";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "122.14";
			arrStoff[intZeileNr][1] = "BaCl2 x 2H2O";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "79.904";
			arrStoff[intZeileNr][1] = "Br";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "21.317";
			arrStoff[intZeileNr][1] = "BrO3";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "80.9";
			arrStoff[intZeileNr][1] = "HBr";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "55.493";
			arrStoff[intZeileNr][1] = "CaCl2";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "109.54";
			arrStoff[intZeileNr][1] = "CaCl2 x 6H2O";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "26.018";
			arrStoff[intZeileNr][1] = "CN";
            arrStoff[intZeileNr][3] = "nach Mohr";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "52.036";
			arrStoff[intZeileNr][1] = "CN";
            arrStoff[intZeileNr][3] = "nach Liebig";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "27.026";
			arrStoff[intZeileNr][1] = "HCN";
            arrStoff[intZeileNr][3] = "nach Mohr";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "54.052";
			arrStoff[intZeileNr][1] = "HCN";
            arrStoff[intZeileNr][3] = "nach Liebig";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "35.453";
			arrStoff[intZeileNr][1] = "Cl";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "36.461";
			arrStoff[intZeileNr][1] = "HCl";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "126.90";
			arrStoff[intZeileNr][1] = "I";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "127.91";
			arrStoff[intZeileNr][1] = "HI";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "119.01";
			arrStoff[intZeileNr][1] = "KBr";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "65.120";
			arrStoff[intZeileNr][1] = "KCN";
            arrStoff[intZeileNr][3] = "nach Mohr";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "130.24";
			arrStoff[intZeileNr][1] = "KCN";
            arrStoff[intZeileNr][3] = "nach Liebig";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "74.555";
			arrStoff[intZeileNr][1] = "KCl";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "166.01";
			arrStoff[intZeileNr][1] = "KI";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "97.180";
			arrStoff[intZeileNr][1] = "KSCN";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "42.394";
			arrStoff[intZeileNr][1] = "LiCl";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "47.606";
			arrStoff[intZeileNr][1] = "MgCl2";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "97.947";
			arrStoff[intZeileNr][1] = "NH4Br";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "53.492";
			arrStoff[intZeileNr][1] = "NH4Cl";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "144.94";
			arrStoff[intZeileNr][1] = "NH4I";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "76.116";
			arrStoff[intZeileNr][1] = "NH4SCN";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "102.89";
			arrStoff[intZeileNr][1] = "NaBr";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "49.008";
			arrStoff[intZeileNr][1] = "NaCN";
            arrStoff[intZeileNr][3] = "nach Mohr";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "98.015";
			arrStoff[intZeileNr][1] = "NaCN";
            arrStoff[intZeileNr][3] = "nach Liebig";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "58.443";
			arrStoff[intZeileNr][1] = "NaCl";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "149.89";
			arrStoff[intZeileNr][1] = "NaI";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "81.068";
			arrStoff[intZeileNr][1] = "NaSCN";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "58.08";
			arrStoff[intZeileNr][1] = "SCN";
	    }

	    if(strGewaehlteMassanalyse.equals("Argentometrie - 2"))
	    {	
            arrStoff[intZeileNr][0] = "107.87";
			arrStoff[intZeileNr][1] = "Ag";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "169.87";
			arrStoff[intZeileNr][1] = "AgNO3";
	    }

	    if(strGewaehlteMassanalyse.equals("Argentometrie - 3"))
	    {	
            arrStoff[intZeileNr][0] = "107.87";
			arrStoff[intZeileNr][1] = "Ag";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "169.87";
			arrStoff[intZeileNr][1] = "AgNO3";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "63.546";
			arrStoff[intZeileNr][1] = "Cu";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "100.30";
			arrStoff[intZeileNr][1] = "Hg";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "108.29";
			arrStoff[intZeileNr][1] = "HgO";
	    }

	    if(strGewaehlteMassanalyse.equals("Bromatometrie"))
	    {
			arrStoff[intZeileNr][0] = "37.461";
			arrStoff[intZeileNr][1] = "As";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "61.460";
			arrStoff[intZeileNr][1] = "AsO3";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "49.460";
			arrStoff[intZeileNr][1] = "As2O3";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "4.0075";
			arrStoff[intZeileNr][1] = "S";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "4.260";
			arrStoff[intZeileNr][1] = "H2S";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "60.875";
			arrStoff[intZeileNr][1] = "Sb";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "59.345";
			arrStoff[intZeileNr][1] = "Sn";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "102.19";
			arrStoff[intZeileNr][1] = "Tl";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "36.290";
			arrStoff[intZeileNr][1] = "C9H7ON";
            arrStoff[intZeileNr][3] = "als Oxin";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "36.038";
			arrStoff[intZeileNr][1] = "C9H7ON";
            arrStoff[intZeileNr][3] = "als Oxinat";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "2.2485";
			arrStoff[intZeileNr][1] = "Al";
            arrStoff[intZeileNr][3] = "als Oxin";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "17.415";
			arrStoff[intZeileNr][1] = "Bi";
            arrStoff[intZeileNr][3] = "als Oxin";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "14.050";
			arrStoff[intZeileNr][1] = "Cd";
            arrStoff[intZeileNr][3] = "als Oxin";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "11.677";
			arrStoff[intZeileNr][1] = "Ce";
            arrStoff[intZeileNr][3] = "als Oxin";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "7.943";
			arrStoff[intZeileNr][1] = "Cu";
            arrStoff[intZeileNr][3] = "als Oxin";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "4.6539";
			arrStoff[intZeileNr][1] = "Fe";
            arrStoff[intZeileNr][3] = "als Oxin";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "5.81";
			arrStoff[intZeileNr][1] = "Ga";
            arrStoff[intZeileNr][3] = "als Oxin";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "9.568";
			arrStoff[intZeileNr][1] = "In";
            arrStoff[intZeileNr][3] = "als Oxin";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "3.0381";
			arrStoff[intZeileNr][1] = "Mg";
            arrStoff[intZeileNr][3] = "als Oxin";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "7.33";
			arrStoff[intZeileNr][1] = "Ni";
            arrStoff[intZeileNr][3] = "als Oxin";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "25.90";
			arrStoff[intZeileNr][1] = "Pb";
            arrStoff[intZeileNr][3] = "als Oxin";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "10.146";
			arrStoff[intZeileNr][1] = "Sb";
            arrStoff[intZeileNr][3] = "als Oxin";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "14.502";
			arrStoff[intZeileNr][1] = "TH";
            arrStoff[intZeileNr][3] = "als Oxin";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "5.9875";
			arrStoff[intZeileNr][1] = "Ti";
            arrStoff[intZeileNr][3] = "als Oxin";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "19.836";
			arrStoff[intZeileNr][1] = "U";
            arrStoff[intZeileNr][3] = "als Oxin";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "6.3677";
			arrStoff[intZeileNr][1] = "V";
            arrStoff[intZeileNr][3] = "als Oxin";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "8.1713";
			arrStoff[intZeileNr][1] = "Zn";
            arrStoff[intZeileNr][3] = "als Oxin";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "5.701";
			arrStoff[intZeileNr][1] = "Zr";
            arrStoff[intZeileNr][3] = "als Oxin";
	    }

	    if(strGewaehlteMassanalyse.equals("Cerimetrie"))
	    {	
            arrStoff[intZeileNr][0] = "37.461";
			arrStoff[intZeileNr][1] = "As als As2O3";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "61.460";
			arrStoff[intZeileNr][1] = "AsO3";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "49.460";
			arrStoff[intZeileNr][1] = "As2O3";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "68.665";
			arrStoff[intZeileNr][1] = "Ba als Oxalat";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "76.670";
			arrStoff[intZeileNr][1] = "BaO als Oxalat";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "85.677";
			arrStoff[intZeileNr][1] = "Ba(OH)2 als Oxalat";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "45.018";
			arrStoff[intZeileNr][1] = "(COOH)2";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "63.033";
			arrStoff[intZeileNr][1] = "(COOH)2 x 2H2O";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "15.009";
			arrStoff[intZeileNr][1] = "C4H6O6";
            arrStoff[intZeileNr][3] = "Weinsäure";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "7.5066";
			arrStoff[intZeileNr][1] = "C6H12O6";
            arrStoff[intZeileNr][3] = "Glucose";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "20.040";
			arrStoff[intZeileNr][1] = "Ca als Oxalat";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "50.045";
			arrStoff[intZeileNr][1] = "CaCO3 als Oxalat";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "28.040";
			arrStoff[intZeileNr][1] = "CaO als Oxalat";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "548.23";
			arrStoff[intZeileNr][1] = "Ce(NO3)4 x 2NH4NO3";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "332.24";
			arrStoff[intZeileNr][1] = "Ce(SO4)2";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "528.40";
			arrStoff[intZeileNr][1] = "Ce(HSO4)4";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "632.55";
			arrStoff[intZeileNr][1] = "Ce(SO4)2 x 2(NH4)2SO4 x 2H2O";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "55.847";
			arrStoff[intZeileNr][1] = "Fe";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "211.95";
			arrStoff[intZeileNr][1] = "Fe(CN)6";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "71.846";
			arrStoff[intZeileNr][1] = "FeO";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "79.846";
			arrStoff[intZeileNr][1] = "Fe2O3";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "151.90";
			arrStoff[intZeileNr][1] = "FeSO4";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "278.01";
			arrStoff[intZeileNr][1] = "FeSO4 x 7H2O";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "392.13";
			arrStoff[intZeileNr][1] = "(NH4)2Fe(SO4)2 x 6 H2O";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "200.59";
			arrStoff[intZeileNr][1] = "Hg";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "216.60";
			arrStoff[intZeileNr][1] = "HgO";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "83.112";
			arrStoff[intZeileNr][1] = "K2C2O4";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "92.116";
			arrStoff[intZeileNr][1] = "K2C2O4 x H2O";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "64.065";
			arrStoff[intZeileNr][1] = "KHC2O4";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "73.071";
			arrStoff[intZeileNr][1] = "KHC2O4 x H2O";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "63.549";
			arrStoff[intZeileNr][1] = "KHC2O4 x H2C2O4 x H2O";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "368.36";
			arrStoff[intZeileNr][1] = "K4[Fe(CN)6]";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "422.41";
			arrStoff[intZeileNr][1] = "K4[Fe(CN)6] x 3H2O";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "46.006";
			arrStoff[intZeileNr][1] = "NO2";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "67.000";
			arrStoff[intZeileNr][1] = "Na2C2O4";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "60.875";
			arrStoff[intZeileNr][1] = "Sb";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "72.875";
			arrStoff[intZeileNr][1] = "Sb2O3";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "59.345";
			arrStoff[intZeileNr][1] = "Sn";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "43.81";
			arrStoff[intZeileNr][1] = "Sr als Oxalat";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "73.815";
			arrStoff[intZeileNr][1] = "SrCO3 als Oxalat";
	
			intZeileNr++;
			arrStoff[intZeileNr][0] = "102.19";
			arrStoff[intZeileNr][1] = "Tl";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "119.01";
			arrStoff[intZeileNr][1] = "U";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "50.941";
			arrStoff[intZeileNr][1] = "V";
	    }

	    if(strGewaehlteMassanalyse.equals("Chromatometrie"))
	    {	
            arrStoff[intZeileNr][0] = "55.847";
			arrStoff[intZeileNr][1] = "Fe";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "71.846";
			arrStoff[intZeileNr][1] = "FeO";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "207.2";
			arrStoff[intZeileNr][1] = "Pb";
	    }

	    if(strGewaehlteMassanalyse.equals("Chromometrie"))
	    {	
            arrStoff[intZeileNr][0] = "107.87";
			arrStoff[intZeileNr][1] = "Ag inH2SO4 oder HCl + NH4Cl";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "69.660";
			arrStoff[intZeileNr][1] = "Bi in H2SO4 + KCl";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "431.98";
			arrStoff[intZeileNr][1] = "Cr2O7 in H2SO4";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "63.546";
			arrStoff[intZeileNr][1] = "Cu in HCl";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "31.773";
			arrStoff[intZeileNr][1] = "Cu in H2SO4";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "100.30";
			arrStoff[intZeileNr][1] = "Hg in H2SO4 oder HCl";
	    }

	    if(strGewaehlteMassanalyse.equals("Iodometrie"))
	    {	
            arrStoff[intZeileNr][0] = "37.461";
			arrStoff[intZeileNr][1] = "As";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "61.460";
			arrStoff[intZeileNr][1] = "AsO3";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "49.460";
			arrStoff[intZeileNr][1] = "As2O3";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "69.460";
			arrStoff[intZeileNr][1] = "AsO4";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "57.460";
			arrStoff[intZeileNr][1] = "As2O5";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "79.904";
			arrStoff[intZeileNr][1] = "Br";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "21.317";
			arrStoff[intZeileNr][1] = "BrO3";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "70.026";
			arrStoff[intZeileNr][1] = "CO";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "9.680";
			arrStoff[intZeileNr][1] = "C2H6O";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "15.686";
			arrStoff[intZeileNr][1] = "C6H5OH";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "35.453";
			arrStoff[intZeileNr][1] = "Cl";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "26.230";
			arrStoff[intZeileNr][1] = "HClO";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "14.077";
			arrStoff[intZeileNr][1] = "HClO3";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "17.332";
			arrStoff[intZeileNr][1] = "Cr";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "25.332";
			arrStoff[intZeileNr][1] = "Cr2O3";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "35.998";
			arrStoff[intZeileNr][1] = "Cr2O7";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "63.546";
			arrStoff[intZeileNr][1] = "Cu";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "159.60";
			arrStoff[intZeileNr][1] = "CuSO4";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "249.68";
			arrStoff[intZeileNr][1] = "CuSO4 x 5H2O";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "55.847";
			arrStoff[intZeileNr][1] = "Fe";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "211.95";
			arrStoff[intZeileNr][1] = "Fe(CN)6";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "162.21";
			arrStoff[intZeileNr][1] = "FeCl3";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "79.846";
			arrStoff[intZeileNr][1] = "Fe2O3";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "151.90";
			arrStoff[intZeileNr][1] = "FeSO4";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "278.01";
			arrStoff[intZeileNr][1] = "FeSO4 x 7H2O";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "17.007";
			arrStoff[intZeileNr][1] = "H2O2";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "100.30";
			arrStoff[intZeileNr][1] = "Hg";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "135.75";
			arrStoff[intZeileNr][1] = "HgCl2";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "126.04";
			arrStoff[intZeileNr][1] = "HgClNH2";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "108.30";
			arrStoff[intZeileNr][1] = "HgO";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "126.90";
			arrStoff[intZeileNr][1] = "I";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "127.91";
			arrStoff[intZeileNr][1] = "HI";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "29.150";
			arrStoff[intZeileNr][1] = "IO3";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "29.318";
			arrStoff[intZeileNr][1] = "HIO3";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "23.863";
			arrStoff[intZeileNr][1] = "IO4";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "23.989";
			arrStoff[intZeileNr][1] = "HIO4";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "27.834";
			arrStoff[intZeileNr][1] = "KBrO3";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "20.426";
			arrStoff[intZeileNr][1] = "KClO3";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "64.733";
			arrStoff[intZeileNr][1] = "K2CrO4";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "49.032";
			arrStoff[intZeileNr][1] = "K2Cr2O7";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "60.084";
			arrStoff[intZeileNr][1] = "KHSO3";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "43.468";
			arrStoff[intZeileNr][1] = "MnO2";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "8.011";
			arrStoff[intZeileNr][1] = "N2H4";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "32.530";
			arrStoff[intZeileNr][1] = "N2H4 x H2SO4";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "37.221";
			arrStoff[intZeileNr][1] = "NaClO";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "17.740";
			arrStoff[intZeileNr][1] = "NaClO3";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "43.661";
			arrStoff[intZeileNr][1] = "Na2Cr2O7";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "84.954";
			arrStoff[intZeileNr][1] = "Na2HAsO3";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "28.031";
			arrStoff[intZeileNr][1] = "NaHS";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "39.020";
			arrStoff[intZeileNr][1] = "Na2S";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "52.028";
			arrStoff[intZeileNr][1] = "NaHSO3";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "63.019";
			arrStoff[intZeileNr][1] = "Na2So3";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "158.10";
			arrStoff[intZeileNr][1] = "Na2S2O3";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "248.17";
			arrStoff[intZeileNr][1] = "Na2S2O3 x 5H2O";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "23.999";
			arrStoff[intZeileNr][1] = "O3";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "119.60";
			arrStoff[intZeileNr][1] = "PbO2";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "16.03";
			arrStoff[intZeileNr][1] = "S";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "17.04";
			arrStoff[intZeileNr][1] = "H2S";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "32.030";
			arrStoff[intZeileNr][1] = "SO2";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "40.029";
			arrStoff[intZeileNr][1] = "SO3";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "41.037";
			arrStoff[intZeileNr][1] = "H2SO3";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "192.12";
			arrStoff[intZeileNr][1] = "S2O8";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "60.875";
			arrStoff[intZeileNr][1] = "Sb";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "72.875";
			arrStoff[intZeileNr][1] = "Sb2O3";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "166.97";
			arrStoff[intZeileNr][1] = "SbOKC4H4O6 x 0,5H2O";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "59.345";
			arrStoff[intZeileNr][1] = "Sn";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "67.345";
			arrStoff[intZeileNr][1] = "SnO";
	    }

	    if(strGewaehlteMassanalyse.equals("Komplexometrie"))
	    {	
			arrStoff[intZeileNr][0] = "215.74";
			arrStoff[intZeileNr][1] = "Ag";
			arrStoff[intZeileNr][2] = "Murexid";

            intZeileNr++;
            arrStoff[intZeileNr][0] = "26.982";
			arrStoff[intZeileNr][1] = "Al";
			arrStoff[intZeileNr][2] = "Eriochromschwarz T oder Xylenolorange";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "137.34";
			arrStoff[intZeileNr][1] = "Ba";
			arrStoff[intZeileNr][2] = "Phthaleinpurpur";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "208.98";
			arrStoff[intZeileNr][1] = "Bi";
			arrStoff[intZeileNr][2] = "PAN (Pyridyl-beta-azonaphthol oder Xylenolorange)";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "159.81";
			arrStoff[intZeileNr][1] = "Br";
			arrStoff[intZeileNr][2] = "Murexid";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "40.08";
			arrStoff[intZeileNr][1] = "Ca";
			arrStoff[intZeileNr][2] = "Eriochromschwarz T, Phthaleinpurpur oder Murexid";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "112.40";
			arrStoff[intZeileNr][1] = "Cd";
			arrStoff[intZeileNr][2] = "Eriochromschwarz T, PAN (Pyridyl-beta-azonaphthol oder Xylenolorange)";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "70.906";
			arrStoff[intZeileNr][1] = "Cl";
			arrStoff[intZeileNr][2] = "Murexid";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "104.07";
			arrStoff[intZeileNr][1] = "CN";
			arrStoff[intZeileNr][2] = "Murexid";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "58.933";
			arrStoff[intZeileNr][1] = "Co";
			arrStoff[intZeileNr][2] = "Murexid";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "63.546";
			arrStoff[intZeileNr][1] = "Cu";
			arrStoff[intZeileNr][2] = "PAN (Pyridyl-beta-azonaphthol) oder Murexid";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "55.847";
			arrStoff[intZeileNr][1] = "Fe(II)";
			arrStoff[intZeileNr][2] = "Sulfosalicylsäure (Variaminblau B)";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "55.85";
			arrStoff[intZeileNr][1] = "Fe(III)";
			arrStoff[intZeileNr][2] = "Xylenolorange";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "71.846";
			arrStoff[intZeileNr][1] = "FeO";
			arrStoff[intZeileNr][2] = "Murexid";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "79.846";
			arrStoff[intZeileNr][1] = "Fe2O3";
			arrStoff[intZeileNr][2] = "Murexid";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "278.01";
			arrStoff[intZeileNr][1] = "FeSO4 x 7H2O";
			arrStoff[intZeileNr][2] = "Murexid";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "281.01";
			arrStoff[intZeileNr][1] = "Fe2(SO4)3 x 9H2O";
			arrStoff[intZeileNr][2] = "Murexid";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "392.13";
			arrStoff[intZeileNr][1] = "(NH4)2Fe(SO4)2 x 6H2O";
			arrStoff[intZeileNr][2] = "Murexid";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "69.72";
			arrStoff[intZeileNr][1] = "Ga";
			arrStoff[intZeileNr][2] = "Xylenolorange";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "23.507";
			arrStoff[intZeileNr][1] = "HNO2";
			arrStoff[intZeileNr][2] = "Murexid";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "17.007";
			arrStoff[intZeileNr][1] = "H2O2";
			arrStoff[intZeileNr][2] = "Murexid";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "200.59";
			arrStoff[intZeileNr][1] = "Hg(II)";
			arrStoff[intZeileNr][2] = "Eriochromschwarz T oder Xylenolorange";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "253.81";
			arrStoff[intZeileNr][1] = "I";
			arrStoff[intZeileNr][2] = "Murexid";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "31.608";
			arrStoff[intZeileNr][1] = "KMnO4";
			arrStoff[intZeileNr][2] = "Murexid";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "138.91";
			arrStoff[intZeileNr][1] = "La";
			arrStoff[intZeileNr][2] = "Xylenolorange";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "24.305";
			arrStoff[intZeileNr][1] = "Mg";
			arrStoff[intZeileNr][2] = "Eriochromschwarz T";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "54.938";
			arrStoff[intZeileNr][1] = "Mn";
			arrStoff[intZeileNr][2] = "Eriochromschwarz T";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "27.470";
			arrStoff[intZeileNr][1] = "Mn";
			arrStoff[intZeileNr][2] = "Murexid";
            arrStoff[intZeileNr][3] = "nach Hampe";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "16.481";
			arrStoff[intZeileNr][1] = "Mn";
			arrStoff[intZeileNr][2] = "Murexid";
            arrStoff[intZeileNr][3] = "nach Volhard-Wolff";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "21.281";
			arrStoff[intZeileNr][1] = "MnO";
			arrStoff[intZeileNr][2] = "Murexid";
            arrStoff[intZeileNr][3] = "nach Volhard-Wolff";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "26.081";
			arrStoff[intZeileNr][1] = "MnO2";
			arrStoff[intZeileNr][2] = "Murexid";
            arrStoff[intZeileNr][3] = "nach Volhard-Wolff";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "43.468";
			arrStoff[intZeileNr][1] = "MnO2";
			arrStoff[intZeileNr][2] = "Murexid";
            arrStoff[intZeileNr][3] = "mit Oxalsäure oder Eisen(II)-sulfat";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "33.882";
			arrStoff[intZeileNr][1] = "Mo";
			arrStoff[intZeileNr][2] = "Murexid";
            arrStoff[intZeileNr][3] = "nach Auchy empirisch";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "32.00";
			arrStoff[intZeileNr][1] = "Mo";
			arrStoff[intZeileNr][2] = "Murexid";
            arrStoff[intZeileNr][3] = "nach Kassler empirisch";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "50.824";
			arrStoff[intZeileNr][1] = "MoO3";
			arrStoff[intZeileNr][2] = "Murexid";
            arrStoff[intZeileNr][3] = "nach Auchy empirisch";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "48.00";
			arrStoff[intZeileNr][1] = "MoO3";
			arrStoff[intZeileNr][2] = "Murexid";
            arrStoff[intZeileNr][3] = "nach Kassler empirisch";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "19.003";
			arrStoff[intZeileNr][1] = "N2O3";
			arrStoff[intZeileNr][2] = "Murexid";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "46.006";
			arrStoff[intZeileNr][1] = "N2O4";
			arrStoff[intZeileNr][2] = "Murexid";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "22.990";
			arrStoff[intZeileNr][1] = "Na";
			arrStoff[intZeileNr][2] = "Eriochromschwarz T";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "17.740";
			arrStoff[intZeileNr][1] = "NaClO3";
			arrStoff[intZeileNr][2] = "Murexid";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "34.498";
			arrStoff[intZeileNr][1] = "NaNO2";
			arrStoff[intZeileNr][2] = "Murexid";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "28.332";
			arrStoff[intZeileNr][1] = "NaNO3";
			arrStoff[intZeileNr][2] = "Murexid";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "16.515";
			arrStoff[intZeileNr][1] = "NH2OH";
			arrStoff[intZeileNr][2] = "Murexid";
            arrStoff[intZeileNr][3] = "nach Raschig";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "32.022";
			arrStoff[intZeileNr][1] = "NH4NO2";
			arrStoff[intZeileNr][2] = "Murexid";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "58.71";
			arrStoff[intZeileNr][1] = "Ni";
			arrStoff[intZeileNr][2] = "Murexid";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "7.9997";
			arrStoff[intZeileNr][1] = "O";
			arrStoff[intZeileNr][2] = "Murexid";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "0.86056";
			arrStoff[intZeileNr][1] = "P als (NH4)3PO4 x 12MoO3";
			arrStoff[intZeileNr][2] = "Murexid";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "30.974";
			arrStoff[intZeileNr][1] = "P";
			arrStoff[intZeileNr][2] = "Eriochromschwarz T";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "94.971";
			arrStoff[intZeileNr][1] = "PO4";
			arrStoff[intZeileNr][2] = "Eriochromschwarz T";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "70.972";
			arrStoff[intZeileNr][1] = "P2O5";
			arrStoff[intZeileNr][2] = "Eriochromschwarz T";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "207.2";
			arrStoff[intZeileNr][1] = "Pb";
			arrStoff[intZeileNr][2] = "Eriochromschwarz T oder Xylenolorange";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "119.60";
			arrStoff[intZeileNr][1] = "PbO2";
			arrStoff[intZeileNr][2] = "Murexid";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "342.80";
			arrStoff[intZeileNr][1] = "Pb3O4";
			arrStoff[intZeileNr][2] = "Murexid";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "32.06";
			arrStoff[intZeileNr][1] = "S";
			arrStoff[intZeileNr][2] = "Phthaleinpurpur";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "4.101";
			arrStoff[intZeileNr][1] = "S";
			arrStoff[intZeileNr][2] = "Murexid";
            arrStoff[intZeileNr][3] = "nach Pinsl";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "96.058";
			arrStoff[intZeileNr][1] = "S2O8";
			arrStoff[intZeileNr][2] = "Murexid";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "60.058";
			arrStoff[intZeileNr][1] = "Sb";
			arrStoff[intZeileNr][2] = "Murexid";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "72.875";
			arrStoff[intZeileNr][1] = "Sb2O3";
			arrStoff[intZeileNr][2] = "Murexid";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "118.69";
			arrStoff[intZeileNr][1] = "Sn";
			arrStoff[intZeileNr][2] = "Xylenolorange";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "80.06";
			arrStoff[intZeileNr][1] = "SO3";
			arrStoff[intZeileNr][2] = "Phthaleinpurpur";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "96.06";
			arrStoff[intZeileNr][1] = "SO4";
			arrStoff[intZeileNr][2] = "Phthaleinpurpur";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "87.62";
			arrStoff[intZeileNr][1] = "Sr";
			arrStoff[intZeileNr][2] = "Phthaleinpurpur";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "232.04";
			arrStoff[intZeileNr][1] = "Th";
			arrStoff[intZeileNr][2] = "Xylenolorange";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "47.9";
			arrStoff[intZeileNr][1] = "Ti";
			arrStoff[intZeileNr][2] = "Murexid";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "204.37";
			arrStoff[intZeileNr][1] = "Tl";
			arrStoff[intZeileNr][2] = "Eriochromschwarz T, PAN (Pyridyl-beta-azonaphthol oder Xylenolorange)";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "119.01";
			arrStoff[intZeileNr][1] = "U";
			arrStoff[intZeileNr][2] = "Murexid";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "140.35";
			arrStoff[intZeileNr][1] = "U3O8";
			arrStoff[intZeileNr][2] = "Murexid";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "50.941";
			arrStoff[intZeileNr][1] = "V";
			arrStoff[intZeileNr][2] = "Murexid";
            arrStoff[intZeileNr][3] = "reduziert mit SO2";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "16.980";
			arrStoff[intZeileNr][1] = "V";
			arrStoff[intZeileNr][2] = "Murexid";
            arrStoff[intZeileNr][3] = "reduziert mit ZnHg";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "90.940";
			arrStoff[intZeileNr][1] = "V2O5";
			arrStoff[intZeileNr][2] = "Murexid";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "65.37";
			arrStoff[intZeileNr][1] = "Zn";
			arrStoff[intZeileNr][2] = "Eriochromschwarz T oder PAN (Pyridyl-beta-azonaphthol)";

			intZeileNr++;
			arrStoff[intZeileNr][0] = "91.22";
			arrStoff[intZeileNr][1] = "Zr";
			arrStoff[intZeileNr][2] = "Xylenolorange";
            }

  	    if(strGewaehlteMassanalyse.equals("Permanganometrie"))
	    {	
			arrStoff[intZeileNr][0] = "45.018";
			arrStoff[intZeileNr][1] = "(COOH)2";

            intZeileNr++;
			arrStoff[intZeileNr][0] = "63.033";
			arrStoff[intZeileNr][1] = "(COOH)2 x 2H2O";

            intZeileNr++;
			arrStoff[intZeileNr][0] = "44.010";
			arrStoff[intZeileNr][1] = "(COO)2";

            intZeileNr++;
			arrStoff[intZeileNr][0] = "67.000";
			arrStoff[intZeileNr][1] = "Na2C2O4";

            intZeileNr++;
			arrStoff[intZeileNr][0] = "23.013";
			arrStoff[intZeileNr][1] = "HCOOH";
			arrStoff[intZeileNr][3] = "sauer nach Jones";

            intZeileNr++;
			arrStoff[intZeileNr][0] = "13.808";
			arrStoff[intZeileNr][1] = "HCOOH";
			arrStoff[intZeileNr][3] = "sauer nach Liebig";

            intZeileNr++;
			arrStoff[intZeileNr][0] = "20.04";
			arrStoff[intZeileNr][1] = "Ca";

            intZeileNr++;
			arrStoff[intZeileNr][0] = "50.045";
			arrStoff[intZeileNr][1] = "CaCO3";

            intZeileNr++;
			arrStoff[intZeileNr][0] = "28.040";
			arrStoff[intZeileNr][1] = "CaO";

            intZeileNr++;
			arrStoff[intZeileNr][0] = "37.045";
			arrStoff[intZeileNr][1] = "Ca(OH)2";

            intZeileNr++;
			arrStoff[intZeileNr][0] = "17.332";
			arrStoff[intZeileNr][1] = "Cr";

            intZeileNr++;
			arrStoff[intZeileNr][0] = "25.332";
			arrStoff[intZeileNr][1] = "Cr2O3";

            intZeileNr++;
			arrStoff[intZeileNr][0] = "38.665";
			arrStoff[intZeileNr][1] = "CrO4";

            intZeileNr++;
			arrStoff[intZeileNr][0] = "63.546";
			arrStoff[intZeileNr][1] = "Cu";
			arrStoff[intZeileNr][3] = "Zuckerreduktion";

            intZeileNr++;
			arrStoff[intZeileNr][0] = "55.847";
			arrStoff[intZeileNr][1] = "Fe";
            }

  	    if(strGewaehlteMassanalyse.equals("Titanometrie"))
	    {	
			arrStoff[intZeileNr][0] = "65.656";
			arrStoff[intZeileNr][1] = "Au";

            intZeileNr++;
			arrStoff[intZeileNr][0] = "101.11";
			arrStoff[intZeileNr][1] = "AuCl3";

            intZeileNr++;
			arrStoff[intZeileNr][0] = "63.546";
			arrStoff[intZeileNr][1] = "Cu";

            intZeileNr++;
			arrStoff[intZeileNr][0] = "79.545";
			arrStoff[intZeileNr][1] = "CuO";

            intZeileNr++;
			arrStoff[intZeileNr][0] = "159.60";
			arrStoff[intZeileNr][1] = "CuSo4";

            intZeileNr++;
			arrStoff[intZeileNr][0] = "249.68";
			arrStoff[intZeileNr][1] = "CuSo4 x 5H2O";

            intZeileNr++;
			arrStoff[intZeileNr][0] = "55.847";
			arrStoff[intZeileNr][1] = "Fe";

            intZeileNr++;
			arrStoff[intZeileNr][0] = "16.221";
			arrStoff[intZeileNr][1] = "FeCl3";

            intZeileNr++;
			arrStoff[intZeileNr][0] = "270.30";
			arrStoff[intZeileNr][1] = "FeCl3 x 6H2O";

            intZeileNr++;
			arrStoff[intZeileNr][0] = "79.846";
			arrStoff[intZeileNr][1] = "Fe2O3";

            intZeileNr++;
			arrStoff[intZeileNr][0] = "199.94";
			arrStoff[intZeileNr][1] = "Fe2(SO4)3";

            intZeileNr++;
			arrStoff[intZeileNr][0] = "329.25";
			arrStoff[intZeileNr][1] = "K3[Fe(CN)6]";

            intZeileNr++;
			arrStoff[intZeileNr][0] = "482.19";
			arrStoff[intZeileNr][1] = "NH4Fe(SO4)2 x 12H2O";

            intZeileNr++;
			arrStoff[intZeileNr][0] = "100.30";
			arrStoff[intZeileNr][1] = "Hg";

            intZeileNr++;
			arrStoff[intZeileNr][0] = "135.75";
			arrStoff[intZeileNr][1] = "HgCl2";

            intZeileNr++;
			arrStoff[intZeileNr][0] = "108.30";
			arrStoff[intZeileNr][1] = "HgO";

            intZeileNr++;
			arrStoff[intZeileNr][0] = "148.33";
			arrStoff[intZeileNr][1] = "HgSO4";

            intZeileNr++;
			arrStoff[intZeileNr][0] = "60.875";
			arrStoff[intZeileNr][1] = "Sb";

            intZeileNr++;
			arrStoff[intZeileNr][0] = "149.51";
			arrStoff[intZeileNr][1] = "SbCl5";

            intZeileNr++;
			arrStoff[intZeileNr][0] = "80.875";
			arrStoff[intZeileNr][1] = "Sb2O5";

            intZeileNr++;
			arrStoff[intZeileNr][0] = "119.01";
			arrStoff[intZeileNr][1] = "U";

            intZeileNr++;
			arrStoff[intZeileNr][0] = "212.07";
			arrStoff[intZeileNr][1] = "UO2(CH3COO)2 x 2H2O";
            }

		intZeileNr_max = intZeileNr;

	} // erstelle_Liste_arrStoff
	
} // clsErstelle_Liste_Stoff
	