
package lab_git_20056001_munozcarreno;

import java.text.SimpleDateFormat;
import java.util.Date;


public class ArchTextoPlano {
    private String nombre;
    private String fecha;
    private String contenido;
    
    //constructor
    public ArchTextoPlano(String nombre,String contenido){
        //se inicializa el nombre del archivo
        this.nombre=nombre;
        //se inicializa el contenido del archivo
        this.contenido=contenido;
        //se procede a inicializar la fecha de modificación
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
        this.fecha = sdf.format(new Date());
    
    
    }
    
    //METODOS
    
        
    public void mostrarInformacion(){
        System.out.println("----informacion de archivo----");
        System.out.println("nombre archivo: "+getNombre());
        System.out.println("fecha mofificacion: "+getFecha());
        System.out.println("contenido archivo: "+getContenido());
        
    }
        
       
    //Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}
