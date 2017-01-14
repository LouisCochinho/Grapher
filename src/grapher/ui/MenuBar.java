/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grapher.ui;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Antoine Gambro
 */
public class MenuBar extends JMenuBar {

    protected Menu menu;
    
    public MenuBar() {
        menu = new Menu();
        add(menu);
    }
    
}
