

package Naves;

import Main.Nave;


public class NabooN1 extends Nave {
    private final int lugares = 25;
    private final int costoConstruir = 40;
    private final double distaRecorrida = 1;

    public NabooN1() {
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
