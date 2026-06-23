package aerolinea;

public class Azafata extends Personas {
    
    private double altura;
    private int idiomas;

    public Azafata(double altura, int idiomas, int id, String nombre, int edad, Vuelos vuelo, String categoria) {
        super(id, nombre, edad, vuelo, categoria);
        this.altura = altura;
        this.idiomas = idiomas;
        
        calcularCategoria();
    }

    
    
    @Override
    public void mostrar() {
        System.out.println("=== DATOS AZAFATA ===");
        System.out.println("ID: " + getId());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Edad: " + getEdad() + " años");
        System.out.println("Altura: " + this.altura + " m");
        System.out.println("Idiomas dominados: " + this.idiomas);
        System.out.println("Categoría de Vuelo: " + getCategoria());
        if (getVuelo() != null) {
            System.out.println("Vuelo Asignado: " + getVuelo().getVuelo() + " con destino a " + getVuelo().getDestino());
        } else {
            System.out.println("Vuelo Asignado: Ninguno");
        }
        System.out.println("---------------------");
    }

    @Override
    public void calcularCategoria() {
        if (this.idiomas >= 3) {
            setCategoria("Internacional");
        } else {
            setCategoria("Nacional");
        }
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public int getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(int idiomas) {
        this.idiomas = idiomas;
    }
    
    

    
    
    
}
