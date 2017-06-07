/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrera;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import nivel.NivelDTO;
import nivel.NivelImpl;

public class CarreraController {
    private CarreraDAO carreraDAO;
    private DefaultTableModel modeloTabla = new DefaultTableModel(null, getColumnas());
    private NivelImpl nivelImpl = new NivelImpl();
    private DefaultComboBoxModel<NivelDTO> modeloCombo = new DefaultComboBoxModel<>(getNiveles());
    
    public CarreraController(){
        carreraDAO = new CarreraDAO();
    }
    
    public NivelDTO[] getNiveles(){
        ArrayList<NivelDTO> listaNiveles = new ArrayList();
        listaNiveles.addAll(nivelImpl.getNiveles());
        NivelDTO[] arrayNiveles = new NivelDTO[listaNiveles.size()];
        for(int i = 0; i<listaNiveles.size(); i++){
            arrayNiveles[i] = listaNiveles.get(i);
        }
        return arrayNiveles;
    }
    
    private String[] getColumnas(){
        return new String[]{"Id Carrera","Carrera", "Id Nivel"};
    }
    
    public void setFilas(){
        modeloTabla.getDataVector().removeAllElements();
        modeloTabla.fireTableDataChanged();
        ArrayList<CarreraDTO> listaCarreras = new ArrayList();
        listaCarreras.addAll(carreraDAO.getCarreras());
        Object[] obj = new Object[3];
        for(int i = 0; i<listaCarreras.size(); i++){
            obj[0] = listaCarreras.get(i).getIdCarrera();
            obj[1] = listaCarreras.get(i).getCarrera();
            obj[2] = listaCarreras.get(i).getIdNivel();
            modeloTabla.addRow(obj);
        }
    }
    
    public DefaultTableModel getModeloTabla(){
        return this.modeloTabla;
    }
    
    public DefaultComboBoxModel getModeloCombo(){
        return this.modeloCombo;
    }
    
    public void insertarCarrera(CarreraDTO carrera){
        carreraDAO.insertarCarrera(carrera);
    }
    
    public void actualizarCarrera(CarreraDTO carrera){
        carreraDAO.actualizarCarrera(carrera);
    }
    
    public void eliminarCarrera(int idCarrera){
        carreraDAO.borrarCarrera(idCarrera);
    }
}
