package lab_git_20056001_munozcarreno;


import java.util.ArrayList;


/*
descripcion clase: Esta clase funciona como el constrcutor de la zona remote repository.

atributos: CommitsEnRemote (lista de tipo ArrayList<Commit>)

metodos incorporados: 

- ObtenerArchivosDeRemote


*/

public class RemoteRepository {
    //atributos u objetos
    private ArrayList<Commit> CommitsEnRemote;

    /**
     * CONSTRUCTOR
     */
    public RemoteRepository() {
        this.CommitsEnRemote = new ArrayList<>();
    }
    
    
    //METODOS
    
    // descripcion metodo: El metodo tiene como objetivo obtener todos los archivos de cada
    // commit de la lista ingresada ListaCommits (de tipo ArrayList<Commit>)
    /**
     * SELECTOR
     * @param ListaCommits
     * @return ArrayList
     */
    public static ArrayList<ArchTextoPlano> ObtenerArchivosDeRemote(ArrayList<Commit> ListaCommits){
        //SE CREA UN OBJETO DE TIPO ArrayList<ArchTextoPlano> PARA GUARDAR TODOS
        //LOS ARCHIVOS ALMACENADOS EN REMOTE REPOSITORY
        ArrayList<ArchTextoPlano> TodosLosArchivos = new ArrayList<>();
        //ITERADORES
        int i,j,p;
        
        //SE CREA OBJETO Commit
        Commit commit;
         
        //ArrayList<ArchTextoPlano> ArchivosIniciales = new ArrayList<>();
        
        //LISTA DE ARCHIVOS DE UN COMMIT
         ArrayList<ArchTextoPlano> archTemp = new ArrayList<>();
        
        
        //FOR QUE RECORRE TODA LA LISTA DE COMMITS
        for(i=0;i<ListaCommits.size();i++){
            //SE OBTIENE UN COMMIT
            commit = ListaCommits.get(i);
            //SE OBTIENE LA LISTA DE ARCHIVOS DEL COMMIT
            archTemp = commit.getArchivosCommit();
            //SE GUARDA LA LISTA DE ARCHIVOS EN UN NUEVO OBJETO
            TodosLosArchivos = ArchTextoPlano.UnirListasDeArchivos(archTemp,TodosLosArchivos);
        }
        return TodosLosArchivos;
    } 
    
    
    
    
    
    
    //GETTERS Y SETTERS

    /**
     * SELECTOR
     * @return ArrayList
     */
    public ArrayList<Commit> getCommitsEnRemote() {
        return CommitsEnRemote;
    }

    /**
     * MODIFICADOR
     * @param archivosCommit 
     */
    public void setCommitsEnRemote(ArrayList<Commit> archivosCommit) {
        this.CommitsEnRemote = archivosCommit;
    }

    @Override
    public String toString() {
        return "[" + CommitsEnRemote + ']';
    }
    
    
    
    
    
}
