package es.jmg;


public class VehiculoMain {

    public static void main(String[] args) {

      Coche coche01 = new Coche();
      coche01.setColor("amarillo");
      System.out.println(coche01.getDatosGenerales()+"El coche es de color "+coche01.getColor()+".\n");

      Furgoneta furgo01 = new Furgoneta(1200, 3);
      furgo01.setColor("rojo"); // Hereda setColor de la clase Coche
      furgo01.setAsientosCuero("Si");
      furgo01.setClimatizador("Si");
      System.out.println(furgo01.getDatosGenerales()+furgo01.getDatosFurgoneta()); // DatosGenerales vía herencia

      
    }

}

  // import javax.swing.JOptionPane;
  // versión anterior, previa a la creación de Furgoneta y la herencia
     /*   Coche renault21 = new Coche(); // instanciamos la clase coche. Creamos un ejemplar: renault21
        // Ahora ya podemos acceder a sus propiedades y métodos.
      
        renault21.setColor("azul");
      //  renault21.setClimatizador("si");
        renault21.setClimatizador(JOptionPane.showInputDialog("¿Tiene climatizador?: 'Si'/'No'"));
        renault21.setAsientosCuero(JOptionPane.showInputDialog("¿Tiene asientos de cuero?: 'Si'/'No'"));
        System.out.println("Datos generales del coche: \n"
        +renault21.getDatosGenerales());
        System.out.println(renault21.getPesoFinalCoche());
        System.out.println("El precio final del coche es: "+renault21.getPrecioCoche()+" Euros.");

     */