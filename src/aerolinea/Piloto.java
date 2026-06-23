package aerolinea;

public class Piloto extends Personas {
    //atributo
    private int horas;
    //constructor
    public Piloto(int horas, int id, String nombre, int edad, Vuelos vuelo, String categoria) {
        super(id, nombre, edad, vuelo, categoria);
        this.horas = horas;
    }
    
    
    @Override
    public void mostrar() {
        System.out.println("=== DATOS PILOTO ===");
        System.out.println("ID: " + getId());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Edad: " + getEdad() + " años");
        System.out.println("Horas de Vuelo acumuladas: " + this.horas + " hrs");
        System.out.println("Rango de Vuelo: " + getCategoria()); 
        
        if (getVuelo() != null) {
            System.out.println("Vuelo Asignado: " + getVuelo().getVuelo() + " con destino a " + getVuelo().getDestino());
        } else {
            System.out.println("Vuelo Asignado: Ninguno");
        }
        System.out.println("---------------------");
    }

    @Override
    public void calcularCategoria() {
        if (this.horas >= 1000) {
            setCategoria("Comandante");
        } else {
            setCategoria("Co-Piloto");
        }
    }
    
    //getters y setters
    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }
    
    
    
}
