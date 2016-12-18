/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC;

import POJO.UnidadDeMedidaPOJO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cristo
 */
public class UnidadDeMedidaJDBC {
    
    private static final String TABLE = "UnidadDeMedida";

    private static final String SQL_INSERT = "insert into " + TABLE + " (nombre_unidadDeMedida, descripcion_unidadDeMedida)" + " values (?,?)";

    private static final String SQL_QUERY = "Select * from " + TABLE;

    private static final String SQL_DELETE = "Delete from " + TABLE + " Where idUnidadDeMedida=?";

    private static final String SQL_UPDATE = "Update " + TABLE + " set nombre_unidadDeMedida=?, descripcion_unidadDeMedida=?, where idUnidadDeMedida=?";

    public static boolean insertar(UnidadDeMedidaPOJO pojo) {
        Connection con = null;
        PreparedStatement ps = null;
        int x;

        try {
            con = Conexion.getConnection(); //Obtengo la conexion a la BD
            ps = con.prepareStatement(SQL_INSERT); //Preparo el Insert

            //Empiezo a llenar el preparado desde 1
            ps.setString(1, pojo.getNombre_unidadDeMedida());
            ps.setString(2, pojo.getDescripcion_unidadDeMedida());

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
    
    public static boolean actualizar(UnidadDeMedidaPOJO pojo) {
        Connection con = null;
        PreparedStatement ps = null;
        int x;

        try {
            con = Conexion.getConnection(); //Obtengo la conexion a la BD
            ps = con.prepareStatement(SQL_UPDATE); //Preparo el Insert
            ps.setString(1, pojo.getNombre_unidadDeMedida());
            ps.setString(2, pojo.getDescripcion_unidadDeMedida());
            ps.setInt(3, pojo.getIdUnidadDeMedida());
            

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
                ob[0] = rs.getObject("idUnidadDeMedida");
                ob[1] = rs.getObject("nombre_unidadDeMedida");
                ob[2] = rs.getObject("descripcion_unidadDeMedida");
                

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
    
    
    public static DefaultComboBoxModel cargarCombo() {
        Connection con = null;
        PreparedStatement ps = null;
        DefaultComboBoxModel modelo = null;
        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(SQL_QUERY);
            modelo = new DefaultComboBoxModel();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UnidadDeMedidaPOJO pojo = new UnidadDeMedidaPOJO();
                pojo.setIdUnidadDeMedida(rs.getInt("idUnidadDeMedida"));
                pojo.setNombre_unidadDeMedida(rs.getString("nombre_UnidadDeMedida"));
                pojo.setDescripcion_unidadDeMedida(rs.getString("Descripcion_unidadDeMedida"));
               
                modelo.addElement(pojo);
            }
        } catch (Exception e) {
            System.out.println("Error al cargar combo " + e);

        } finally {
            Conexion.close(con);
            Conexion.close(ps);
        }
        return modelo;

    }
    
}
