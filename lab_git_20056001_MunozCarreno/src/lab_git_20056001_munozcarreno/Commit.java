package lab_git_20056001_munozcarreno;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/*
descripcion clase: Esta clase funciona como el constructor de un commit.

atributos: autor (autor del commit), tiempo (fecha y hora de creacion del commit),
mensaje (es el mensaje descriptivo) y archivosCommit (Es una lista de tipo
Arraylist<ArchTextoPlano>, donde cada archivo es de tipo ArchTetoPlano.

metodos incorporados:

- obtenerFecha
- UnirConjuntoDeCommits
- BorrarCommitRep






*/

public class Commit {
    //ATRIBUTOS U OBJETOS
    private String autor;
    private String tiempo;
    private String mensaje;
    private ArrayList<ArchTextoPlano> archivosCommit;

    /**
     * CONSTRUCTOR
     * @param autor
     * @param tiempo
     * @param mensaje 
     * @param archivos 
     */  
    public Commit(String autor, String tiempo, String mensaje, ArrayList<ArchTextoPlano> archivos) {
        this.autor = autor;
        this.tiempo = obtenerFecha();
        this.mensaje = mensaje;
        this.archivosCommit = archivos;
    }

    //METODOS
    
    
    /**
     * SELECTOR DE FECHA Y HORA
     * @return String
     */
     //descripcon metodo: El metodo tiene como objetivo retornar la fecha y hora actual.
    public static String obtenerFecha(){
        LocalDateTime Fecha = LocalDateTime.now();
        DateTimeFormatter SET = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formattedDate = Fecha.format(SET);
        return formattedDate;
    }
    
    
    /**
     * MODIFICADOR
     * @param conj1
     * @param conj2
     * @return ArrayList<>
     */
    // descripcion metodo: El metodo concatena dos lista de commit y retorna una nueva lista tipo Commit.
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
    
    
    
    /**
    * MODIFICADOR
    * @param Lcommits
    * @return ArrayList<>
    */
    // descripcion metodo: El metodo tiene como objetivo eliminar aquellos commits repetidos,
    // tomando como filtro el autor del commit, el mensaje del commit, la cantidad de archivos, 
    // los nombres de los archivos y su contenido.
    public static ArrayList<Commit> BorrarCommitRep(ArrayList<Commit> Lcommits){
        //ITERADOR
        int i,j;
        //SI EL ACTIVADOR ES MAYOR A 1 => QUE EL ARCHIVOS ESTA MAS DE UNA VEZ
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
                                        }
                                    }
                                }
                            }
                            //SE ANALIZA EL VALOR DE llave
                            //SI SE ENTRA AL SIGUIENTE IF, SIGNIFICA QUE
                            //LOS ARCHIVOS QUE CONTIENE EL COMMIT SON DISTINTOS
                            if(llave == largoListas){
                                activador+=1;
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
                NuevosL = Commit.UnirConjuntoDeCommits(temp,NuevosL);
            }
            //SE REINICIA EL CONDICIONADOR
            activador=0;
        }
        return NuevosL;
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

    /**
     * SELECTOR
     * @return ArrayList
     */
    public ArrayList<ArchTextoPlano> getArchivosCommit() {
        return archivosCommit;
    }

    /**
     * MODIFICADOR
     * @param archivosCommit 
     */
    public void setArchivosCommit(ArrayList<ArchTextoPlano> archivosCommit) {
        this.archivosCommit = archivosCommit;
    }

    
    @Override
    public String toString() {
        return "[" + autor + ", " + tiempo + ", " + mensaje + ", " + archivosCommit + ']';
    }
    

}
