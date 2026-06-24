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
    public String mostrar() {
        String info = "ID: " + getId() + " | Nombre: " + getNombre() + " | Categoría de Vuelo: "+ getCategoria() + "\n"
                    + "   Detalles -> Altura: " + this.altura + "m | Idiomas: " + this.idiomas;
        if (getVuelo() != null) {
            info += " | Vuelo: " + getVuelo().getVuelo() + " -> " + getVuelo().getDestino();
        }
        return info;
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
