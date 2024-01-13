/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Nastavnik;
import model.Zvanje;

/**
 *
 * @author necam
 */
public class ModelTabeleNastavnik extends AbstractTableModel {
    private List<Nastavnik> lista = new ArrayList<>();
    private String[] kolone = {"ime", "prezime", "zvanje"};

    public ModelTabeleNastavnik() {
    }
    

    public ModelTabeleNastavnik(List<Nastavnik> lista) {
        this.lista = lista;
    }
    
    
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Nastavnik n = lista.get(rowIndex);
        switch (columnIndex) {
                case 0:
                    return n.getIme();
                case 1:
                    return n.getPrezime();
                case 2:
                    if(n.getZvanje() == null) return null;
                    return n.getZvanje().getNaziv();
                default:
                    return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public List<Nastavnik> getLista() {
        return lista;
    }

    public void setLista(List<Nastavnik> lista) {
        this.lista = lista;
    }

    void obrisiNastavnika(int selektovaniRed) {
        lista.remove(selektovaniRed);
        fireTableDataChanged();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        Nastavnik n = lista.get(rowIndex);
        if(n.getZvanje() != null && n.getZvanje().getNaziv().equals("redovni profesor") && (columnIndex == 0  || columnIndex == 1)) {
            return true;
        } else if(n.getZvanje() == null) {   //DODAT USLOV
            return true;
        }
        return false;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Nastavnik n = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                n.setIme((String) aValue);
                break;
            case 1:
                n.setPrezime((String) aValue);
                break;
                //ovo iznad sam koristio za prvu formu IZMENI, sva tri case-a koristim za drugu formu i opciju DODAJ RED
            case 2:
                n.setZvanje((Zvanje) aValue);
                break;
        }
    }

    void dodajNastavnika(Nastavnik n) {
        lista.add(n);
        fireTableDataChanged();
    }
    
    
    
    
    
    
    
}
