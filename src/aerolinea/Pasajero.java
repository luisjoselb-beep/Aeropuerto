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
    public String mostrar() {
        String info = "ID: " + getId() + " | Nombre: " + getNombre() + " | Tipo de Pasajero: " + getCategoria() + "\n"
                    + "   Detalles -> Asiento: " + this.numAsiento + " | Pasaje: $" + this.valorPasaje;
        if (getVuelo() != null) {
            info += " | Vuelo: " + getVuelo().getVuelo() + " -> " + getVuelo().getDestino();
        }
        return info;
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
