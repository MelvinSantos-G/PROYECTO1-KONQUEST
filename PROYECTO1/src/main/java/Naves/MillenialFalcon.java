
package Naves;

import Main.Nave;


public class MillenialFalcon extends Nave{
    private final int lugares = 58;
    private final int costoConstruir = 70;
    private final double distaRecorrida = 1.5;

    public MillenialFalcon() {
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
