/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ciclo;

import db.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author user
 */
public class CicloDAO implements Ciclo{
    
    public CicloDAO(){
        Conexion conexion = Conexion.getInstance();
        conexion.conectar();
    }

    @Override
    public Collection<CicloDTO> getCiclos() {
        Connection conn = Conexion.getInstance().getConexion();
        final String consulta = "select * from ciclo";
        final List<CicloDTO> listaCiclo = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            CicloDTO ciclo;
            while (rs.next()){
                ciclo = new CicloDTO(rs.getInt("idCiclo"),rs.getInt("Anio"),rs.getString("Estatus"));
                listaCiclo.add(ciclo);
            }
        } catch (SQLException e) {
            final String mensaje = "Error en la tabla Ciclo";
            e.printStackTrace();
        }
        return listaCiclo;
    }

    @Override
    public CicloDTO getCiclo(int idCiclo) {
        return null;
    }

    @Override
    public void insertarCiclo(CicloDTO ciclo) {
        Connection conn = Conexion.getInstance().getConexion();
        final String procedimiento = "{ call insertarCiclo(?,?)}";
        try {
            CallableStatement cs = conn.prepareCall(procedimiento);
            cs.setInt("Anio", ciclo.getAnio());
            cs.setString("Estatus",ciclo.getStatus());
            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizarCiclo(CicloDTO ciclo) {
        Connection conn = Conexion.getInstance().getConexion();
        final String procedimiento = "{ call editarCiclo(?,?,?)}";
        try {
            CallableStatement cs = conn.prepareCall(procedimiento);
            cs.setInt("idCiclo", ciclo.getIdCiclo());
            cs.setInt("Anio", ciclo.getAnio());
            cs.setString("Estatus",ciclo.getStatus());
            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void borrarCiclo(int idCiclo) {
        Connection conn = Conexion.getInstance().getConexion();
        final String procedimiento = "{ call eliminarCiclo(?)}";
        try {
            CallableStatement cs = conn.prepareCall(procedimiento);
            cs.setInt("idCiclo", idCiclo);
            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
