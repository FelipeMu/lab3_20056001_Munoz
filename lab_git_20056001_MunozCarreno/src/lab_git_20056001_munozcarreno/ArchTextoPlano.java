package lab_git_20056001_munozcarreno;


import java.util.ArrayList;

/*
descripcion clase: Esta clase tiene como objetivo creaar un objeto de tipo ArchTextoPlano

atributos: nombre (nombre del autor del texto), fechahora (fecha creacion del archivo) y
contenido (es el contenido que se encuentra al interior del archivo).

metodos incorporados:

- mostrarInformacion : metodo que muestra toda la informacion acerca de un archivo.
- mostrarNombres: metodo que imprime todos los nombres de una lista de archivos.

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
