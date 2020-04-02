
package Mundos;

import Main.Planeta;


public class Radiactivo extends Planeta {
     
    private final String guerrero = "FisionGuy";
    private final String tipoPlanet="Radiactivo";

    public Radiactivo(){
    }

    public String getGuerrero() {
        return guerrero;
    }
    public String getTipoPlanet() {
        return tipoPlanet;
    }
    public int obtenerCanGuerreros(int inicio) {
        
        return valorPlanetas(3, 9, inicio);
    }

    public int obtenerDineroProducido(int inicio) {
        return valorPlanetas(90, 180, inicio);
    }
        
}
