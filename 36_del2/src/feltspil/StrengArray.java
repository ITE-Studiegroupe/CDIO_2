package feltspil;
import java.util.Arrays;

/**
 * Klassen: StrengArray<br>
 * Klassen har til formål at holde på en String Array og kunne håndtere fleksibilitet ved at kunne 
 * tilføje en String til for at udvide det via metoden {@link #tilføj(String) tilføj}. Den kan 
 * også returnere en String via indeks i array'et med metoden {@link #getFraIndeks(int) getFraIndeks}.
 * @author gruppe: 36
 */
public class StrengArray {
	
	private String[] array;	
	
	/**
	 * StrengArray konstruktør, initialiserer String Array "array" med et tomt String Array.
	 */
	
	public StrengArray() {
		array = new String[0];
	}
	
	/**
	 * StrengArray konstruktør, gemmer kopi af det givne String Array parameter.
	 * @param a String Array
	 */
	public StrengArray(String[] a) {
		array = Arrays.copyOf(a, a.length);
	}
	
	/**
	 * Henter og returnerer strengen i String Array "array" af det givne indeks int "i" parameter.
	 * @param i indeks
	 * @return Strengen i indekset
	 * @throws ArrayIndexOutOfBoundsException hvis indekset "i" er uden for grænserne.
	 */
	public String getFraIndeks(int i) throws ArrayIndexOutOfBoundsException {
		if (i > array.length-1||i<0) throw new ArrayIndexOutOfBoundsException(
				"indeks \""+i+"\" er uden for grænserne 0 til "+(array.length-1));;
		return array[i];
	}
	
	/**
	 * Laver en copy af String Array "array" med et indeks ekstra 
	 * og tilføjer String parameteren "udvidelse" til det nye indeks. dvs. for enden.
	 * @param udvidelse strengen som skal tilføjes til
	 */
	public StrengArray tilføj(String udvidelse) {
		String[] nyArray = Arrays.copyOf(array, array.length+1);
		nyArray[array.length] = udvidelse;
		array = nyArray;
		return this;
	}
	
}
