package aerolinea;


public class Pasajero extends Personas{
    
    private String numAsiento;
    private int valorPasaje;

    public Pasajero(String numAsiento, int valorPasaje, int id, String nombre, int edad, Vuelos vuelo, String categoria) {
        super(id, nombre, edad, vuelo, categoria);
        this.numAsiento = numAsiento;
        this.valorPasaje = valorPasaje;
        
        calcularCategoria();
    }
    
    @Override
    public void mostrar() {
        System.out.println("=== DATOS PASAJERO ===");
        System.out.println("ID: " + getId());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Edad: " + getEdad() + " años");
        System.out.println("Asiento: " + this.numAsiento);
        System.out.println("Valor del Pasaje: $" + this.valorPasaje);
        System.out.println("Tipo de Pasajero: " + getCategoria()); 
        
        if (getVuelo() != null) {
            System.out.println("Vuelo Asignado: " + getVuelo().getVuelo() + " con destino a " + getVuelo().getDestino());
        } else {
            System.out.println("Vuelo Asignado: Ninguno");
        }
        System.out.println("---------------------");
    }

    @Override
    public void calcularCategoria() {
        if (this.valorPasaje >= 400) {
            setCategoria("VIP");
        } else {
            setCategoria("Turista");
        }
    }
    
   

    public String getNumAsiento() {
        return numAsiento;
    }

    public void setNumAsiento(String numAsiento) {
        this.numAsiento = numAsiento;
    }

    public int getValorPasaje() {
        return valorPasaje;
    }

    public void setValorPasaje(int valorPasaje) {
        this.valorPasaje = valorPasaje;
    }
    
    
    
    
}
