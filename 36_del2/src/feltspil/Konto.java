package feltspil;

/**
 * Klassen: Konto
 * @author gruppe: 36
 */

public class Konto {
	private int balance;
	
	/**
	 * Denne metode returnerer ingenting (void)
	 * Den sætter metodens blance lig med din givne balance i parameter
	 */
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	/**
	 * Denne metode returnere variablen balance
	 */
	public int getBalance() {
		return balance;
	}
	
	/**
	 * Metoden kontrollerer at spillerens pengebeholdning ikke går under 0, via. true eller false
	 * Hvis koden er false, så ændres balancen ikke og false returneres
	 * Hvis koden er true, vil spilleren få opdateret sin pengebeholdning
	 * Metoden returnerer dermed resultat
	 */
	public boolean indsætPenge(int p) {
		int tjek = balance + p ;
		boolean resultat;
		if(tjek<0) {
			resultat = false;
					}
		else {
			this.balance = tjek;
			resultat = true;
		}
	return resultat;
	}
}