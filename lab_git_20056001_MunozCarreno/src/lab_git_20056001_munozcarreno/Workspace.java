
package lab_git_20056001_munozcarreno;

import java.util.ArrayList;


public class Workspace {
    //atributos u objetos
    private ArrayList<ArchTextoPlano> zonaWorkspace;
    
    /**
     * CONSTRUCTOR
     */
    public Workspace() {
        //SE INICIALIZA LA ZONA WORKSPACE COMO UNA LISTA VACÍA
        zonaWorkspace = new ArrayList<>();
    }
    
    
    /**
     * SELECTOR DE zonasWorkspace
     * @return zonasWorkspace
     */
    public ArrayList<ArchTextoPlano> getZonaWorkspace() {
        return zonaWorkspace;
    }
    /**
     * MODIFICADOR DE zonasWorkspace
     * @param zonaWorkspace 
     */
    public void setZonaWorkspace(ArrayList<ArchTextoPlano> zonaWorkspace) {
        this.zonaWorkspace = zonaWorkspace;
    }

    @Override
    public String toString() {
        return "Workspace{" + "zonaWorkspace=" + zonaWorkspace + '}';
    }
    
}
