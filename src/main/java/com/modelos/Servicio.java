package com.modelos;

/**
 *
 * @author Satan
 */
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "servicio")
public class Servicio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int servicio_id;
    
    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha")
    private Date date;
    @Column(name = "especialidad")
    private String especialidad;
    @Column(name = "tareas")
    private String tareas;
    @Column(name = "precio")
    private float precio;
    @Column(name = "finalizado")
    private boolean finalizado;

    @ManyToOne
    @JoinColumn(name = "prestador_id")//, referencedColumnName="prestador_id")
    private Prestador prestador;
    @ManyToOne
    @JoinColumn(name = "consumidor_id")//, referencedColumnName="consumidor_id")
    private Consumidor consumidor;
    
//constructores
    public Servicio() {
    }

    public Servicio(Date date, String especialidad, String tareas, float precio, boolean finalizado) {
        this.date = date;
        this.especialidad = especialidad;
        this.tareas = tareas;
        this.precio = precio;
        this.finalizado = finalizado;
    }
    
//getters and setters
    public int getServicio_id() {
        return servicio_id;
    }
    public void setServicio_id(int servicio_id) {
        this.servicio_id = servicio_id;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public boolean isFinalizado() {
        return finalizado;
    }
    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }
    public String getTareas() {
        return tareas;
    }
    public void setTareas(String tareas) {
        this.tareas = tareas;
    }
    public float getPrecio() {
        return precio;
    }
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    public Prestador getPrestador() {
        return prestador;
    }
    public void setPrestador(Prestador prestador) {
        this.prestador = prestador;
    }
    public Consumidor getConsumidor() {
        return consumidor;
    }
    public void setConsumidor(Consumidor consumidor) {
        this.consumidor = consumidor;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
   
}

