
package lab_git_20056001_munozcarreno;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
descripcion clase: Esta clase es el constructor principal del TDA, inicializa
todas las zonas de trabajo (workspace, index, local y remote repository).


atributos:


workspace (objeto de tipo Workspace)
index (objeto de tipo Index)
localRepository (objeto de tipo LocalRepository)
remoteRepository (objeto de tipo RemoteRepository)

metodos incorporados:

- toString




*/



public class ZonasDeTrabajo {
    //se definen los atributos de la clase y los objetos (zonas de trabajo)

    
    private Workspace workspace;
    private Index index;
    private LocalRepository localRepository;
    private RemoteRepository remoteRepository;
    
   /**
    * CONSTRUCTOR
    */
    public ZonasDeTrabajo() {

        this.workspace = new Workspace();
        this.index = new Index();
        this.localRepository = new LocalRepository();
        this.remoteRepository = new RemoteRepository();
    }
    
    
    //METODOS
    
    /**
     * SELECTOR DE FECHA Y HORA
     * @return String
     */
     //descripcon metodo: El metodo tiene como objetivo retornar la fecha y hora actual.
    public static String obtenerFecha(){
        LocalDateTime Fecha = LocalDateTime.now();
        DateTimeFormatter SET = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formattedDate = Fecha.format(SET);
        return formattedDate;
    }
    
    
    
    
    //GETTERS Y SETTERS



    
    /**
     * SELECTOR
     * @return ArrayList
     */
    public Workspace getWorkspace() {
        return workspace;
    }

    /**
     * MODIFICADOR  
     * @param workspace 
     */
    public void setWorkspace(Workspace workspace) {
        this.workspace = workspace;
    }

    /**
     * SELECTOR
     * @return ArrayList
     */
    public Index getIndex() {
        return index;
    }

    /**
     * MODIFICADOR
     * @param index 
     */
    public void setIndex(Index index) {
        this.index = index;
    }

    /**
     * SELECTOR
     * @return ArrayList
     */
    public LocalRepository getLocalRepository() {
        return localRepository;
    }

    /**
     * MODIFICADOR
     * @param localRepository 
     */
    public void setLocalRepository(LocalRepository localRepository) {
        this.localRepository = localRepository;
    }

    /**
     * SELECTOR
     * @return ArrayList
     */
    public RemoteRepository getRemoteRepository() {
        return remoteRepository;
    }

    /**
     * MODIFICADOR
     * @param remoteRepository 
     */
    public void setRemoteRepository(RemoteRepository remoteRepository) {
        this.remoteRepository = remoteRepository;
    }

    @Override
    public String toString() {
        return "ZonasDeTrabajo[" + ",\n workspace" + workspace + ",\n index" + index + ",\n localRepository" + localRepository + ",\n remoteRepository" + remoteRepository + ']';
    }
}
