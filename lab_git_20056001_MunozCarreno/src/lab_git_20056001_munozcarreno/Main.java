
package lab_git_20056001_munozcarreno;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        String n;
       String inf;
       Scanner S = new Scanner(System.in);
       System.out.println("INGRESO DE UN ARCHIVO");
       System.out.println("nombre de archivo -->");
       n = S.nextLine();
       System.out.println("contenido de archivo -->");
       inf = S.nextLine();
       ArchTextoPlano arch = new ArchTextoPlano(n,inf);
       arch.mostrarInformacion();
    }
    
}
