
package Constructores;

import Main.Trabajador;


public class MaestroObra extends Trabajador {
    private final int tardaConstruir = 2;
    private final int precioTienda =100 ;
    private final int ventaTienda = 70;
    private final String navecontruye = "X-WING";

    public MaestroObra() {
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
