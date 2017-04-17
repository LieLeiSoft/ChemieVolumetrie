package de.lieleisoft.chemievolumetrie;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class ActivityTools {
	// Gleitkommazahl runden
	public static double fktRunden(double Zahl, int AnzahlStellen) {
		long Dummy =  (long) Math.pow(10, AnzahlStellen);
		double Ergebnis = (long) ((Zahl*Dummy) + (0.5*Math.signum(Zahl))) / (Dummy*1.0); // *1.0 damit's ein double wird!
		
		return Ergebnis;		
	} // fktRunden

	/*
	   Text duplizieren
	   
       Ein Text wird so oft dupliziert, wie im 2. Parameter angegeben
       Beispiel: repeat("ha", 5) 
                 gibt den Text "hahahahaha" zurück
    
	   http://rosettacode.org/wiki/Repeat_a_string#Java
	   Works with: Java version 1.5+
	 */
	public static String repeat(String str, int times){
		return new String(new char[times]).replace("\0", str);
	} // repeat
	
	// Gleitkommazahl in Text umwandeln
	public static String fktDoubleToStringFormat(double Zahl, int AnzahlStellen) {
		double dblWert;
		String strFormat;
		String strErgebnis = "";
		
		dblWert = fktRunden(Zahl, AnzahlStellen);
		
		strFormat = "#0."+repeat("0", AnzahlStellen);
		NumberFormat formatter = new DecimalFormat(strFormat); 
		strErgebnis = formatter.format(dblWert);

		// Punkt durch Komma ersetzen. Dadurch ist sichergestellt, dass im Ergebnis kein Punkt als Dezimaltrennzeichen steht.
    	strErgebnis = strErgebnis.replace(".", ",");
    	
		return strErgebnis;
	} // fktDoubleToStringFormat

	/*
		Text in Zahl umwandeln
		Ist der übergebene Text leer, wird 0 zurückgegeben
	*/
	public double fktBlankToNumber(String strParameter){
    	double Ergebnis = 0;
    	if (strParameter.equals("") == false) {
           	Ergebnis = Double.parseDouble(strParameter);
   		}
		return Ergebnis;		
    } // fktBlankToNumber

	
} // ActivityTools
