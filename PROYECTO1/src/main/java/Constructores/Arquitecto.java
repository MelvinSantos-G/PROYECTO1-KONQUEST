
package Constructores;
 
import Main.Trabajador;


public class Arquitecto extends Trabajador{
    private final int tardaConstruir = 1;
    private final int precioTienda = 250;
    private final int ventaTienda = 175;
    private final String navecontruye = "MILLENIAL FALCON";

    public Arquitecto() {
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
