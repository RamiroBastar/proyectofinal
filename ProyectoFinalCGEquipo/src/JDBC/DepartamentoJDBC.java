/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC;

import POJO.DepartamentoPOJO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aealc
 */
public class DepartamentoJDBC {

    private static final String TABLE = "departamento";

    private static final String SQL_INSERT = "insert into " + TABLE + " (nombre_departamento, descripcion_departamento)" + " values (?,?)";

    private static final String SQL_QUERY = "Select * from " + TABLE;

    private static final String SQL_DELETE = "Delete from " + TABLE + " Where idDepartamento=?";

    private static final String SQL_UPDATE = "Update " + TABLE + " set nombre_departamento=?, descripcion_departamento=?, where idDepartamento=?";

    public static boolean insertar(DepartamentoPOJO pojo) {
        Connection con = null;
        PreparedStatement ps = null;
        int x;

        try {
            con = Conexion.getConnection(); //Obtengo la conexion a la BD
            ps = con.prepareStatement(SQL_INSERT); //Preparo el Insert

            //Empiezo a llenar el preparado desde 1
            ps.setString(1, pojo.getNombre_departamento());
            ps.setString(2, pojo.getDescripcion_departamento());

            x = ps.executeUpdate(); //Aqui se ejecuta la insercion 
            if (x == 0) {
                return false;
            } else {
                return true;
            }

        } catch (Exception e) {
            System.out.println("Error al insertar " + e);
            return false;

        } finally {
            Conexion.close(con);  //Cierro la conexion con la red
            Conexion.close(ps);  //Cierro el prepareStatement

        }
    }

    public static boolean eliminar(String id) {
        Connection con = null;
        PreparedStatement ps = null;
        int x;
        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(SQL_DELETE);
            ps.setString(1, id);
            x = ps.executeUpdate();
            if (x == 0) {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar " + e);
            return false;

        } finally {
            Conexion.close(con);
            Conexion.close(ps);
        }
        return true;

    }
    
    public static boolean actualizar(DepartamentoPOJO pojo) {
        Connection con = null;
        PreparedStatement ps = null;
        int x;

        try {
            con = Conexion.getConnection(); //Obtengo la conexion a la BD
            ps = con.prepareStatement(SQL_UPDATE); //Preparo el Insert
            ps.setString(1, pojo.getNombre_departamento());
            ps.setString(2, pojo.getDescripcion_departamento());
            ps.setInt(3, pojo.getIdDepartamento());
            

            x = ps.executeUpdate(); //Aqui se ejecuta la insercion 
            if (x == 0) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error al Actualizar " + e);
            return false;

        } finally {
            Conexion.close(con);
            Conexion.close(ps);
        }
    }
    
    public static DefaultTableModel cargarTabla() {
        Connection con = null;
        PreparedStatement ps = null;
        DefaultTableModel modelo = null;

        //Como me gustaria que salieran
        String encabezados[] = {"ID", "Nombre", "Descripcion"};

        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(SQL_QUERY);
            modelo = new DefaultTableModel();
            modelo.setColumnIdentifiers(encabezados); //Aqui asigno los encabezados
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Object ob[] = new Object[3]; //Numero de Campos

                //A partir de aqui son identicos
                ob[0] = rs.getObject("idDepartamento");
                ob[1] = rs.getObject("nombre_departamento");
                ob[2] = rs.getObject("descripcion_departamento");
                

                modelo.addRow(ob);
            }
            Conexion.close(rs);

        } catch (Exception e) {
            System.out.println("Error al consultar " + e);

        } finally {
            Conexion.close(con);
            Conexion.close(ps);
        }
        return modelo;
    }
}
