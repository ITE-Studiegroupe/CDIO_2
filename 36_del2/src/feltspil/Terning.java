package feltspil;

/**
 * Klassen: Terning<br>
 * Denne klasse har til formål at lave et terning-kast, der som en terning 
 * en terning i virkeligheden giver en tilfældig værdi mellem 1-6
 * @author gruppe 36
 *
 */
public class Terning {

	private int terning;
	private int antalSider = 6;

	/**
	 * Giver den private int "terning" attribut en tilfældig værdi mellem 1 og 6 inklusiv.<br> 
	 * Simulerer et tærninge kast.
	 */
	private void Kast() {
		int terning;
		terning = ((int) (Math.random()*antalSider)+1);
		this.terning = terning;
	}

	/**
	 * Kalder den private metode Kast() og returnerer derefter den private int "terning" atribut.
	 * @return tilføldig værdi mellem 1 og 6 inklusiv.
	 */
	public int getVærdi() {
		Kast();
		return terning;

	}

}
