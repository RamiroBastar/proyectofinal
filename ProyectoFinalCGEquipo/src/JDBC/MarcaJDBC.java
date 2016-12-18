/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC;

import POJO.MarcaPOJO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MiguelAngel
 */
public class MarcaJDBC {
    
      private static final String TABLE = "marca";

    private static final String SQL_INSERT = "Insert into " + TABLE
            + " (nombre_marca,descripcion_marca)"
            + " values (?,?)";

    private static final String SQL_DELETE = "Delete from " + TABLE
            + " where idMarca=?";

    private static final String SQL_QUERY = "Select * from " + TABLE;
    
    private static final String SQL_UPDATE = "Update " + TABLE + " set nombre_marca=?, descripcion_marca=? where idMarca=?";

    public static boolean insertar(MarcaPOJO pojo) {
        Connection con = null;
        PreparedStatement ps = null;
        int x;
        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(SQL_INSERT);
            ps.setString(1, pojo.getNombre_marca());
            ps.setString(2, pojo.getDescripcion_marca());
            
            x = ps.executeUpdate();//Aquí se ejecuta la inserción
            if (x == 0) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error al insertar " + e);
            return false;
        } finally {
            Conexion.close(con);
            Conexion.close(ps);
        }
    }

    public static boolean eliminar(String id) {
        Connection con = null;
        PreparedStatement ps = null;
        int x;
        try {
            con = Conexion.getConnection();//Obtengo la conexion a la bd
            ps = con.prepareStatement(SQL_DELETE);//Preparo el insert
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
    
    
    public static boolean actualizar(MarcaPOJO pojo) {
        Connection con = null;
        PreparedStatement ps = null;
        int x;

        try {
            con = Conexion.getConnection(); //Obtengo la conexion a la BD
            ps = con.prepareStatement(SQL_UPDATE); //Preparo el Insert
            ps.setString(1, pojo.getNombre_marca());
            ps.setString(2, pojo.getDescripcion_marca());
            ps.setInt(3, pojo.getIdMarca());
            

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
        //Como me gustaría que salieran 
        String encabezados[] = {"ID", "Nombre", "Descripción"};
        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(SQL_QUERY);
            modelo = new DefaultTableModel();
            modelo.setColumnIdentifiers(encabezados);//Aqui asigno los encabe
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Object ob[] = new Object[3];//Número de campos
                //A partir de aquí son IDENTICOS a la BD
                ob[0] = rs.getObject("idMarca");
                ob[1] = rs.getObject("nombre_marca");
                ob[2] = rs.getObject("descripcion_marca");
              
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
    

