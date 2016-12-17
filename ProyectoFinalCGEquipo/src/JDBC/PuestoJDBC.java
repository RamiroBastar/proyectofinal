/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC;

import POJO.PuestoPOJO;
import POJO.SucursalPOJO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADOLFO
 */
public class PuestoJDBC {
    
    private static final String TABLE = "puesto";
    
    private static final String SQL_INSERT = "insert into " + TABLE + " (nombre_puesto, descripcion_puesto) values (?,?)";

    private static final String SQL_QUERY = "Select * from " + TABLE;
    
    private static final String SQL_DELETE="Delete from "+TABLE+ " where idPuesto=?";
    
    private static final String SQL_UPDATE = "Update "+TABLE+" set nombre_puesto=?, descripcion_puesto=? where idPuesto=?"; 
    

    public static boolean insertar(PuestoPOJO pojo) {
        Connection con = null;
        PreparedStatement ps = null;

        int x;

        try {
            con = Conexion.getConnection(); //Obtengo la conexion de la BD.
            ps = con.prepareStatement(SQL_INSERT); //Preparo el insert.
            ps.setString(1, pojo.getNombre_puesto());
            ps.setString(2, pojo.getDescripcion_puesto());
            
            
            x = ps.executeUpdate(); //Aqui se ejecuta la insercion.
            if (x == 0) {
                return false;

            } else {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error al insertar " + e);
            return false;

        } finally {
            Conexion.close(con);  //Cierro la conexion 
            Conexion.close(ps);  //Cierro el preparedStatement

        }

    }

    
    public static boolean eliminar(String id){
        Connection con =null;
        PreparedStatement ps= null;
        int x;
        
        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(SQL_DELETE);
            ps.setString(1, id);
            
            x = ps.executeUpdate();
            
            if (x==0) {
                return false;
            }
                    
        } catch (Exception e) {
            System.out.println("Error al eliminar "+e);
            return false;
            
        }finally{
            Conexion.close(con);
            Conexion.close(ps);
   }
        return true;
   }
    
    public static boolean actualizar(PuestoPOJO pojo){ 
        
       Connection con = null;
        PreparedStatement ps = null;
        int x; 
        
        try {
            con = Conexion.getConnection(); 
            ps = con.prepareStatement(SQL_UPDATE);
            
            ps.setString(1, pojo.getNombre_puesto());
            ps.setString(2, pojo.getDescripcion_puesto());
            ps.setInt(3, pojo.getIdPuesto()); 
            
            x= ps.executeUpdate();
            if (x == 0) {
                return false;

            } else {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar " +e);
            return false;
            
        }finally{
            Conexion.close(con);
            Conexion.close(ps);
        }
    }
    
    public static DefaultTableModel cargarTabla() {
        Connection con = null;
        PreparedStatement ps = null;
        DefaultTableModel modelo = null;

        String encabezados[] = {"ID", "Nombre", "Descripcion"};

        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(SQL_QUERY);
            modelo=new DefaultTableModel();
            modelo.setColumnIdentifiers(encabezados);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Object ob[] = new Object[3]; //numero de columnas (campos).
                ob[0] = rs.getObject("idSucursal");
                ob[1] = rs.getObject("nombre_puesto");
                ob[2] = rs.getObject("descripcion_puesto");
             
                
                
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
