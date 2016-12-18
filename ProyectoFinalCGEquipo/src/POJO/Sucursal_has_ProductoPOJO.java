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
public class Sucursal_has_ProductoPOJO {
    
    private int Sucursal_idSucursal;
    private int Producto_idProducto;
    private double existencia_en_sucursal;

   
    
    

    public int getSucursal_idSucursal() {
        return Sucursal_idSucursal;
    }

    public void setSucursal_idSucursal(int Sucursal_idSucursal) {
        this.Sucursal_idSucursal = Sucursal_idSucursal;
    }

    public int getProducto_idProducto() {
        return Producto_idProducto;
    }

    public void setProducto_idProducto(int Producto_idProducto) {
        this.Producto_idProducto = Producto_idProducto;
    }

    public double getExistencia_en_sucursal() {
        return existencia_en_sucursal;
    }

    public void setExistencia_en_sucursal(double existencia_en_sucursal) {
        this.existencia_en_sucursal = existencia_en_sucursal;
    }
    
    
    
}
