package alumno;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import encargado.EncargadoDTO;
import encargado.EncargadoDAO;

public class AlumnoController {
    private AlumnoDAO alumnoDAO;
    private DefaultTableModel mt = new DefaultTableModel(null, getColumnas());
    private EncargadoDAO enDAO = new EncargadoDAO();
    private DefaultComboBoxModel<EncargadoDTO> mc = new DefaultComboBoxModel<>(getEncargados());
    
    public AlumnoController(){
        alumnoDAO = new AlumnoDAO();
    }
    
    public EncargadoDTO[] getEncargados(){
        ArrayList<EncargadoDTO> listEncar = new ArrayList();
        listEncar.addAll(enDAO.getEncargados());
        EncargadoDTO[] arrayEncargados = new EncargadoDTO[listEncar.size()];
        for(int i =0; i<listEncar.size(); i++){
            arrayEncargados[i] = listEncar.get(i);
        }
        return arrayEncargados;
    }
    
    public String[] getColumnas(){
        return new String[]{"ID", "Apellidos", "Nombres","Fecha Nacimiento","Género", "Telefono", "Direccion", "id Encargado","Estatus"};
    }
    public void setFilas(){
        mt.getDataVector().removeAllElements();
        mt.fireTableDataChanged();
        ArrayList<AlumnoDTO> listaAlumnos = new ArrayList();
        listaAlumnos.addAll(alumnoDAO.getAlumnos());
        Object[] obj = new Object[9];
        for(int i=0; i<listaAlumnos.size();i++ ){
            obj[0] = listaAlumnos.get(i).getIdAlumno();
            obj[1] = listaAlumnos.get(i).getApellidos();
            obj[2] = listaAlumnos.get(i).getNombres();
            obj[3] = listaAlumnos.get(i).getFechaNacimiento();
            obj[4] = listaAlumnos.get(i).getGenero();
            obj[5] = listaAlumnos.get(i).getTelefono();
            obj[6] = listaAlumnos.get(i).getDireccion();
            obj[7] = listaAlumnos.get(i).getIdEncargado();
            obj[8] = listaAlumnos.get(i).getEstatus();
            mt.addRow(obj);
        }
        
    }
    
    public DefaultTableModel getModeloTabla(){
        return this.mt;
    }
    public DefaultComboBoxModel getModeloCombo(){
        return this.mc;
    }
    public void insertarAlumno(AlumnoDTO alumno){
        alumnoDAO.insertarAlumno(alumno);
    }
    public void eliminarAlumno(int idAlumno){
        alumnoDAO.borrarAlumno(idAlumno);
    }
    public void actualizarAlumno(AlumnoDTO alumno){
        alumnoDAO.actualizarAlumno(alumno);
    }
    
}
