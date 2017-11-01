package feltspil;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Tekst {
	private static StrengArray sprog = new StrengArray(new String[] {"DA", "EN"});
	private static StrengArray tekstFelter = new StrengArray();
	private static StrengArray tekstKnapper = new StrengArray();
	private static StrengArray tekstBeskeder = new StrengArray();
	private static StrengArray[] tekstArray = new StrengArray[] {tekstKnapper, tekstFelter, tekstBeskeder};

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
		læsTekst(fil);
	}
	
	public static String getTekst(int t, int i) {
		if (t>=tekstArray.length||t<0) return "index out of bounds";
		return tekstArray[t].getFraIndeks(i);
	}
	
	private static void læsTekst(File f) {
		Scanner sc;
		int i = -1;
		try {
			sc = new Scanner(f);
			while(sc.hasNextLine()) {
				String st = sc.nextLine();
				
				if(st.contains("//")||st.equals("")) continue;
				else if (st.contains("@@")) {
					i++;
					continue;
				}
				
				tekstArray[i].tilføj(st);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
