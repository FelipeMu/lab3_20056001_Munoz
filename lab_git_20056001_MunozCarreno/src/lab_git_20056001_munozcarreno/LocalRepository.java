
package lab_git_20056001_munozcarreno;

import java.util.ArrayList;


public class LocalRepository {
    //atributos u objetos
    private ArrayList<Commit> CommitsEnLocal; 
    
    /**
     * CONSTRUCTOR
     */
    public LocalRepository() {
        this.CommitsEnLocal = new ArrayList<>();
    }

    //GETTERS Y SETTERS
    
    /**
     * SELECTOR
     * @return ArrayList
     */
    public ArrayList<Commit> getCommitsEnLocal() {
        return CommitsEnLocal;
    }

    /**
     * MODIFICADOR
     * @param localRepository 
     */
    public void setCommitsEnLocal(ArrayList<Commit> localRepository) {
        this.CommitsEnLocal = localRepository;
    }

    @Override
    public String toString() {
        return "[" + CommitsEnLocal + ']';
    }
    
    
    
    
}
