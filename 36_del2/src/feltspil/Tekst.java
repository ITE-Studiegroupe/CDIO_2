package feltspil;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Tekst {
	private static StrengArray sprog = new StrengArray(new String[] {"DA", "EN"});
	private static StrengArray tekstArray = new StrengArray();

	public static void indlæsSprog(String input) {
		// TODO Auto-generated method stub
		File fil = new File("src/sprog/EN");
		
		
		if(sprog.indeholder(input)) {
			switch(sprog.indeksAf(input)) {
			case 0:
				fil = new File("src/sprog/DA");
				break;
			case 1:
				fil = new File("src/sprog/EN");
				break;
			}
		}
		tekstArray = læsTekst(fil);
	}
	
	public static String getTekst(int i) {
		return tekstArray.getFraIndeks(i);
	}
	
	private static StrengArray læsTekst(File f) {
		Scanner sc;
		StrengArray result = new StrengArray();
		try {
			sc = new Scanner(f);
			while(sc.hasNextLine()) {
				result.tilføj(sc.nextLine());
			}
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
}
