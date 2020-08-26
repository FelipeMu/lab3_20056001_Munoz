
package lab_git_20056001_munozcarreno;

import java.util.ArrayList;

public class Commit {
    //ATRIBUTOS U OBJETOS
    String autor;
    String tiempo;
    String mensaje;
    ArrayList<ArchTextoPlano> archivosCommit;

    /**
     * CONSTRUCTOR
     * @param autor
     * @param tiempo
     * @param mensaje 
     * @param archivos 
     */  
    public Commit(String autor, String tiempo, String mensaje, ArrayList<ArchTextoPlano> archivos) {
        this.autor = autor;
        this.tiempo = MetodosExtras.obtenerFecha();
        this.mensaje = mensaje;
        this.archivosCommit = archivos;
    }

    
    //GETTERS Y SETTERS
    
    /**
     * SELECTOR
     * @return String
     */
    public String getAutor() {
        return autor;
    }

    /**
     * MODIFICADOR
     * @param autor 
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * SELECTOR
     * @return String
     */
    public String getTiempo() {
        return tiempo;
    }

    /**
     * MODIFICADOR
     * @param tiempo 
     */
    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    /**
     * SELECTOR
     * @return String
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * MODIFICADOR
     * @param mensaje 
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "Commit{" + "autor=" + autor + ", tiempo=" + tiempo + ", mensaje=" + mensaje + ", archivosCommit=" + archivosCommit + '}';
    }
    
   
    
    
    
    
}
