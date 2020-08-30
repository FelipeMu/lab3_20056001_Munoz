package lab_git_20056001_munozcarreno;


import java.util.ArrayList;

/*
descricion clase: esta clase tiene el objetivo de almacenar métodos que
ayuden al desarrollo del programa.

atributos: sin atributos

metodos incorporados:


- ComandoPermitido
- mostrarComandos (metodo extra que permite ver el el transcurso de los comandos incorporados,
                   para activarlo, se debe sacar los 2 slash (comentario) que se encuentran en la clase Main,
                   especificamente en el switch para la selecion de los comandos).

*/
public class MetodosExtras {
    
    /**
     * CONSTRUCTOR
     */
    public MetodosExtras() {
    }
    
    //METODOS
    
    /**
     * 
     * @param ListaComandos
     * @param comando
     * @return boolean
     */
    // descripcion metodo: Este metodo mas que aportar al simulador, se le atribuye la mision de
    // analizar los comandos ingresados por el usuario y verificar si son validos en aquel instante.
    public static boolean ComandoPermitido(ArrayList<String> ListaComandos,String comando){
       
        boolean ejecutar = true;
        //SE PROCEDE A VERIFICAR QUE EL COMANDO "comando" SELECCIONADO SEA VALIDO
        
        //COMANDO Add _____________________
        
        //STRING QUE ALMACENARA EL ULTIMO COMANDO EJECUTADO
        String C;
        
        //ENTERO QUE ALMACENA EL TAMANO DE LA LISTA ListaComandos
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
    
   
    //descripcion metodo: El metodo tiene como objetivo mostrar el transcurso de los 
    // comandos ejecutador por el usuario.
    /**
     * SELECTOR
     * @param LineaDeTiempo 
     */
    public static void mostrarComandos(ArrayList<String> LineaDeTiempo){
        int i=0;
        for(i=0;i<LineaDeTiempo.size();i++){
            System.out.printf("%s",LineaDeTiempo.get(i));
        
        }
        System.out.println();
    }
    
    
 
}
