/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

/**
 *
 * @author Juan Luis Elabore el POJO de Producto
 */
public class ProductoPOJO {

    private int idProducto;
    private String nombre_producto;
    private double costo_producto;
    private double precio_producto;
    private String presentacion_producto;
    private String descripcion_producto;
    private String codigo_barras_producto;
    private String codigo_interno_producto;
    private boolean iva_producto;
    private int marca_idMarca;
    private int categoria_idCategoria;
    private int unidadDeMedida_idUnidadDeMedida;

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public double getCosto_producto() {
        return costo_producto;
    }

    public void setCosto_producto(double costo_producto) {
        this.costo_producto = costo_producto;
    }

    public double getPrecio_producto() {
        return precio_producto;
    }

    public void setPrecio_producto(double precio_producto) {
        this.precio_producto = precio_producto;
    }

    public String getPresentacion_producto() {
        return presentacion_producto;
    }

    public void setPresentacion_producto(String presentacion_producto) {
        this.presentacion_producto = presentacion_producto;
    }

    public String getDescripcion_producto() {
        return descripcion_producto;
    }

    public void setDescripcion_producto(String descripcion_producto) {
        this.descripcion_producto = descripcion_producto;
    }

    public String getCodigo_barras_producto() {
        return codigo_barras_producto;
    }

    public void setCodigo_barras_producto(String codigo_barras_producto) {
        this.codigo_barras_producto = codigo_barras_producto;
    }

    public String getCodigo_interno_producto() {
        return codigo_interno_producto;
    }

    public void setCodigo_interno_producto(String codigo_interno_producto) {
        this.codigo_interno_producto = codigo_interno_producto;
    }

    public boolean isIva_producto() {
        return iva_producto;
    }

    public void setIva_producto(boolean iva_producto) {
        this.iva_producto = iva_producto;
    }

    public int getMarca_idMarca() {
        return marca_idMarca;
    }

    public void setMarca_idMarca(int marca_idMarca) {
        this.marca_idMarca = marca_idMarca;
    }

    public int getCategoria_idCategoria() {
        return categoria_idCategoria;
    }

    public void setCategoria_idCategoria(int categoria_idCategoria) {
        this.categoria_idCategoria = categoria_idCategoria;
    }

    public int getUnidadDeMedida_idUnidadDeMedida() {
        return unidadDeMedida_idUnidadDeMedida;
    }

    public void setUnidadDeMedida_idUnidadDeMedida(int unidadDeMedida_idUnidadDeMedida) {
        this.unidadDeMedida_idUnidadDeMedida = unidadDeMedida_idUnidadDeMedida;
    }

    @Override
    public String toString() {
        return nombre_producto;
    }

}
