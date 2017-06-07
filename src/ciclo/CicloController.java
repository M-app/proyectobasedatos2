/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ciclo;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class CicloController {
    
    private final CicloDAO cicloDAO;
    private final DefaultTableModel modeloTabla = new DefaultTableModel(null,getColumns());
    
    public CicloController(){
        cicloDAO = new CicloDAO();
    }
    
    private String[] getColumns(){
        return new String[]{"Id Ciclo","Año","Estatus"};
    }
    
    public DefaultTableModel getModelTabla(){
        return this.modeloTabla;
    }
    
    public void setFilas(){
        modeloTabla.getDataVector().removeAllElements();
        modeloTabla.fireTableDataChanged();
        ArrayList<CicloDTO> listaCiclos = new ArrayList();
        listaCiclos.addAll(cicloDAO.getCiclos());
        Object[] obj = new Object[3];
        for(int i = 0; i<listaCiclos.size(); i++){
            obj[0] = listaCiclos.get(i).getIdCiclo();
            obj[1] = listaCiclos.get(i).getAnio();
            obj[2] = listaCiclos.get(i).getStatus();
            modeloTabla.addRow(obj);
        }
    }
    
    public void insertarCiclo(CicloDTO ciclo){
        cicloDAO.insertarCiclo(ciclo);
    }
    
    public void actualizarCiclo(CicloDTO ciclo){
        cicloDAO.actualizarCiclo(ciclo);
    }
    
    public void eliminarCiclo(int idCiclo){
        cicloDAO.borrarCiclo(idCiclo);
    }
    
}
