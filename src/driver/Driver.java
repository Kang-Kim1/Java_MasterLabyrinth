package driver;
import javax.swing.SwingUtilities;

import gui.MasterLabyrinthGUI;
import objects.Board;

public class Driver {
	public static void main(String[] args) {
		System.out.println("ddd");
		SwingUtilities.invokeLater(new MasterLabyrinthGUI(new Board()));
	}
	
}
