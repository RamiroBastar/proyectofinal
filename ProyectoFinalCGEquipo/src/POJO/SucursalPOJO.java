/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

/**
 *
 * @author Personalizados
 */
public class SucursalPOJO {
    
    private int idSucursal;
    private String nombre_sucursal;
    private String direccion_sucursal;
    private String clave_sucursal;
    private String telefono_sucursal;

    @Override
    public String toString() {
        return nombre_sucursal; //To change body of generated methods, choose Tools | Templates.
    }
    
    

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getNombre_sucursal() {
        return nombre_sucursal;
    }

    public void setNombre_sucursal(String nombre_sucursal) {
        this.nombre_sucursal = nombre_sucursal;
    }

    public String getDireccion_sucursal() {
        return direccion_sucursal;
    }

    public void setDireccion_sucursal(String direccion_sucursal) {
        this.direccion_sucursal = direccion_sucursal;
    }

    public String getClave_sucursal() {
        return clave_sucursal;
    }

    public void setClave_sucursal(String clave_sucursal) {
        this.clave_sucursal = clave_sucursal;
    }

    public String getTelefono_sucursal() {
        return telefono_sucursal;
    }

    public void setTelefono_sucursal(String telefono_sucursal) {
        this.telefono_sucursal = telefono_sucursal;
    }
    
    
}
