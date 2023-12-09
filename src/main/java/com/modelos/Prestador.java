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
@Table(name = "prestador")
public class Prestador implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int prestador_id;
    
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "especialidad")
    private String especialidad;
    @Column(name = "disponibilidad")
    private String disponibilidad;
    @Column(name = "cobertura")
    private int cobertura;
    @Column(name = "reputacion")
    private String reputacion;
    @Column(name = "comentarios")
    private String comentarios;
    
    @OneToMany(mappedBy = "prestador", cascade = CascadeType.ALL)
    private List<Servicio> servicios;


//constructores
    public Prestador() {}
    
    public Prestador(String nombre, String especialidad, String disponibilidad, int cobertura, String comentarios) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.disponibilidad = disponibilidad;
        this.cobertura = cobertura;
        this.comentarios = comentarios;
    }
    
//getters and setters

    public int getPrestador_id() {
        return prestador_id;
    }
    public void setPrestador_id(int prestador_id) {
        this.prestador_id = prestador_id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    public String getDisponibilidad() {
        return disponibilidad;
    }
    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
    public int getCobertura() {
        return cobertura;
    }
    public void setCobertura(int cobertura) {
        this.cobertura = cobertura;
    }
    public String getReputacion() {
        return reputacion;
    }
    public void setReputacion(String reputacion) {
        this.reputacion = reputacion;
    }
    public String getComentarios() {
        return comentarios;
    }
    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
    

    
}
