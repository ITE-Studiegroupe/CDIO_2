package feltspil;

/**
 * Klassen: Raflebæger
 * @author gruppe: 36
 *
 */
public class Raflebæger {
	private Terning terning = new Terning();

	/**
	 * Henter en tilfældig værdi to gange med metoden .getVærdi() igennem Terning instancen "terning", 
	 * gemmer dem i to int "t1" og "t2" og returnerer summen.
	 * @return Summen af to terninger i efter et 'kast'.
	 */
	public int getSumterninger() {
		int t1 = terning.getVærdi();
		int t2 = terning.getVærdi();
	return t1+t2;

  }
}