
package lab_git_20056001_munozcarreno;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
DESCRIPCIÓN DE LA CLASE: esta clase tiene el objetivo de almacenar métodos que
ayuden al desarrollo del programa.
*/
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
    
    /**
     * MODIFICADOR
     * @param Archivos
     * @return ArrayList
     */
    public static ArrayList<ArchTextoPlano> EliminarArchRep(ArrayList<ArchTextoPlano> Archivos){
        //ITERADOR
        int i,j;
        //SI EL ACTIVADOR ES MAYOR A 1 => QUE EL ARCHIVOS ESTÁ MAS DE UNA VEZ
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
    
    
    /**
     * MODIFICADOR
     * @param Lista1
     * @param Lista2
     * @return ArrayList
     */
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
            // QUE tranferir DISMINUYA EN 1 SIGNIFICA QUE YA SE PASO UN
            //ARCHIVO DE WORKPSACE A INDEX
            tranferir-=1;
                 
        }while(tranferir > 0);

        return ListaIndex;
        
    
    }
}
