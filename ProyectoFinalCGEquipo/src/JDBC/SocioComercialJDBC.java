/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC;

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
import javax.swing.DefaultListModel;

/**
 *
 * @author Profesor Bastar
 */
public class SocioComercialJDBC {

    private static String TABLE = "sociocomercial";
    private static String SQL_QUERY = "Select * from " + TABLE;
    private static final String SQL_INSERT = "Insert into " + TABLE
            + " (nombre_socio_comercial,rfc_socio_comercial,"
            + " razon_social_socio_comercial,direccion_socio_comercial,"
            + "localidad_socio_comercial,municipio_socio_comercial,"
            + "estado_socio_comercial,colonia_socio_comercial,"
            + "cp_socio_comercial,pais_socio_comercial,"
            + "cliente_o_proveedor_socio_comercial,"
            + "fecha_nacimiento_socio_comercial,foto_socio_comercial) "
            + " values (?,?,?,?,?,?,?,?,?,?,?,?,?)";

    //Cuando quiera guardar fotos, debo agregar
    //el parámetro ruta
    public static boolean insertar(SocioComercialPOJO pojo, String ruta) {
        Connection con = null;
        PreparedStatement ps = null;
        int x;
        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(SQL_INSERT);
            ps.setString(1, pojo.getNombre_socio_comercial());
            ps.setString(2, pojo.getRfc_socio_comercial());
            ps.setString(3, pojo.getRazon_social_socio_comercial());
            ps.setString(4, pojo.getDireccion_socio_comercial());
            ps.setString(5, pojo.getLocalidad_socio_comercial());
            ps.setString(6, pojo.getMunicipio_socio_comercial());
            ps.setString(7, pojo.getEstado_socio_comercial());
            ps.setString(8, pojo.getColonia_socio_comercial());
            ps.setString(9, pojo.getCp_socio_comercial());
            ps.setString(10, pojo.getPais_socio_comercial());
            ps.setString(11, pojo.getCliente_o_proveedor_socio_comercial());
            ps.setDate(12, pojo.getFecha_nacimiento_socio_comercial());
            File archivo = new File(ruta);
            ps.setBinaryStream(13, new FileInputStream(archivo), archivo.length());
            
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
        DefaultListModel<SocioComercialPOJO> modelo = null;
        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(SQL_QUERY);
            modelo = new DefaultListModel<SocioComercialPOJO>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SocioComercialPOJO pojo = new SocioComercialPOJO();
                pojo.setNombre_socio_comercial(rs.getString("nombre_socio_comercial"));
                pojo.setRfc_socio_comercial(rs.getString("rfc_socio_comercial"));
                pojo.setRazon_social_socio_comercial(rs.getString("razon_social_socio_comercial"));
                pojo.setDireccion_socio_comercial(rs.getString("direccion_socio_comercial"));
                pojo.setLocalidad_socio_comercial(rs.getString("localidad_socio_comercial"));
                pojo.setMunicipio_socio_comercial(rs.getString("municipio_socio_comercial"));
                pojo.setEstado_socio_comercial(rs.getString("estado_socio_comercial"));
                pojo.setColonia_socio_comercial(rs.getString("colonia_socio_comercial"));
                pojo.setCp_socio_comercial(rs.getString("cp_socio_comercial"));
                pojo.setPais_socio_comercial(rs.getString("pais_socio_comercial"));
                pojo.setCliente_o_proveedor_socio_comercial(rs.getString("cliente_o_proveedor_socio_comercial"));
                pojo.setFecha_nacimiento_socio_comercial(rs.getDate("fecha_nacimiento_socio_comercial"));
                byte[] b = rs.getBytes("foto_socio_comercial");
                if (b != null) {
                    pojo.setFoto_socio_comercial(convertirImagen(b));
                }
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

    
    
    
}
