package lab_git_20056001_munozcarreno;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
REPRESENTACION:

El repositorio será representado a traves de una clase conformada por dintintas clases,
en donde cada una de estas clases es un constructor de cada zona de trabajo. En otras
repositorio esta conformado por:

-> [<nombre repositorio>, <nombre autor>, fecha creacion. class "zonas de trabajo"]

la clase zona de trabajo, para este programa denominada con el nombre "ZonasDeTrabajo", en 
su constructor inicializa las 4 zonas de trabajo, workspace, index, local repository y 
remote repository. Cada unas de estas zonas corresponde a una clase unica.

zona workspace:

- Es una lista de tipo ArrayList<ArchTextoPlano>, donde el objeto ArchTextoPlano, corresponde
  tambien a una clase con los atributos: nombre de archivo, autor del archivo y fecha de creacion.



zona index:

- Es una lista de tipo ArrayList<ArchTextoPlano>, donde el objeto ArchTextoPlano, corresponde
  tambien a una clase con los atributos: nombre de archivo, autor del archivo y fecha de creacion.


zona local repository: 

- La zona local repository es una lista de tipo ArrayList<Commit>, donde el objeto Commit
  corresponde a una clase con distintos atributos, tales como, autor del commit, fecha del
  commit, un mensaje descriptivo del commit y una lista de tipo ArrayList<ArchTextoPlano>.

zona remote repository:

- La zona remote repository es una lista de tipo ArrayList<Commit>, donde el objeto Commit
  corresponde a una clase con distintos atributos, tales como, autor del commit, fecha del
  commit, un mensaje descriptivo del commit y una lista de tipo ArrayList<ArchTextoPlano>.


*/


/*

descripcion clase: Clase principal encargada de mostrar el menu de interaccion

atributos: -


metodos incorporados: -


*/





/**
 * 
 * @author CLundstedt
 */
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
       
       //SE INICIALIZA EL REPOSITORIO
       Repositorio repositorio = Git.gitInit();
       
       

       System.out.println(repositorio.toString());
       System.out.println();
       
       
       //SE PROCEDE A OBTENER LA ZONA DE TRABAJO
       ZonasDeTrabajo Zonas = repositorio.getZonas();
       
       
       //Se crea una lista tipo String
       ArrayList<String> COMANDOS = new ArrayList<>();
       
       
       int opcion=0;
       //SE PROCEDE A MOSTRAR EL MENU A TRAVES DE UN BUCLE
       do{
           System.out.println();
           System.out.println("###SIMULACION DE GIT###");
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
                   System.out.println(" ! Error, introduzca una opcion valida.\n");
                }
           } catch(InputMismatchException e){
               System.out.println("! Error, introduzca una opcion valida.\n");
               S.next();
              
             }
           
            
            //STRING PARA VERIFICAR SI EL COMANDO INGRESADO ES PERMITIDO
            String comando;
            //TIPO BOOLEAN QUE PERMITE REALIZAR EL COMANDO
            boolean permitir;

           
            //se obtiene la zona de trabajo del repositorio
            
            ZonasDeTrabajo zonas = repositorio.getZonas();
            
            
            //SE PROCEDE A REVISAR LA OPCIÓN ESCOGIDA A TRAVÉS DE UN SWITCH
            switch(opcion){
                // ADD
                case 1: 
                    permitir = MetodosExtras.ComandoPermitido(COMANDOS,"Add->");
                    if(permitir){
                        COMANDOS.add("Add->");
                        zonas.gitAdd(zonas);
			System.out.println();
                        System.out.println(zonas.toString());
                        System.out.println();
                        //MetodosExtras.mostrarComandos(COMANDOS);
                    }
                    else{
                        System.out.println("Si por casualidad realizo un Push, es necesario que realice un Pull para ejecutar le comando Add,\nsi ese no es el caso, entonces agregue archivos a la zona workspace.\n");
                    }
                    

                    break;
                // COMMIT
                case 2:
                    permitir = MetodosExtras.ComandoPermitido(COMANDOS,"Commit->");
                    if(permitir){
                        COMANDOS.add("Commit->");
                        zonas.gitCommit(zonas);
			System.out.println();
                        System.out.println(zonas.toString());
                        System.out.println();
                        //MetodosExtras.mostrarComandos(COMANDOS);
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
                        zonas.gitPull(zonas);
			System.out.println();
                        System.out.println(zonas.toString());
                        System.out.println();
                        //MetodosExtras.mostrarComandos(COMANDOS);
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
                        zonas.gitPush(zonas);
			System.out.println();
                        System.out.println(zonas.toString());
                        System.out.println();
                        //MetodosExtras.mostrarComandos(COMANDOS);
                    }
                    else{
                        System.out.println("por favor, genere un Commit antes de realizar un Push.");
                    
                    }
                    break;   
                // STATUS
                case 5:
                    zonas.gitStatus(repositorio,Zonas);
                    break;
                // LOG
                case 6:
                    zonas.gitLog(Zonas);
                    break;
                // INGRESAR ARCHIVOS A WORKSPACE
                case 7:
                    permitir = MetodosExtras.ComandoPermitido(COMANDOS,"CargarArchivosWorkspace->");
                    if(permitir){
                        COMANDOS.add("CargarArchivosWorkspace->");
                        zonas.AgregarArchivo(zonas);
			System.out.println();
                        System.out.println(zonas.toString());
                        System.out.println();
                        //MetodosExtras.mostrarComandos(COMANDOS);
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
