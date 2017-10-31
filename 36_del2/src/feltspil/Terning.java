package feltspil;

public class Terning {
	
	/*Denne klasse har til formål at lave et terning-kast, der som en terning 
	en terning i virkeligheden giver en tilfældig værdi mellem 1-6*/
	private int terning;

	private void Kast() {
		int terning;
		terning = ((int) (Math.random()*6)+1);
		this.terning = terning;
	 }
	 //get kast
	 public int getKast() {
		 Kast();
		 return terning;

	}

}
