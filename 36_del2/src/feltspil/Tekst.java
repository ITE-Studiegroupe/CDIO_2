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
	private static StrengArray sprog = new StrengArray(new String[] {"DA", "EN"});
	private static StrengArray tekstFelter = new StrengArray();
	private static StrengArray tekstKnapper = new StrengArray();
	private static StrengArray tekstBeskeder = new StrengArray();
	private static StrengArray[] tekstArray = new StrengArray[] {tekstKnapper, tekstFelter, tekstBeskeder};
	
	/**
	 * Indlæser sprogfil i forhold til det givne String input, 
	 * hvis input'et ikke matcher nogle kompatible sprog, sættes dette til dansk.<br>
	 * Tilgængelige sprog: DA (dansk) og EN (engelsk).
	 * @param input ISO 639-1 sprog koder
	 */
	public static void indlæsSprog(String input) {
		File fil;
		String sti;
		
		if(sprog.indeholder(input.toUpperCase())) {
			switch(sprog.indeksAf(input)) {
			case 0:
				sti = "src/sprog/DA";
				break;
			case 1:
				sti = "src/sprog/EN";
				break;
			default:
				sti = "src/sprog/DA";
			}
		}
		else sti = "src/sprog/DA";
		
		fil = new File(sti);
		læsTekst(fil);
	}
	
	/**
	 * Returnerer den valgte tekst fra tekstArray i forhold til givne kategori nummer k og tekst indeks i.
	 * @param k tekst kategori
	 * @param i tekst indeks
	 * @return String med den valgte tekst eller "index out of bounds" hvis denne ikke findes.
	 */
	public static String getTekst(int k, int i) {
		if (k>=tekstArray.length||k<0) return "index out of bounds";
		return tekstArray[k].getFraIndeks(i);
	}
	
	/**
	 * Indlæser sprogfilen ind i StrengArray array'en tekstArray i deres respektive pladser i forhold til tekst formateringen<br>
	 * I følgende rækkefølge:<br>
	 * - StrengArray tekstKnapper<br>
	 * - StrengArray tekstFelter<br>
	 * - StrengArray tekstBeskeder
	 * @param f Filen som skal læses
	 */
	private static void læsTekst(File f) {
		Scanner sc;
		int i = -1;
		try {
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
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
