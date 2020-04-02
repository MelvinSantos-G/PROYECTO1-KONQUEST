
package Mundos;

import Main.Planeta;


public class Tierra extends Planeta {
   
    private final String guerrero = "Mole";
    private final String tipoPlanet="Tierra";

    public Tierra(){
    }

    public String getGuerrero() {
        return guerrero;
    }
    public String getTipoPlanet() {
        return tipoPlanet;
    }   

    public int obtenerCanGuerreros(int inicio) {
        
        return valorPlanetas(15, 25, inicio);
    }

    public int obtenerDineroProducido(int inicio) {
        return valorPlanetas(50, 100, inicio);
    }
    
}
