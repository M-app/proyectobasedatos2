package alumno;

import db.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import encargado.EncargadoDTO;
import nivel.NivelDTO;

public class AlumnoDAO implements Alumno {
    
    public AlumnoDAO(){
        Conexion conexion = Conexion.getInstance();
        conexion.conectar();
    }

    @Override
    public Collection<AlumnoDTO> getAlumnos() {
        Connection conn = Conexion.getInstance().getConexion();
        final String consulta = "select * from alumno";
        final List<AlumnoDTO> listaAlumnos = new ArrayList<>();
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            AlumnoDTO alumno;
            while(rs.next()){
                alumno = new AlumnoDTO(rs.getInt("idAlumno"),rs.getString("apellidos"),
                        rs.getString("nombres"), rs.getString("fechaNacimiento"),
                        rs.getString("genero"),rs.getString("telefono"),
                        rs.getString("direccion"), rs.getInt("idEncargado"),
                        rs.getString("estatus"));
                    listaAlumnos.add(alumno);
                
            }
        }
        catch(SQLException e){
            final String mensaje = "Error al intentar mostrar datos en la tabla Alumnos";
            e.printStackTrace();
        }
        return listaAlumnos;
    }

    @Override
    public AlumnoDTO getAlumno(int idAlumno) {
        Connection conn = Conexion.getInstance().getConexion();
        final String consulta = "select * from alumno";
        final List<AlumnoDTO> listaAlumno = new ArrayList<>();
    try{
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(consulta);
        AlumnoDTO alumno;
        while(rs.next()){
            alumno = new AlumnoDTO(rs.getInt("idAlumno"), rs.getString("apellidos"),
                    rs.getString("nombres"), rs.getString("fechaNacimiento"),
                    rs.getString("genero"),rs.getString("telefono"),
                    rs.getString("direccion"),rs.getInt("idEncargado"),
                    rs.getString("estatus"));
                listaAlumno.add(alumno);
                }
    }
    catch(SQLException e){
        final String mensaje = "Error al intentar mostrar datos en la Tabla";
        e.printStackTrace();
    }
        return null;
    }

    @Override
    public Collection<AlumnoDTO> getAlumnosPorEncargado(int idEncargado) {
        Connection conn = Conexion.getInstance().getConexion();
        final String consulta = String.format("select * from alumno where idEncargado = %s", idEncargado+"");
        final List<AlumnoDTO> listaAlumnos = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            AlumnoDTO alumno;
            while (rs.next()){
                alumno = new AlumnoDTO(rs.getInt("idAlumno"),
                rs.getString("Apellidos"),rs.getString("Nombres"),
                rs.getString("FechaNacimiento"),rs.getString("Genero"),
                rs.getString("Telefono"),rs.getString("Direccion"),rs.getInt("idEncargado"),rs.getString("estatus"));
                listaAlumnos.add(alumno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaAlumnos;
    }

    @Override
    public void insertarAlumno(AlumnoDTO alumno) {
       Connection conn = Conexion.getInstance().getConexion();
       final String procedimiento = "{ call insertarAlumno(?,?,?,?,?,?,?,?)}";
       try{
           CallableStatement cs = conn.prepareCall(procedimiento);
           cs.setString("Apellidos",alumno.getApellidos());
           cs.setString("Nombres", alumno.getNombres());
           cs.setString("FechaNacimiento", alumno.getFechaNacimiento());
           cs.setString("Genero", alumno.getGenero());
           cs.setString("Telefono",alumno.getTelefono());
           cs.setString("Direccion", alumno.getDireccion());
           cs.setInt("idEncargado", alumno.getIdEncargado());
           cs.setString("Estatus", alumno.getEstatus());
           cs.execute();
       }
       catch(SQLException e){
           final String mesanje = "Error al intentar insertar datos en la tabla Alumnos";
           e.printStackTrace();
       }
    }

    @Override
    public void actualizarAlumno(AlumnoDTO alumno) {
       Connection conn = Conexion.getInstance().getConexion();
       final String procedimiento = "{ call editarAlumno(?,?,?,?,?,?,?,?,?)}";
       try{
           CallableStatement cs = conn.prepareCall(procedimiento);
           cs.setInt("idAlumnno", alumno.getIdAlumno());
           cs.setString("Apellidos",alumno.getApellidos());
           cs.setString("Nombres", alumno.getNombres());
           cs.setString("FechaNacimiento", alumno.getFechaNacimiento());
           cs.setString("Genero", alumno.getGenero());
           cs.setString("Telefono",alumno.getTelefono());
           cs.setString("Direccion", alumno.getDireccion());
           cs.setInt("idEncargado", alumno.getIdEncargado());
           cs.setString("Estatus", alumno.getEstatus());
           cs.execute();
       }
       catch(SQLException e){
           final String mesanje = "Error al intentar actualizar datos en la tabla Alumnos";
           e.printStackTrace();
       }
    }

    @Override
    public void borrarAlumno(int idAlumno) {
        Connection conn = Conexion.getInstance().getConexion();
        final String procedimiento = "{ call eliminarAlumno(?) }";
        try{
            CallableStatement cs = conn.prepareCall(procedimiento);
            cs.setInt("idAlumno", idAlumno);
            cs.execute();
        }
        catch(SQLException e){
            final String mensaje = "Error al intentar eliminar datos";
            e.printStackTrace();
        }
    }
    
}
