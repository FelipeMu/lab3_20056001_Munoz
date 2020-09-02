package lab_git_20056001_munozcarreno;



import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


/*
DESCRIPCIÓN DE LA CLASE: Inicializa un repositorio


atributos: sin atributos.

metodos incorporados:

- gitInit();

*/
public class Git {
    
    
    /**
     * CONSTRUCTOR
     */
    public Git() {
        
    }
    
    
    //MÉTODOS   
    
    /**
     * 
     * @return Repositorio
     */
    // descripcion metodo: la finalidad del metodo es inicializar el repositorio,
    // generando el nombre del repositorio, el autor, la fecha de creacion y las
    // 4 zonas de trabajo inicializadas.
    public static Repositorio gitInit(){
       Scanner S = new Scanner(System.in); 
       String nombreRep;
       String autor;
        
       System.out.println("###SIMULACION DE GIT###");
       System.out.printf("(*) Ingrese el nombre del repositorio: ");
       nombreRep = S.nextLine();
       System.out.println();
       System.out.printf("(*) Ingrese nombre del autor: ");
       autor = S.nextLine();
       System.out.println();
       
       
       //CREACION DE REPOSITORIO
       Repositorio repositorio = new Repositorio(nombreRep,autor);
       return repositorio;
    }
      
    
     
}
