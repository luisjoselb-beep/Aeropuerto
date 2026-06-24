package aerolinea;

public class Piloto extends Personas {
    //atributo
    private int horas;
    //constructor
    public Piloto(int horas, int id, String nombre, int edad, Vuelos vuelo, String categoria) {
        super(id, nombre, edad, vuelo, categoria);
        this.horas = horas;
        
        calcularCategoria();
    }
    
    
    @Override
    public String mostrar() {
        String info = "ID: " + getId() + " | Nombre: " + getNombre() + " | Rango de Vuelo: " + getCategoria() + "\n"
                    + "   Detalles -> Horas de vuelo: " + this.horas + " hrs";
        if (getVuelo() != null) {
            info += " | Vuelo: " + getVuelo().getVuelo() + " -> " + getVuelo().getDestino();
        }
        return info;
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
