
package lab_git_20056001_munozcarreno;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MetodosExtras {
    
    /**
     * CONSTRUCTOR
     */
    public MetodosExtras() {
    }
    
    /**
     * SELECTOR DE FECHA Y HORA
     * @return String
     */
    public static String obtenerFecha(){
        LocalDateTime Fecha = LocalDateTime.now();
        DateTimeFormatter SET = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formattedDate = Fecha.format(SET);
        return formattedDate;
    }
}
