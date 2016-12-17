/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

/**
 *
 * @author MiguelAngel
 */
public class Transaccion_has_ProductoPOJO {
    
    private int Transaccion_idTransaccion;
    private int Producto_idProducto;
    private double cantidad_transaccion_has_producto;
    private double importe_transaccion_has_producto;

    public int getTransaccion_idTransaccion() {
        return Transaccion_idTransaccion;
    }

    public void setTransaccion_idTransaccion(int Transaccion_idTransaccion) {
        this.Transaccion_idTransaccion = Transaccion_idTransaccion;
    }

    public int getProducto_idProducto() {
        return Producto_idProducto;
    }

    public void setProducto_idProducto(int Producto_idProducto) {
        this.Producto_idProducto = Producto_idProducto;
    }

    public double getCantidad_transaccion_has_producto() {
        return cantidad_transaccion_has_producto;
    }

    public void setCantidad_transaccion_has_producto(double cantidad_transaccion_has_producto) {
        this.cantidad_transaccion_has_producto = cantidad_transaccion_has_producto;
    }

    public double getImporte_transaccion_has_producto() {
        return importe_transaccion_has_producto;
    }

    public void setImporte_transaccion_has_producto(double importe_transaccion_has_producto) {
        this.importe_transaccion_has_producto = importe_transaccion_has_producto;
    }
    
    
    
}
