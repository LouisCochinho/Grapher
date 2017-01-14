/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grapher.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Vector;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

/**
 *
 * @author Antoine Gambro
 */
public class LeftPane extends JPanel {

	protected Table table;
	protected ToolBar toolbar;
	protected Object selected;

	public LeftPane() {
		toolbar = new ToolBar();
		table = new Table();
		setLayout(new BorderLayout());
		this.add(table, BorderLayout.NORTH);
		this.add(toolbar, BorderLayout.SOUTH);
	}


	public void addListData(String expression){
		table.addRow(new Object[]{expression, MyColor.chooseRandomColor()});
		table.getTableModel().fireTableDataChanged();
	}

	public void removeListData(Object o){
		table.getTableModel().removeRow(o);
		table.getTableModel().fireTableDataChanged();
	}

	public void setSelected(Object o, Color selectedColor) {
		if(o != null){
			selected = o;
			((Pane)this.getParent()).getGrapher().setSelected(o,selectedColor);
		}
		((Pane)this.getParent()).getGrapher().repaint();
	}

	public Object getSelected() {
		return selected;
	}
}
