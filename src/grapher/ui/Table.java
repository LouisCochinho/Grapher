/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grapher.ui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableColumnModelListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Antoine Gambro
 */
public class Table extends JTable {
	public Table() {

		this.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				Object selectedFunction = null;
				Color functionColor = Color.WHITE;
				try{
					selectedFunction = getThis().getModel().getValueAt(getThis().getSelectedRow(), 0);  
					functionColor = ((MyColor)getThis().getModel().getValueAt(getThis().getSelectedRow(), 1)).getColor();  
				}catch(IndexOutOfBoundsException exception){
				}finally{
					((LeftPane)getThis().getParent()).setSelected(selectedFunction,functionColor);                		
				}        	

			}            
		});
		setModel(new TableModel()); 

	}


	private void setCellBackgroundColor(Object value, int row, int col){
		TableCellRenderer renderer = this.getCellRenderer(row, col);		
		Component component = renderer.getTableCellRendererComponent(
				this, value, false, false, row, col);	
		component.setBackground(((MyColor)value).getColor());
	}
	public void addRow(Object[] row) {
		TableModel tm = (TableModel)getModel();
		tm.addRow(row);    
		// NE FONCTIONNE PAS 
		//setCellBackgroundColor(row[1],tm.getRowCount(),1);
	}

	public void clear() {
		((TableModel)getModel()).clear();
	}

	public Table getThis() {
		return this;
	}

	public TableModel getTableModel(){
		return (TableModel)getModel();   	 	
	}
}
