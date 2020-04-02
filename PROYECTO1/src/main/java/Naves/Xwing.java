
package Naves;

import Main.Nave;


public class Xwing extends Nave {
    
    private final int lugares = 42;
    private final int costoConstruir = 50;
    private final double distaRecorrida = 1.25;

    public Xwing() {
    }

    @Override
    public int getLugares() {
        return lugares;
    }

    @Override
    public int getCostoConstruir() {
        return costoConstruir;
    }

    @Override
    public double getDistaRecorrida() {
        return distaRecorrida;
    }  
    
}
