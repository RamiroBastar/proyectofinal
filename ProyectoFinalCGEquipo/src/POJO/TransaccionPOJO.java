/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import java.sql.Date;

/**
 *
 * @author cristo
 */
public class TransaccionPOJO {
    
    private int idTransaccion;
    private String tipo_de_pago_Transaccion;
    private Date fecha_hora_Transaccion;
    private int cantidad_productos_Transaccion;
    private double total_pago_Transaccion;
    private double iva_Transaccion;
    private int Sucursal_idSucursal;
    private long numero_ticket_Transaccion;
    private String compra_o_venta_Transaccion;
    private int SocioComercial_idSocioComercial;

    public int getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public String getTipo_de_pago_Transaccion() {
        return tipo_de_pago_Transaccion;
    }

    public void setTipo_de_pago_Transaccion(String tipo_de_pago_Transaccion) {
        this.tipo_de_pago_Transaccion = tipo_de_pago_Transaccion;
    }

    public Date getFecha_hora_Transaccion() {
        return fecha_hora_Transaccion;
    }

    public void setFecha_hora_Transaccion(Date fecha_hora_Transaccion) {
        this.fecha_hora_Transaccion = fecha_hora_Transaccion;
    }

    public int getCantidad_productos_Transaccion() {
        return cantidad_productos_Transaccion;
    }

    public void setCantidad_productos_Transaccion(int cantidad_productos_Transaccion) {
        this.cantidad_productos_Transaccion = cantidad_productos_Transaccion;
    }

    public double getTotal_pago_Transaccion() {
        return total_pago_Transaccion;
    }

    public void setTotal_pago_Transaccion(double total_pago_Transaccion) {
        this.total_pago_Transaccion = total_pago_Transaccion;
    }

    public double getIva_Transaccion() {
        return iva_Transaccion;
    }

    public void setIva_Transaccion(double iva_Transaccion) {
        this.iva_Transaccion = iva_Transaccion;
    }

    public int getSucursal_idSucursal() {
        return Sucursal_idSucursal;
    }

    public void setSucursal_idSucursal(int Sucursal_idSucursal) {
        this.Sucursal_idSucursal = Sucursal_idSucursal;
    }

    public long getNumero_ticket_Transaccion() {
        return numero_ticket_Transaccion;
    }

    public void setNumero_ticket_Transaccion(long numero_ticket_Transaccion) {
        this.numero_ticket_Transaccion = numero_ticket_Transaccion;
    }

    public String getCompra_o_venta_Transaccion() {
        return compra_o_venta_Transaccion;
    }

    public void setCompra_o_venta_Transaccion(String compra_o_venta_Transaccion) {
        this.compra_o_venta_Transaccion = compra_o_venta_Transaccion;
    }

    public int getSocioComercial_idSocioComercial() {
        return SocioComercial_idSocioComercial;
    }

    public void setSocioComercial_idSocioComercial(int SocioComercial_idSocioComercial) {
        this.SocioComercial_idSocioComercial = SocioComercial_idSocioComercial;
    }
    
    
    
    
    
}
