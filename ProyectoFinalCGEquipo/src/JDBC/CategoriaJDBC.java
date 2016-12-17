/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC;

import POJO.CategoriaPOJO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Personalizados
 */
public class CategoriaJDBC {
    

    
     private static final String TABLE = "Categoria";

    private static final String SQL_INSERT = "Insert into " + TABLE
            + " (nombre_categoria, descripcion_categoria) values (?,?)";

    private static final String SQL_DELETE = "Delete from " + TABLE
            + " where idCategoria=?";

   private static final String SQL_UPDATE = "Update " + TABLE
            + " set nombre_categoria=?, descripcion_categoria, where idCategoria=?";

    private static final String SQL_QUERY = "Select * from " + TABLE;
    


    public static boolean insertar(CategoriaPOJO pojo) {
        Connection con = null;
        PreparedStatement ps = null;
        int x;
        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(SQL_INSERT);
            ps.setString(1, pojo.getNombre_categoria());
            ps.setString(2, pojo.getDescripcion_categoria());
          
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
      
       public static boolean actualizar(CategoriaPOJO pojo) {
        Connection con = null;
        PreparedStatement ps = null;
        int x;
        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(SQL_UPDATE);
            ps.setString(1, pojo.getNombre_categoria());
            ps.setString(2, pojo.getDescripcion_categoria());
            ps.setInt(3, pojo.getIdCategoria());
            x = ps.executeUpdate();//Aquí se ejecuta el update
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
       
         public static DefaultTableModel cargarTabla() {
        Connection con = null;
        PreparedStatement ps = null;
        DefaultTableModel modelo = null;
        //Como me gustaría que salieran 
        String encabezados[] = {"ID", "Nombre", "Descripcion"};
        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(SQL_QUERY);
            modelo = new DefaultTableModel();
            modelo.setColumnIdentifiers(encabezados);//Aqui asigno los encabe
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Object ob[] = new Object[3];//Número de campos
                //A partir de aquí son IDENTICOS a la BD
                ob[0] = rs.getObject("id_categoria");
                ob[1] = rs.getObject("nombre_categoria");
                ob[2] = rs.getObject("descripcion_categoria");
                
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
                CategoriaPOJO pojo=new CategoriaPOJO();
                pojo.setIdCategoria(rs.getInt("id_categoria"));
                pojo.setNombre_categoria(rs.getString("nombre_categoria"));
                pojo.setDescripcion_categoria(rs.getString("descripcion_sucursal"));
                modelo.addElement(pojo);
            }
                        
        } catch (Exception e) {
            System.out.println("Error al cargar combo "+e);
        } finally {
            Conexion.close(con);
            Conexion.close(ps);
        }
        return modelo;
    }


}

    

