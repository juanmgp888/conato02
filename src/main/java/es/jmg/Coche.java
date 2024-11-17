package es.jmg;

public class Coche {
    private int ruedas;
    private int largo; // en cm
    private int ancho; // en cm
    private int motor; // cm.cúbiccos (cc)
    private int pesoPlataforma; // la base común a distintos modelos
    private int pesoTotal;
    private String color;
    boolean asientosCuero, climatizador;

    // Método constructor para fijar valores iniciales
    public Coche(){
        ruedas = 4;
        largo = 500;
        ancho = 300;
        motor = 1600;
        pesoPlataforma = 500; // base del coche, común en varios modelos
    }
    
    public String getPesoFinalCoche(){
        int pesoCarroceria = 550;
        this.pesoTotal = pesoPlataforma+ pesoCarroceria;
        if (asientosCuero==true){
            this.pesoTotal+=50;
        }
        if (climatizador==true){
            this.pesoTotal+=25;
        }
        return "El peso final del coche incluyen los extras es de: "+this.pesoTotal+" Kg";
    }
    public int getPrecioCoche(){
        int precioFinal = 20000; // precio base
        // Sumamos los extras:
        if (asientosCuero==true){
            precioFinal += 1100;
        }
        if (climatizador==true){
            precioFinal += 1600;
        }
        // En la declaración del método le hemos dicho que tiene
        // que devolver un dato de tipo entero.
        return precioFinal;
    }


    // Getters y Setters al final del código
    public String getDatosGenerales(){
        return "El coche tiene "+ruedas+" ruedas, mide "+largo+" cm de largo, \n"+
        ancho+" cm de ancho y con un motor de "+motor+" cc.\n"+"Es de color "+color+
        ". "+hasClimatizador()+" "+hasAsientosCuero();
    }

    public int getPesoTotal() {
        return pesoTotal;
    }

    public void setPesoTotal(int pesoTotal) {
        this.pesoTotal = pesoTotal;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    // is o has es una convención
    public String hasAsientosCuero() {  // Getter
        if (asientosCuero==true){
        return "El coche tiene asientos de cuero.";
        } else {
        return "El coche no tiene asientos de cuero, son de serie.";   
        }
    }

    public void setAsientosCuero(String asientosCuero) {
        if (asientosCuero.equalsIgnoreCase("si")){ // Las cadenas no se comparan con '=='
        this.asientosCuero = true;
        } else { this.asientosCuero=false;}
    }

    public String hasClimatizador() {
        if (climatizador==true){
        return "El coche tiene climatizador.";
        } else {
        return "El coche no tiene climatizador.";
        }
    }

    public void setClimatizador(String climatizador) {
        if (climatizador.equalsIgnoreCase("si")){
        this.climatizador = true;
        } else {this.climatizador=false;}
    }

    public int getRuedas() {
        return ruedas;
    }

    public int getLargo() {
        return largo;
    }

    public int getAncho() {
        return ancho;
    }

    public int getMotor() {
        return motor;
    }

    public int getPesoPlataforma() {
        return pesoPlataforma;
    }

    public void setRuedas(int ruedas) {
        this.ruedas = ruedas;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public void setMotor(int motor) {
        this.motor = motor;
    }

    public void setPesoPlataforma(int pesoPlataforma) {
        this.pesoPlataforma = pesoPlataforma;
    }
    


}
