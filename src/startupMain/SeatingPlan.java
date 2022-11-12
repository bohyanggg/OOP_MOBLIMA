package startupMain;

/* import java.awt.*;
import java.awt.event.*;
import javax.swing.*; */

/**
 * Entity class representing a seating plan
 * @author Low Zheng Han, Lou Sim Teng, MD Firdaus Bin Azizan, Hsieh Boh Yang, Martin Chin
 *
 */
public abstract class SeatingPlan {
	private String cinema;
	protected String plan[][] = new String[10][10];
	public SeatingPlan() {
		// create the seating plan
		for (int i = 0; i <10 ; i++) {
			for (int j = 0; j < 10; j ++) {
				if (j == 2 || j == 7) {
					plan[i][j] = " ";
				}
				else {
					plan[i][j] = "0";
				}
			}
		}
	}

	public void Display() {
		for (int i = 0; i <10 ; i++) {
			for (int j = 0; j < 10; j ++) {
				System.out.print(plan[i][j]);
			}
		}
	}

}
