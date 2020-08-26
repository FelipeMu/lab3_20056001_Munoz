
package lab_git_20056001_munozcarreno;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


/*
DESCRIPCIÓN DE LA CLASE: Esta clase tiene como objetivo ejecutar todos los
comandos ingresados por el usuario a través del menú principal. Esta clase
contiene los métodos:
1) agregar archivos workspace
2) gitInit
3)gitAdd
4)gitCommit
5)gitPull
6)gitPush
7)gitStatus
*/
public class Git {
    
    
    /**
     * CONSTRUCTOR
     */
    public Git() {
        
    }
    
    //MÉTODOS
    
    
    /**
     * CONSTRUCTOR INICIAL
     * @param nombreRep
     * @param autor
     * @return ZonasDeTrabajo 
     */
    public static ZonasDeTrabajo gitInit(String nombreRep, String autor){
        
        String FechaCreacion = MetodosExtras.obtenerFecha();
        ZonasDeTrabajo NuevasZonas = new ZonasDeTrabajo(nombreRep,autor,FechaCreacion);
        return NuevasZonas;
    }
    
    
    
    /**
     * MODIFICADOR
     * @param Zonas
     * @return ZonasDeTrabajo
     */
    public static ZonasDeTrabajo AgregarArchivo(ZonasDeTrabajo Zonas){
        //atributos u objetos definidos
        String nombreArchivo;
        String Contenido;
        String FechaHora;
        //se crear un objeto de tipo Scanner
        Scanner S = new Scanner(System.in);
        //SE INGRESA EL NOMBRE DEL ARCHIVO
        
         // SE OBTIENE UN OBJETO DE TIPO WORKSPACE
        Workspace preWorkspace = Zonas.getWorkspace();
        //SE OBTIENE LA LISTA DE ARCHIVOS DEL OBJETO CREADO ANTERIORMENTE
        ArrayList<ArchTextoPlano> ArchivosDelWorkspace = preWorkspace.getArchivos_Workspace();
        
        
        System.out.printf("Ingrese el nombre del archivo: ");
        nombreArchivo = S.nextLine();
        System.out.printf("Ingrese el contenido del archivo: ");
        Contenido = S.nextLine();
        //Se incorpora la fecha y hora de creación con la clase MetodosExtras
        FechaHora = MetodosExtras.obtenerFecha();
        
  
        //SE CREA UN OBJETO DE TIPO ArchTextoPlano
        ArchTextoPlano Archivo= new ArchTextoPlano(nombreArchivo,Contenido,FechaHora);
        // SE PROCEDE A AGREGAR EL NUEVO ARCHIVO A LA ZONA WORKSPACE
        ArchivosDelWorkspace.add(Archivo);
        
        
        //SE CREA UN NUEVO OBJETO DE TIPO ArrayList<ArchTextoPlano>
        ArrayList<ArchTextoPlano> Archivos_Actualizados = MetodosExtras.EliminarArchRep(ArchivosDelWorkspace);
       
        
        
        //SE ACTUALIZA LAS ZONA WORKSPACE
        Workspace NuevoWorkspace = new Workspace();
        NuevoWorkspace.setArchivos_Workspace(Archivos_Actualizados);
        
        //SE ACTUALIZA EL TDA DE ZonasDeTrabajo
        Zonas.setWorkspace(NuevoWorkspace);
        return Zonas;
    
    }
    
    /**
     * MODIFICADOR
     * @param Zonas
     * @return ZonasDeTrabajo
     */
    public static ZonasDeTrabajo gitAdd(ZonasDeTrabajo Zonas){
        Scanner S = new Scanner(System.in);
        int op=0;
        do{
            System.out.println("**cantidad de archivos a ingresar**\n");
            System.out.println("(1) Todos los archivos.");
            System.out.println("(2) Archivos especificos.");
            System.out.printf("opción:  ");
          
            
            try{
               
               op = S.nextInt();
               if(op < 1 || op > 2){
                   System.out.println(" ! Error, introduzca una opción válida.\n");
                }
           } catch(InputMismatchException e){
               System.out.println("! Error, introduzca una opción válida.\n");
               S.next();
            
           }
        }while(op < 1 || op > 2);
        
        //SE CREA UN OBJETO TEMPORAL DE TIPO WORKSPACE
        Workspace WorkspaceTemp = Zonas.getWorkspace();
        //SE OBTIENE LA LISTA DE ARCHIVOS CONTENIDOS EN WOKSPACE
        ArrayList<ArchTextoPlano> ListaArchivos_W = WorkspaceTemp.getArchivos_Workspace();
         
        //SE CREA UN OBJETO TEMPORAL DE TIPO INDEX
        Index IndexTemp = Zonas.getIndex();
        //SE OBTIENE LA LISTA DE ARCHIVOS CONTENIDOS EN INDEX
        ArrayList<ArchTextoPlano> ListaArchivos_I = IndexTemp.getArchivos_Index();

        // ATRIBUTO PARA LA CANTIDAD DE ARCHIVOS ALMACENADOS EN WORKSPCE
        int cantidadArch;

        //SE PROCEDE A TOMAR LA DECISIÓN ENTRE LAS DOS OPCIONES
        switch(op){
            //CASO EN QUE SE DESEA INGRESAR TODOS LOS ARCHIVOS
            case 1:
                //SE PASAN TODOS LOS ARCHIVOS DE WORKSPACE A INDEX
                ArrayList<ArchTextoPlano> NuevoIndex = MetodosExtras.UnirListasDeArchivos(ListaArchivos_W, ListaArchivos_I);
                //SE OBTIENE UN OBJETO TEMPORAL DE LAZONA INDEX
                Index IndexAuxiliar = Zonas.getIndex();
                //SE ACTUALIZA LA ZONA INDEX
                IndexAuxiliar.setArchivos_Index(NuevoIndex);
                //SE ACTUALIZA LA ZONA DE TRABAJO
                Zonas.setIndex(IndexAuxiliar);         
                 break;
                 
             //CASO EN QUE SE DESEA PASAR ARCHIVOS ESPECIFICOS   
             case 2:
                 //SE DEBE MOSTRAR LOS NOMBRES DE LOS ARCHIVOS DISPONIBLES Y
                 //LA CANTIDAD DE ARCHIVOS EN EL WORKSPACE
                 cantidadArch=ListaArchivos_W.size();
                 //ATRIBUTO PARA LA CANTIDAD DE ARCHIVOS QUE DESEA EL USUARIO TRNAFERIR
                 int transferir=0;
                 
                do{ 
                    System.out.printf("(#) Existen %d archivos disponibles en Workspace\n",cantidadArch);
                    System.out.println("¿Cuantos archivos desea transferir?");
                    
                 
                    try{
               
                        transferir = S.nextInt();
                        if(transferir > cantidadArch || transferir < 1){
                            System.out.println(" ! Error, no existe tal cantidad de archivos en Workspace.\n");
                        }
                     } catch(InputMismatchException e){
                         System.out.println("! Error, introduzca una opción válida.\n");
                         S.next();
              
                       }
                }while(transferir > cantidadArch || transferir < 1);
                
                //EN ESTE MOMENTO EN NÚMERO DE ARCHIVOS INGRESADOS POR EL 
                //USUARIO ES MENOR IGUAL A LA CANTIDAD QUE EXISTE EN LA ZONA
                //WORKSPACE, LUEGO SE PROCEDE A TRANSFERIRLOS.
                ArrayList<ArchTextoPlano> N_INDEX = MetodosExtras.UnirArchivosEspecificos(Zonas,transferir,cantidadArch);
                ArrayList<ArchTextoPlano> N_INDEX2 = MetodosExtras.EliminarArchRep(N_INDEX);
                Index IndexTemporal = Zonas.getIndex();
                
                IndexTemporal.setArchivos_Index(N_INDEX2);
                Zonas.setIndex(IndexTemp);
                break;
        }
        return Zonas;        
    }
    
    
    
    
    
    
}
