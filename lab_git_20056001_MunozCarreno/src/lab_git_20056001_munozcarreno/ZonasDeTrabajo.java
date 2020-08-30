
package lab_git_20056001_munozcarreno;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
descripcion clase: Esta clase es el constructor principal del TDA, inicializa
todas las zonas de trabajo (workspace, index, local y remote repository).


atributos:

nombreRep (nombre del repositorio)
nombreAutor (nombre del autor del repositorio)
FechaCreacion (fecha creacion del repositorio)

workspace (objeto de tipo Workspace)
index (objeto de tipo Index)
localRepository (objeto de tipo LocalRepository)
remoteRepository (objeto de tipo RemoteRepository)

metodos incorporados:

- obtenerFecha





*/



public class ZonasDeTrabajo {
    //se definen los atributos de la clase y los objetos (zonas de trabajo)
    private String nombreRep;
    private  String nombreAutor;
    private String FechaCreacion;
    
    private Workspace workspace;
    private Index index;
    private LocalRepository localRepository;
    private RemoteRepository remoteRepository;
    
    /**
     * CONSTRUCTOR
     * @param nombreRep
     * @param autor 
     * @param FechaHora 
     */
    public ZonasDeTrabajo(String nombreRep, String autor) {
        this.nombreRep = nombreRep;
        this.nombreAutor = autor;
        this.FechaCreacion = obtenerFecha();
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
     * @return String 
     */
    public String getNombreRep() {
        return nombreRep;
    }

    /**
     * MODIFICADOR
     * @param nombreRep 
     */
    public void setNombreRep(String nombreRep) {
        this.nombreRep = nombreRep;
    }

    /**
     * SELECTOR
     * @return String
     */
    public String getNombreAutor() {
        return nombreAutor;
    }

    /**
     * MODIFICADOR
     * @param nombreAutor 
     */
    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    /**
     * SELECTOR
     * @return  String
     */
    public String getFechaCreacion() {
        return FechaCreacion;
    }

    /**
     * MODIFICADOR
     * @param FechaCreacion 
     */
    public void setFechaCreacion(String FechaCreacion) {
        this.FechaCreacion = FechaCreacion;
    }

    
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
        return "ZonasDeTrabajo[" + "nombreRep= " + nombreRep + ", nombreAutor= " + nombreAutor + ", FechaCreacion= " + FechaCreacion + ",\n workspace" + workspace + ",\n index" + index + ",\n localRepository" + localRepository + ",\n remoteRepository" + remoteRepository + ']';
    }
}
