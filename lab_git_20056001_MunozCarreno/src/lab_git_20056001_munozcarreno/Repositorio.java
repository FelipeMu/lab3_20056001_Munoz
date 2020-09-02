
package lab_git_20056001_munozcarreno;

/*
descripción clase: Esta clase tiene como objetivo inicializar el repositorio, 
en otras palabras, definir el nombre del reposiotorio, el autor del repositorio
e inicializar todas las zonas de trsbajo.

atributos: 

nombre_repositorio (nombre del repositorio)
autor (autor del repositorio)
Zonas (objeto que corresponde al tipo de clase ZonasDeTrabajo)


metodos incorporados: 

- toString


*/






public class Repositorio {
    //ATRIBUTOS
    private String nombre_repositorio;
    private String autor;
    private ZonasDeTrabajo Zonas;
    
    
    
    /**
     * 
     * @param nomRep
     * @param autor 
     */
    public Repositorio(String nomRep,String autor){
        this.nombre_repositorio = nomRep;
        this.autor = autor;
        Zonas = new ZonasDeTrabajo();
    
    }
    
    
    //GETTERS Y SETTERS

    public String getNombre_repositorio() {
        return nombre_repositorio;
    }

    public void setNombre_repositorio(String nombre_repositorio) {
        this.nombre_repositorio = nombre_repositorio;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public ZonasDeTrabajo getZonas() {
        return Zonas;
    }

    public void setZonas(ZonasDeTrabajo Zonas) {
        this.Zonas = Zonas;
    }

    @Override
    public String toString() {
        return "Repositorio[" + "nombre_repositorio= " + nombre_repositorio + ", autor= " + autor + ",\n Zonas[\n" + Zonas + ']';
    }
    
    
}
