package feltspil;

/**
 * 
 * Kallsen Spiller
 * @author gruppe 36
 * 
 */
public class Spiller {
	
	/** Denne klasse har til formål at give muligheden for at spillerne får et navn
	 * og et nr, så man kan holde styr på hvem der er spiller 1 og spiller 2.
	 */
	
	//variabler
	private String spillernavn;
	private int spillernr;

	 //Sætter spillerens navn
	 public void setNavn(String navn_spiller) {
		 spillernavn = navn_spiller;
	}
	 //Returnerer spillerens navn
	 public String getNavn() {
		 return spillernavn;
	}
	 //Sætter spillerens nummer
	 public void setNummer(int nr_spiller) {
		 spillernr = nr_spiller;
	 }
	 //Returner spillerens nummer
	 public int getNummer() {
		 return spillernr;
	 }
}
