package com.controllers;

/**
 *
 * @author Satan
 */
import com.modelos.Prestador;
import com.modelos.Consumidor;
import com.modelos.Servicio;
import java.util.ArrayList;

public class Controllers {
PersistenceController control = new PersistenceController(); 

//Prestador
    public void crearPrestador(Prestador pres)
    {
        control.crearPrestador(pres);
    }
    
    public void eliminarPrestador(int id)
    {
        control.eliminarPrestador(id);
    }
    
    public void editarPrestador(Prestador pres)
    {
        control.editarPrestador(pres);
    }

    public Prestador buscarPrestador(int id)
    {
       Prestador pres = new Prestador();
       pres = control.buscarPrestador(id);
       return pres; 
    }

    public ArrayList<Prestador> listaPrestador()
    {
       ArrayList <Prestador> prestador = new ArrayList();
       prestador = control.listaPrestador();
       return prestador; 
    }
    
//Consumidor
    public void crearConsumidor(Consumidor con)
    {
        control.crearConsumidor(con);
    }
    
    public void eliminarConsumidor(int id)
    {
        control.eliminarConsumidor(id);
    }
    
    public void editarConsumidor(Consumidor con)
    {
        control.editarConsumidor(con);
    }

    public Consumidor buscarConsumidor(int id)
    {
       Consumidor con = new Consumidor();
       con = control.buscarConsumidor(id);
       return con; 
    }

    public ArrayList<Consumidor> listaConsumidor()
    {
       ArrayList <Consumidor> consumidor = new ArrayList();
       consumidor = control.listaConsumidor();
       return consumidor; 
    }

//Servicio
    public void crearServicio(Servicio ser)
    {
        control.crearServicio(ser);
    }
    
    public void eliminarServicio(int id)
    {
        control.eliminarServicio(id);
    }
    
    public void editarServicio(Servicio ser)
    {
        control.editarServicio(ser);
    }

    public Servicio buscarServicio(int id)
    {
       Servicio ser = new Servicio();
       ser = control.buscarServicio(id);
       return ser; 
    }

    public ArrayList<Servicio> listaServicio()
    {
       ArrayList <Servicio> servicio = new ArrayList();
       servicio = control.listaServicio();
       return servicio; 
    }
    
}

    

