package com.modelos;
/**
 *
 * @author Satan
 */
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "consumidor")
public class Consumidor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int consumidor_id;
    
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "direccion")
    private String direccion;
    
    @OneToMany(mappedBy = "consumidor", cascade = CascadeType.ALL)
    private List<Servicio> servicios;
    
//constructor
    public Consumidor() {
    }
    public Consumidor(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

//getters and setters
    public int getConsumidor_id() {
        return consumidor_id;
    }
    public void setConsumidor_id(int consumidor_id) {
        this.consumidor_id = consumidor_id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }

    

}
