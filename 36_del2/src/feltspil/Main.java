package feltspil;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Klassen: Main.
 * @author Gruppe_36.
 */

public class Main {
	
	/**
	 * Klassen sørger for at spillet kan køres.
	 */

	public static void main(String[] args) {

		/**
		 * Vi skifter mellem spiller 1 og spiller 2. Derfor oprettes et array objekt
		 * kaldet spillere. Vi skifter mellem de respektive spileres kontier, konto 1 og
		 * konto 2. Derfor oprettes et array objekt kaldet kontoer. Scanner indlæses.
		 * Integeren nr = 0 sørger for hvis spillers tur det er.
		 */

		Spiller[] spillere = new Spiller[] { new Spiller(), new Spiller() };
		Konto[] kontoer = new Konto[] { new Konto(), new Konto() };
		Raflebæger rafle = new Raflebæger();
		Felter felter = new Felter();
		Scanner sc = new Scanner(System.in);
		int nr = 0;
		
		/**
		 * Indlæser tekstfilen DA.
		 */

		try {
			Tekst.indlæsSprog("DA");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/**
		 * Printer tekst fra tekstfil.
		 * I dette tilfælde teksten i tekstfilen, i 2 afsnit på linje 0.
		 * Opretter system exit hvis exit indtastes.
		 * Sætter spiller 1's navn (spillere[0] i arrayet).
		 */
		
		System.out.print(Tekst.getTekst(2, 0));
		String input = sc.nextLine();
		if (input.toLowerCase().equals("exit"))
			System.exit(0);
		spillere[0].setNavn(input);
		
		/**
		 * Printer tekst fra tekstfil.
		 * Sætter spiller 2's navn (spillere[1] i arrayet).
		 */

		System.out.print(Tekst.getTekst(2, 1));
		input = sc.nextLine();
		spillere[1].setNavn(input);

		/**
		 * Spillernes kontier bliver oprettet.
		 * Sætter balence for de to kontier med værdien 1000.
		 */
				
		kontoer[0].setBalance(1000);
		kontoer[1].setBalance(1000);

		/**
		 * while (true) loop oprettes.
		 * En gennemgang af looped svarer til en spillers tur.
		 * Printer tekst fra tekstfil i afsnit 2 linje 3 + spillers nr, og spillers navn.
		 */
		
		while (true) {
			System.out.println("\n" + "######################################################" + "\n");
			System.out.println(Tekst.getTekstMedInput(2, 3, spillere[nr].getNavn()));
			sc.nextLine();
			
			/**
			 * Gemmer sum af øjne på terningerne der kastes.
			 * Får øjnenes værdi fra rafle objekt.
			 * Får point fra felter objekt ved at oplyse sum af øjne.
			 */

			int sum = rafle.getSumterninger();
			int point = felter.getPoint(sum);
			System.out.println("@------------------------------------------------@\n" + Tekst.getTekst(1, sum - 2)
					+ "\n@------------------------------------------------@");
			
			/**
			 * if-statement for taber og vinder scenarie.
			 */

			if (!kontoer[nr].indsætPenge(point)) {
				System.out.println(Tekst.getTekstMedInput(2, 5, spillere[nr].getNavn()));
				break;
			} else {
				if (kontoer[nr].getBalance() >= 3000) {
					System.out.println(Tekst.getTekstMedInput(2, 6, spillere[nr].getNavn()));
					break;
				}
			}
			
			/**
			 * Printer hvad en given konto har af balance.
			 */

			System.out.println(Tekst.getTekstMedInput(2, 4, kontoer[nr].getBalance()));
			
			/**
			 * if-statement der sørger for at respektiv spiller får en ekstra tur når man får summen
			 * af øjne svarenden til 10.
			 */

			if (sum != 10) {
				if (nr < 1)
					nr++;
				else
					nr = 0;
			}

		}
		sc.close();
	}

}
