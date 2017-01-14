package grapher.ui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author antoine Gambro
 */
public class ToolBar extends JToolBar {

	protected JButton plus;
	protected JButton moins;

	public ToolBar() {
		plus = new JButton("+");
		moins = new JButton("-");
		this.add(plus);
		this.add(moins);

		plus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String expression = JOptionPane.showInputDialog("Nouvelle expression :");
				if(expression != null)
					try{
						((Pane)getThis().getParent().getParent()).add(expression);
					}catch(RuntimeException exception){
						JOptionPane.showMessageDialog(getThis().getParent(), "Veuillez entrer une fonction mathématique.");
					}

			}
		});
		moins.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object selected = ((LeftPane)getThis().getParent()).getSelected();
				if(selected != null)
					((Pane)getThis().getParent().getParent()).remove(selected);
			}
		});
	}

	private ToolBar getThis() {
		return this;
	}


}
