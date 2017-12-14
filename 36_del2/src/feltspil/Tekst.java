package feltspil;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Klassen: Tekst<br>
 * Klassen har til formål at indlæse det valgte sprog, hvis filen findes i pakken, i nogle String arrays
 * som man så kan hente teksten fra via metoden {@link #getTekst(int, int) getTekst} eller hente 
 * tilpasset tekst med input via metoden {@link #getTekstMedInput(int, int, Object) getTekstMedInput}.
 * @author gruppe: 36
 */
public class Tekst {
	
	private static StrengArray tekstFelter = new StrengArray();
	private static StrengArray tekstKnapper = new StrengArray();
	private static StrengArray tekstBeskeder = new StrengArray();
	private static StrengArray[] tekstArray = new StrengArray[] {tekstKnapper, tekstFelter, tekstBeskeder};
	
	/**
	 * Indlæser sprogfil i forhold til det givne String input, 
	 * hvis input'et ikke matcher nogle kompatible sprog kommer der fejl.<br>
	 * Tilgængelige sprog: DA (dansk) og EN (engelsk).
	 * @param input ISO 639-1 sprog koder
	 * @throws FileNotFoundException hvis filen/sproget ikke findes
	 */
	public static void indlæsSprog(String input) throws FileNotFoundException {
		InputStream stream = Tekst.class.getClass().getResourceAsStream("/sprog/"+input);
		
		if(stream != null) {
			læsTekst(stream);
		}
		else throw new FileNotFoundException("Det givne sprog: \""+input+"\" eller tilhørende fil findes ikke");

	}
	
	/**
	 * Returnerer den valgte tekst fra tekstArray i forhold til givne kategori nummer k og tekst indeks i.
	 * @param k tekst kategori
	 * @param i tekst indeks
	 * @return String med den valgte tekst.
	 * @throws ArrayIndexOutOfBoundsException hvis indekset "k" er uden for grænserne.
	 */
	public static String getTekst(int k, int i) throws ArrayIndexOutOfBoundsException {
		if (k>=tekstArray.length||k<0) throw new ArrayIndexOutOfBoundsException(
				"indeks \""+k+"\" er uden for grænserne 0 til "+(tekstArray.length-1));
		return tekstArray[k].getFraIndeks(i);
	}
	
	/**
	 * Returnerer den valgte tekst fra tekstArray i forhold til givne kategori nummer k og tekst indeks i
	 * med o indsat i teksten hvis den er lavet til det.
	 * @param k tekst kategori
	 * @param i tekst indeks
	 * @param o ønsket input i teksten
	 * @return String med den valgte tekst og indsat input hvis muligt.
	 */
	public static String getTekstMedInput(int k, int i, Object o) throws ArrayIndexOutOfBoundsException {
		String s = getTekst(k,i);
		
		if (s.contains("@_")){
			s = s.replace("@_", o.toString());
		}
		
		return s;
	}
	
	/**
	 * Indlæser sprogfilen ind i StrengArray array'en tekstArray i deres respektive pladser i forhold til tekst formateringen<br>
	 * I følgende rækkefølge:<br>
	 * - StrengArray tekstKnapper<br>
	 * - StrengArray tekstFelter<br>
	 * - StrengArray tekstBeskeder
	 * @param f Filen som skal læses
	 */
	private static void læsTekst(InputStream f) {
		Scanner sc;
		int i = -1;
		sc = new Scanner(f);
		while(sc.hasNextLine()) {
			String st = sc.nextLine();
			
			if(st.contains("//")||st.equals("")) continue; // linjer der starter med "//" eller tomme linjer springes over.
			else if (st.contains("@@")) { // linjer der starter med "@@" giver tegn på at der skal skiftes indeks i tekstArray[], dvs ny kategori.
				i++;
				continue;
			}
			
			tekstArray[i].tilføj(st.substring(3));
		}
		sc.close();
		
	}
	
}
