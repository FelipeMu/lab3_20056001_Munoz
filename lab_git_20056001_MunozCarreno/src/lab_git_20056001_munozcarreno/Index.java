package lab_git_20056001_munozcarreno;


import java.util.ArrayList;

/*
descripcion clase: Esta clase toma el rol de constructor de la zona index.

atributos: Archivos_Index (lista de tipo ArrayList<ArchTextoPlano>)

metodos incorporados: 

- EliminarArchRep
- toString



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
    
    //METODOS
    
    /**
     * MODIFICADOR
     * @param Archivos
     * @return ArrayList
     */
    // descripcion metodo: El objetivo de este metodo es devolver una lista sin archivos duplicados
    // tomando como filtro el nombre del archivo.
    public static ArrayList<ArchTextoPlano> EliminarArchRep(ArrayList<ArchTextoPlano> Archivos){
        //ITERADOR
        int i,j;
        //SI EL ACTIVADOR ES MAYOR A 1 => QUE EL ARCHIVOS ESTA MAS DE UNA VEZ
        int activador=0;
        ArrayList<ArchTextoPlano> NuevosArchivos = new ArrayList<>();
        //OBJETO DE TIPO ARCHIVO
        ArchTextoPlano archivo;
        //ATRIBUTO TIPO STRING QUE GUARDA EL NOMBRE DEL ARCHIVO ANTERIOR
        String na1;
        //OBJETO DE TIPO ARCHIVO
        ArchTextoPlano temporal;
        //ATRIBUTO TIPO STRING QUE GUARDA EL NOMBRE DEL ARCHIVO ANTERIOR
        String na2;
        
        //BUCLE PARA ELIMINAR ARCHIVOS REPETIDOS
        for(i=0;i<Archivos.size();i++){
            archivo=Archivos.get(i); // SE OBTIENE EL ARCHIVO EN LA POSICIÓN i
            na1=archivo.getNombre();
            for(j=i;j<Archivos.size();j++){
                temporal=Archivos.get(j);
                na2=temporal.getNombre();
                //SE COMPARARN LOS NOMBRES DE LOS ARCHIVOS
                if(na1.equals(na2)){
                    activador+=1;
                }   
            }
            if(activador == 1){
                NuevosArchivos.add(archivo);
            }
            //SE REINICIA EL CONDICIONADOR
            activador=0;
        }
        return NuevosArchivos;
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
