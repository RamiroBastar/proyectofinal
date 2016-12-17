/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import java.awt.Image;
import java.sql.Date;

/**
 *
 * @author aealc
 */
public class PersonalPOJO {
    
    private int idPersonal;
    private String nombre_personal;
    private String direccion_personal;
    private String telefono_personal;
    private Date fecha_nacimiento_personal;
    private boolean acceso_sistema_personal;
    private String usuario_personal;
    private String password_personal;
    private Image foto_personal;
    private int Departamento_idDepartamento;
    private int Puesto_idPuesto;
    private int Sucursal_idSucursal;

    public int getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
    }

    public String getNombre_personal() {
        return nombre_personal;
    }

    public void setNombre_personal(String nombre_personal) {
        this.nombre_personal = nombre_personal;
    }

    public String getDireccion_personal() {
        return direccion_personal;
    }

    public void setDireccion_personal(String direccion_personal) {
        this.direccion_personal = direccion_personal;
    }

    public String getTelefono_personal() {
        return telefono_personal;
    }

    public void setTelefono_personal(String telefono_personal) {
        this.telefono_personal = telefono_personal;
    }

    public Date getFecha_nacimiento_personal() {
        return fecha_nacimiento_personal;
    }

    public void setFecha_nacimiento_personal(Date fecha_nacimiento_personal) {
        this.fecha_nacimiento_personal = fecha_nacimiento_personal;
    }

    public boolean isAcceso_sistema_personal() {
        return acceso_sistema_personal;
    }

    public void setAcceso_sistema_personal(boolean acceso_sistema_personal) {
        this.acceso_sistema_personal = acceso_sistema_personal;
    }

    public String getUsuario_personal() {
        return usuario_personal;
    }

    public void setUsuario_personal(String usuario_personal) {
        this.usuario_personal = usuario_personal;
    }

    public String getPassword_personal() {
        return password_personal;
    }

    public void setPassword_personal(String password_personal) {
        this.password_personal = password_personal;
    }

    public Image getFoto_personal() {
        return foto_personal;
    }

    public void setFoto_personal(Image foto_personal) {
        this.foto_personal = foto_personal;
    }

    public int getDepartamento_idDepartamento() {
        return Departamento_idDepartamento;
    }

    public void setDepartamento_idDepartamento(int Departamento_idDepartamento) {
        this.Departamento_idDepartamento = Departamento_idDepartamento;
    }

    public int getPuesto_idPuesto() {
        return Puesto_idPuesto;
    }

    public void setPuesto_idPuesto(int Puesto_idPuesto) {
        this.Puesto_idPuesto = Puesto_idPuesto;
    }

    public int getSucursal_idSucursal() {
        return Sucursal_idSucursal;
    }

    public void setSucursal_idSucursal(int Sucursal_idSucursal) {
        this.Sucursal_idSucursal = Sucursal_idSucursal;
    }
    
    
    
    
}
