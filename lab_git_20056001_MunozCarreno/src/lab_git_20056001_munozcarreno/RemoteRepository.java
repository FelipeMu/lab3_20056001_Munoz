package lab_git_20056001_munozcarreno;


import java.util.ArrayList;


/*
descripcion clase: Esta clase funciona como el constrcutor de la zona remote repository.

atributos: CommitsEnRemote (lista de tipo ArrayList<Commit>)

metodos incorporados: sin metodos.


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
