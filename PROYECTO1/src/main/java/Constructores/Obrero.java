
package Constructores;

import Main.Trabajador;


public class Obrero extends Trabajador{
    private final int tardaConstruir = 3;
    private final int precioTienda = 50;
    private final int ventaTienda = 40;
    private final String navecontruye = "NABOO N-1";

    public Obrero() {
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
