package carrera;

import db.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import nivel.NivelDTO;


public class CarreraDAO implements Carrera{
    
    public CarreraDAO(){
        Conexion conexion = Conexion.getInstance();
        conexion.conectar();
    }

    @Override
    public Collection<CarreraDTO> getCarreras() {
        Connection conn = Conexion.getInstance().getConexion();
        final String consulta = "select * from carrera";
        final List<CarreraDTO> listaCarreras = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            CarreraDTO carrera;
            while (rs.next()){
                carrera = new CarreraDTO(rs.getInt("idCarrera"),
                rs.getString("Carrera"),
                rs.getInt("idNivel"));
                listaCarreras.add(carrera);
            }
        } catch (SQLException e) {
            final String mensaje = "Error en la tabla Carrera";
            e.printStackTrace();
        }
        return listaCarreras;
    }

    @Override
    public CarreraDTO getCarrera(int idCarrera) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<CarreraDTO> getCarrerasPorNivel(int idNivel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertarCarrera(CarreraDTO carrera) {
        Connection conn = Conexion.getInstance().getConexion();
        final String procedimiento = "{ call insertarCarrera(?,?)}";
        try {
            CallableStatement cs = conn.prepareCall(procedimiento);
            cs.setString("Carrera",carrera.getCarrera());
            cs.setInt("idNivel", carrera.getIdNivel());
            cs.execute();
        } catch (SQLException e) {
            final String mensaje = "Error en la tabla Carreras";
            e.printStackTrace();
        }
    }

    @Override
    public void actualizarCarrera(CarreraDTO carrera) {
        Connection conn = Conexion.getInstance().getConexion();
        final String procedimiento = "{ call editarCarrera(?,?,?)}";
        try {
            CallableStatement cs = conn.prepareCall(procedimiento);
            cs.setInt("idCarrera", carrera.getIdCarrera());
            cs.setString("Carrera",carrera.getCarrera());
            cs.setInt("idNivel", carrera.getIdNivel());
            cs.execute();
        } catch (SQLException e) {
            final String mensaje = "Error en la tabla Carrera";
            e.printStackTrace();
        }
    }

    @Override
    public void borrarCarrera(int idCarrera) {
        Connection conn = Conexion.getInstance().getConexion();
        final String procedimiento = "{ call eliminarCarrera(?)}";
        try {
            CallableStatement cs = conn.prepareCall(procedimiento);
            cs.setInt("idCarrera", idCarrera);
            cs.execute();
        } catch (SQLException e) {
            final String mensaje = "Error en la tabla Carrera";
            e.printStackTrace();
        }
    }
    
}
