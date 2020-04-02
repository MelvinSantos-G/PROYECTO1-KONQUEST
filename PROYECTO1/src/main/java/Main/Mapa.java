package Main;

import java.util.Scanner;

/**
 *
 * @author melvin
 */
public class Mapa {

    Scanner entrada = new Scanner(System.in);
    private int filas;
    private int columnas;
    private int planetNeutral;
    private double distancia_planetas;
    private String[][] datos[];
    
    private final String ANSI_RESET = "\u001B[0m";
    private final String GREEN = "\u001B[32m";
    private final String RED = "\u001B[31m";
    private final String BLACK = "\u001B[40m";
    private final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    private final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    private final String ANSI_RED_BACKGROUND = "\u001B[41m";
    
    
    Jugador datoJugador1 = new Jugador();
    Planeta datoPlaneta1 = new Planeta();
    Principal decision = new Principal();
    
    /**
     *constructor
     */
    public Mapa() {
    }

    /**
     *
     * @return
     */
    public double getDistancia_planetas() {
        return distancia_planetas;
    }

    /**
     *
     * @return
     */
    public int getFilas() {
        return filas;
    }

    /**
     *
     * @return
     */
    public int getColumnas() {
        return columnas;
    }

    /**
     *
     * @return
     */
    public String[][][] getDatos() {
        return datos;
    }
    
    /**
     *solicita nombre a los usuario y solicita las dimensiones del mapa al igual que los planetas
     * y los datos de cada planete que estaran dentro de dicho Mapa
     */
    public void generarMapa() {        
        datoJugador1.pedirNombreUsuario();
        System.out.println("\n"+GREEN+"         \\---------DISEÑO DE MAPA--------/ \n"+ANSI_RESET);
        ingresarTamañoMapa();
        ingresarDatosPlanetJugador();
        ingresarDatoPlanetNeutro();
        imprimirPlaneta();            
    }
    
    private void ingresarTamañoMapa() {
        pedirfilas();
        pedircolumnas();
        pedirNumPlanNeu();
    }

    private void ingresarDatosPlanetJugador() {
        
        datos = new String[filas][columnas][12];
        System.out.println("\n" + GREEN + "** INGRESAR LOS DATOS DEL PLANETA DE CADA JUGADOR **\n" + ANSI_RESET);
        for (int i = 0; i < 2; i++) {
            int fil = valoresAleatorios(filas);
            int colum = valoresAleatorios(columnas);
            if (i == 0) {
                datos[fil][colum][11] = ANSI_RED_BACKGROUND;
            } else {
                datos[fil][colum][11] = ANSI_BLUE_BACKGROUND;
            }
            if (decidirAleatorio(datoJugador1.getNombre_jugador(i)) == 's') {
                datoPlaneta1.ingresarDatosUsuario(i+1);                
            } else {
                datoPlaneta1.generarValoresAleatorios();
            }
            
            rellenarDatos(fil, colum, i,datoJugador1.getNombre_jugador(i) );
        }
    }
    
    /*
    *el usuario ingresa los datos de sus planetas o si desea que se generen de forma aleatoria
    */
    private void ingresarDatoPlanetNeutro() {
        System.out.println("\n" + GREEN + "** INGRESAR LOS DATOS DE CADA PLANETA NEUTRO **\n" + ANSI_RESET);
        int number=0;
        if (decidirAleatorio("Jugador") == 's') {
            number =decidirNumPlanetNeutro();
        }
        
        for (int i = 0; i < number; i++) {
            int fil = valoresAleatorios(filas);
            int colum = valoresAleatorios(columnas);
             if (datos[fil][colum][0] == null) {
                datoPlaneta1.ingresarDatosUsuario(i+1);
                rellenarDatos(fil, colum, i,"NEUTRO" );               
                datos[fil][colum][11] = ANSI_PURPLE_BACKGROUND;
            } else {
                i--;
            }            
        }
        for (int i = 0; i < planetNeutral-number; i++) {
            int fil = valoresAleatorios(filas);
            int colum = valoresAleatorios(columnas);
            if (datos[fil][colum][0] == null) {
                datoPlaneta1.generarValoresAleatorios();
                rellenarDatos(fil, colum, i,"NEUTRO" );
                datos[fil][colum][11] = ANSI_PURPLE_BACKGROUND;
            } else {
                i--;
            }
        }
        
    }   

    /**
     *implime el mapa que se usara duarante el juego
     */
    public void imprimirPlaneta() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < columnas; j++) {
                if (i == 0 && j == 0) {
                    System.out.print(" _____");
                }
                if (i == 1 && j == 0) {
                    System.out.print("\n|_____|");
                }
                if (i == 0) {
                    System.out.print(" _________________");
                } else {
                    char letra = (char) (65 + j);
                    System.out.print("________" + letra + "________|");
                }
            }
        }
        for (int k = 0; k < filas; k++) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < columnas; j++) {
                    String nombre = datos[k][j][0];
                    if (j == 0) {
                        switch (i) {
                            case (0):
                                System.out.print("\n|     |");
                                break;
                            case (1):
                                //if (k < 9) {
                                    System.out.print("\n|  " + (k + 1) + "  |");
                                /*} else {
                                    System.out.print("\n|  " + (k + 1) + " |");
                                }*/
                                break;
                            default:
                                System.out.print("\n|_____|");
                        }
                    }
                    if (nombre != null) {
                        nombre = "Nombre: " + datos[k][j][0];
                        String dueño = "Dueño: " + datos[k][j][1];
                        String color = datos[k][j][11];
                        switch (i) {
                            case (0):
                                dibujarPlanetas(nombre, color);
                                break;
                            case (1):
                                dibujarPlanetas(dueño, color);
                                break;
                            default:
                                System.out.print(color + "                  " + ANSI_RESET);
                        }
                    } else {
                        System.out.print("                  ");
                    }
                }
            }
        }
        System.out.println(BLACK+"\n");
        
    }

    private int valoresAleatorios(int numero) {
        int valor = (int) ((Math.random() * numero));
        //System.out.println(valor);
        return valor;
    }

    private void dibujarPlanetas(String palabra, String color) {
        System.out.print(color + palabra + ANSI_RESET);
        for (int i = 0; i < 18 - palabra.length(); i++) {
            System.out.print(color + " " + ANSI_RESET);
        }
    }
    

    private void pedirfilas() {
        System.out.print("\ningrese el numero de filas del mapa entre(2---9) : ");
        filas = entrada.nextInt();
        if (filas < 2 || filas >= 10) {
            System.out.println("");
            decision.mostrarError(1);
            System.out.println("");
            pedirfilas();
        }
    }

    private void pedircolumnas() {
        System.out.print("ingrese el numero de columnas del mapa entre(2---26) : ");
        columnas = entrada.nextInt();
        if (columnas < 2 || columnas >= 27) {
            decision.mostrarError(1);
            pedircolumnas();
        }
    }

    private void pedirNumPlanNeu() {
        System.out.print("ingrese el numero de Planetas Neutrales del mapa entre(depende del tamaño del mapa) : ");
        planetNeutral = entrada.nextInt();
        if (planetNeutral < 1 || planetNeutral > (filas * columnas) - 2) {
            System.out.println("\n");
            decision.mostrarError(1);
            System.out.println("");
            pedirNumPlanNeu();
        }

    }
    
    private int decidirNumPlanetNeutro(){
        System.out.print("\nA cuantos planetas Neutros deseas ingresarles sus datos (son "+planetNeutral+" planetas): ");
        int planetN= entrada.nextInt();
        if (planetN<=0||planetN>=planetNeutral+1) {
            decision.mostrarError(1);
            return decidirNumPlanetNeutro();
        }
        return planetN;
    }
    //se rellanan todos los datos de cada planeta
    private void rellenarDatos(int fil, int colum, int i, String dueño){
        datos[fil][colum][0] = datoPlaneta1.getNombrePlaneta();
        datos[fil][colum][1] = dueño;
        datos[fil][colum][2] = datoPlaneta1.getTipoPlaneta();
        datos[fil][colum][3] = datoPlaneta1.getNomGuerrero();
        datos[fil][colum][4] = Integer.toString(datoPlaneta1.getNumGuerreros());
        datos[fil][colum][5] = datoPlaneta1.getTipoNave();
        datos[fil][colum][6] = Integer.toString(datoPlaneta1.getNumNaves());
        datos[fil][colum][7] = datoPlaneta1.getTipoconstructor();
        datos[fil][colum][8] = Integer.toString(datoPlaneta1.getNumConstructores());
        datos[fil][colum][9] = Integer.toString(datoPlaneta1.getDinero());
        datos[fil][colum][10] = Double.toString(datoPlaneta1.getPorcenMuerte());
    }
    
    private char decidirAleatorio(String name){        
        System.out.println("\n"+name+" deseas ingresar los datos tu o se ingresaran por defecto.");
        System.out.println("Ingresar los datos yo ------------(presiona 's')");
        System.out.println("ingresar los datos por defecto ---(presiona 'n')");
        System.out.print("ingresa tu decision: ");
        char decidir = entrada.next().toLowerCase().charAt(0);
        switch(decidir){
            case ('s'): 
            case ('n'):
                break;
            default: 
                
                decidirAleatorio(name);
        }
        return decidir;
    }

    /**
     *verifica si el planeta existe en las coordenadas ingresadas
     * @param x
     * @param y
     * @return
     */
    public boolean verificarPosicion(int x, int y){
        if (datos[x][y][0]!=null) {
            System.out.println( RED+"No existe un planeta en esta posicion "+x+(char)(y+65)+ANSI_RESET);//System.out.println("Posicion valida "+x+(char)(y+65));
            return false;
        }        
        return true;
    }

    /**
     *
     */
    public void medirDistancia(){
        System.out.print("\nIngresa las coorenadas de los planetas, con espacios y separado por coma (ej: 1 A , 2 B): ");
        char x1= entrada.next().toUpperCase().charAt(0);
        
        char y1= entrada.next().toUpperCase().charAt(0);
        char coma = entrada.next().charAt(0);
        char x2 = entrada.next().toUpperCase().charAt(0);
        char y2 = entrada.next().toUpperCase().charAt(0);
        if (coma !=',') {
            decision.mostrarError(0);
            medirDistancia();
        }        
        double X1=(int)(x1)-49;
        double Y1=(int)(y1)-65;
        double X2 =(int)(x2)-49;
        double Y2 = (int)(y2)-65;
                
        distancia_planetas=Math.sqrt(Math.pow((x1-x2),2)+Math.pow((y1-y2),2));
    }
}