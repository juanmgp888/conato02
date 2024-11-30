package es.jmg;

public class Furgoneta extends Coche{
    // Clase Furgoneta hereda los atributos, métodos y contructores de Coche. Ahora, clase 'super' Coche
    // Sus atributos particulares
    private int capacidadCarga;
    private int plazasExtra;

    // Constructor
    public Furgoneta(int capacidadCarga, int plazasExtra){
        super(); // Llama al constructor padre para darle un estado inicial a Furgoneta. (Sin parámetros en este ej.)
        this.capacidadCarga=capacidadCarga;
        this.plazasExtra=plazasExtra;
    }

    // getter
    public String getDatosFurgoneta(){
        return "La capacidad de carga de la furgoneta es de "+capacidadCarga+" Kg y las plazas extra son: "+plazasExtra;
    }

}
