
package Main;

import java.util.Scanner;

/**
 *    
 * @author melvin
 */
public class Principal {
    
    static Scanner entrada = new Scanner(System.in);
    private static final String RED = "\u001B[31m";
    //private static final String GREEN = "\u001B[32m";      
    private static final String RESET = "\u001B[0m";
    
    /**
     * clase donde se ejecuta el programa
     * @param args
     */
    public static void main(String [] args){
        Jugador datoJugador = new Jugador();
        Mapa diseñoMapa = new Mapa();
        //inicio del programa y una corta introduccion
        mostrarBienvenida();
        do{
            
            System.out.println("\n");
            // Gererar planetas y mapa.
            diseñoMapa.generarMapa();
            // acciones del jugador
            datoJugador.verificarGanador();
            
                      
        }while (mostrarMenu() == false);
        System.out.println("\n\n");
      
    }
     // muestra las opciones de salida del juego al usuario y devuelve su opcion.
    private static boolean mostrarMenu(){
        char opcion;
        boolean salir;
        
        System.out.print("\n1.- Salir-----------(presiona 's').\n2.- Volver a jugar--(presiona 'v').\n"
                + "Que deseas hacer: ");
        opcion = entrada.next().toLowerCase().charAt(0);
        switch(opcion){
            case('s'): salir=true;
            break;
            case('v'): salir = false;
            break;
            default: 
                System.out.println("\n"+RED+"**ERROR. El caracter ingresado no es correcto.**\n"+RESET);
                salir =mostrarMenu();
        }
        return salir;
    }
    
    private static void mostrarBienvenida(){
        System.out.println("\n****** CHALANA - BOX ******\n\n"
                + "      BIENVENIDO A «KONQUEST»\n"
                + "Es un juego de dos jugadores, el objetivo del juego es conquistar todos\n"
                + "los planetas del mapa antes que tu oponente, para lograrlo hay naves\n"
                + "que transportan guerreros que lucharan hasta conquister el planeta\n"
                + "que quieras, pero ten cuidado los planetas sin conquistar se defenderan\n"
                + "de cualquier ataque. Suerte GUARDIANES ESPACIALES. ");
    }
         
    /**
     *Muestra al usuario errores al ingresar mal los datos ya sea numerico o de tipo caracter
     * @param num
     */
    public void mostrarError(int num){
        if(num==1){
            System.out.println("\n\n"+RED+"**ERROR. El valor ingresado no es correcto.**\n"+RESET);        
        }else{
            System.out.println("\n\n"+RED+"**ERROR. El caracter  ingresado no es valida.**\n"+RESET);
        }
    }   
}
