

package Main;

import static Main.Principal.entrada;
import javax.swing.JOptionPane;

public class Jugador {  
    
    private final String[] nombre_jugador;
    private int planetasConquistados;
    private final String GREEN = "\u001B[32m";    
    private final String RESET = "\u001B[0m";
    //Mapa mapa =new Mapa();
    //private int turno;
   

    public Jugador() {
        //turno =1;
        nombre_jugador= new String [2];
    }

    public int getPlanetasConquistados() {
        return planetasConquistados;
    }

    public void setPlanetasConquistados(int planetasConquistados) {
        this.planetasConquistados = planetasConquistados;
    }
    

    public String getNombre_jugador(int num) {
        return nombre_jugador[num];
    }
        
    
    public void pedirNombreUsuario(){
        for (int i = 0; i < 2; i++) {
            System.out.print("- Ingresa tu nombre jugador "+(i+1)+" : ");
            nombre_jugador[i]=entrada.next().toUpperCase();
        }       
    }
    
    public void controlarTurno(int turno){
        
        for (int i = 0; i <2; i++) {
            System.out.println("\n\n"+GREEN+"            /** Turno de "
                        +nombre_jugador[i]+" **\\                No. turno: "+turno+RESET);
            do{
                System.out.println("");               
            }while(mostrarOpciones(nombre_jugador[i])==false);
            
        }
    }
    public void verificarGanador(){
        for (int i = 0; i < 3; i++) {
            controlarTurno(i+1);
        }
    }
    
    public boolean mostrarOpciones(String name){
        Mapa extraer = new Mapa();
        System.out.println(name+" puedes hacer las siguientes acciones:");
        System.out.println("Medir distacia ---------(presiona '1')");
        System.out.println("Terminar turno ---------(presiona '2')");
        System.out.print("Ingresa tu opcion: ");
        char opcion = entrada.next().charAt(0);
        switch(opcion){
            case ('1') :
                extraer.medirDistancia();
                JOptionPane.showMessageDialog(null, "La distancia entre los planetas es de "
                        +extraer.getDistancia_planetas()+" años luz." );
                return mostrarOpciones(name);
            case ('2') :
                return true;                
        }        
        return false;
    }
    
        
    
    
    
    
    
}
