/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.admincampos.ui;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import poo.admincampos.Lote;

/**
 *
 * @author facundo
 */
public class TablaLotesModel extends AbstractTableModel {
        private static final String[] COLUMNAS = { "Nro.", "Superficie", "Tipo de Suelo" };
    
    private List<Lote> lotes;

    public TablaLotesModel (List<Lote> lotes) {
        super();
        this.lotes = lotes;
    }

    @Override
    public int getRowCount() {
        return lotes.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        Object retorno = null;
        Lote lote = lotes.get(fila);
        
        // según la columna deseada obtenemos el valor a mostrar
        switch (columna) {
            case 0:
                retorno = lote.getNumeroLote();
                break;
            case 1:
                retorno = lote.getSuperficie();
                break;
            case 2:
                retorno = lote.getTipoSuelo().getNombre();
                break;
        }
        
        return retorno;
    }
    
    @Override
    public String getColumnName(int index) {
        return COLUMNAS[index];
    }
    
    public Lote obtenerLoteEn (int fila) {
        return lotes.get(fila);
    }

    public void setLotes(List<Lote> lotes) {
        this.lotes = lotes;
    }
}
