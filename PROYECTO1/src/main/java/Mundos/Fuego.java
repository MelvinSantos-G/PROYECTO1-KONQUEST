
package Mundos;

import Main.Planeta;


public class Fuego extends Planeta {
    
   
    private final String guerrero = "Magma";
    private final String tipoPlanet="Fuego";
    
    public Fuego(){
    }

    public String getGuerrero() {
        return guerrero;
    }
    public String getTipoPlanet() {
        return tipoPlanet;
    }
    public int obtenerCanGuerreros(int inicio) {
        
        return valorPlanetas(10, 20, inicio);
    }

    public int obtenerDineroProducido(int inicio) {
        return valorPlanetas(70, 140, inicio);
    }
}
