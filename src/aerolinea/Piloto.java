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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void calcularCategoria() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    //getters y setters
    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }
    
    
    
}
