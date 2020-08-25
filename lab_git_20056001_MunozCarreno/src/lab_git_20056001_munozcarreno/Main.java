
package lab_git_20056001_munozcarreno;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        //se procede a intancias un objeto de tipo Scanner
        Scanner S = new Scanner(System.in);
        //se definen dos atributos corrrespondientes al nombre del
        //repositorio y el autor
        String nombreRep;
        String autor;
       //se procede a ingresar el nombre del nuevo repositorio junto con el 
       //nombre del autor
       System.out.println("###SIMULACIÓN DE GIT###");
       System.out.printf("Ingrese el nombre del repositorio: ");
       nombreRep = S.nextLine();
       System.out.println();
       System.out.printf("Ingrese nombre del autor: ");
       autor = S.nextLine();
       ZonasDeTrabajo Zonas = new ZonasDeTrabajo(nombreRep,autor);
       
       //SE PROCEDE A MOSTRAR EL MENU A TRAVÉS DE UN BUCLE
       int opcion=0;
       do{
           System.out.println("###SIMULACIÓN DE GIT###");
           System.out.println("Escoja una opcion: ");
           System.out.println("1. add");
           System.out.println("2. commit");
           System.out.println("3. pull");
           System.out.println("4. push");
           System.out.println("5. status");
           System.out.println("6. log");
           System.out.println("7. Crear nuevo archivo");
           System.out.println("8. salir");
           System.out.println("INTRODUZCA SU OPCION: ");
       }while(opcion!=8);
       
       //SE PROCEDE A REVISAR LA OPCIÓN ESCOGIDA A TRAVÉS DE UN SWITCH
       
       switch(opcion){
           case 1: 
               
               break;
               
           case 2:
               
               break;
              
           case 3:
               
               break;  
       
           case 4:
               
               break;   
       
           case 5:
               
               break;
       
           case 6:
               
               break;
       
           case 7:
               
               
               break;
       
           case 8:
               System.out.println();
               System.out.println("Hasta luego.");
               break;
              
           default:
               System.out.println();
               System.out.println("Error, introduzca una opcion valida");     
       } 
    }
}
