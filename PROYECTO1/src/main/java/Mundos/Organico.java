
package Mundos;

import Main.Planeta;


public class Organico extends Planeta {
        
    private final String guerrero = "Groot";
    private final String tipoPlanet="Organico";
 
    public Organico(){
    }

    public String getGuerrero() {
        return guerrero;
    }
    public String getTipoPlanet() {
        return tipoPlanet;
    }
    public int obtenerCanGuerreros(int inicio) {
        
        return valorPlanetas(5, 15, inicio);
    }

    public int obtenerDineroProducido(int inicio) {
        return valorPlanetas(80, 160, inicio);
    }
    
}
