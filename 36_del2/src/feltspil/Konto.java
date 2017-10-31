package feltspil;

public class Konto {
	private int balance;
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public boolean indsætPenge(int p) {
		int tjek = balance - p ;
		boolean resultat;
		if(tjek<0) {
			resultat = false;
					}
		else {
			resultat = true;
		}
	return resultat;
	}
	

}
