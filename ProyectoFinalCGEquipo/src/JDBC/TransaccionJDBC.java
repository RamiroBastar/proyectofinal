/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC;

import POJO.TransaccionPOJO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Brandon
 */
public class TransaccionJDBC {
    private static final String TABLE = "Transaccion";
    private static final String SQL_INSERT = "insert into " + TABLE + " (tipo_de_pago_Transaccion, fecha_hora_Transaccion, cantidad_productos_Transaccion, total_pago_Transaccion, iva_Transaccion, Sucursal_idSucursal, numero_ticket_Transaccion, compra_o_venta_Transaccion, SocioComercial_idSocioComercial) values (?,?,?,?,?,?,?,?,?)";
    private static final String SQL_QUERY = "Select * from " + TABLE;
    private static final String SQL_DELETE = "Delete from " + TABLE + " where idTransaccion";
    private static final String SQL_UPDATE = "Update " + TABLE + " set tipo_de_pago_Transaccion=?, fecha_hora_Transaccion=?, cantidad_productos_Transaccion=?, total_pago_Transaccion=?, iva_Transaccion=?, Sucursal_idSucursal=?, numero_ticket_Transaccion=?, compra_o_venta_Transaccion=?, SocioComercial_idSocioComercial=? where idTransaccion=?";

    public static boolean insertar(TransaccionPOJO pojo) {
        Connection con = null;
        PreparedStatement ps = null;
        int x;
        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(SQL_INSERT);
            ps.setString(1, pojo.getTipo_de_pago_Transaccion());
            ps.setDate(2, pojo.getFecha_hora_Transaccion());
            ps.setInt(3, pojo.getCantidad_productos_Transaccion());
            ps.setDouble(4, pojo.getTotal_pago_Transaccion());
            ps.setDouble(5, pojo.getIva_Transaccion());
            ps.setInt(6, pojo.getSucursal_idSucursal());
            ps.setLong(7, pojo.getNumero_ticket_Transaccion());
            ps.setString(8, pojo.getCompra_o_venta_Transaccion());
            ps.setInt(9, pojo.getSocioComercial_idSocioComercial());
            x = ps.executeUpdate();
            if (x == 0) {
                return false;
            } else {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Error al incertar :( " + e);
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
            con = Conexion.getConnection();
            ps = con.prepareStatement(SQL_DELETE);
            ps.setString(1, id);
            x = ps.executeUpdate();
            if (x == 0) {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error al Eliminar " + e);
            return false;
        } finally {
            Conexion.close(con);
            Conexion.close(ps);
        }
        return true;
    }

    public static DefaultTableModel cargarTabla() {
        Connection con = null;
        PreparedStatement ps = null;
        DefaultTableModel modelo = null;
        String encabezados[] = {"ID Transaccion", "Tipo de pago Transaccion", "fecha_hora_Transaccion", "cantidad_productos_Transaccion", "total_pago_Transaccion", "iva_Transaccion", "Sucursal_idSucursal", "numero_ticket_Transaccion", "compra_o_venta_Transaccion", "SocioComercial_idSocioComercial"};
        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(SQL_QUERY);
            modelo = new DefaultTableModel();
            modelo.setColumnIdentifiers(encabezados);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Object ob[] = new Object[10];
                ob[0] = rs.getObject("idTransaccion");
                ob[1] = rs.getObject("tipo_de_pago_Transaccion");
                ob[2] = rs.getObject("fecha_hora_Transaccion");
                ob[3] = rs.getObject("cantidad_productos_Transaccion");
                ob[4] = rs.getObject("total_pago_Transaccion");
                ob[5] = rs.getObject("iva_Transaccion");
                ob[6] = rs.getObject("Sucursal_idSucursal");
                ob[7] = rs.getObject("numero_ticket_Transaccion");
                ob[8] = rs.getObject("compra_o_venta_Transaccion");
                ob[9] = rs.getObject("SocioComercial_idSocioComercial");
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
    
    public static boolean actualizar(TransaccionPOJO pojo) {
        Connection con = null;
        PreparedStatement ps = null;
        int x;
        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(SQL_UPDATE);
            ps.setString(1, pojo.getTipo_de_pago_Transaccion());
            ps.setDate(2, pojo.getFecha_hora_Transaccion());
            ps.setInt(3, pojo.getCantidad_productos_Transaccion());
            ps.setDouble(4, pojo.getTotal_pago_Transaccion());
            ps.setDouble(5, pojo.getIva_Transaccion());
            ps.setInt(6, pojo.getSucursal_idSucursal());
            ps.setLong(7, pojo.getNumero_ticket_Transaccion());
            ps.setString(8, pojo.getCompra_o_venta_Transaccion());
            ps.setInt(9, pojo.getSocioComercial_idSocioComercial());
            ps.setInt(10, pojo.getIdTransaccion());
            x = ps.executeUpdate();
            if (x == 0) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error al Actualizar :( " + e);
            return false;
        } finally {
            Conexion.close(con);
            Conexion.close(ps);
        }
    }
}
