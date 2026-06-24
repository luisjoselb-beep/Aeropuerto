package aerolinea;


public abstract class Personas {
    private int id;
    private String nombre;
    private int edad;
    private Vuelos vuelo;
    protected String categoria;

    public Personas(int id, String nombre, int edad, Vuelos vuelo, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.vuelo = vuelo;
        this.categoria = categoria;
    }
    
    public abstract String mostrar ();
    public abstract void calcularCategoria ();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Vuelos getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelos vuelo) {
        this.vuelo = vuelo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    
    
}

