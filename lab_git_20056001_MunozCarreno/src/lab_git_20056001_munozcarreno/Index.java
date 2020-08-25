
package lab_git_20056001_munozcarreno;

import java.util.ArrayList;


public class Index {
    //atributos u objetos
    private ArrayList<ArchTextoPlano> index;
    
    
    /**
     * CONSTRUCTOR
     */
    public Index() {
        //SE INICIALIZA LA ZONA INDEX COMO UNA LISTA VACÍA
        index = new ArrayList<>();
    }
    
    
    
    
    //GETTER Y SETTERS
    
    /**
     * SELECTOR DE ZONA INDEX
     * @return ArrayList
     */
    public ArrayList<ArchTextoPlano> getIndex() {
        return index;
    }
    /**
     * MODIFICADOR DE ZONA INDEX
     * @param index 
     */
    public void setIndex(ArrayList<ArchTextoPlano> index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "Index{" + "index=" + index + '}';
    }
    
    
}
