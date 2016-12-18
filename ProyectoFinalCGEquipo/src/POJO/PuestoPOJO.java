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
public class PuestoPOJO {
    
    private int idPuesto;
    private String nombre_puesto;
    private String descripcion_puesto;

    @Override
    public String toString() {
        return nombre_puesto; //To change body of generated methods, choose Tools | Templates.
    }
    
    

    public int getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(int idPuesto) {
        this.idPuesto = idPuesto;
    }

    public String getNombre_puesto() {
        return nombre_puesto;
    }

    public void setNombre_puesto(String nombre_puesto) {
        this.nombre_puesto = nombre_puesto;
    }

    public String getDescripcion_puesto() {
        return descripcion_puesto;
    }

    public void setDescripcion_puesto(String descripcion_puesto) {
        this.descripcion_puesto = descripcion_puesto;
    }
    
}
