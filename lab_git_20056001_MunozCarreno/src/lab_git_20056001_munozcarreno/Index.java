package lab_git_20056001_munozcarreno;


import java.util.ArrayList;

/*
descripcion clase: Esta clase toma el rol de constructor de la zona index.

atributos: Archivos_Index (lista de tipo ArrayList<ArchTextoPlano>)

metodos incorporados: sin metodos.
*/

public class Index {
    //atributos u objetos
    private ArrayList<ArchTextoPlano> Archivos_Index;
    
    
    /**
     * CONSTRUCTOR
     */
    public Index() {
        //SE INICIALIZA LA ZONA INDEX COMO UNA LISTA VACIA
        Archivos_Index = new ArrayList<>();
    }
    
    
    
    
    //GETTER Y SETTERS
    
    /**
     * SELECTOR DE ZONA INDEX
     * @return ArrayList
     */
    public ArrayList<ArchTextoPlano> getArchivos_Index() {
        return Archivos_Index;
    }
    /**
     * MODIFICADOR DE ZONA INDEX
     * @param index 
     */
    public void setArchivos_Index(ArrayList<ArchTextoPlano> index) {
        this.Archivos_Index = index;
    }

    @Override
    public String toString() {
        return "[" + Archivos_Index + ']';
    }
    
    
}
