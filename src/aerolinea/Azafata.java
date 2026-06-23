package aerolinea;

public class Azafata extends Personas {
    
    private double altura;
    private int idiomas;

    public Azafata(double altura, int idiomas, int id, String nombre, int edad, Vuelos vuelo, String categoria) {
        super(id, nombre, edad, vuelo, categoria);
        this.altura = altura;
        this.idiomas = idiomas;
    }

    
    
    @Override
    public void mostrar() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void calcularCategoria() {
        throw new UnsupportedOperationException("Not supported yet."); 
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
