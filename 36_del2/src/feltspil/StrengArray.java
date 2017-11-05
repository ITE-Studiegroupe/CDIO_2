package feltspil;
import java.util.Arrays;

public class StrengArray {
	
	private String[] array;	
	
	public StrengArray() {
		array = new String[0];
	}
	
	public StrengArray(String[] a) {
		array = Arrays.copyOf(a, a.length);
	}
	
	public String getFraIndeks(int i) {
		if (i > array.length-1||i<0) throw new ArrayIndexOutOfBoundsException(
				"indeks \""+i+"\" er uden for grænserne 0 til "+(array.length-1));;
		return array[i];
	}
	
	public StrengArray tilføj(String udvidelse) {
		String[] nyArray = Arrays.copyOf(array, array.length+1);
		nyArray[array.length] = udvidelse;
		array = nyArray;
		return this;
	}
	
	public boolean indeholder(String element) {
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals(element)) return true;
		}
		return false;
	}
	
	public int indeksAf(String element) {
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals(element)) return i;
		}
		return 0;
	}

}
