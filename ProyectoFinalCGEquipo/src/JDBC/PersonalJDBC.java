/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC;

import POJO.PersonalPOJO;
import POJO.ProductoPOJO;
import POJO.SocioComercialPOJO;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

/**
 *
 * @author Uriel
 */
public class PersonalJDBC {
      private static String TABLE = "personal;";
    private static final String SQL_QUERY = "Select * from " + TABLE;
    
    private static final String SQL_INSERT = "insert into " + TABLE +
            " (nombre_personal, direccion_personal, telefono_personal, "
            +"fecha_nacimiento_personal,acceso_sistema_personal, "
            +" usuario_personal, password_personal,"
            +" foto_personal, departamento_idDepartamento,"
            +" puesto_idPuesto,"
            +"sucursal_idSucursal) "
            + " values (?,?,?,?,?,?,?,?,?,?,?)";
     private static final String SQL_DELETE="Delete from "+TABLE+
              " where idPersonal=?";
      
      private static final String SQL_UPDATE=
            "Update "+TABLE+" set nombre_personal=?, direccion_personal=?, telefono_personal=?, fecha_nacimiento_personal=?, acceso_personal=?, usuario_personal=?, password_personal=?, foto_personal=?, departamento_idDepartamento=?, puesto_idPuesto=?, sucursal_idSucursal=? "+
            " where idPersonal=?";
      
    
    // Cuando quiera guardar fotos debo agregar el parametro ruta
   public static boolean insertar(PersonalPOJO pojo, String ruta){//Nombre de la clase de Pojo
        Connection con=null;
        PreparedStatement ps= null;
        int x;
        try {
            con= Conexion.getConnection(); //Obtengo la conexion con BD
            ps= con.prepareStatement(SQL_INSERT);//Preparo el insert
            
            // Empiezo a llenar el preparado desde 1
            // a qui no se pone el id
            ps.setString(1, pojo.getNombre_personal());
                ps.setString(2, pojo.getDireccion_personal());
                ps.setString(3, pojo.getTelefono_personal());
                ps.setDate(4, pojo.getFecha_nacimiento_personal());
                ps.setBoolean(5, pojo.isAcceso_sistema_personal());
                ps.setString(6, pojo.getUsuario_personal());
                ps.setString(7, pojo.getPassword_personal());
               File archi = new File(ruta);
                ps.setBinaryStream(13, new FileInputStream(archi), archi.length());
                ps.setInt(9, pojo.getDepartamento_idDepartamento());
                ps.setInt(10, pojo.getPuesto_idPuesto());
                ps.setInt(11, pojo.getSucursal_idSucursal());
                
           
                
              x=ps.executeUpdate();// Aqui se ejecuta la insercion
              if (x==0) {
                return false;
            }else{
                  return true;
              }
        } catch (Exception e) {
            System.out.println("Error al insertar "+e);
            return false;
        }finally{ // Se ejecuta siempre al finalizar el trycatch
            Conexion.close(con);// Cierro la conexion con base de datos
            Conexion.close(ps);// cierro el preparedDtatement
        }
              
    }
   
   //Si manejaré imágenes debo copiar y pegar este método
     private static Image convertirImagen(byte[] bytes) throws IOException   {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        Iterator readers = ImageIO.getImageReadersByFormatName("jpeg");
        ImageReader reader = (ImageReader) readers.next();
        Object source = bis; // File or InputStream
        ImageInputStream iis = ImageIO.createImageInputStream(source);
        reader.setInput(iis, true);
        ImageReadParam param = reader.getDefaultReadParam();
        return reader.read(0, param);
    }
     
     
     public static DefaultListModel cargarLista() {
        Connection con = null;
        PreparedStatement ps = null;
        DefaultListModel<PersonalPOJO> modelo = null;
        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(SQL_QUERY);
            modelo = new DefaultListModel<PersonalPOJO>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PersonalPOJO pojo = new PersonalPOJO();
                pojo.setNombre_personal(rs.getString("nombre_personal"));
                pojo.setDireccion_personal(rs.getString("direccion_personal"));
                pojo.setTelefono_personal(rs.getString("telefono_personal"));
                pojo.setFecha_nacimiento_personal(rs.getDate("fecha_nacimiento_personal"));
                pojo.setAcceso_sistema_personal(rs.getBoolean("acceso_personal"));
                pojo.setUsuario_personal(rs.getString("usuario_personal"));
                pojo.setPassword_personal(rs.getString("pasword_personal"));
             byte[] b = rs.getBytes("foto_personal");
                if (b != null) {
                    pojo.setFoto_personal(convertirImagen(b));
                }
                pojo.setDepartamento_idDepartamento(rs.getInt("departamento_idDepartamento"));
                pojo.setPuesto_idPuesto(rs.getInt("puesto_idPuesto"));
                pojo.setSucursal_idSucursal(rs.getInt("sucursal_idSucursal"));
                
                modelo.addElement(pojo);
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
       public static boolean eliminar(String id){//Solo requiero el ID para eliminar
    //El ID se ocupa como String ya que se necesita hacer un parseo si lo ocupas como entero(int)
         Connection con = null;
        PreparedStatement ps = null;
        int x;
        try {
             con = Conexion.getConnection();
            ps = con.prepareStatement(SQL_DELETE);
            ps.setString(1, id);
            x=ps.executeUpdate();
            if (x==0) {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error al Eliminar "+e);
            return false;
        }finally{
            Conexion.close(con);
            Conexion.close(ps);
        }
        return true;
    }
       
        public static boolean Actualizar(PersonalPOJO pojo) {
        Connection con = null;
        PreparedStatement ps = null;
        int x;

        try {
            con = Conexion.getConnection();//obtengo la conexion a la BD
            ps = con.prepareStatement(SQL_UPDATE);//preparo el update

            ps.setString(1, pojo.getNombre_personal());
            ps.setString(2, pojo.getDireccion_personal());
            ps.setString(3, pojo.getTelefono_personal());
            ps.setDate(4, pojo.getFecha_nacimiento_personal());
            ps.setBoolean(5, pojo.isAcceso_sistema_personal());
            ps.setString(6, pojo.getUsuario_personal());
            ps.setString(7, pojo.getPassword_personal());
            ps.setInt(8, pojo.getDepartamento_idDepartamento());
            ps.setInt(9, pojo.getPuesto_idPuesto());
            ps.setInt(10, pojo.getSucursal_idSucursal());
            ps.setInt(11, pojo.getIdPersonal());
          

            x = ps.executeUpdate();//Aqui se ejecuta el update
            if (x == 0) {
                return false;
            } else {
                return true;
            }

        } catch (Exception e) {
            System.out.println("Error al actualizar " + e);
            return false;

        } finally {
            Conexion.close(con);
            Conexion.close(ps);

        }

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
                PersonalPOJO pojo = new PersonalPOJO();
                pojo.setIdPersonal(rs.getInt("idPersonal"));
                pojo.setNombre_personal(rs.getString("nombre_personal"));
                pojo.setDireccion_personal(rs.getString("direccion_personal"));
                pojo.setTelefono_personal(rs.getString("telefono_peronal"));
                pojo.setFecha_nacimiento_personal(rs.getDate("fecha_nacimoento_personal"));
                pojo.setAcceso_sistema_personal(rs.getBoolean("acceso_sistema_personal"));
                pojo.setUsuario_personal(rs.getString("usuario_personal"));
                pojo.setPassword_personal(rs.getString("password_personal"));
                //pojo.setFoto_personal(rs.get("iva_producto"));
                pojo.setDepartamento_idDepartamento(rs.getInt("departamento_idDepartamento"));
                pojo.setPuesto_idPuesto(rs.getInt("puesto_idPuesto"));
                pojo.setSucursal_idSucursal(rs.getInt("sucursal_idSucursal"));
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
