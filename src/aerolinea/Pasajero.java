
package aerolinea;


public class Pasajero extends Personas{

    public Pasajero(String numAsiento, int valorPasaje, int id, String nombre, int edad, Vuelos vuelo, String categoria) {
        super(id, nombre, edad, vuelo, categoria);
        this.numAsiento = numAsiento;
        this.valorPasaje = valorPasaje;
    }

        
    
    
    @Override
    public void mostrar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void calcularCategoria() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private String numAsiento;
    private int valorPasaje;

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
