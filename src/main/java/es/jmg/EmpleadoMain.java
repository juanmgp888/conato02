package es.jmg;
// Creación de varias clases dentro de un mismo archivo java. Sin embargo, habrá tantos .class como clases!!
// Rompe la modularidad de la POO, pero es para probar.

        /* Constructor usado:
         * public GregorianCalendar(int year,
                         int month,
                         int dayOfMonth)

         */


import java.util.Date;
import java.util.GregorianCalendar;  // Hereda de Calendar, que contiene el método getTime(); Devuelve un obj de tipo Date
                                     // GregorianCalendar tiene getTimeZone();

public class EmpleadoMain {

    // En el main de la clase EmpleadoMain, introducimos los datos. En la clase Empleado, los gestionamos.
    public static void main(String[] args) {

    /* versión primera (sin array y sin campo estático Id)
        Empleado empleado1 = new Empleado("Pepe", 41000, 1999, 12, 7);
        Empleado empleado2 = new Empleado("Paco", 26000, 1997, 5, 4);
        Empleado empleado3 = new Empleado("Ana", 33000, 2013, 2, 2);
        Empleado empleado4 = new Empleado("Rosa", 44000, 2009, 12, 9);

        System.out.println(empleado1.getNombre()+", sueldo bruto anual: "+empleado1.getSueldo());    
        empleado.subirSueldo(5);    
        System.out.println(empleado1.getNombre()+", sueldo tras subida >>> "+empleado1.getSueldo());    
 
        System.out.println(empleado2.getNombre()+", sueldo bruto anual: "+empleado2.getSueldo()+
        " Euros. \n     Fecha de alta: "+empleado2.getFechaAltaContrato());  //getter        

        System.out.println(empleado3.getNombre()+", sueldo bruto anual: "+empleado3.getSueldo()+
        " Euros. \n     Fecha de alta: "+empleado3.getFechaAltaContrato());  //getter
        empleado3.subirSueldo(10);   // setter, no devuelve valor
        
        System.out.println(empleado3.getNombre()+", sueldo tras subida >>> "+empleado3.getSueldo());    
        
        System.out.println(empleado4.getNombre()+", sueldo bruto anual: "+empleado4.getSueldo()+
        " Euros. \n     Fecha de alta: "+empleado3.getFechaAltaContrato());  //getter

    */

    // versión mejorada
    // Crearemos un arreglo que contenga a los empleados.
    // Del mismo modo que declaramos un arreglo de tipo entero int[] numeros = new int[5]; 
    // (o de la clase) String[] cadena = new String[4]; o String[] cadena = {"Pepe","Lolo","José","María"}; 
    // creamos un arreglo de la clase Empleados. Contendrá sus instancias de clase u objetos.
    // NO CONFUNDIR declaración de una instancia con la de un arreglo
    // = new Empleado();  Llama al método constructor.Paréntesis  -- = new Empleado[4]; Corchetes
    Empleado[] empleado = new Empleado[4];
        empleado[0] = new Empleado("Pepe", 41000, 1999, 12, 7);
        empleado[1] = new Empleado("Paco", 26000, 1997, 5, 4);
        empleado[2] = new Empleado("Ana", 33000, 2013, 2, 2);
        empleado[3] = new Empleado("Rosa", 44000, 2009, 12, 9);
    // con un for tradicional
        for (int i=0;i<empleado.length;i++){
            empleado[i].subirSueldo(10);
            System.out.println(empleado[i].getDatosEmpleado());
            
        }

    // con for each
        for (Empleado empleadoConcreto : empleado) {
            System.out.println(empleadoConcreto.getNombre()+", sueldo: "+empleadoConcreto.getSueldo());
            
            empleadoConcreto.subirSueldo(10);
            System.out.println("Sueldo con el aumento: "+empleadoConcreto.getSueldo()) ;
        }
        
    }
}



class Empleado{
    // Variables de clase. Privadas para encapsularlas. Que se modifiquen a través de setters
    private final String nombre; //Una vez dado el valor inicial con es constructor, con el 'final' ya no podrá cambiar.
    private double sueldo;
    private Date fechaAltaContrato;
    private int IdEmpleado;
    public static int IdSiguiente; // Para incrementar el Id con cada nueva alta.


    // Método constructor de la clase Empleado. Público, para poder ser invicado desde otras clases
    public Empleado( String nombre, double sueldo, int anno, int mesAlta, int diaAlta){
        this.nombre = nombre;
        this.sueldo = sueldo;
        GregorianCalendar calendario = new GregorianCalendar(anno, mesAlta-1,diaAlta);
        // Le pasamos mesAlta - 1, porque esta clase indexa del [0-11].
        this.fechaAltaContrato = calendario.getTime();  // getTime devuelve tipo Date. fechaAltaContrato definida como Date
        this.IdEmpleado=IdSiguiente; // IdSiguiente es estática
        IdSiguiente+=1; 
    }

    public void subirSueldo(int porcentaje){  // setter
        double aumento = sueldo * porcentaje / 100;
        sueldo +=aumento;
    }
    public String getDatosEmpleado(){
        return "Id: "+IdEmpleado+", "+nombre+" , sueldo: "+sueldo+" , alta contrato: "+fechaAltaContrato;
    }
        

    public String getNombre() {
        return nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public Date getFechaAltaContrato() {
        return fechaAltaContrato;
    }
}