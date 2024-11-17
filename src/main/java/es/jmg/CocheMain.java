package es.jmg;
import javax.swing.JOptionPane;

public class CocheMain {

    public static void main(String[] args) {
        Coche renault21 = new Coche(); // instanciamos la clase coche. Creamos un ejemplar: renault21
        // Ahora ya podemos acceder a sus propiedades y métodos.
      
        renault21.setColor("azul");
      //  renault21.setClimatizador("si");
        renault21.setClimatizador(JOptionPane.showInputDialog("¿Tiene climatizador?: 'Si'/'No'"));
        renault21.setAsientosCuero(JOptionPane.showInputDialog("¿Tiene asientos de cuero?: 'Si'/'No'"));
        System.out.println("Datos generales del coche: \n"
        +renault21.getDatosGenerales());
        System.out.println(renault21.getPesoFinalCoche());
        System.out.println("El precio final del coche es: "+renault21.getPrecioCoche()+" Euros.");
    }
}