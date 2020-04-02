
package Naves;

import Main.Nave;


public class StarDestroyer extends Nave {
    private final int lugares = 80;
    private final int costoConstruir = 100;
    private final double distaRecorrida = 1.75;

    public StarDestroyer() {
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
