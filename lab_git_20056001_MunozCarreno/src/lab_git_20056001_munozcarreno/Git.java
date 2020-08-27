
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
                Zonas.setIndex(IndexTemporal);
                break;
        }
        return Zonas;        
    }
    
    /**
     * MODIFICADOR
     * @param Zonas
     * @return ZonasDeTrabajo
     */
    public static ZonasDeTrabajo gitCommit(ZonasDeTrabajo Zonas){
        Scanner S = new Scanner(System.in);
        //SE PROCEDE A OBTENER EL NOMBRE DEL AUTOR DEL REPOSITORIO
        String Autor;
        //SE INGRESA EL AUTOR DEL COMMIT
        System.out.printf("Ingrese nombre del autor: ");
        Autor = S.nextLine();
        
        //SE OBTIENE LA FECHA DE CREACIÓN DEL COMMIT
        String FechaCommit;
        FechaCommit = MetodosExtras.obtenerFecha();
        //SE CREA UN ATRIBUTO PARA GUARDAR EL MENSAJE
        String Mensaje;
        //SE LE INDICA AL USUARIO QUE INGRESE UN MENSAJE PARA EL COMMIT
        System.out.printf("Ingrese un mensaje descriptivo: ");
        Mensaje = S.nextLine();
        
        //SE PROCEDE A OBTENER UN OBJETO DE TIPO Index
        Index index = Zonas.getIndex();
        //SE OBTIENE LA LISTA DE ARCHIVOS
        ArrayList<ArchTextoPlano> ArchivosIndex = index.getArchivos_Index();
        

        //SE PROCEDE A CREAR UN OBJETO DE TIPO Commit
        Commit commit = new Commit(Autor,FechaCommit,Mensaje,ArchivosIndex);

        
        
        //SE OBTIENE UN OBJETO TIPO LocalRepository
        LocalRepository localRep = Zonas.getLocalRepository();
        
        //SE OBTIENE LA LISTA DE COMMIT DEL OBJETO localRep
        ArrayList<Commit> ListaCommits = localRep.getCommitsEnLocal();
        
        
        //SE AGREGA EL NUEVO COMMIT
        ListaCommits.add(commit);

        
        //AHORA SE PROCEDE A CREAR UN NUEVO OBJETO DE TIPO INDEX Y AGREGARLO A 
        Index nuevo_index = new Index();
        //SE ACTUALIZA LA ZONA localRep
        localRep.setCommitsEnLocal(ListaCommits); 
        //SE ACTUALIZA LA ZONA DE TRABAJO
        Zonas.setIndex(nuevo_index);
        //SE ACTUALIZA LA ZONA DE TRABAJO
        Zonas.setLocalRepository(localRep);
       
        return Zonas;
    }
    
    /**
     * MODIFICADOR
     * @param Zonas
     * @return ZonasDeTrabajo
     */
    public static ZonasDeTrabajo gitPush(ZonasDeTrabajo Zonas){
  
        //SE PROCEDE A OBTENER EL OBJETO DE TIPO localRepository 
        LocalRepository local = Zonas.getLocalRepository();
        //SE OBTIENE LOS COMMIT DEL OBJETO local
        ArrayList<Commit> commitDeLocal = local.getCommitsEnLocal();
         
        //SE OBTIENE EL OBJETO UN OBJETO RemoteRepository
        RemoteRepository remote = Zonas.getRemoteRepository();
        
        //SE CDEFINE UN OBJETO DE TIPO ArrayList<Commits>
        ArrayList<Commit> commitDeRemote = remote.getCommitsEnRemote();
        
        //SE CREA UN OBJETO DE TIPO ArrayList<Commit>
        ArrayList<Commit> NuevoConjuntoCommits = new ArrayList<>();
        
        //SE PROCEDE A UNIR LOS COMMITS DE LOCAL REPOSITORY Y LOCAL REPOSITORY
        NuevoConjuntoCommits = MetodosExtras.UnirConjuntoDeCommits(commitDeLocal, commitDeRemote);
        //SE CREA UN OBJETO DE TIPO ArrayList<Commit>
        ArrayList<Commit> NuevoConjuntoCommits2 = new ArrayList<>();
        //SE PROCEDE A ELIMINAR LOS REPETIDOS
        NuevoConjuntoCommits2 = MetodosExtras.BorrarCommitRep(NuevoConjuntoCommits);

        
        // SE CREA UN NUEVO OBJETO DE TIPO RemoteRepository
        RemoteRepository remoteFinal = new RemoteRepository();
        //SE ACTUALIZA LA ZONA remtoeFinal
        remoteFinal.setCommitsEnRemote(NuevoConjuntoCommits2);
        ///SE ACTUALIZA LA ZONA DE TRABAJO
        Zonas.setRemoteRepository(remoteFinal);
        
        
        
        //SE 
        
        
        
        
 
        return Zonas;
    
    }
    
    /**
     * MODIFICADOR
     * @param Zonas
     * @return ZonasDeTrabajo
     */
    public static ZonasDeTrabajo gitPull(ZonasDeTrabajo Zonas){
        //SE PROCEDE A CREAR UN OBJETO DE TIPO ArrayList<ArchTextoPlano> PARA
        //GUARDAR TODOS LOS ARCHIVOS QUE EXISTEN EN REMOTE REPOSITORY
        ArrayList<ArchTextoPlano> TodosLosArchivosR= new ArrayList<>();
        
        //SE OBTIENE UN  OBJETO DE TIPO RemoteRepsitory
        RemoteRepository remote = Zonas.getRemoteRepository();
        //SE OBTIENE LA LISTA DE COMMIT DEL OBJETO remote (instruccion anterior)
        ArrayList<Commit> CommitsRemote = remote.getCommitsEnRemote();
        
        //SE OBTIENE UNA LISTA CON TODOS LOS ARCHUIVOS DE REMOTE REPOSITORY
        TodosLosArchivosR = MetodosExtras.ObtenerArchivosDeRemote(CommitsRemote);
        
        //SE PROCEDE A ELIMINAR LOS REPETIDOS
        
        //SE CREA UN NUEVO ONEJTO TIPO ArrayList<ArchTextoPlano>
        ArrayList<ArchTextoPlano> NuevosArchivosUnicos = new ArrayList<>();
        
        //SE OBTIENE UNA LISTA DE ARCHIVOS SIN REPETICIONES
        NuevosArchivosUnicos = MetodosExtras.EliminarArchRep(TodosLosArchivosR);
        
        //SE ACTUALIZA LA ZONA WORKSPACE
        Workspace workspace = Zonas.getWorkspace();
        //SE ACTUALIZA LA ZONA WORKSPACE
        workspace.setArchivos_Workspace(NuevosArchivosUnicos);
        
        //SE ACTUALIZA LA ZONA DE TRABAJO
        Zonas.setWorkspace(workspace);
        
        
        
        
        
        
        
        
        
        
        
        return Zonas;
   
    
    }
    
    
    public static void gitStatus(ZonasDeTrabajo Zonas){
        
        //SE PROCEDE A MOSTRAR EL NOMBRE DEL REPOSITORIO Y SU AUTOR
        System.out.println("###REPOSITORIO ACTUAL###\n");
        
        //SE MUESTRA EL NOMBRE DEL REPOSITOIO
        System.out.printf("Nombre repositorio: %s \n",Zonas.getNombreRep());
        //SE MUESTRA EL AUTOR DEL REPOSITORIO
        System.out.printf("Nombre autor: %s \n",Zonas.getNombreAutor());
        
        //AHORA DE DEBE OBTENER LA CANTIDAD DE ARCHIVOS QUE POSEE WORKSPACE E
        //INDEX Y LA CANTIDAD DE COMMIT EN LOCAL REPOSITORY
        
        //SE CRRAN LAS 3 VARIBLES PARA ACUMULAR LAS RESPECTIVAS CANTIDADES
        int cantArch_W;
        int cantArch_I;
        int cantCommits_Local;
        
        //SE OBTIENE EL OBJETO TIPO WORKSPACE
        Workspace workspace = Zonas.getWorkspace();
        ArrayList<ArchTextoPlano> cantidadAW = workspace.getArchivos_Workspace();
        //SE GUARDA LA CANTIDAD DE ARCHIVOS DE WORKSPACE
        cantArch_W = cantidadAW.size();
        
        
        //SE OBTIENE EL OBJETO TIPO INDEX
        Index index = Zonas.getIndex();
        ArrayList<ArchTextoPlano> cantidadAI = index.getArchivos_Index();
        //SE GUARDA LA CANTIDAD DE ARCHIVOS DE WORKSPACE
        cantArch_I = cantidadAI.size();
        
        //SE OBTIENE UN OBJETO DE TIPO LOCAL REPOSITORY
        LocalRepository localRep = Zonas.getLocalRepository();
        ArrayList<Commit> commitsL = localRep.getCommitsEnLocal();
        //SE OBTIENE LA CANTIDAD DE COMMIT QUE POSEE LOCAL REPOSITORY
        cantCommits_Local = commitsL.size();
        
        //SE MUESTRA LA CANTIDAD DE ARCHIVOS QUE POSEE WORKAPCE
        System.out.printf("Cantidad archivos en Workspace: %d \n",cantArch_W);
        //SE MUESTRA LA CANTIDAD DE ARCHIVOS QUE POSEE INDEX
        System.out.printf("Cantidad archivos en Index: %d \n",cantArch_I);
        //SE MUESTRA LA CANTIDAD DE COMMITS EN LOCAL REPOSITORY
        System.out.printf("Cantidad de commits en Local repostiroy: %d \n",cantCommits_Local);
        
        //AHORA SE DEBEN IGUALAR LA CANTIDAD DE COMMMIT DE LOCAL REPOSITORY
        //Y REMOTE REPOSITORY PARA VER SI ESTAN ACTUALIZADOS
        
        //LA CANTIDAD DE LOS COMMIT DE LOCAL YA SE OBTUVIERON ANTES *********
        
        
        int cantCommits_Remote;
        //SE PROCEDE A OBTENER LA CANTIDAD DE COMMIT DE REMOTE REPOSITORY
        RemoteRepository remoteRep = Zonas.getRemoteRepository();
        ArrayList<Commit> commitsR = remoteRep.getCommitsEnRemote();
        cantCommits_Remote = commitsR.size();
        
        //SE PROCEDE A IGUALARLOS
        //IGUALES => REMOTE ACTUALIZADO
        //DISTINTOS => REMOTE NO ACTUALIZADO
        
        String si = "actualizado";
        String no = "no actualizado";
        
        if(cantCommits_Local == cantCommits_Remote){
            System.out.printf("Estado de Remote repository: %s \n\n",si);
        }
        else{
            System.out.printf("Estado de Remote repository: %s \n\n",no);
        
        }
        System.out.printf("####FIN REPOSITORIO#####\n\n",no);
        
        
        
        
        
        

        
    
    
    }
   
    
}
