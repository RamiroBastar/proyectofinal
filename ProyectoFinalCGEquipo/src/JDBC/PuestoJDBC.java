/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC;

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
    

    public static boolean insertar(SucursalPOJO pojo) {
        Connection con = null;
        PreparedStatement ps = null;

        int x;

        try {
            con = jdbc.Conexion.getConnection(); //Obtengo la conexion de la BD.
            ps = con.prepareStatement(SQL_INSERT); //Preparo el insert.
            ps.setString(1, pojo.getNombre_sucursal());
            ps.setString(2, pojo.getDireccion_sucursal());
            ps.setString(3, pojo.getClave_sucursal());
            ps.setString(4, pojo.getTelefono_sucursal());
           
            
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
            jdbc.Conexion.close(con);  //Cierro la conexion 
            jdbc.Conexion.close(ps);  //Cierro el preparedStatement

        }

    }

    
    public static boolean eliminar(String id){
        Connection con =null;
        PreparedStatement ps= null;
        int x;
        
        try {
            con = jdbc.Conexion.getConnection();
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
            jdbc.Conexion.close(con);
            jdbc.Conexion.close(ps);
   }
        return true;
   }
    
    public static boolean actualizar(SucursalPOJO pojo){ 
        
       Connection con = null;
        PreparedStatement ps = null;
        int x; 
        
        try {
            con = jdbc.Conexion.getConnection(); 
            ps = con.prepareStatement(SQL_UPDATE);
            
            ps.setString(1, pojo.getNombre_sucursal());
            ps.setString(2, pojo.getDireccion_sucursal());
            ps.setString(3, pojo.getClave_sucursal());
            ps.setString(4, pojo.getTelefono_sucursal());
            ps.setInt(5, pojo.getIdSucursal()); 
            
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
            jdbc.Conexion.close(con);
            jdbc.Conexion.close(ps);
        }
    }
    
    public static DefaultTableModel cargarTabla() {
        Connection con = null;
        PreparedStatement ps = null;
        DefaultTableModel modelo = null;

        String encabezados[] = {"ID", "Nombre", "Direccion", "Clave", "Telefono"};

        try {
            con = jdbc.Conexion.getConnection();
            ps = con.prepareStatement(SQL_QUERY);
            modelo=new DefaultTableModel();
            modelo.setColumnIdentifiers(encabezados);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Object ob[] = new Object[5]; //numero de columnas (campos).
                ob[0] = rs.getObject("idSucursal");
                ob[1] = rs.getObject("nombre_sucursal");
                ob[2] = rs.getObject("direccion_sucursal");
                ob[3] = rs.getObject("clave_sucursal");
                ob[4] = rs.getObject("telefono_sucursal");
                
                
                modelo.addRow(ob);
            }
            jdbc.Conexion.close(rs);

        } catch (Exception e) {
            System.out.println("Error al consultar " + e);

        } finally {
            jdbc.Conexion.close(con);
            jdbc.Conexion.close(ps);
            
        }
         return modelo;
    }
    
    
}
