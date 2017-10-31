package feltspil;

public class Raflebæger {
	private Terning terning = new Terning();
//get sumTerninger
public int getSumterninger() {
	int t1 = terning.getKast();
	int t2 = terning.getKast();
	return t1+t2;

  }
}