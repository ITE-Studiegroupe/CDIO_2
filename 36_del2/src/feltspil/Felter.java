package feltspil;


/**
 * 
 * Klassen: Felter
 * @author gruppe: 36
 * 
 */
public class Felter {

	/**
	 *nr henviser til case, den case der matcher med spillerens terningekast værdi, vil blive udført
	 *klassen Felter, retunerer point, disse point skal korrigeres med spillerens pengebeholdning
	 */
	public int getPoint(int nr) {
	 	int point;	
	 	switch(nr) {
	 	case 2: point=250;
	 	break;
	 	case 3: point=-100; 
	 	break;
	 	case 4: point=+100; 
	 	break;
	 	case 5: point=-20; 
	 	break;
	 	case 6: point=180;
	 	break;
	 	case 7: point=0; 
	 	break;
	 	case 8: point=-70; 
	 	break;
	 	case 9: point=60; 
	 	break;
	 	case 10: point=-80; 
	 	break;
	 	case 11: point=-50; 
	 	break;
	 	case 12: point=650; 
	 	break;
	 	default: point=0;
	 	}
		 
	 	return point;
	
	 	}

}
