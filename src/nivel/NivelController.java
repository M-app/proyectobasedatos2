/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nivel;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class NivelController {
    NivelImpl nivelImpl = new NivelImpl(); // instance del DAO
    DefaultTableModel modeloTabla = new DefaultTableModel(null,getColumnas());
    
    private String[] getColumnas(){
        return new String[]{"Id Nivel","Nivel"};
    }
    
    public DefaultTableModel getModeloTabla(){
        return this.modeloTabla;
    }
    
    public void setFilas(){
        modeloTabla.getDataVector().removeAllElements();
        modeloTabla.fireTableDataChanged();
        ArrayList<NivelDTO> listaNiveles = new ArrayList();
        listaNiveles.addAll(nivelImpl.getNiveles());
        Object[] obj = new Object[2];
        for(int i = 0; i<listaNiveles.size(); i++){
            obj[0] = listaNiveles.get(i).getIdNivel();
            obj[1] = listaNiveles.get(i).getNivel();
            modeloTabla.addRow(obj);
        }
    }
    
    public void actualizarNivel(NivelDTO nivel){
        nivelImpl.actualizarNivel(nivel);
    }
    
    public void insertarNivel(NivelDTO nivel){
        nivelImpl.insertarNivel(nivel);
    }
    
    public void borrarNivel(int idNivel){
        nivelImpl.borrarNivel(idNivel);
    }
}
