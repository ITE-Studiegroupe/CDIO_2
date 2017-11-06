package feltspil;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Spiller[] spillere = new Spiller[] {new Spiller(), new Spiller()};
		Konto[] kontoer = new Konto[] {new Konto(), new Konto()};
		Raflebæger rafle = new Raflebæger();
		Felter felter = new Felter();
		Scanner sc = new Scanner(System.in);
		int nr = 0;
		final int MAX = 3000;
		
		try {
			Tekst.indlæsSprog("DA");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.print(Tekst.getTekst(2, 0));
		String input = sc.nextLine();
		if(input.toLowerCase().equals("exit")) System.exit(0);
		spillere[0].setNavn(input);
		
		System.out.print(Tekst.getTekst(2, 1));
		input = sc.nextLine();
		spillere[1].setNavn(input);
		
		kontoer[0].setBalance(1000);
		kontoer[1].setBalance(1000);
		
		while(true) {
			System.out.println("\n"
					+ "######################################################"
					+ "\n");
			System.out.println(Tekst.getTekstMedInput(2, 3, spillere[nr].getNavn()));
			sc.nextLine();
			
			int sum = rafle.getSumterninger();
			int point = felter.getPoint(sum);
			System.out.println("@------------------------------------------------@\n"
					+ Tekst.getTekst(1, sum-2)
					+ "\n@------------------------------------------------@");
			
			if(!kontoer[nr].indsætPenge(point)) {
				System.out.println(Tekst.getTekstMedInput(2, 5, spillere[nr].getNavn()));
				break;
			}
			else {
				if(kontoer[nr].getBalance() >= 3000) {
					System.out.println(Tekst.getTekstMedInput(2, 6, spillere[nr].getNavn()));
					break;
				}
			}
			
			System.out.println(Tekst.getTekstMedInput(2, 4, kontoer[nr].getBalance()));
			
			if(sum != 10) {
				if (nr < 1) nr++;
				else nr = 0;
			}
			
		}
		
	}
}
