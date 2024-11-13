/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package form;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Predmet;

/**
 *
 * @author Omnix
 */
public class ModelTabelePredmeta extends AbstractTableModel {
    List<Predmet> listaPredmeta;
    String[] columns = {"id", "naziv", "kod", "espb"};
    
   ModelTabelePredmeta(List<Predmet> listaPredmeta){
       this.listaPredmeta = listaPredmeta;
   }

    public List<Predmet> getListaPredmeta() {
        return listaPredmeta;
    }

    public void setListaPredmeta(List<Predmet> listaPredmeta) {
        this.listaPredmeta = listaPredmeta;
    }

   
   
    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
    
    @Override
    public int getRowCount() {
        return listaPredmeta.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Predmet p = listaPredmeta.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return p.getId();
            case 1:
                return p.getNaziv();
            case 2:
                return p.getKod();
            case 3:
                return p.getEspb();
            default:
                return "N/A";
        }
    }
    
}
