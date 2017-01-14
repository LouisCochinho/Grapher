/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grapher.ui;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Antoine Gambro
 */
public class TableModel extends AbstractTableModel {
    
    protected ArrayList<Object[]> donnees;
    protected String colonnes[];
    
    public TableModel() {
        colonnes = new String[]{"Fonction", "Couleur"};
        donnees = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return donnees.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return donnees.get(rowIndex)[columnIndex];
    }
    
    public void addRow(Object[] row) {
        donnees.add(row);
        
    }
    
    public void removeRow(Object row){
    	donnees.removeIf(p -> p[0].toString().equals(row.toString()));
    }
    
    public void clear() {
        donnees.clear();
    }
    
}
