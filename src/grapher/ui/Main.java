package grapher.ui;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.SwingUtilities;


public class Main extends JFrame {

	protected Pane pane;

	Main(String title, String[] expressions) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		pane = new Pane();		
		for(String expression : expressions) {
			pane.add(expression);
		}

		JMenuBar menuBar;
		Menu menu;

		menuBar = new MenuBar();

		add(pane);
		setJMenuBar(menuBar);
		pack();
	}

	public Pane getPane() {
		return pane;
	}

	public static void main(String[] argv) {
		final String[] expressions = argv;
		SwingUtilities.invokeLater(new Runnable() {
			public void run() { 
				new Main("grapher", expressions).setVisible(true); 
			}
		});
	}
}
