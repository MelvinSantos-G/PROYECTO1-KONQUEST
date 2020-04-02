
package Mundos;

import Main.Planeta;


public class Agua extends Planeta {
    private final String guerrero = "Nemo";
    private final String tipoPlanet="Agua";
    
    public Agua(){
    }

    public String getGuerrero() {
        return guerrero;
    }
    public String getTipoPlanet() {
        return tipoPlanet;
    }
    public int obtenerCanGuerreros(int inicio) {
        
        return valorPlanetas(12, 23, inicio);
    }

    public int obtenerDineroProducido(int inicio) {
        return valorPlanetas(60, 120, inicio);
    }
    
   
   
    
}
