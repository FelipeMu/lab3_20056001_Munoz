
package lab_git_20056001_munozcarreno;

import java.util.ArrayList;


public class Workspace {
    //atributos u objetos
    private ArrayList<ArchTextoPlano> Archivos_Workspace;
    
    /**
     * CONSTRUCTOR
     */
    public Workspace() {
        //SE INICIALIZA LA ZONA WORKSPACE COMO UNA LISTA VACÍA
        Archivos_Workspace = new ArrayList<>();
    }
    
    
    /**
     * SELECTOR DE zonasWorkspace
     * @return zonasWorkspace
     */
    public ArrayList<ArchTextoPlano> getArchivos_Workspace() {
        return Archivos_Workspace;
    }
    /**
     * MODIFICADOR DE zonasWorkspace
     * @param zonaWorkspace 
     */
    public void setArchivos_Workspace(ArrayList<ArchTextoPlano> zonaWorkspace) {
        this.Archivos_Workspace = zonaWorkspace;
    }

    @Override
    public String toString() {
        return "[" + Archivos_Workspace + ']';
    }
    
}
