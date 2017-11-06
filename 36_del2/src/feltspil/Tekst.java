package feltspil;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Klassen: Tekst<br>
 * @author gruppe 36
 *
 */
public class Tekst {
	private static StrengArray tekstFelter = new StrengArray();
	private static StrengArray tekstKnapper = new StrengArray();
	private static StrengArray tekstBeskeder = new StrengArray();
	private static StrengArray[] tekstArray = new StrengArray[] {tekstKnapper, tekstFelter, tekstBeskeder};
	
	/**
	 * Indlæser sprogfil i forhold til det givne String input, 
	 * hvis input'et ikke matcher nogle kompatible sprog, sættes dette til dansk.<br>
	 * Tilgængelige sprog: DA (dansk) og EN (engelsk).
	 * @param input ISO 639-1 sprog koder
	 * @throws FileNotFoundException 
	 */
	public static void indlæsSprog(String input) throws FileNotFoundException {
		String sti = "src/sprog/"+input;
		File fil = new File(sti);
		
		if (fil.exists()) {
			læsTekst(fil);
		}
		else throw new FileNotFoundException("Det givne sprog: \""+input+"\" eller tilhørende fil findes ikke");
	
	}
	
	/**
	 * Returnerer den valgte tekst fra tekstArray i forhold til givne kategori nummer k og tekst indeks i.
	 * @param k tekst kategori
	 * @param i tekst indeks
	 * @return String med den valgte tekst.
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
	 * @throws FileNotFoundException 
	 */
	private static void læsTekst(File f) throws FileNotFoundException {
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
