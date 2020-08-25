
package lab_git_20056001_munozcarreno;

import java.util.ArrayList;


public class LocalRepository {
    //atributos u objetos
    private ArrayList<Commit> localRepository; 
    
    /**
     * CONSTRUCTOR
     */
    public LocalRepository() {
        this.localRepository = new ArrayList<>();
    }

    //GETTERS Y SETTERS
    
    /**
     * SELECTOR
     * @return ArrayList
     */
    public ArrayList<Commit> getLocalRepository() {
        return localRepository;
    }

    /**
     * MODIFICADOR
     * @param localRepository 
     */
    public void setLocalRepository(ArrayList<Commit> localRepository) {
        this.localRepository = localRepository;
    }
    
    
    
    
}
