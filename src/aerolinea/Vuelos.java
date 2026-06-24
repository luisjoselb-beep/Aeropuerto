package aerolinea;

public class Vuelos {
    
    private String nombre;
    private int vuelo;
    private String destino;

    public Vuelos(String nombre, int vuelo, String destino) {
        this.nombre = nombre;
        this.vuelo = vuelo;
        this.destino = destino;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVuelo() {
        return vuelo;
    }

    public void setVuelo(int vuelo) {
        this.vuelo = vuelo;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
    
    
}
