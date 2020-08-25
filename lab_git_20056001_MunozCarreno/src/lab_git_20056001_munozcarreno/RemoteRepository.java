
package lab_git_20056001_munozcarreno;

import java.util.ArrayList;


public class RemoteRepository {
    //atributos u objetos
    private ArrayList<Commit> archivosCommit;

    /**
     * CONSTRUCTOR
     */
    public RemoteRepository() {
        this.archivosCommit = new ArrayList<>();
    }
    
    //GETTERS Y SETTERS

    /**
     * SELECTOR
     * @return ArrayList
     */
    public ArrayList<Commit> getArchivosCommit() {
        return archivosCommit;
    }

    /**
     * MODIFICADOR
     * @param archivosCommit 
     */
    public void setArchivosCommit(ArrayList<Commit> archivosCommit) {
        this.archivosCommit = archivosCommit;
    }
    
    
    
    
    
}
