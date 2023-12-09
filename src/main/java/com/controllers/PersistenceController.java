package com.controllers;

import com.controllers.exceptions.NonexistentEntityException;
import com.modelos.Prestador;
import com.modelos.Consumidor;
import com.modelos.Servicio;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersistenceController {
    PrestadorJpaController preJPA = new PrestadorJpaController();
    ConsumidorJpaController conJPA = new ConsumidorJpaController();
    ServicioJpaController serJPA = new ServicioJpaController();

    //Prestador
    public void crearPrestador(Prestador pre) 
    {
        preJPA.create(pre);
    }

    public void eliminarPrestador(int id) 
    {
        try { 
            preJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarPrestador(Prestador pre) 
    {
        try {
            preJPA.edit(pre);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Prestador buscarPrestador(int id) 
    {
        return preJPA.findPrestador(id);
    }

    public ArrayList<Prestador> listaPrestador() 
    {
        List<Prestador> listaTemp = preJPA.findPrestadorEntities();
        ArrayList<Prestador> lista = new ArrayList(listaTemp);
        return lista;
    }

//Consumidor
    public void crearConsumidor(Consumidor con) {
        conJPA.create(con);
    }

    public void eliminarConsumidor(int id) {
        try { 
            conJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }    }

    public void editarConsumidor(Consumidor con) {
        try { 
            conJPA.edit(con);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }    }

    public Consumidor buscarConsumidor(int id) {
        return conJPA.findConsumidor(id);
    }

    public ArrayList<Consumidor> listaConsumidor() {
        List<Consumidor> listaTemp = conJPA.findConsumidorEntities();
        ArrayList<Consumidor> lista = new ArrayList(listaTemp);
        return lista;    }

//Servicio
    public void crearServicio(Servicio ser) {
        serJPA.create(ser);
    }

    public void eliminarServicio(int id) {
        try { 
            serJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }    }

    public void editarServicio(Servicio ser) {
        try { 
            serJPA.edit(ser);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }    }

    public Servicio buscarServicio(int id) {
        return serJPA.findServicio(id);
    }

    public ArrayList<Servicio> listaServicio() {
        List<Servicio> listaTemp = serJPA.findServicioEntities();
        ArrayList<Servicio> lista = new ArrayList(listaTemp);
        return lista;    
    }
}
