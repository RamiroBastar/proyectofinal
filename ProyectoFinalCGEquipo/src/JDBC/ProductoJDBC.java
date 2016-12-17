/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC;

import POJO.ProductoPOJO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ruben
 */
public class ProductoJDBC {

    private static final String TABLE = "Producto";//nombre de la tabla de BD
    private static final String SQL_INSERT = "insert into " + TABLE
            + " (nombre_producto,costo_producto,precio_producto,presentacion_producto,descripcion_producto"
            + " codigo_barras_producto,codigo_interno_producto,iva_produto,Marca_idMarca,UnidadDeMedida_idUnidadDeMedida"
            + " Categoria_idCategoria) Values (?,?,?,?,?,?,?,?,?,?,?)";

    private static final String SQL_QUERY = "Select * from " + TABLE;

    private static final String SQL_UPDATE = "Update " + TABLE + " set nombre_producto=?,costo_producto=?,precio_producto=?"
            + " presentacion_producto=?,descripcion_prodcuto=?,codigo_barras_producto=?,codigo_interno_producto=?"
            + " iva_producto=?,Marca_idMarca=?,UnidaDeMedida_idUnidadDeMedida=?,Categoria_idCategoria where idProducto=?";

    private static final String SQL_DELETE = "Delete from " + TABLE + " where idProducto=?";

    public static boolean insertar(ProductoPOJO pojo) {
        Connection con = null;
        PreparedStatement ps = null;
        int x;
        try {
            con = Conexion.getConnection();//obtengo la conexion a la BD
            ps = con.prepareStatement(SQL_INSERT);//preparo el insert
            //empiezo a llenar el preparado desde 1
            ps.setString(1, pojo.getNombre_producto());
            ps.setDouble(2, pojo.getCosto_producto());
            ps.setDouble(3, pojo.getPrecio_producto());
            ps.setString(4, pojo.getPresentacion_producto());
            ps.setString(5, pojo.getDescripcion_producto());
            ps.setString(6, pojo.getCodigo_barras_producto());
            ps.setString(7, pojo.getCodigo_interno_producto());
            ps.setBoolean(8, pojo.isIva_producto());
            ps.setInt(9, pojo.getMarca_idMarca());
            ps.setInt(10, pojo.getUnidadDeMedida_idUnidadDeMedida());
            ps.setInt(11, pojo.getCategoria_idCategoria());

            x = ps.executeUpdate();//Aqui se ejecuta la inserción
            if (x == 0) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error al insertar " + e);
            return false;
        } finally {
            Conexion.close(con);//Cierro la conexión con la BD
            Conexion.close(ps);//Cierro el PreparedStatement
        }

    }

    public static boolean eliminar(String id) {
        Connection con = null;
        PreparedStatement ps = null;
        int x;
        try {
            con = Conexion.getConnection();//Obtengo la conexion a la bd
            ps = con.prepareStatement(SQL_DELETE);//preparo el delete
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

    public static boolean Actualizar(ProductoPOJO pojo) {
        Connection con = null;
        PreparedStatement ps = null;
        int x;

        try {
            con = Conexion.getConnection();//obtengo la conexion a la BD
            ps = con.prepareStatement(SQL_UPDATE);//preparo el update

            ps.setString(1, pojo.getNombre_producto());
            ps.setDouble(2, pojo.getCosto_producto());
            ps.setDouble(3, pojo.getPrecio_producto());
            ps.setString(4, pojo.getPresentacion_producto());
            ps.setString(5, pojo.getDescripcion_producto());
            ps.setString(6, pojo.getCodigo_barras_producto());
            ps.setString(7, pojo.getCodigo_interno_producto());
            ps.setBoolean(8, pojo.isIva_producto());
            ps.setInt(9, pojo.getMarca_idMarca());
            ps.setInt(10, pojo.getUnidadDeMedida_idUnidadDeMedida());
            ps.setInt(11, pojo.getCategoria_idCategoria());
            ps.setInt(12, pojo.getIdProducto());

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

    public static DefaultTableModel cargaTabla() {
        Connection con = null;
        PreparedStatement ps = null;
        DefaultTableModel modelo = null;
        //como me gustaria que salieran
        String encabezados[] = {"Id", "Nombre", "Costo", "Precio", "Presentacion", "Descripcion", "Codigo de barras", "Codigo interno", "Iva", "IdMarca", "IdUnidadDeMedida", "IdCategoria"};
        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(SQL_QUERY);
            modelo = new DefaultTableModel();
            modelo.setColumnIdentifiers(encabezados);//Aqui asigno los encabezados
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Object ob[] = new Object[12];//numeros de columnas(campos)
                //A partir de aqui son IDENTICOS a la BD
                ob[0] = rs.getObject("idProducto");
                ob[1] = rs.getObject("nombre_producto");
                ob[2] = rs.getObject("costo_prodcuto");
                ob[3] = rs.getObject("precio_prodcuto");
                ob[4] = rs.getObject("presentacion_prodcuto");
                ob[5] = rs.getObject("descripcion_prodcuto");
                ob[6] = rs.getObject("codigo_barras_prodcuto");
                ob[7] = rs.getObject("codigo_interno_prodcuto");
                ob[8] = rs.getObject("iva_prodcuto");
                ob[9] = rs.getObject("Marca_idMarca");
                ob[10] = rs.getObject("UnidadDeMedida_idUnidadDeMedida");
                ob[11] = rs.getObject("Categoria_idCategoria");

                modelo.addRow(ob);

            }
            Conexion.close(rs);
        } catch (Exception e) {

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
                ProductoPOJO pojo = new ProductoPOJO();
                pojo.setIdProducto(rs.getInt("idProducto"));
                pojo.setNombre_producto(rs.getString("nombre_producto"));
                pojo.setCosto_producto(rs.getDouble("costo_producto"));
                pojo.setPrecio_producto(rs.getDouble("precio_producto"));
                pojo.setPresentacion_producto(rs.getString("presentacion_producto"));
                pojo.setDescripcion_producto(rs.getString("descripcion_producto"));
                pojo.setCodigo_barras_producto(rs.getString("codigo_barras_producto"));
                pojo.setCodigo_interno_producto(rs.getString("codigo_interno_producto"));
                pojo.setIva_producto(rs.getBoolean("iva_producto"));
                pojo.setMarca_idMarca(rs.getInt("Marca_idMarca"));
                pojo.setUnidadDeMedida_idUnidadDeMedida(rs.getInt("UnidadDeMedida_idUnidadDeMedida"));
                pojo.setCategoria_idCategoria(rs.getInt("Categoria_idCategoria"));
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
