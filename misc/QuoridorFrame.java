package misc;

import javax.swing.*;

public class QuoridorFrame extends JFrame {
	
	public QuoridorFrame() {
		super("Quoridor");
		setSize(350,350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		QuoridorFrame quoridor = new QuoridorFrame();
	}
}
