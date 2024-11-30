package es.jmg;
// Creación de VARIAS CLASES dentro de un mismo archivo java. Sin embargo, habrá tantos .class como clases!!
// Rompe la modularidad de la POO, pero es para probar.

        /* Constructor usado:
         * public GregorianCalendar(int year,
                         int month,
                         int dayOfMonth)
         */
import java.util.Date;
import java.util.GregorianCalendar;  
        // Hereda de Calendar, que contiene el método getTime(); Devuelve un obj de tipo Date
        // GregorianCalendar tiene getTimeZone();
public class EmpleadoMain {

    // En el main de la clase EmpleadoMain, introducimos los datos. En la clase Empleado, los gestionamos.
    public static void main(String[] args) {
        Jefatura jefeRRHH = new Jefatura("Hermenegildo", 65000, 1978, 11, 4);
        jefeRRHH.setIncentivo(2500);
        // Los objetos de tipo jefeRRHH reciben una actualización en su sueldo a través de 'incentivo'
        // Hermenegildo tendrá el campo Id = 0, por ser el primero en crearse. (En reservar memoria), y no Pepe. 
        // Otra cosa es el índice del array.
        
        // Arreglo de empleados con creación de instancias de empleado
        Empleado[] empleado = new Empleado[7];  // Podemos incluir tanto objetos de Empleado como de la subclase Jefatura
        empleado[0] = new Empleado("Pepe", 41000, 1999, 12, 7);
        empleado[1] = new Empleado("Paco", 26000, 1997, 5, 4);
        empleado[2] = new Empleado("Ana", 33000, 2013, 2, 2);
        empleado[3] = new Empleado("Rosa", 44000, 2009, 12, 9);
        empleado[4] = new Empleado("Ignacio"); // Sobrecarga de constructores. Llamamos al 2º constructor
        empleado[5] = jefeRRHH; // Polimorfismo. Principio de sustitución. 
        // Hemos metido en el arreglo una instancia de la subclase, como si fuera un elemento de su padre Empleado.
        // Se puede usar un objeto de una subclase en aquellos lugares del código donde éste espere a la superclase.
        // Otra manera de expresarlo:
        empleado[6] = new Jefatura("Nuria", 66000, 1970, 02, 14);
        // Ahora bien, si quiero aplicarle el incentivo, no puedo porque dentro del arreglo, 
        // Nuria es de la clase 'Empleado'. Necesitaría hacer un casting de objetos.
        Jefatura jefeFinanzas = (Jefatura) empleado[6];
        jefeFinanzas.setIncentivo(1333);  // Total sueldo ini+incentivo = 67333.0
     
        // Subida de suelto del 10% para todos los empleados
        /*
        for (int i=0;i<empleado.length;i++){
            empleado[i].subirSueldo(10);
            //System.out.println(empleado[i].getDatosEmpleado());
            System.out.println(empleado[i].getNombre()+", "+empleado[i].getSueldo());
        }
         */
   
         // O BIEN con for each

        for (Empleado empleadoConcreto : empleado) {
        // El for Each sabe cuándo llamar a getSueldo de Empleado y cuándo al getSueldo de Jefatura (aplicando el incentivo)
        // Es lo que se conoce como ENLAZADO DINÁMICO.
            System.out.print(empleadoConcreto.getNombre()+", sueldo: "+empleadoConcreto.getSueldo());
            empleadoConcreto.subirSueldo(10);
            System.out.println(" .Sueldo con el aumento (10%): "+empleadoConcreto.getSueldo()) ;
        }

            
        System.out.println("\nSueldo del jefe "+jefeRRHH.getNombre()+" con incentivo y con el aumento: "+jefeRRHH.getSueldo()) ;
        System.out.println("\nSueldo del jefe "+jefeFinanzas.getNombre()+" con incentivo y con el aumento: "+jefeFinanzas.getSueldo()) ;
    }
}

class Empleado{
    // Variables de clase. Privadas para encapsularlas. Que se modifiquen a través de setters
    private final String nombre; //Una vez dado el valor inicial con es constructor, con el 'final' ya no podrá cambiar.
    private double sueldo;
    private Date fechaAltaContrato;
    private int IdEmpleado;
    public static int IdSiguiente; // Para incrementar el Id con cada nueva alta. Statis=> es de la clase,
                                    // no de las instancias


    // Método constructor de la clase Empleado. Público, para poder ser invocado desde otras clases
    public Empleado( String nombre, double sueldo, int anno, int mesAlta, int diaAlta){
        this.nombre = nombre;
        this.sueldo = sueldo;
        GregorianCalendar calendario = new GregorianCalendar(anno, mesAlta-1,diaAlta);
        // Le pasamos mesAlta - 1, porque esta clase indexa del [0-11].
        this.fechaAltaContrato = calendario.getTime();  // getTime devuelve tipo Date. 
                                                    // fechaAltaContrato definida como Date
        this.IdEmpleado=IdSiguiente; // IdSiguiente es estática, es decir, pertenece a la clase no al obje to.
        IdSiguiente+=1; 
    }
    // 2º CONSTRUCTOR. Sobrecarga de constructores. Para poder dar otros valores iniciales.
    // Por ejemplo, desconocemos alguno de los datos a la hora de dar de alta a un empleado.
    public Empleado( String nombre){
        //this.nombre = nombre;  // Pero sueldo y fecha de alta quedarían como 0 y null.
        // OTRO USO del this es el de llamar a otro constuctor con el nº de parámetros que 
        // le estemos pasando ****************
        // sueldo y fechaAlta por defecto cuando no los conozcamos
        this(nombre, 30000, 2024,01,01); 

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

class Jefatura extends Empleado{
    
    // constructor
    public Jefatura(String nombre, double sueldo, int annoAlta, int mesAlta, int diaAlta){
        // Llamada al constructor padre. Esta vez con parámetros, no como en el ejemplo de la furgoneta.
        super(nombre, sueldo, annoAlta, mesAlta, diaAlta);
    }
    // La particularidad de la Jefatura respecto al resto de los empleados. Incentivos.
    private double incentivo;

    public void setIncentivo(double incentivo) {  // setter del incentivo
        this.incentivo = incentivo;
    }
    // Vamos a sobreescribir el método getSueldo adaptándolo a Jefatura. (Incluyendo 'incentivo')
    public double getSueldo(){
        double sueldoJefe = super.getSueldo();
        return sueldoJefe+this.incentivo;  // OJO al super. Si ponemos this estaríamos retrollamándonos
    }
}



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

    /*
     * 
    // Crearemos un arreglo que contenga a los empleados.
    // Del mismo modo que declaramos un arreglo de tipo entero int[] numeros = new int[5]; 
    // (o de la clase) String[] cadena = new String[4]; o String[] cadena = {"Pepe","Lolo","José","María"}; 
    // creamos un arreglo de la clase Empleados. Contendrá sus instancias de clase u objetos.
    // NO CONFUNDIR declaración de una instancia con la de un arreglo
    // = new Empleado();  Llama al método constructor.Paréntesis  -- = new Empleado[4]; Corchetes
     */


     /*
      * En Java, un atributo estático es un miembro de una clase que pertenece a la propia clase en lugar
        de a las instancias (objetos) de esa clase. Los atributos estáticos se comparten entre todas las
        instancias de la clase y pueden ser accedidos sin necesidad de crear un objeto de esa clase.
      */