package encargado;

import db.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.JOptionPane;

public class EncargadoDAO implements Encargado{
    
    public EncargadoDAO(){
    Conexion conexion = Conexion.getInstance();
    conexion.conectar();
    }

    @Override
    public Collection<EncargadoDTO> getEncargados() {
        Connection conn = Conexion.getInstance().getConexion();
        final String consulta = "select * from encargado";
        final List<EncargadoDTO> listaEncargado = new ArrayList<>();
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            EncargadoDTO encargado;
            while(rs.next()){
                encargado = new EncargadoDTO(rs.getInt("idEncargado"),rs.getString("apellidos"),
                rs.getString("nombres"),rs.getString("direccion"),
                rs.getString("telefono"),rs.getString("parentesco"));
                listaEncargado.add(encargado);
            }
        }
        catch(SQLException e){
            final String mensaje = "Error al intenter mostrar datos en la tabla Encargados";
            e.printStackTrace();
        }
        return listaEncargado;
    }

    @Override
    public EncargadoDTO getEncargado(int idEncrgado) {
            Connection conn = Conexion.getInstance().getConexion();
            final String consulta = "select * from encargados";
            final List<EncargadoDTO> listEnc = new ArrayList<>();
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            EncargadoDTO encargado;
            while(rs.next()){
                encargado = new EncargadoDTO(rs.getInt("idEncagado"),rs.getString("apellidos"),
                        rs.getString("nombres"),rs.getString("direccion"), 
                        rs.getString("telefono"),rs.getString("parentesco")); 
                listEnc.add(encargado);
            }
        }
        catch(SQLException e){
        final String mensaje =  "Error al intentar buscar encargado en la base de datos ";
        e.printStackTrace();
        }
        return null;
    }

    @Override
    public void actualizarEncargado(EncargadoDTO encargado) {
        Connection conn = Conexion.getInstance().getConexion();
        final String procedimiento = "{ call editarEncargado(?,?,?,?,?,?)}";
        try{
            CallableStatement cs = conn.prepareCall(procedimiento);
            cs.setInt("idEncargado", encargado.getIdEncargado());
            cs.setString("Apellidos", encargado.getApellidos());
            cs.setString("Nombres", encargado.getNombres());
            cs.setString("Direccion", encargado.getDireccion());
            cs.setString("Telefono", encargado.getTelefono());
            cs.setString("Parentesco", encargado.getParentesco());
            cs.execute();
        }
        catch(SQLException e){
            final String mensaje = "Error al intentar actualizar encargado";
            e.printStackTrace();
        }
    }

    @Override
    public void borrarEncargado(int idEncargado) {
        Connection conn = Conexion.getInstance().getConexion();
        final String procedimiento = "{call eliminarEncargado(?)}";
    try{
           CallableStatement cs = conn.prepareCall(procedimiento);
           cs.setInt("idEncargado", idEncargado);
           cs.execute();
        }
        catch(SQLException e){
            final String mensaje = "Error al intentar eliminar encargado";
            e.printStackTrace();
        }    
    }

    @Override
    public void insertarEncargado(EncargadoDTO encargado) {
       Connection conn = Conexion.getInstance().getConexion();
        final String procedimiento = "{ call insertarEncargado(?,?,?,?,?,?)}";
        try{
            CallableStatement cs = conn.prepareCall(procedimiento);
            cs.setInt("idEncargado", encargado.getIdEncargado());
            cs.setString("Apellidos", encargado.getApellidos());
            cs.setString("Nombres", encargado.getNombres());
            cs.setString("Direccion", encargado.getDireccion());
            cs.setString("Telefono", encargado.getTelefono());
            cs.setString("Parentesco", encargado.getParentesco());
            cs.execute();
        }
        catch(SQLException e){
            final String mensaje = "Error al intentar insertar encargado";
            e.printStackTrace();
        }
    }
    
}
