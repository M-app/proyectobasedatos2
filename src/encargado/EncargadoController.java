package encargado;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class EncargadoController {
    private EncargadoDAO encargadoDAO;
    private DefaultTableModel mt = new DefaultTableModel(null, getColumnas());
    
    
    public EncargadoController(){
        encargadoDAO = new EncargadoDAO();
    }
    public String[] getColumnas(){
        return new String[]{"ID", "Apellidos", "Nombres", "Direccion", "Telefono", "Parentesco"};
    }
    public void SetFilas(){
        mt.getDataVector().removeAllElements();
        mt.fireTableDataChanged();
        ArrayList<EncargadoDTO> listEnc = new ArrayList();
        listEnc.addAll(encargadoDAO.getEncargados());
        Object[] obj = new Object[6];
        for(int i =0; i<listEnc.size(); i ++){
            obj[0]= listEnc.get(i).getIdEncargado();
            obj[1]= listEnc.get(i).getApellidos();
            obj[2]= listEnc.get(i).getNombres();
            obj[3]= listEnc.get(i).getDireccion();
            obj[4]= listEnc.get(i).getTelefono();
            obj[5]= listEnc.get(i).getParentesco();
            mt.addRow(obj);
        }
    }
    public DefaultTableModel getModeloTabla(){
        return this.mt;
    }
    public void insertarEncargado(EncargadoDTO encargado){
        encargadoDAO.insertarEncargado(encargado);
    }
    public void eliminarEncargado(int idEncargado){
        encargadoDAO.borrarEncargado(idEncargado); 
    }
    public void actualizarEncargdo(EncargadoDTO encargado){
        encargadoDAO.actualizarEncargado(encargado);
    }
}
