/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import POJO.SucursalPOJO;


/**
 *
 * @author Juan
 */
public class SucursalJDBC {
    private static final String TABLE="sucursal";  //abajo importante despues de into SPACE
    private static final String SQL_INSERT="insert into "+TABLE+
            " (nombre_sucursal,direccion_sucursal,clave_sucursal,telefono_sucursal) values (?,?,?,?)";
                                         //Importante poner ?=segun campos
            // revisar si es correcto nombre=campo?????????????????      
    
    // ** se agregar para borrar
    private static final String SQL_DELETE="Delete from "+TABLE
            +" where idSucursal=?";  // aqui borra como en SQL
    
    private static final String SQL_UPDATE="Update "+TABLE+" set nombre_sucursal=?, direccion_sucursal=?, clave_sucursal=?, telefono_sucursal=? where idsucursal=?";
                       // revisar si es correcto nombre=campo?????????????????
    
    //** se agregar  para consultar
    private static final String SQL_QUERY="Select * from "+TABLE;  // se crea la consulta como en SQL
    
    
    
    // metodo de alta insertar
    public static boolean insertar(SucursalPOJO pojo){ //importar fojo.CONTACO POJOS
        Connection con=null; //importar
        PreparedStatement ps=null; //importar
        int x;
        try {
            con=Conexion.getConnection(); //obtengo la conexion de la BD
            ps=con.prepareStatement(SQL_INSERT); // preparo Insert
            //empiezo a llenar el preparado desde 1
            ps.setString(1, pojo.getNombre_sucursal());
            ps.setString(2, pojo.getDireccion_sucursal());
            ps.setString(3, pojo.getClave_sucursal());
            ps.setString(4, pojo.getTelefono_sucursal());
            
            x=ps.executeUpdate(); // Aqui se ejecuta la inserccion
            if (x==0) {
                return false;
            }else{
                return true;
            }        
        } catch (Exception e) {
            System.out.println("Error al insert "+e);
            return false;
        }finally{
            Conexion.close(con); // Cierro la conexion con la bd
            Conexion.close(ps);  // Cierro el preparedStatement
        }
        
    }
    
    
    
     public static boolean eliminar(String id){
        Connection con=null;
        PreparedStatement ps=null;
        int x;
        try {
            con=Conexion.getConnection(); //Obtengo la Conexion en la BD
            ps=con.prepareStatement(SQL_DELETE);
            ps.setString(1, id);
            x=ps.executeUpdate();
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
    
    
     
    public static boolean actualizar(SucursalPOJO pojo){
        Connection con=null; //importar
        PreparedStatement ps=null; //importar
        int x;
        try {
            con=Conexion.getConnection(); //obtengo la conexion de la BD
            ps=con.prepareStatement(SQL_UPDATE); // preparo Insert
            ps.setString(1,pojo.getNombre_sucursal());
            ps.setString(2,pojo.getDireccion_sucursal());
            ps.setString(3,pojo.getClave_sucursal());
            ps.setString(4,pojo.getTelefono_sucursal());
            ps.setInt(5, pojo.getIdSucursal()); // tiene que ser el ultimo
                        
            x=ps.executeUpdate(); // Aqui se ejecuta 
            if (x==0) {
                return false;
            }else{
                return true;
            } 
            
        } catch (Exception e) {
            System.out.println("Error al actualizar "+e);
            return false;
            
        }finally{
           Conexion.close(con);
           Conexion.close(ps); 
            
        }
    } 
    
    
    
       //Metodo de consulta
    public static DefaultTableModel cargarTabla(){
        Connection con=null;
        PreparedStatement ps=null;
        DefaultTableModel modelo=null;
        // Como me gustaria que salieran
        String encabezados[]={"ID","Nombre","Direccion","Clave","Telefono"};
        try {
            con=Conexion.getConnection();
            ps=con.prepareStatement(SQL_QUERY);
            modelo=new DefaultTableModel();
            modelo.setColumnIdentifiers(encabezados); // Aqui asigno encabezados
            //este se importa
            ResultSet rs=ps.executeQuery(); //ejecuta consulta y se guarda
            while (rs.next()) {
                Object ob[]=new Object[5]; //Cantidad de campos (columnas)
                // A partir de aqui son identicos a la BD
                ob[0]=rs.getObject("idsucursal");
                ob[1]=rs.getObject("nombre_sucursal");
                ob[2]=rs.getObject("direccion_sucursal");
                ob[3]=rs.getObject("clave_sucursal");
                ob[4]=rs.getObject("telefono_sucursal");
                
                modelo.addRow(ob);
                                        
            }
            Conexion.close(rs);
            
        } catch (Exception e) {
            System.out.println("Error al consultar "+e);
            
        }finally{
            Conexion.close(con);
            Conexion.close(ps);
        }
        return modelo;
              
    }
    
    
    
    public static DefaultComboBoxModel cargarCombo(){  // se IMPORTA
       Connection con=null;
       PreparedStatement ps=null;
       DefaultComboBoxModel modelo=null; 
        try {
            con=Conexion.getConnection();
            ps=con.prepareStatement(SQL_QUERY);
            modelo=new DefaultComboBoxModel();
            ResultSet rs=ps.executeQuery(); //ejecuta consulta y se guarda
            while (rs.next()) {
              SucursalPOJO pojo=new SucursalPOJO();  
              pojo.setIdSucursal(rs.getInt("idsucursal"));
              pojo.setNombre_sucursal(rs.getString("nombre_sucursal"));
              pojo.setDireccion_sucursal(rs.getString("direccion_sucursal"));
              pojo.setClave_sucursal(rs.getString("clave_sucursal"));
              pojo.setTelefono_sucursal(rs.getString("telefono_sucursal"));
              
              modelo.addElement(pojo);
            }
          
        } catch (Exception e) {
            System.out.println("Error al cargar combo"+e);
            
        }finally{
            Conexion.close(con);
            Conexion.close(ps);
        }
 
        return modelo;
        
        
    }
    
    
    
    
    
    
    
}
