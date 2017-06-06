package nivel;

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
import java.util.logging.Level;
import java.util.logging.Logger;

public class NivelImpl implements Nivel{
    
    public NivelImpl(){
        Conexion conexion = Conexion.getInstance();
        conexion.conectar();
    }

    @Override
    public Collection<NivelDTO> getNiveles() {
        Connection conn = Conexion.getInstance().getConexion();
        final String consulta = "select * from nivel";
        final List<NivelDTO> listaNiveles = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            NivelDTO nivel;
            while (rs.next()){
                nivel = new NivelDTO(rs.getInt("idNivel"),
                rs.getString("Nivel"));
                listaNiveles.add(nivel);
            }
        } catch (SQLException e) {
            final String mensaje = "Error en la tabla Niveles";
            e.printStackTrace();
        }
        return listaNiveles;
    }

    @Override
    public void insertarNivel(NivelDTO nivel) {
        Connection conn = Conexion.getInstance().getConexion();
        final String procedimiento = "{ call insertarNivel(?)}";
        try {
            CallableStatement cs = conn.prepareCall(procedimiento);
            cs.setString("Nivel",nivel.getNivel());
            cs.execute();
        } catch (SQLException e) {
            final String mensaje = "Error en la tabla Niveles";
            e.printStackTrace();
        }
    }

    @Override
    public void actualizarNivel(NivelDTO nivel) {
        Connection conn = Conexion.getInstance().getConexion();
        final String procedimiento = "{ call editarNivel(?,?)}";
        try {
            CallableStatement cs = conn.prepareCall(procedimiento);
            cs.setInt("idNivel", nivel.getIdNivel());
            cs.setString("Nivel",nivel.getNivel());
            cs.execute();
        } catch (SQLException e) {
            final String mensaje = "Error en la tabla Niveles";
            e.printStackTrace();
        }
    }

    @Override
    public void borrarNivel(int idNivel) {
        Connection conn = Conexion.getInstance().getConexion();
        final String procedimiento = "{ call eliminarNivel(?)}";
        try {
            CallableStatement cs = conn.prepareCall(procedimiento);
            cs.setInt("idNivel", idNivel);
            cs.execute();
        } catch (SQLException e) {
            final String mensaje = "Error en la tabla Niveles";
            e.printStackTrace();
        }
    }

    @Override
    public NivelDTO getNivel(int idNivel) {
        Connection conn = Conexion.getInstance().getConexion();
        final String consulta = "select * from nivel";
        final List<NivelDTO> listaNiveles = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            NivelDTO nivel;
            while (rs.next()){
                nivel = new NivelDTO(rs.getInt("idNivel"),
                rs.getString("Nivel"));
                listaNiveles.add(nivel);
            }
        } catch (SQLException e) {
            final String mensaje = "Error en la tabla Niveles";
            e.printStackTrace();
        }
        return null;
    }
    
}
