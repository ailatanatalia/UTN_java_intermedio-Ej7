package Vista;

import com.controllers.Controllers;
import com.modelos.Consumidor;
import com.modelos.Prestador;
import com.modelos.Servicio;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Satan
 */
public class Vista {
    
    public void Correr(){
    
        Scanner scanner = new Scanner(System.in);
        while (true) {
        System.out.println("Elija que quiere entidad quiere manejar:");
        System.out.println("1. Prestador");
        System.out.println("2. Consumidor");
        System.out.println("3. Servicio");
        System.out.println("4. Salir");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                crud(scanner, "prestador");
                break;
            case 2:
                crud(scanner, "consumidor");
                break;
            case 3:
                crud(scanner, "servicio");
                break;
            case 4:
                System.out.println("salir");
                System.exit(0);
            default:
                System.out.println("ingresar una opción válida");
            }
        }
    }

        public static void crud(Scanner scanner, String objeto){
        Controllers control = new Controllers();
        System.out.println("Elija una opcion");
        System.out.println("1. Ingresar nuevo");
        System.out.println("2. Editar");
        System.out.println("3. Eliminar");
        System.out.println("4. Salir");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                if (objeto.equals("prestador")){
                    ingresarPrestador(control, scanner);
                } else if (objeto.equals("consumidor")){
                    ingresarConsumidor(control, scanner);
                } else {
                    System.out.println("Ingrese id del consumidor");
                    int id_c = scanner.nextInt();
                    System.out.println("Ingrese id del prestador");
                    int id_p = scanner.nextInt();

                    ingresarServicio(control, scanner, id_c, id_p);
                }
                break;
            case 2:
                if (objeto.equals("prestador")){
                    editarPrestador(control, scanner);
                } else if (objeto.equals("consumidor")){
                    editarConsumidor(control, scanner);
                } else {
                    editarServicio(control, scanner);
                }
                break;
            case 3:
                if (objeto.equals("prestador")){
                    eliminarPrestador(control, scanner);
                } else if (objeto.equals("consumidor")){
                    eliminarConsumidor(control, scanner);
                } else {
                    eliminarServicio(control, scanner);
                }
                break;
            case 4:
                System.out.println("salir");
                System.exit(0);
            default:
                System.out.println("ingresar una opción válida");
            }
    }
    
    public static void ingresarPrestador(Controllers control, Scanner scanner){
        System.out.println("Ingrese nombre");
        String nom = scanner.next();
        System.out.println("Ingrese especialidad");
        String esp = scanner.next();
        System.out.println("Ingrese disponibilidad: dias de la semana y horarios");
        String disp = scanner.next();
        System.out.println("Ingrese radio de cobertura respecto de su domicilio");
        int cob = scanner.nextInt();
        System.out.println("Ingrese comentarios sobre su trabajo");
        String com = scanner.next();
        
        Prestador pres = new Prestador(nom, esp, disp, cob, com);
        control.crearPrestador(pres);
        
        System.out.println("Prestador creado");
    }
    
    public static void ingresarConsumidor(Controllers control, Scanner scanner){
        System.out.println("Ingrese nombre");
        String nom = scanner.next();
        System.out.println("Ingrese direccion");
        String dir = scanner.next();
        
        Consumidor con = new Consumidor(nom, dir);
        control.crearConsumidor(con);
        
        System.out.println("Consumidor creado");
    }

    public static void ingresarServicio(Controllers control, Scanner scanner, int id_c, int id_p){
        System.out.println("Ingrese especialidad para el servicio");
        String esp = scanner.next();
        System.out.println("Ingrese tareas a desarrollar");
        String tar = scanner.next();
        System.out.println("Ingrese id precio");
        int pre = scanner.nextInt();

        Consumidor con = control.buscarConsumidor(id_c);
        Prestador pres = control.buscarPrestador(id_p);

        Servicio ser = new Servicio(new Date(), esp, tar, pre, false);
        ser.setConsumidor(con);
        ser.setPrestador(pres);
        control.crearServicio(ser);
        
        System.out.println("Servicio creado");
        
    }
//------------------------------------------------------------------------
    public static void editarPrestador(Controllers control, Scanner scanner){
        System.out.println("ingrese el id del prestador");
        int id = scanner.nextInt();
        Prestador pres = control.buscarPrestador(id);

        while (true) {
        System.out.println("Elija la opcion que quiere editar");
        System.out.println("1. nombre");
        System.out.println("2. especialidad");
        System.out.println("3. disponibilidad");
        System.out.println("4. cobertura");
        System.out.println("5. reputacion");
        System.out.println("6. salir");
        int op = scanner.nextInt();
    
        switch(op){
            case 1:
                System.out.println("ingrese nuevo");
                String nom = scanner.next();
                pres.setNombre(nom);
                break;
            case 2:
                System.out.println("ingrese nuevo");
                String esp = scanner.next();
                pres.setEspecialidad(esp);
                break;
            case 3:
                System.out.println("ingrese nuevo");
                String disp = scanner.next();
                pres.setDisponibilidad(disp);
                break;
            case 4:
                System.out.println("ingrese nuevo");
                int cob = scanner.nextInt();
                pres.setCobertura(cob);
                break;
            case 5:
                System.out.println("ingrese nuevo");
                String rep = scanner.next();
                pres.setReputacion(rep);
                break;
            case 6:
                System.out.println("ingrese nuevo");
                System.out.println("salir");
                System.exit(0);
                break;
        }
        control.editarPrestador(pres);
        System.out.println("Prestador editado");
        }    
    }
    
    public static void editarConsumidor(Controllers control, Scanner scanner){
        System.out.println("ingrese el id del consumidor");
        int id = scanner.nextInt();
        Consumidor con = control.buscarConsumidor(id);

        while (true) {
        System.out.println("Elija la opcion que quiere editar");
        System.out.println("1. nombre");
        System.out.println("2. direccion");
        System.out.println("3. salir");
        int op = scanner.nextInt();
    
        switch(op){
            case 1:
                System.out.println("ingrese nuevo");
                String nom = scanner.next();
                con.setNombre(nom);
                break;
            case 2:
                System.out.println("ingrese nuevo");
                String dir = scanner.next();
                con.setDireccion(dir);
                break;
            case 3:
                System.out.println("ingrese nuevo");
                System.out.println("salir");
                System.exit(0);
                break;
        }
        control.editarConsumidor(con);
        System.out.println("Consumidor editado");
        }    
    }

    public static void editarServicio(Controllers control, Scanner scanner){
        System.out.println("ingrese el id del servicio");
        int id = scanner.nextInt();
        Servicio ser = control.buscarServicio(id);

        while (true) {
        System.out.println("Elija la opcion que quiere editar");
        System.out.println("1. especialidad");
        System.out.println("2. tareas");
        System.out.println("3. precio");
        System.out.println("4. finalizado: true/false");
        System.out.println("5. salir");
        int op = scanner.nextInt();
    
        switch(op){
            case 1:
                System.out.println("ingrese nuevo");
                String esp = scanner.next();
                ser.setEspecialidad(esp);
                break;
            case 2:
                System.out.println("ingrese nuevo");
                String tar = scanner.next();
                ser.setTareas(tar);
                break;
            case 3:
                System.out.println("ingrese nuevo");
                int pre = scanner.nextInt();
                ser.setPrecio(pre);
                break;
            case 4:
                System.out.println("ingrese nuevo");
                boolean fin = scanner.nextBoolean();
                ser.setFinalizado(fin);
                break;
            case 5:
                System.out.println("ingrese nuevo");
                System.out.println("salir");
                System.exit(0);
                break;
        }
        control.editarServicio(ser);
        System.out.println("Servicio editado");
        }    
    }
    
    public static void eliminarPrestador(Controllers control, Scanner scanner){
        System.out.println("ingrese el id del prestador");
        int id = scanner.nextInt();

        control.eliminarPrestador(id);
        System.out.println("Prestador eliminado");
    }
    
    public static void eliminarConsumidor(Controllers control, Scanner scanner){
        System.out.println("ingrese el id del consumidor");
        int id = scanner.nextInt();

        control.eliminarConsumidor(id);
        System.out.println("Consumidor eliminado");
    }
    public static void eliminarServicio(Controllers control, Scanner scanner){
        System.out.println("ingrese el id del servicio");
        int id = scanner.nextInt();

        control.eliminarServicio(id);
        System.out.println("Servicio eliminado");
    }



}
