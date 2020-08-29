
package lab_git_20056001_munozcarreno;

import java.util.ArrayList;
import java.util.InputMismatchException;
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
       System.out.printf("(*) Ingrese el nombre del repositorio: ");
       nombreRep = S.nextLine();
       System.out.println();
       System.out.printf("(*) Ingrese nombre del autor: ");
       autor = S.nextLine();
       System.out.println();
       
       //SE HACE USO DEL MÉTODO gitInit()
       ZonasDeTrabajo Zonas = Git.gitInit(nombreRep,autor);
       System.out.println(Zonas.toString());
       
       
       //Se crea una lista tipo Strinb
       ArrayList<String> COMANDOS = new ArrayList<>();
       
       
       int opcion=0;
       //SE PROCEDE A MOSTRAR EL MENU A TRAVÉS DE UN BUCLE
       do{
           System.out.println();
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
         
           
           //CON LA INSTRUCCION TRY CATCH GENERAMOS UN CONTROL DE ERRORES DE LAS
           //POSIBLES ENTRADAS QUE INGRESA EL USUARIO, YA SEA, NÚMEROS NO
           //DISPONIBLES Y UN DATO DISTINTO AL TIPO "ENTERO".
           try{
               
               opcion = S.nextInt();
               if(opcion < 1 || opcion > 8){
                   System.out.println(" ! Error, introduzca una opción válida.\n");
                }
           } catch(InputMismatchException e){
               System.out.println("! Error, introduzca una opción válida.\n");
               S.next();
              
             }
           
            
            //STRING PARA VERIFICAR SI EL COMANDO INGRESADO ES PERMITIDO
            String comando;
            //TIPO BOOLEAN QUE PERMITE REALIZAR EL COMANDO
            boolean permitir;

           
            
            //SE PROCEDE A REVISAR LA OPCIÓN ESCOGIDA A TRAVÉS DE UN SWITCH
            switch(opcion){
                // ADD
                case 1: 
                    permitir = MetodosExtras.ComandoPermitido(COMANDOS,"Add->");
                    if(permitir){
                        COMANDOS.add("Add->");
                        ZonasDeTrabajo ZonasNueva1 = Git.gitAdd(Zonas);
                        System.out.println(ZonasNueva1.toString());
                        System.out.println();
                        MetodosExtras.mostrarComandos(COMANDOS);
                    }
                    else{
                        System.out.println("Si por casualidad realizó un Push, es necesario que realice un Pull para ejecutar le comando Add,\nsi ese no es el caso, entonces agregue archivos a la zona workspace.\n");
                    }
                    

                    break;
                // COMMIT
                case 2:
                    permitir = MetodosExtras.ComandoPermitido(COMANDOS,"Commit->");
                    if(permitir){
                        COMANDOS.add("Commit->");
                        ZonasDeTrabajo ZonasNueva2 = Git.gitCommit(Zonas);
                        System.out.println(ZonasNueva2.toString());
                        System.out.println();
                        MetodosExtras.mostrarComandos(COMANDOS);
                    }
                    else{
                        System.out.println("Por favor, realice el comando Add antes de crear un Commit.");
                    }
                    break;
                // PULL
                case 3:
                    permitir = MetodosExtras.ComandoPermitido(COMANDOS,"Pull->");
                    if(permitir){
                        COMANDOS.add("Pull->");
                        ZonasDeTrabajo ZonasNueva3 = Git.gitPull(Zonas);
                        System.out.println(ZonasNueva3.toString());
                        System.out.println();
                        MetodosExtras.mostrarComandos(COMANDOS);
                    }
                    else{
                        System.out.println("Por favor, realice el comando Push antes de ejecutar un Pull.");
                    }
                    break;  
                // PUSH
                case 4:
                    permitir = MetodosExtras.ComandoPermitido(COMANDOS,"Push->");
                    if(permitir){
                        COMANDOS.add("Push->");
                        ZonasDeTrabajo ZonasNueva4 = Git.gitPush(Zonas);
                        System.out.println(ZonasNueva4.toString());
                        System.out.println();
                        MetodosExtras.mostrarComandos(COMANDOS);
                    }
                    else{
                        System.out.println("por favor, genere un Commit antes de realizar un Push.");
                    
                    }
                    break;   
                // STATUS
                case 5:
                    Git.gitStatus(Zonas);
                    break;
                // LOG
                case 6:
                    Git.gitLog(Zonas);
                    break;
                // INGRESAR ARCHIVOS A WORKSPACE
                case 7:
                    permitir = MetodosExtras.ComandoPermitido(COMANDOS,"CargarArchivosWorkspace->");
                    if(permitir){
                        COMANDOS.add("CargarArchivosWorkspace->");
                        ZonasDeTrabajo ZonasNueva7 = Git.AgregarArchivo(Zonas);
                        System.out.println(ZonasNueva7.toString());
                        System.out.println();
                        MetodosExtras.mostrarComandos(COMANDOS);
                    }
                    else{
                        System.out.println("Para seguir cargando archivos a workspace, por favor realice un Pull");
                    }

                    break;
                // CERRAR SIMULADOR
                case 8:
                    System.out.println();
                    System.out.println("Hasta luego.\n");
                    break;     
            } 
            // SE VERIFICA SI EL USUARIO DECIDIÓ SALIR DEL SIMULADOR
            if(opcion != 8){
                opcion=0;
            }
       }while(opcion < 1 || opcion > 8);
    }
}
