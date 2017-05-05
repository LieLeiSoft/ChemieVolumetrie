package de.lieleisoft.chemievolumetrie;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import de.lieleisoft.chemievolumetrie.R;

public class HilfeActivity extends Activity {
	List<Map<String, String>> hilfeListe = new ArrayList<Map<String,String>>();
	String[][] Hilfe = new String[10][4];
	int intFeldNr_max = 0;

	// 4 Spalten pro Hilfetext:
	// Spalte 0: Kapitel
	// Spalte 1: �berschrift, die in der Liste angezeigt wird (ListView)
	// Spalte 2: �berschrift, die in der Titelleiste des Meldungsfensters angezeigt wird
	// Spalte 3: Hilfetext

	private void erstelle_Hilfe_Menue(String strKapitel) {		
		int intFeldNr = 0;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = getResources().getString(R.string.Beschriftung_Urtiter);
		Hilfe[intFeldNr][2] = "Neuer Titer mit Urtiter";
		Hilfe[intFeldNr][3] = "In dieser Routine l�sst sich der Titer von einer"
				+ " Ma�l�sung bestimmen. Der Titer wird dabei mit einem Urtiter eingestellt.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = getResources().getString(R.string.Beschriftung_Titer);
		Hilfe[intFeldNr][2] = "Neuer Titer mit eingestellter Ma�l�sung";
		Hilfe[intFeldNr][3] = "In dieser Routine l�sst sich der Titer von einer"
				+ " Ma�l�sung bestimmen. Der Titer wird dabei mit einer anderen Ma�l�sung"
				+ " mit bekanntem Titer eingestellt.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = getResources().getString(R.string.Beschriftung_Berechnung);
		Hilfe[intFeldNr][2] = "Titration des Gehaltes in %";
		Hilfe[intFeldNr][3] = "In dieser Routine l�sst sich der Gehalt in % von der zu"
				+ " untersuchenden Substanz bestimmen. Dies geschieht mit einer"
				+ " eingestellten Ma�l�sung. ";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = getResources().getString(R.string.Fettkennzahl);
		Hilfe[intFeldNr][2] = "Titration von Fettkennzahlen";
		Hilfe[intFeldNr][3] = "In dieser Routine l�sst sich eine aufgef�hrte Fettkennzahl"
				+ " nach dem Europ�ischen oder Amerikanischen Arzneibuch bestimmen."
				+ " Dabei werden die laut Methode fest vorgegebenen Parameter vollst�ndig"
				+ " �bernommen.";

		intFeldNr_max = intFeldNr;
	} // erstelle_Hilfe_Menue
	private void erstelle_Hilfe_Fettkennzahlen(String strKapitel) {		
		int intFeldNr = 0;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "S�urezahl (EP oder USP)";
		Hilfe[intFeldNr][2] = "S�urezahl (nach EP oder USP)";
		Hilfe[intFeldNr][3] = "Die S�urezahl (SZ) ist eine chemische Gr��e zur Charakterisierung"
				+ " von sauren Bestandteilen in Fetten oder �len. Sie bezeichnet die Masse an"
				+ " Kaliumhydroxid (in mg), die notwendig ist um die in 1 g Fett enthaltenen freien"
				+ " Fetts�uren zu neutralisieren."
				+ "\n"
				+ "Berechnung nach EP:\n"
				+ "SZ = (5,610 x V) / m\n"
				+ "Berechnung nach USP:\n"
				+ "SZ = (56,11 x V x 0,1) / m\n"
				+ "V = Verbrauch KOH 0,1N\n"
				+ "m = Einwaage in Gramm";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Esterzahl (USP)";
		Hilfe[intFeldNr][2] = "Esterzahl (USP)";
		Hilfe[intFeldNr][3] = "Die Esterzahl (EZ) bezeichnet die Masse an Kaliumhydroxid in Milligramm,"
				+ " die ben�tigt wird, um die in 1 g Fett enthaltenen Esterbindungen der Neutralester"
				+ " zu hydrolysieren (zu verseifen). Im Europ�ischen Arzneibuch wird die Esterzahl nicht"
				+ " titriert, sondern aus der Verseifungszahl (VZ) und der S�urezahl (SZ) berechnet."
				+ "\n"
				+ "Berechnung nach EP:\n"
				+ "EZ = VZ - SZ\n"
				+ "Berechnung nach USP:\n"
				+ "EZ = (56,11 x (VB - VT) x 0,5) / m\n"
				+ "VB = Verbr. Blank HCL 0,5N\n"
				+ "VT = Verbr. Probe HCL 0,5N\n"
				+ "m = Einwaage in Gramm";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Hydroxylzahl (mit bekannter SZ)";
		Hilfe[intFeldNr][2] = "Hydroxylzahl (nach EP oder USP und bekannter SZ)";
		Hilfe[intFeldNr][3] = "Die Hydroxylzahl (OHZ) ist ein Ma� f�r den Gehalt an Hydroxygruppen in"
				+ " organischen Materialien, z. B. in Harzen, Lacken, Polyesterolen, Fetten und L�sungsmitteln."
				+ " Die Hydroxylzahl gibt die Menge Kaliumhydroxid in Milligramm an, welche der bei einer"
				+ " Acetylierung von einem Gramm Substanz gebundenen Menge Essigs�ure gleichwertig ist."
				+ "\n"
				+ "Berechnung nach EP:\n"
				+ "OHZ = ((28,05 x (VB - VT)) / m) + SZ\n"
				+ "Berechnung nach USP:\n"
				+ "OHZ = (56,11 x 0,5) / m x (VB - VT) x SZ\n"
				+ "VB = Verbr. Blank KOH 0,5N\n"
				+ "VT = Verbr. Probe KOH 0,5N\n"
				+ "m = Einwaage in Gramm";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Hydroxylzahl (unbekannte SZ)";
		Hilfe[intFeldNr][2] = "Hydroxylzahl (nach EP oder USP und unbekannter SZ)";
		Hilfe[intFeldNr][3] = "Die Hydroxylzahl (OHZ) ist ein Ma� f�r den Gehalt an Hydroxygruppen in"
				+ " organischen Materialien, z. B. in Harzen, Lacken, Polyesterolen, Fetten und L�sungsmitteln."
				+ " Die Hydroxylzahl gibt die Menge Kaliumhydroxid in Milligramm an, welche der bei einer"
				+ " Acetylierung von einem Gramm Substanz gebundenen Menge Essigs�ure gleichwertig ist.";
		
		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Iodzahl (EP oder USP)";
		Hilfe[intFeldNr][2] = "Iodzahl (nach EP oder USP)";
		Hilfe[intFeldNr][3] = "Die Iodzahl (IZ) ist eine Fettkennzahl zur Charakterisierung von Fetten und"
				+ " �len. Sie ist ein Ma� f�r den Gehalt eines Fettes an unges�ttigten Verbindungen"
				+ " � genauer: unges�ttigte Fetts�urereste in den Glyceriden. Es ist die Menge in Gramm Iod,"
				+ " die formal an 100 g Fett addiert werden kann. Je mehr olefinische Doppelbindungen es in"
				+ " einem Fett gibt, desto mehr Iod kann formal addiert werden und desto h�her ist somit die Iodzahl.";
		
		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Peroxidzahl (EP oder USP)";
		Hilfe[intFeldNr][2] = "Peroxidzahl (nach EP oder USP)";
		Hilfe[intFeldNr][3] = "Die Peroxidzahl (POZ) ist eine Kennzahl f�r den Gehalt an peroxidischen"
				+ " funktionellen Gruppen eines Fettes oder eines fetten �ls. Sie kann als Kennzahl f�r die Beurteilung"
				+ " des Fettverderbs herangezogen werden.";
		
		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Verseifungszahl (EP oder USP)";
		Hilfe[intFeldNr][2] = "Verseifungszahl (nach EP oder USP)";
		Hilfe[intFeldNr][3] = "Die Verseifungszahl (VZ) ist eine Kennzahl zur chemischen Charakterisierung von"
				+ " Fetten und �len. Sie wird zu deren Reinheitspr�fung und Qualit�tskontrolle herangezogen. Die"
				+ " Verseifungszahl ist ein Ma� f�r die in einem Gramm Fett gebundenen und frei vorkommenden S�uren."
				+ " Sie gibt an, wie viel Kaliumhydroxid (in mg) notwendig ist, um die in 1 g Fett enthaltenen freien"
				+ " S�uren zu neutralisieren und die vorhandenen Esterbindungen zu spalten (Verseifung). Je kleiner"
				+ " die mittlere molare Masse eines Fettes ist (also je mehr kurzkettige Fetts�uren enthalten sind),"
				+ " desto gr��er ist die Verseifungszahl.";

		intFeldNr_max = intFeldNr;
	} // erstelle_Hilfe_Fettkennzahlen
	
	private void erstelle_Hilfe_Einwaage(String strKapitel) {		
		int intFeldNr = 0;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Eingaben l�schen";
		Hilfe[intFeldNr][2] = "Button > Eingaben l�schen <";
		Hilfe[intFeldNr][3] = "Mit Hilfe dieses Buttons k�nnen alle Eingaben auf dem aktuellen"
            + " Bildschirm gel�scht werden. Eingaben von dem n�chsten oder vorherigen"
            + " Display bleiben dabei unber�hrt.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Weiter";
		Hilfe[intFeldNr][2] = "Button > Weiter <";
		Hilfe[intFeldNr][3] = "Wurden alle n�tigen Eingaben gemacht, kann mit diesem Button zum"
            + " n�chsten Bildschirm gewechseln werden. Mit der Android Zur�cktaste, kann man zum vorheringen"
            + " Display zur�ckkehren, um �nderungen bei den Eingaben vorzunehmen.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Einwaage";
		Hilfe[intFeldNr][2] = "Eingabefeld > Einwaage <";
		Hilfe[intFeldNr][3] = "In diesen Eingabefeldern k�nnen bis zu 8 Einwaagen gleichzeitig eingegeben"
			+ " werden. Erst beim Anw�hlen eines Eingabefeldes �ffnet sich das jeweils n�chte Eingabefeld."
			+ " F�r jede Einwaage erscheint sp�ter auch ein entsprechendes Eingabefeld f�r den Verbrauch."
            + " Nicht belegte Felder bleiben sp�ter bei der Berechnung unber�cksichtigt. Mit der Android"
            + " Zur�cktaste, kann man jedoch zum vorheringen Display zur�ckkehren,"
            + " und Eingaben jederzeit korrigieren. Alle Einwaagen m�ssen in Gramm eingegeben werden!";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Urtiter";
		Hilfe[intFeldNr][2] = "Eingabefeld > Urtiter (%) <";
		Hilfe[intFeldNr][3] = "Nur in der Routine der Volumetrischen Gehaltsbestimmung: Der Urtiter ist ein"
			+ " prim�rer Standard, der vollst�ndig mit einer entsprechenden Ma�l�sung"
            + " reagiert. In diesem Eingabefeld wird die Reinheit des Urtiters in Prozent eingetragen. Wird keine"
            + " Eingabe vorgenommen und zum n�chsten Display gewechselt, wird der Urtiter automatisch auf 100%"
            + " gesetzt. Mit der Android Zur�cktaste, kann man jedoch zum zur�ckkehren, und diese gesetzte Eingabe"
            + " jederzeit korrigieren.";

		intFeldNr_max = intFeldNr;
	} // erstelle_Hilfe_Einwaage

	private void erstelle_Hilfe_Berechnung(String strKapitel) {		
		int intFeldNr = 0;

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Einstellungen";
		Hilfe[intFeldNr][2] = "Button > Einstellungen <";
		Hilfe[intFeldNr][3] = "Unter Einstellungen l�sst sich die Anzahl der gerundeten Nachkommastellen"
				+ " von dem errechneten Gehalt und der relativen Standardabweichung einstellen. Die"
				+ " Nachkommastellen vom Titer k�nnen nicht eingestellt werden, weil dieser in der Chemie"
				+ " standardm��ig mit 4 Stellen angegeben wird. Desweiteren l�sst sich bei einigen Layouts"
				+ " die Schriftgr��e und Buttonh�he individuell anpassen.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Berechne auf TS";
		Hilfe[intFeldNr][2] = "Umrechnung auf TS";
		Hilfe[intFeldNr][3] = "Die Trockensubstanz ist jener Bestandteil"
				+ " einer Substanz, der nach Abzug des Wassergehalts �brig bleibt."
				+ " Trockensubstanz und Wassergehalt erg�nzen sich also zu 100 Prozent."
				+ " Wird zuvor in dem Eingabefeld > Wasser � Probe < der � Wassergehalt der Proben"
				+ " eingeben, so kann mit Hilfe dieses Buttons der Gehalt (as is) auf die"
				+ " Trockensubstanz (TS) umgerechnet werden. Um den Gehalt wieder auf den"
				+ " as is Wert (= so wie es ist) zu berechnen, muss vor dem erneuten Bet�tigen"
				+ " des Buttons bei dem Wassergehalt wieder eine 0 eingegeben werden.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Gehalt";
		Hilfe[intFeldNr][2] = "Gehalt in %";
		Hilfe[intFeldNr][3] = "Der Gehalt as is (so wie es ist, inkl. Wasser) oder TS"
				+ " (Trockensubstanz ohne Wasser) wird in Gewichtsprozent angegeben."
				+ " Dabei steht Gewichtsprozent f�r die Anzahl Gramm pro 100 Gramm. Der Gehalt"
				+ " ist ein Ma� f�r die Reinheit einer Substanz.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Titer";
		Hilfe[intFeldNr][2] = "Ausgabefeld > Titer <";
		Hilfe[intFeldNr][3] = "Der Titer ist ein Faktor, der die Abweichung der tats�chlichen"
            + " Konzentration von der gew�nschten Konzentration einer Ma�l�sung angibt."
            + " Der Idealwert eines Titers ist somit 1,0000.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "% RSD";
		Hilfe[intFeldNr][2] = "Relative Standardabweichung RSD%";
		Hilfe[intFeldNr][3] = "Relative Standardabweichung ist ein statistisches Ma�"
				+ " f�r die Streuung der Me�werte in Prozent. Die Anzahl der gerundeten"
				+ " Nachkommastellen lassen sich unter dem Button >Einstellungen< verstellen.";

		intFeldNr_max = intFeldNr;
	} // erstelle_Hilfe_Berechnung

	private void erstelle_Hilfe_Verbrauch(String strKapitel) {		
		int intFeldNr = 0;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Eingaben l�schen";
		Hilfe[intFeldNr][2] = "Button > Eingaben l�schen <";
		Hilfe[intFeldNr][3] = "Mit Hilfe dieses Buttons k�nnen alle Eingaben auf dem aktuellen"
				+ " Bildschirm gel�scht werden. Eingaben von dem n�chsten oder vorherigen"
				+ " Display bleiben dabei unber�hrt.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Berechnung";
		Hilfe[intFeldNr][2] = "Button > Berechnung <";
		Hilfe[intFeldNr][3] = "Wurden alle Verbr�uche (jedoch mindestens ein Verbrauch)"
				+ " eingegeben, kann man mit diesem Button zum n�chsten Bildschirm"
				+ " wechseln, in welchem dann die Ergebnisse der einzelnen Proben"
				+ " angezeigt werden. Mit der Android Zur�cktaste, kann man jederzeit"
				+ " zum vorheringen Display zur�ckkehren, um �nderungen bei den Eingaben"
				+ " vorzunehmen.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Blindwerte";
		Hilfe[intFeldNr][2] = "Button > Blindwerte? <";
		Hilfe[intFeldNr][3] = "Mit diesem Button kann man zu einem Bildschirm"
		+ " wechseln, in welchem, falls vorhanden, die Verbr�uche von Blindwerten,"
		+ " eingeben werden. Werden mehere Blindwerte eingegeben, wird der Durchschnitt"
		+ " aller Blindwerte berechnet. Dieser Durchschnittsblindwert wird dann bei der"
		+ " Berechnung ber�cksichtigt. Um zu dem Display"
		+ " der Probenverbr�uche zur�ckzukehren muss die Android Zur�cktaste 2x"
		+ " oder der Button  < zur Titration > bet�tigt werden.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Verbrauch Probe";
		Hilfe[intFeldNr][2] = "Eingabefeld > Verbrauch Probe <";
		Hilfe[intFeldNr][3] = "In diesen Eingabefeldern k�nnen, entsprechend der Einwaagen,"
				+ " bis zu 8 Verbr�uche gleichzeitig eingegeben werden. Der Verbrauch an"
				+ " Ma�l�sung wird f�r jede Probe in Milliliter eingegeben. Ein Verbrauch von 0 ml"
				+ " ist ebenfalls m�glich.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Verbrauch Blindwerte";
		Hilfe[intFeldNr][2] = "Eingabefeld > Verbrauch Blindwerte <";
		Hilfe[intFeldNr][3] = "In diesen Eingabefeldern k�nnen bis zu 8 Verbr�uche von Blindwerten in Milliliter"
				+ " eingegeben werden. Die Verbr�uche von mehreren Blindwerten werden automatisch zu"
				+ " einem � Blindwert gemittelt. Ein Blindwertverbrauch von 0ml ist ebenfalls m�glich."
				+ " Der errechnete � Blindwert wird dann f�r die Berechnung verwendet und standardm��ig von den "
				+ " Probenverbr�uchen abgezogen. Ist der errechnete � Blindwert gr��er, als ein Probenverbrauch,"
				+ " so kann dieser sp�ter nach einer Abfrage in einer Dialogbox von den Verbr�uchen der Proben abgezogen"
				+ " werden. Nicht belegte Felder bleiben sp�ter f�r die Berechnung unber�cksichtigt.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Vorlagevolumen";
		Hilfe[intFeldNr][2] = "Eingabefeld > Volumen Vorlage <";
		Hilfe[intFeldNr][3] = "Wird bei einer R�cktitration mit einer Vorlage gearbeitet, kann in diesem"
				+ " Eingabefeld das entsprechende Volumen in Milliliter der Vorlage eingegeben werden."
				+ " Da es sich bei der Verwendung einer Vorlage immer um eine R�cktitration handelt, werden"
				+ " die Probenverbr�uche grunds�tzlich von dem Vorlagevolumen abgezogen.";

		intFeldNr_max = intFeldNr;
	} // erstelle_Hilfe_Verbrauch
		
	private void erstelle_Hilfe_Titereingaben(String strKapitel) {		
		int intFeldNr = 0;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Eingaben l�schen";
		Hilfe[intFeldNr][2] = "Button > Eingaben l�schen <";
		Hilfe[intFeldNr][3] = "Mit Hilfe dieses Buttons k�nnen alle Eingaben auf dem aktuellen"
				+ " Bildschirm gel�scht werden. Eingaben von dem n�chsten oder vorherigen"
				+ " Display bleiben dabei unber�hrt.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "zur Titration";
		Hilfe[intFeldNr][2] = "Button > zur Vorlage <";
		Hilfe[intFeldNr][3] = "Wurde in alle Eingaben vorgenommen, kann man mit diesem Button zum"
				+ " n�chsten Bildschirm wechseln. Mit der Android Zur�cktaste, kann man  zur�ckkehren,"
				+ " um �nderungen bei den Eingaben vorzunehmen.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Volumetrischer Faktor";
		Hilfe[intFeldNr][2] = "Eingabefeld > Volumetrischer Faktor <";
		Hilfe[intFeldNr][3] = "In diesem Eingabefeld muss der volumetrische Faktor in mg/ml eingegeben werden."
				+ " Der volumetrische Faktor gibt an, wieviel Milligramm des gesuchten Stoffes ein Milliliter"
				+ " der Ma�l�sung verbraucht. Wird die gesuchte Substanz vollst�ndig von der Ma�l�sung umgesetzt,"
				+ " entspricht das genau ein Mol der gesuchten Substanz, welche sich dann aus der Molmasse errechnen l�sst."
				+ " Ist der Faktor nicht bekannt, kann er auch �ber den >Datenbank< Button bestimmt werden."
				+ " Dieses Eingabefeld wird bei der Berechnung des Titer mit einer anderen Ma�l�sung nicht ben�tigt.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Stoffmengenkonzentration (mol/l)";
		Hilfe[intFeldNr][2] = "Eingabefeld > Stoffmengenkonzentration (mol/l) <";
		Hilfe[intFeldNr][3] = "In diesem Eingabefeld muss die Stoffmengenkonzentration in Mol pro Liter von der"
				+ " Vorlage bzw. des Titranten eingeben werden. Die Stoffmengenkonzentration oder auch veraltet Molarit�t,"
				+ " ist der Quotient der Stoffmenge (in mol) zu dem L�sungsmittel (in Liter).";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Titer";
		Hilfe[intFeldNr][2] = "Eingabefeld > Titer <";
		Hilfe[intFeldNr][3] = "In diesem Eingabefeld wird der Titer der Ma�l�sung eingegeben."
				+ " Der Titer ist ein Faktor, der die Abweichung der tats�chlichen"
            + " Konzentration von der gew�nschten Konzentration einer Ma�l�sung angibt."
            + " Der Idealwert eines Titers ist somit 1,0000. Wird keine Eingabe vorgenommen"
            + " und zum n�chsten Display gewechselt,"
            + " wird der Titer automatisch auf 1,0000 gesetzt. Mit der Android Zur�cktaste,"
            + " kann man jedoch zur�ckkehren, und diese gesetzte Eingabe"
            + " jederzeit korrigieren.";

		intFeldNr_max = intFeldNr;
	} // erstelle_Hilfe_Titereingaben
	
	private void erstelle_Hilfe_Molaritaet(String strKapitel) {		
		int intFeldNr = 0;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Eingaben l�schen";
		Hilfe[intFeldNr][2] = "Button > Eingaben l�schen <";
		Hilfe[intFeldNr][3] = "Mit Hilfe dieses Buttons k�nnen alle Eingaben auf dem aktuellen"
				+ " Bildschirm gel�scht werden. Eingaben von dem n�chsten oder vorherigen"
				+ " Display bleiben dabei unber�hrt.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Zur�ck";
		Hilfe[intFeldNr][2] = "Button > Zur�ck <";
		Hilfe[intFeldNr][3] = "Mit diesem Button kehrt man zum vorherigen Bildschirm zur�ck."
				+ " Die get�tigten Eingaben werden dabei �bernommen. Der Zur�ck Button ist dem"
				+ " Android Zur�ck Button vorzuziehen!";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Molmasse";
		Hilfe[intFeldNr][2] = "Eingabefeld > Molmasse < und > berechne < Button";
		Hilfe[intFeldNr][3] = "In diesem Eingabefeld muss die Molmasse der eingesetzten Substanz f�r die Ma�l�sung in Gramm"
				+ " pro Mol eingegeben werden. Ist die Molmasse unbekannt, kann diese auch im n�chsten Layout �ber den berechne"
				+ " Button mit Hilfe des Periodensystems errechnet werden.";
		
		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "st�chiometrische Wertigkeit";
		Hilfe[intFeldNr][2] = "Eingabefeld > st�chiometrische Wertigkeit";
		Hilfe[intFeldNr][3] = "In diesem Eingabefeld muss die st�chiometrische Wertigkeit der eingesetzten Substanz f�r die Ma�l�sung"
				+ " eingegeben werden. Die st�chiometrische Wertigkeit oder auch die �quivalentzahl, ist die Anzahl der bei einer"
				+ " elektrochemischen Reaktion ausgetauschten Elektronen. Oder auch die Zahl, die angibt, wieviel Wasserstoffatome"
				+ " ein Atom eines chemischen Elementes binden oder ersetzen kann. Sie wird ben�tigt, um die �quivalentkonzentration "
				+ " (fr�her Normalit�t) aus der Stoffmengenkonzentration (Molarit�t) zu errechnen."
				+ "  Einige Beispiele:\n"
				+ "Salzs�ure HCl = 1\n"
				+ "Schwefels�ure H2S04 = 2\n"
				+ "Phosphors�ure H3PO4 = 3\n"
				+ "Kaliumpermanganat KMnO4 = 5\n"
				+ "(Mn +VII zu Mn +II)\n"
				+ "Kaliumbromat KBrO3 = 6\n"
				+ "(Br +V zu Br -I)";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Einwaage der Ma�l�sung";
		Hilfe[intFeldNr][2] = "Eingabefeld > Einwaage der Ma�l�sung <";
		Hilfe[intFeldNr][3] = "In diesem Eingabefeld muss die Einwaage der eingesetzten Substanz f�r die Ma�l�sung in Gramm"
				+ " eingegeben werden.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Volumen der Ma�l�sung";
		Hilfe[intFeldNr][2] = "Eingabefeld > Volumen der Ma�l�sung <";
		Hilfe[intFeldNr][3] = "In diesem Eingabefeld muss das Volumen der Ma�l�sung in Liter eingegeben werden.";
		
		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Reinheit der Einwaage";
		Hilfe[intFeldNr][2] = "Eingabefeld > Gehalt der Einwaage <";
		Hilfe[intFeldNr][3] = "In diesem Eingabefeld muss die Reinheit in Prozent der eingesetzten Substanz f�r die Ma�l�sung"
				+ " eingegeben werden.";

		intFeldNr_max = intFeldNr;
	} // erstelle_Hilfe_Molaritaet
	
	private void erstelle_Hilfe_Faktor(String strKapitel) {		
		int intFeldNr = 0;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Eingaben l�schen";
		Hilfe[intFeldNr][2] = "Button > Eingaben l�schen <";
		Hilfe[intFeldNr][3] = "Mit Hilfe dieses Buttons k�nnen alle Eingaben auf dem aktuellen"
				+ " Bildschirm gel�scht werden. Eingaben von dem n�chsten oder vorherigen"
				+ " Display bleiben dabei unber�hrt.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Zur�ck";
		Hilfe[intFeldNr][2] = "Button > Zur�ck <";
		Hilfe[intFeldNr][3] = "Mit diesem Button kehrt man zum vorherigen Bildschirm zur�ck."
				+ " Die get�tigten Eingaben werden dabei �bernommen. Der Zur�ck Button ist dem"
				+ " Android Zur�ck Button vorzuziehen!";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Molmasse der gesuchten Substanz";
		Hilfe[intFeldNr][2] = "Eingabefeld > Molmasse der gesuchten Substanz <";
		Hilfe[intFeldNr][3] = "In diesem Eingabefeld muss die Molmasse der gesuchten Substanz in Gramm"
				+ " pro Mol eingegeben werden. Ist die Molmasse unbekannt, kann diese auch im n�chsten Layout �ber den berechne"
				+ " Button mit Hilfe des Periodensystems errechnet werden.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Stoffmengenkonzentration (mol/l) der Ma�l�sung";
		Hilfe[intFeldNr][2] = "Eingabefeld > Stoffmengenkonzentration (mol/l) der Ma�l�sung <";
		Hilfe[intFeldNr][3] = "In diesem Eingabefeld muss die Stoffmengenkonzentration in Mol pro Liter von der"
				+ " bekannten Ma�l�sung eingeben werden. Die Stoffmengenkonzentration oder auch veraltet Molarit�t,"
				+ " ist der Quotient der Stoffmenge (in mol) zu dem L�sungsmittel (in Liter).";

		intFeldNr_max = intFeldNr;
	} // erstelle_Hilfe_Faktor
	
	private void erstelle_Hilfe_Vorlage(String strKapitel) {		
		int intFeldNr = 0;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Eingaben l�schen";
		Hilfe[intFeldNr][2] = "Button > Eingaben l�schen <";
		Hilfe[intFeldNr][3] = "Mit Hilfe dieses Buttons k�nnen alle Eingaben auf dem aktuellen"
				+ " Bildschirm gel�scht werden. Eingaben von dem n�chsten oder vorherigen"
				+ " Display bleiben dabei unber�hrt.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "zur Titration";
		Hilfe[intFeldNr][2] = "Button > zur Titration <";
		Hilfe[intFeldNr][3] = "Mit Hilfe diesen Buttons kommt man zum Layout der Titration.";
		
		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Titrationsart: Direkte / Inverse Titration";
		Hilfe[intFeldNr][2] = "Button > Titrationsart <";
		Hilfe[intFeldNr][3] = "Durch diesen Button wird die Titratonsart mit einer Dialogbox ausgew�hlt. Im Normalfall"
				+ " findet die Direkte Titration Anwendung, die in der App voreingestellt ist."
				+ " Bei dieser Titrationsart wird mit einer titerbekannten Ma�l�sung titriert. Eine titerunbekannte"
				+ " Ma�l�sung (Titerbestimmung mit einer anderen Ma�l�sung) oder eine Probel�sung dient dabei als Vorlage."
				+ " Bei der Inversen Titration ist es genau umgekehrt. Hier wird mit einer titerunbekannten"
				+ " Ma�l�sung oder einer Probel�sung titriert und eine titerbekannte Ma�l�sung dient als Vorlage."
				+ " Die Titrationsart wird auch in einem Ausgabefeld im Layout der Vorlage und der Volumetrie angezeigt.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Volumen der Vorlage";
		Hilfe[intFeldNr][2] = "Eingabefeld > Volumen der Vorlage <";
		Hilfe[intFeldNr][3] = "In diesem Eingabefeld wird das Volumen der Vorlage (falls vorhanden) in Milliliter eingegeben.";

		intFeldNr_max = intFeldNr;
	} // erstelle_Hilfe_Vorlage
	
	private void erstelle_Hilfe_Molmassen(String strKapitel) {		
		int intFeldNr = 0;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Allgemeines!";
		Hilfe[intFeldNr][2] = "Allgemeines!";
		Hilfe[intFeldNr][3] = "In diesem Layout kann die Molmasse der gesuchten Substanz bzw. der Ma�l�sung berechnet werden."
				+ " Achtung WICHTIG! Es ist zu beachten, dass die Molmasse nur dann zur Faktorberechnung 1:1 �bernommen werden"
				+ " kann, wenn die gesuchte Substanz zu 100% von der Ma�l�sung umgesetzt wird. Die berechnete Molmasse wird"
				+ " beim Zur�ckkehren automatisch in dem Eingabefeld Molmasse �bernommen.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Button > Zur�ck <";
		Hilfe[intFeldNr][2] = "Button > Zur�ck <";
		Hilfe[intFeldNr][3] = "Mit diesem Button kann man zu dem vorherigen"
				+ " Bildschirm zur�ck kehren. Die berechnete Molmasse wird dabei �bernommen und in dem vorherigen Eingabefeld"
				+ " Molmasse �bertragen.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Button > Hauptgruppenelemente <";
		Hilfe[intFeldNr][2] = "Button > Hauptgruppenelemente <";
		Hilfe[intFeldNr][3] = "Mit diesem Button kann zwischen den Haupt- und Nebengruppenelementen gewechselt werden."
				+ " Die Lanthanoide und Actinoide werden nicht angezeigt!";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Element-Button (z.B. H, Li, Be, B, C, N, ...)";
		Hilfe[intFeldNr][2] = "Element-Button (z.B. H, Li, Be, B, C, N, ...)";
		Hilfe[intFeldNr][3] = "Beim Bet�tigen eines Element-Buttons wird das entsprechende Elementsymbol in der Liveanzeige,"
				+ " beziehungsweise hinter der bereits bestehenden Formel angezeigt."
				+ " Gleichzeitig wird die Atommasse des Elements zu der Molmasse des Molek�ls dazu addiert. Nebengruppenelemente"
				+ " k�nnen nach Bet�tigen des Hauptgruppenelemente-Buttons eingegeben werden. Von den Lanthanoide und Actinoide k�nnen"
				+ " keine Atommassen berechnet werden.";
		
   		/*							// habe hier versucht das "Pfeil-zur�ck-Symbol" anzeigen zu lassen. Funzt nicht! :-(
   		int resId;
   		EditText et;
   		String strBack;
   		
		resId = R.string.Back;
        et = (EditText) findViewById(resId);
    	strBack = et.getText().toString();
		*/
		
		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Button <- ";
		Hilfe[intFeldNr][2] = "Button <- ";
		Hilfe[intFeldNr][3] = "Mit diesem Button kann die zuvor eingegebene Formel und die berechnetete Molmasse wieder gel�scht werden."
				+ " Ein schrittweises r�ckg�ngiges L�schen einzelner Elemente ist nicht m�glich.";
		
		
		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Indexzahl-Button (z.B. 0, 1, 2, 3, ...)";
		Hilfe[intFeldNr][2] = "Indexzahl-Button (z.B. 0, 1, 2, 3, ...)";
		Hilfe[intFeldNr][3] = "Beim Bet�tigen eines Indexzahl-Buttons wird die entsprechende Indexzahl tiefgestellt in der Liveanzeige angezeigt."
				+ " H�here Potenzen (10er oder 100er) sind ebenfalls m�glich. Indexzahlen k�nnen ausschlie�lich hinter einem Element oder"
				+ " einer geschlossenen Klammer eingegeben werden. Ansonsten werden sie ausgeblendet. Die Null erscheint erst ab einer"
				+ " m�glichen Zehnerpotenz. Bei der Berechnung wird das jeweilige einzelne Element oder die ganze Klammer mit der Indexzahl"
				+ " multipliziert und zur Molmasse addiert. Die Index-Zahlen von 5 bis 9 befinden sich bei den Nebengruppenelementen.";

		intFeldNr++;
		Hilfe[intFeldNr][0] = strKapitel;
		Hilfe[intFeldNr][1] = "Klammer-Button > ( <";
		Hilfe[intFeldNr][2] = "Klammer-Button > ( <";
		Hilfe[intFeldNr][3] = "Beim Bet�tigen des Klammer-Buttons wird das entsprechende Symbol in der Liveanzeige angezeigt. Es"
				+ " k�nnen nicht mehrere Klammern ineinander verschachtelt werden! Das Klammer zu -Symbol erscheint erst, nachdem"
				+ " mindestens ein Element eingegeben wurde. Ein neues Klammer auf -Symbol wird erst wieder angezeigt, nachdem"
				+ " die alte Klammer geschlossen wurde. Eckige Klammern (Komplexe) k�nnen nicht eingegeben werden. Diese Formeln "
				+ " m�ssen als Summenformel eingegeben werden.";
		
		intFeldNr_max = intFeldNr;
	} // erstelle_Hilfe_Molmassen
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hilfe);

		// Activity registrieren, damit sie sp�ter an zentraler Stelle (Hauptmenue) geschlossen werden kann
	    ActivityRegistry.register(this);
		
		Bundle extras = getIntent().getExtras();
		String strKapitel;
		
		strKapitel = extras.getString("Kapitel");
		
		if (strKapitel.equals("Menue") == true) {
			erstelle_Hilfe_Menue(strKapitel);
		} else if (strKapitel.equals("Fettkennzahlen") == true) {
			erstelle_Hilfe_Fettkennzahlen(strKapitel);
		} else if (strKapitel.equals("Einwaage") == true) {
			erstelle_Hilfe_Einwaage(strKapitel);
		} else if (strKapitel.equals("Verbrauch") == true) {
			erstelle_Hilfe_Verbrauch(strKapitel);
		} else if (strKapitel.equals("Titereingaben") == true) {
			erstelle_Hilfe_Titereingaben(strKapitel);
		} else if (strKapitel.equals("Molaritaet") == true) {
			erstelle_Hilfe_Molaritaet(strKapitel);
		} else if (strKapitel.equals("Faktor") == true) {
			erstelle_Hilfe_Faktor(strKapitel);
		} else if (strKapitel.equals("Vorlage") == true) {
			erstelle_Hilfe_Vorlage(strKapitel);	
		} else if (strKapitel.equals("Molmassen") == true) {
			erstelle_Hilfe_Molmassen(strKapitel);
		} else if (strKapitel.equals("Berechnung") == true) {
			erstelle_Hilfe_Berechnung(strKapitel);
		};
		
		initList();

	    // Die ListView-Komponente kommt aus dem Layout
	    ListView lv = (ListView) findViewById(R.id.lvHilfe);

	    // Der 'SimpleAdapter' erwartet folgende Parameter:
	    //  1. Kontext-Referenz (Activity)
	    //  2. Daten, die angezeigt werden sollen (hier vom Typ 'ArrayList')
	    //  3. Layout, das f�r jede Zeile in der Liste verwendet werden soll
	    //  4. String-Array mit den Schl�sseln, nach denen die Datenliste gefiltert werden soll (hier: 'Kapitel')
	    //  5. Integer-Array mit den View-IDs, die je Zeile angezeigt werden sollen
	    //  Die Gr��e der Arrays der Parameter 4 und 5 muss identisch sein!
	    //SimpleAdapter simpleAdpt = new SimpleAdapter(this, hilfeListe, android.R.layout.simple_list_item_1, new String[] {strKapitel}, new int[] {android.R.id.text1});
	    SimpleAdapter simpleAdpt = new SimpleAdapter(this, hilfeListe, R.layout.my_listview, new String[] {strKapitel}, new int[] {R.id.tvHilfezeile});

	    lv.setAdapter(simpleAdpt);		

	    // hier wird festgelegt, was passieren soll, wenn der Anwender eine Zeile anklickt:
	    lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
	         public void onItemClick(AdapterView<?> parentAdapter, View view, int position, long id) {
	        	 
	        	 LinearLayout ll = (LinearLayout) view;
	             TextView clickedView = (TextView) ll.getChildAt(0);
	        	 
	            // es ist bekannt, dass der angeklickte View eine TextView ist; er wird daher als solcher angesprochen 
	            //TextView clickedView = (TextView) view;
             	
	         	for (int intFeldNr=0; intFeldNr<=intFeldNr_max; intFeldNr++) {
	        	    if (Hilfe[intFeldNr][1] == clickedView.getText()) {	        	    	
	        			AlertDialog.Builder builder = new AlertDialog.Builder(HilfeActivity.this);
	        			builder.setTitle(Hilfe[intFeldNr][2]);
	        			builder.setMessage(Hilfe[intFeldNr][3]);
	        			builder.setPositiveButton("OK",
	        					new DialogInterface.OnClickListener()
	        						{
	        							public void onClick(DialogInterface dialog, int id)
	        							{
	        								dialog.dismiss();
	        							}		
	        						});

	        			AlertDialog dialog = builder.create();
	        			dialog.show();

	        			break; // for-Schleife vorzeitig beenden
	        	    } // if (Hilfe[zeile][1] == clickedView.getText())
	      		} // for
	         } // onItemClick
	    }); // setOnItemClickListener	    
	} // onCreate

	private void initList() {
    	for (int zeile=0; zeile<=intFeldNr_max; zeile++) {
    	    hilfeListe.add(erstelleHilfe(Hilfe[zeile][0], Hilfe[zeile][1]));
  		}
	}

	private LinkedHashMap<String, String> erstelleHilfe(String key, String name) {
	    LinkedHashMap<String, String> hilfetext = new LinkedHashMap<String, String>();
	    hilfetext.put(key, name);
	
	    return hilfetext;
	}
	
} // HilfeActivity
