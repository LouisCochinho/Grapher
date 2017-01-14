/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grapher.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Antoine Gambro
 */
public class Menu extends JMenu {

	protected JMenuItem ajouter;
	protected JMenuItem supprimer;

	public Menu() {
		this.setText("Expression");
		ajouter = new JMenuItem("Ajouter");
		supprimer = new JMenuItem("Supprimer");
		ajouter.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
                String expression = JOptionPane.showInputDialog("Nouvelle expression :");
                if(expression != null)
                	try{
                		((Main)SwingUtilities.getWindowAncestor(getThis())).getPane().add(expression);
                	}catch(RuntimeException exception){
                		JOptionPane.showMessageDialog(getThis().getParent(), "Veuillez entrer une fonction mathématique.");
                	}
                    
            }
		});
		supprimer.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
                Object selected = ((Main)SwingUtilities.getWindowAncestor(getThis())).getPane().getLeftPane().getSelected();
                if(selected != null)
                    ((Main)SwingUtilities.getWindowAncestor(getThis())).getPane().remove(selected);
            }
		});
		add(ajouter);
		add(supprimer);
	}

	private JMenu getThis() {
		return this;
	}
}
