package feltspil;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner s; 
		Spiller spiller1 = new Spiller();
		Spiller spiller2 = new Spiller();
		Raflebæger raflebæger = new Raflebæger();
		Felter felt = new Felter();
		
		s = new Scanner(System.in);
		String input;
		
		
		System.out.print("Indtast spiller 1's navn eller \"exit\" for at lukke: ");
		
		input = s.nextLine();
		//Checker om "exit" er blevet indtastet, hvis sandt, lukkes programmet.
		if(input.toLowerCase().contentEquals("exit")) {
			s.close();
			System.exit(0);
			//break;
		}
		else { spiller1.setNavn(input);
				spiller1.setNummer(1);
				
				}
		
		
		System.out.print("Indtast spiller 2's navn: ");
		Konto konto1 = new Konto();
		konto1.setBalance(1000);
		input = s.nextLine();
		spiller2.setNavn(input);
		spiller2.setNummer(2);
		Konto konto2 = new Konto();
		konto2.setBalance(1000);
		
		while (true) {
			s = new Scanner(System.in);
			String input2;
			
			System.out.print("Det er " + spiller1.getNavn()+ " skriv kast");
			
			input2 = s.nextLine();
			//Checker om "exit" er blevet indtastet, hvis sandt, lukkes programmet.
			if(input2.toLowerCase().contentEquals("kast")) {
				s.close();
				int point = raflebæger.getSumterninger();
				int penge = felt.getPoint(point);
				konto1.indsætPenge(penge);
				System.out.println("Du slog " + point);
				System.out.println("Du har dermed " + konto1.getBalance() + " på kontoen");
	
		}
			s = new Scanner(System.in);
			String input3;
			
			System.out.print("Det er " + spiller2.getNavn()+ " skriv kast");
			
			input3 = s.nextLine();
			//Checker om "exit" er blevet indtastet, hvis sandt, lukkes programmet.
			if(input3.toLowerCase().contentEquals("kast")) {
				s.close();
				int point = raflebæger.getSumterninger();
				int penge = felt.getPoint(point);
				konto2.indsætPenge(penge);
				System.out.println("Du slog " + point);
				System.out.println("Du har dermed " + konto2.getBalance() + " på kontoen");
		break;


		}
	}
}}


