package lab_git_20056001_munozcarreno;


import java.util.ArrayList;
import java.util.Scanner;

/*
descripcion clase: Esta clase tiene como objetivo creaar un objeto de tipo ArchTextoPlano

atributos: nombre (nombre del autor del texto), fechahora (fecha creacion del archivo) y
contenido (es el contenido que se encuentra al interior del archivo).

metodos incorporados:

- mostrarInformacion 
- mostrarNombres
- UnirListasDeArchivos
- UnirArchivosEspecificos
- EliminarArchRep

*/

public class ArchTextoPlano {
    private String nombre;
    private String fechahora;
    private String contenido;
    
    /**
     * CONSTRUCTOR
     * @param nombre
     * @param contenido 
     * @param fechahora 
     */
    public ArchTextoPlano(String nombre,String contenido,String fechahora){
        //se inicializa el nombre del archivo
        this.nombre=nombre;
        //se inicializa el contenido del archivo
        this.contenido=contenido;
        //se procede a inicializar la fecha de modificación
        this.fechahora = fechahora;
    
    
    }
    
    //METODOS
    
    /**
     * METODO PARA MOSTRAR LA INFORMACIÓN DE UN ARCHIVO.
     */    
    public void mostrarInformacion(){
        System.out.println("----informacion de archivo----");
        System.out.println("nombre archivo: "+getNombre());
        System.out.println("fecha mofificacion: "+getFechaHora());
        System.out.println("contenido archivo: "+getContenido());
        
    }
     
    /**
     * METODO PARA MOSTRAR LOS NOMBRES DE ARCHIVOS ALMACENADOS EN UNA LISTA DE ARCHIVOS.
     */   
    public static void MostrarNombres(ArrayList<ArchTextoPlano> L){
        int i=0;
        //SE DEFINE UN OBJETO DE TIPO ArchTextoPlano
        ArchTextoPlano archivo;
        for(i=0;i<L.size();i++){
            archivo=L.get(i);
            System.out.printf("%d) %s\n",i+1,archivo.getNombre());
        }
    
    }
    
 
    /**
     * MODIFICADOR
     * @param Lista1
     * @param Lista2
     * @return ArrayList
     */
     // descripcion metodo: Dada dos lista de de tipo ArrayList<ArchTextoPlano>, el metodo retorna una lista nueva
     // con las dos listas concatenadas.
    public static ArrayList<ArchTextoPlano> UnirListasDeArchivos(ArrayList<ArchTextoPlano> Lista1, ArrayList<ArchTextoPlano> Lista2){
        //ITERADOR
        int i=0;
        //SE INSTACIA UN NUEVO OBJETO DE TIPO ArchTextoPlano
        ArrayList<ArchTextoPlano> ListaUnida = new ArrayList<>();
        
        //COMIENZA EL PRIMER CICLO FOR, PARA AGREGAR LOS ARCHIVOS DE List2 A LA
        //NUEVA LISTA ListaUnida
        for(i=0;i<Lista2.size();i++){
            ListaUnida.add(Lista2.get(i));
        }
        for(i=0;i<Lista1.size();i++){
            ListaUnida.add(Lista1.get(i));
        }
        return ListaUnida;
    }
    
    
    /**
     * MODIFICADOR
     * @param Zonas
     * @param tranferir
     * @param cantidadMax
     * @return ArrayList
     */
    // descripcion metodo: Este metodo tiene como fin, pasar un(os) archivo especifico (de tipo ArchTextoPlano) a la zona index.
     public static ArrayList<ArchTextoPlano> UnirArchivosEspecificos(ZonasDeTrabajo Zonas, int tranferir, int cantidadMax){
        Scanner S = new Scanner(System.in);
        
        //ITERADOR
        int i=0;
        //ATRIBUTO QUE GUARDA EL INDICE DEL ARCHIVO A MOVER
        int indice;
        ArrayList<ArchTextoPlano> ListaIndex;
        

        do{
            //GENERO UN OBJETO DE TIPO ArchTextoPlano
            Workspace ZonaWorkspace = Zonas.getWorkspace();
            //DEFINO UN OBJETO DE TIPO Arraylist<ArchTextoPlano>
            ArrayList<ArchTextoPlano> LosArchivos = ZonaWorkspace.getArchivos_Workspace();
            
            System.out.printf("(*)Archivos a tranferir: %d\n",tranferir);
            System.out.println("*Archivos Disponibles*");
            System.out.println("-----------------------");
            ArchTextoPlano.MostrarNombres(LosArchivos);
            System.out.printf("Ingrese el número del archivo a tranferir: ");
         
            indice = S.nextInt() - 1;
            //AHORA SE DEBE TRANFERIR EL ARCHIVO EN LA POSICION INDICE AL INDEX
            //SE DEFINE UN OBJETO TIPO INDEX
            Index NIndex = Zonas.getIndex();
            //CREO UN OBJETO DE TIPO ArrayList<ArchTextoPlano>
            ListaIndex = NIndex.getArchivos_Index();
            
            //SE AGREGA EL ARCHIVO EN LA POSICIÓN indice de Workspace
            ListaIndex.add(LosArchivos.get(indice));
            //SE ACTUALIZA LA ZONA INDEX
            NIndex.setArchivos_Index(ListaIndex);
    
            //SE ACTUALIZA LA ZONA DE TRABAJO
            Zonas.setIndex(NIndex);
            // QUE TRANSFERIR DISMINUYA EN 1 SIGNIFICA QUE YA SE PASO UN
            //ARCHIVO DE WORKPSACE A INDEX
            tranferir-=1;
                 
        }while(tranferir > 0);

        return ListaIndex;
    }
    
    
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
     
     
    
    //GETTERS Y SETTERS
    
    /**
     * SELECTOR
     * @return String
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * MODIFICADOR
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * SELECTOR
     * @return String
     */
    public String getFechaHora() {
        return fechahora;
    }

    /**
     * MODIFICADOR
     * @param fecha 
     */
    public void setFechaHora(String fecha) {
        this.fechahora = fecha;
    }
    
    /**
     * SELECTOR
     * @return String
     */
    public String getContenido() {
        return contenido;
    }
    
    /**
     * MODIFICADOR
     * @param contenido
     */
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    @Override
    public String toString() {
        return "[" + nombre + ", " + fechahora + ", " + contenido + ']';
    }
    
   
    
    
}
