
package lab_git_20056001_munozcarreno;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
    
    /**
     * MODIFICADOR
     * @param conj1
     * @param conj2
     * @return ArrayList<>
     */
    public static ArrayList<Commit> UnirConjuntoDeCommits(ArrayList<Commit> conj1, ArrayList<Commit> conj2){
        
        int i=0;
        ArrayList<Commit> NuevoConjuntoCommits = new ArrayList<>();
        
        for(i=0;i<conj2.size();i++){
            NuevoConjuntoCommits.add(conj2.get(i));
        }
        for(i=0;i<conj1.size();i++){
            NuevoConjuntoCommits.add(conj1.get(i));
        }
        //ArrayList<Commit> NuevoConjuntoCommits2 = new ArrayList<>();
        //NuevoConjuntoCommits2 = BorrarCommitRep(NuevoConjuntoCommits);
        
        return NuevoConjuntoCommits;
    }
    
    
    public static ArrayList<Commit> BorrarCommitRep(ArrayList<Commit> Lcommits){
        //ITERADOR
        int i,j;
        //SI EL ACTIVADOR ES MAYOR A 1 => QUE EL ARCHIVOS ESTÁ MAS DE UNA VEZ
        int activador=0;
        ArrayList<Commit> NuevosL = new ArrayList<>();
        //OBJETO DE TIPO ARCHIVO
        Commit ElemCommit;
        //ATRIBUTO TIPO STRING QUE GUARDA EL NOMBRE DEL ARCHIVO ANTERIOR
        String nc1;
        //OBJETO DE TIPO ARCHIVO
        Commit ElemCommitTemporal;
        //ATRIBUTO TIPO STRING QUE GUARDA EL NOMBRE DEL ARCHIVO ANTERIOR
        String nc2;
         
        //COMPARADORES
        
        //COMPARADORES DE AUTOR DEL COMMIT
        String autor1;
        String autor2;
        
        //COMPARADORES DE MENSAJE
        String mensaje1;
        String mensaje2;
        
        
        //COMPARADORES TAMAÑO LISTA
        int tamano1;
        int tamano2;
        
        
        //OBJETOS QUE GUARDAN LA LISTA DE ARCHIVOS
        ArrayList<ArchTextoPlano> listaArchivos1;
        ArrayList<ArchTextoPlano> listaArchivos2;
        
        
        //OBJETOS TIPO ArchTextoPlano
        ArchTextoPlano arch1;
        ArchTextoPlano arch2;
        
        
        //COMPARADORES DE NOMBRE DE ARCHIVO
        String nombre_archivo1;
        String nombre_archivo2;
        
        //COMAPARADORES DE CONTENIDO DE ARCHIVO
        String contenido1;
        String contenido2;
        
        
        //NUEVOS ITERADORES
        int p;
        int k;
 
        
        //VARIABLE QUE GUARDA EL TAMAÑO DE LA LISTA DE ARCHIVO EN CASO QUE
        //SEAN IGUALES
        int largoListas;
        
        
        //VARIABLES QUE INDICAN QUE LOS ARCHIVOS SON UNICOS
        //( llave < largoListas ) impica son diferentes
        //( llave == largoListas )implica archivos repetidos
        int llave=0;
        
        
        //BUCLE PARA ELIMINAR ARCHIVOS REPETIDOS
        for(i=0;i<Lcommits.size();i++){
            ElemCommit=Lcommits.get(i); // SE OBTIENE EL ARCHIVO EN LA POSICIÓN i
            nc1=ElemCommit.getAutor();
            for(j=i;j<Lcommits.size();j++){
                ElemCommitTemporal=Lcommits.get(j);
                nc2=ElemCommitTemporal.getAutor();
                //SE COMPARARN AUTOR DEL COMMIT
                if(nc1.equals(nc2)){
                    //SE COMPARA EL MENSAJE DEL COMMIT
                    mensaje1 = ElemCommit.getMensaje();
                    mensaje2 = ElemCommitTemporal.getMensaje();
                    if(mensaje1.equals(mensaje2)){
                        listaArchivos1 = ElemCommit.getArchivosCommit();
                        listaArchivos2 = ElemCommitTemporal.getArchivosCommit();
                        //SE OBTIENEN LOS LARGOS DE LAS LISTAS
                        tamano1 = listaArchivos1.size();
                        tamano2 = listaArchivos2.size();
                        //SE PROCEDE A REALIZAR LA COMPARACIÓN
                        if(tamano1 == tamano2){
                            //SE GUARDA EL TAMAÑO DE LA LISTA
                            largoListas = tamano1;
                            //SE PROCEDE A ANALIZAR LOS ARCHUVOS
                            for(p=0;p<listaArchivos1.size();p++){
                                //SE OBTIENE EL PRIMER ARCHIVO
                                arch1 = listaArchivos1.get(p);
                                //SE OBTIENE EL NOMBRE DEL ARCHIVO ANTERIOR
                                nombre_archivo1 = arch1.getNombre();
                                for(k=0;k<listaArchivos2.size();k++){
                                    //SE OBTIENE EL SEGUNDO ARCHIVO
                                    arch2 = listaArchivos2.get(k);
                                    //SE OBTIENE EL ONMBRE DEL ARCHIVO 2
                                    nombre_archivo2 = arch2.getNombre();
                                    //SE PROCEDE A COMPARAR LOS NOMBRES
                                    if(nombre_archivo1.equals(nombre_archivo2)){
                                        //SE PROCEDE A REVISAR SU CONTENIDO
                                        contenido1 = arch1.getContenido();
                                        contenido2 = arch2.getContenido();
                                        //SEC OMPARAN LOS CONTENIDOS DE LOS
                                        //ARCHIVOS
                                        if(contenido1.equals(contenido2)){
                                            //llave AUMENTA EN +1
                                            llave +=1;
                                            System.out.printf("VALOR DE llave ----> %d\n\n",llave);
                                        }
                                    }
                                }
                            }
                            //SE ANALIZA EL VALOR DE llave
                            //SI SE ENTRA AL SIGUIENTE IF, SIGNIFICA QUE
                            //LOS ARCHIVOS QUE CONTIENE EL COMMIT SON DISTINTOS
                            if(llave == largoListas){
                                activador+=1;
                                System.out.printf("VALOR DE activador ----> %d\n\n",activador);
                            }
                            llave=0;
                        }
                    }
                }
            }
            //SE SALE DEL  2DO FOR DE LOS COMMITS
            if(activador == 1){
                //NuevosL.add(ElemCommit);
                ArrayList<Commit> temp = new ArrayList<>();
                temp.add(ElemCommit);
                NuevosL = UnirConjuntoDeCommits(temp,NuevosL);
            }
            //SE REINICIA EL CONDICIONADOR
            activador=0;
        }
        return NuevosL;
    }
    
    
    public static ArrayList<ArchTextoPlano> ObtenerArchivosDeRemote(ArrayList<Commit> ListaCommits){
        //SE CREA UN OBJETO DE TIPO ArrayList<ArchTextoPlano> PARA GUARDAR TODOS
        //LOS ARCHIVOS ALMACENADOS EN REMOTE REPOSITORY
        ArrayList<ArchTextoPlano> TodosLosArchivos = new ArrayList<>();
        //ITERADORES
        int i,j,p;
        
        //SE CREA OBJETO Commit
        Commit commit;
         
        //ArrayList<ArchTextoPlano> ArchivosIniciales = new ArrayList<>();
        
        //LISTA DE ARCHIVOS DE UN COMMIT
         ArrayList<ArchTextoPlano> archTemp = new ArrayList<>();
        
        
        //FOR QUE RECORRE TODA LA LISTA DE COMMITS
        for(i=0;i<ListaCommits.size();i++){
            //SE OPBTIENE UN COMMIT
            commit = ListaCommits.get(i);
            //SE OBTIENE LA LISTA DE ARCHIVOS DEL COMMIT
            archTemp = commit.getArchivosCommit();
            //SE GUARDA LA LISTA DE ARCHIVOS EN UN NUEVO OBJETO
            TodosLosArchivos = UnirListasDeArchivos(archTemp,TodosLosArchivos);
        }
        return TodosLosArchivos;
    } 
    
    
    /**
     * 
     * @param ListaComandos
     * @param comando
     * @return boolean
     */
    public static boolean ComandoPermitido(ArrayList<String> ListaComandos,String comando){
       
        boolean ejecutar = true;
        //SE PROCEDE A VERIFICAR QUE EL COMANDO "comando" SELECCIONADO SEA VÁLIDO
        
        //COMANDO Add _____________________
        
        //STRING QUE ALMACENARÁ EL ÚLTIMO COMANDO EJECUTADO
        String C;
        
        //ENTERO QUE ALMACENA EL TAMAÑO DE LA LISTA ListaComandos
        int largo;
        //CASO BORDE
        if(ListaComandos.isEmpty() && comando.equals("CargarArchivosWorkspace->")){
            
            ejecutar = true;
        }
        
        else{
        
            if(ListaComandos.isEmpty()){
                ejecutar = false;
            }
            
            else{
                largo = ListaComandos.size();

                //SE OBTIENE EL COMANDO (String)
                C = ListaComandos.get(largo-1);


                switch(comando){

                    //COMANDO ADD
                    case "CargarArchivosWorkspace->":
                        if(ListaComandos.isEmpty() || C.equals("CargarArchivosWorkspace->") || C.equals("Add->") || C.equals("Commit->") || C.equals("Pull->") ){
                            ejecutar = true;

                        }
                        else{
                            ejecutar = false;
                        }

                        break;

                    //COMANDO ADD    
                    case "Add->":
                        if(  C.equals("CargarArchivosWorkspace->") || C.equals("Add->") || C.equals("Commit->") || C.equals("Pull->")  ){
                        ejecutar = true;

                        }
                        else{
                            ejecutar = false;
                        }
                        break;

                    //COMANDO COMMIT
                    case "Commit->":
                        if( C.equals("Add->") ){
                        ejecutar = true;

                        }
                        else{
                            ejecutar = false;
                        }
                        break;

                    //COMANDO PUSH
                    case "Push->":
                        if( C.equals("Commit->") ){   
                        ejecutar = true;

                        }
                        else{
                            ejecutar = false;
                        }
                        break;

                    //COMANDO PULL
                    case "Pull->":
                        if( C.equals("Push->") ){
                        ejecutar = true;

                        }
                        else{
                            ejecutar = false;
                        }
                        break;

                }
            }   
        }
        return ejecutar;
    }
    
    
    public static void mostrarComandos(ArrayList<String> LineaDeTiempo){
        int i=0;
        for(i=0;i<LineaDeTiempo.size();i++){
            System.out.printf("%s",LineaDeTiempo.get(i));
        
        }
        System.out.println();
    }
    
    
 
}
