
package Constructores;

import Main.Trabajador;


public class Ingeniero extends Trabajador{
    private final int tardaConstruir = 1;
    private final int precioTienda = 300;
    private final int ventaTienda = 200;
    private final String navecontruye = "STAR DESTROYER";

    public Ingeniero() {
    }

    @Override
    public int getTardaConstruir() {
        return tardaConstruir;
    }

    @Override
    public int getPrecioTienda() {
        return precioTienda;
    }

    @Override
    public int getVentaTienda() {
        return ventaTienda;
    }

    @Override
    public String getNavecontruye() {
        return navecontruye;
    }
    
}
