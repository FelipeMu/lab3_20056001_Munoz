
package lab_git_20056001_munozcarreno;




public class ArchTextoPlano {
    private String nombre;
    private String fecha;
    private String contenido;
    
    /**
     * CONSTRUCTOR
     * @param nombre
     * @param contenido 
     */
    public ArchTextoPlano(String nombre,String contenido){
        //se inicializa el nombre del archivo
        this.nombre=nombre;
        //se inicializa el contenido del archivo
        this.contenido=contenido;
        //se procede a inicializar la fecha de modificación
        this.fecha = MetodosExtras.obtenerFecha();
    
    
    }
    
    //METODOS
    
    /**
     * METODO PARA MOSTRAR LA INFORMACIÓN DE UN ARCHIVO 
     */    
    public void mostrarInformacion(){
        System.out.println("----informacion de archivo----");
        System.out.println("nombre archivo: "+getNombre());
        System.out.println("fecha mofificacion: "+getFecha());
        System.out.println("contenido archivo: "+getContenido());
        
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
    public String getFecha() {
        return fecha;
    }

    /**
     * MODIFICADOR
     * @param fecha 
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
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
    
   
}
