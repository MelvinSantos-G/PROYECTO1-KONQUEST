
package Main;

import Mundos.Agua;
import Mundos.Fuego;
import Mundos.Organico;
import Mundos.Radiactivo;
import Mundos.Tierra;
import java.util.Scanner;

/**
 *
 * @author melvin
 */
public class Planeta {
    Scanner entrada = new Scanner(System.in);
    private double porcenMuerte;
    private int numGuerreros;
    private int  numConstructores;
    private int  numNaves;
    private String tipoNave;
    private String  color ;
    private String  dueño;
    private String nombrePlaneta;
    private String tipoPlaneta;
    private String nomGuerrero;
    private int dinero;
    private String tipoconstructor;
    Principal error = new Principal();

    /**
     *constructor
     */
    public Planeta() {
        
    }

    /**
     *
     * @return
     */
    public String getTipoNave() {
        return tipoNave;
    }

    /**
     *
     * @param tipoNave
     */
    public void setTipoNave(String tipoNave) {
        this.tipoNave = tipoNave;
    }

    /**
     *
     * @return
     */
    public String getTipoconstructor() {
        return tipoconstructor;
    }

    /**
     *
     * @param tipoconstructor
     */
    public void setTipoconstructor(String tipoconstructor) {
        this.tipoconstructor = tipoconstructor;
    }
           
    /**
     *
     * @return
     */
    public double getPorcenMuerte() {
        return porcenMuerte;
    }

    /**
     *
     * @return
     */
    public int getNumGuerreros() {
        return numGuerreros;
    }

    /**
     *
     * @return
     */
    public int getNumConstructores() {
        return numConstructores;
    }

    /**
     *
     * @return
     */
    public int getNumNaves() {
        return numNaves;
    }

    /**
     *
     * @return
     */
    public String getColor() {
        return color;
    }

    /**
     *
     * @return
     */
    public String getDueño() {
        return dueño;
    }

    /**
     *
     * @return
     */
    public String getNombrePlaneta() {
        return nombrePlaneta;
    }

    /**
     *
     * @return
     */
    public String getTipoPlaneta() {
        return tipoPlaneta;
    }
    
    /**
     *
     * @param numGuuerreros
     */
    public void setNumGuerreros(int numGuuerreros) {
        this.numGuerreros = numGuuerreros;
    }

    /**
     *
     * @param numConstructores
     */
    public void setNumConstructores(int numConstructores) {
        this.numConstructores =numConstructores;
    }

    /**
     *
     * @param numNaves
     */
    public void setNumNaves(int numNaves) {
        this.numNaves = numNaves;
    }

    /**
     *
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     *
     * @param dueño
     */
    public void setDueño(String dueño) {
        this.dueño = dueño;
    }

    /**
     *
     * @param nombrePlaneta
     */
    public void setNombrePlaneta(String nombrePlaneta) {
        this.nombrePlaneta = nombrePlaneta;
    }

    /**
     *
     * @return
     */
    public String getNomGuerrero() {
        return nomGuerrero;
    }

    /**
     *
     * @param nomGuerrero
     */
    public void setNomGuerrero(String nomGuerrero) {
        this.nomGuerrero = nomGuerrero;
    }

    /**
     *
     * @return
     */
    public int getDinero() {
        return dinero;
    }

    /**
     *
     * @param dinero
     */
    public void setDinero(int dinero) {
        this.dinero = dinero;
    }   
    
    /**
     *genera el nombre de cada planeta aleatoriamente
     */
    public void generarNombreplaneta(){
         nombrePlaneta = Character.toString((char)(Math.random()*26+65))
                 +Character.toString((char)(Math.random()*26+65));      
    }
    private void generarPorcentaje(){
        porcenMuerte=(double)(Math.random()*0.9999);
        
    }

    /**
     *se utiliza para generar valores aleatorios que serviran para el dinero generado y los
     * guerreros generados de cada planeta despues de cada turno
     * @param limInferio
     * @param limSuperio
     * @param valorinicial
     * @return
     */
    protected int valorPlanetas(int limInferio, int limSuperio, int valorinicial){
        int valor= valorinicial+(int)(Math.random()*(limSuperio-limInferio)+limInferio);
        return valor;
    }
    
    private void generarDinero(){        
        dinero=(int)(Math.random()*400+100);
    }
    private void generarNumNaves(){
        numNaves= (int)(Math.random()*2+1);
    }

    /**
     *El usuario decide que los datos de cada planeta se generen aleatoriamente
     */
    public void generarValoresAleatorios(){
        aparecerEnMapa();        
        generarPorcentaje();
        numConstructores =1;        
        generarNumNaves();
        generarNombreplaneta();
        generarDinero();        
    }
    private void llenarValores(String tipo, String nom, int num){
        tipoPlaneta= tipo;
        nomGuerrero=nom;
        numGuerreros= num;        
    }
    /* genera un numero aleatorio para ver la posibilidad que aparezca un planeta
    del tipo especificado en cada condicion*/
    private void aparecerEnMapa(){
        int posibilidad = (int)(Math.random()*100);
                
        if (posibilidad <45) {
            //tierra
            Tierra valor =new Tierra();           
            llenarValores(valor.getTipoPlanet(), valor.getGuerrero(), valor.obtenerCanGuerreros(0));
        }
        if (posibilidad<70&&posibilidad>=45) {
           // agua
           Agua valor = new Agua();
           llenarValores(valor.getTipoPlanet(), valor.getGuerrero(), valor.obtenerCanGuerreros(0));
        }
        if (posibilidad>=70&&posibilidad<85) {
         //   fuego
            Fuego valor = new Fuego();
            llenarValores(valor.getTipoPlanet(), valor.getGuerrero(), valor.obtenerCanGuerreros(0));
        }
        if (posibilidad>=85&&posibilidad<95) {
            //organico
            Organico valor = new Organico();           
            llenarValores(valor.getTipoPlanet(), valor.getGuerrero(), valor.obtenerCanGuerreros(0));
        }
        if (posibilidad>=95) {
            //radiactivo
            Radiactivo valor = new Radiactivo();
            llenarValores(valor.getTipoPlanet(), valor.getGuerrero(), valor.obtenerCanGuerreros(0));
        }
        tipoNave = "NABOO N-1";
        tipoconstructor = "OBRERO";
    }  
    private void pedirNombrePlaneta(int num){
        System.out.print("\n"+num+") Ingresa el nombre del planeta : ");
        nombrePlaneta=entrada.next().toUpperCase();
    }
    // solicita la cantidad de dinero al usuario para cada planeta
    private void pedirDineroinicial(int num){
        System.out.print(num+") Con cuanto dinero deseas iniciar (consejo: que sea >Q100): Q ");
        dinero = entrada.nextInt();
        if (dinero<=0) {
            error.mostrarError(1);
            pedirDineroinicial(num);
        }
    }
    //solicita la cantidad de constructores al usuario para el inicio de cada planeta
    private void pedirCantConstruInicio(int num){
        System.out.print(num+") Cuantos contructores quieres (consejo: que sea un numero de una cifra): ");
        numConstructores= entrada.nextInt();
        if (numConstructores<=0) {
            error.mostrarError(1);
            pedirCantConstruInicio(num);
        }
    }
    //solicita la cantidad de naves al usuario para el inicio de cada planeta
    private void pedirCantNavesInicio(int num){
        System.out.print(num+") Cuantas naves quieres (consejo: que sea un numero de una cifra): ");
        numNaves= entrada.nextInt();
        if ( numNaves<=0) {
            error.mostrarError(1);
            pedirCantNavesInicio(num);
        }
    }

    /**
     *El usuario ingresa los datos de cada planeta cuando no desea que sus valores sean aleatorios
     * @param num
     */
    public void ingresarDatosUsuario(int num){
        aparecerEnMapa();
        pedirNombrePlaneta(num);
        generarPorcentaje();
        pedirDineroinicial(num);
        pedirCantConstruInicio(num);
        pedirCantNavesInicio(num);        
    }
    
    @Override
    public String toString(){
        return "Datos del Planeta:"+"\n"
                +nombrePlaneta+"---Planeta Tipo: "+tipoPlaneta+"\n"
                +dueño+"---Color Planeta: "+color+"\n\n";
    }

       
    
}
