package lab_git_20056001_munozcarreno;


import java.util.ArrayList;


/*
descripcion clase: La clase tiene como objetivo inicializar la zona local
repository (constructor de la zona local repository)

atributos: CommitsEnLocal (lista de tipo ArrayList<Commit>, que contiene todos
los commit realizados por el usuario)

metodos incorporados: 

- toString


*/

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
