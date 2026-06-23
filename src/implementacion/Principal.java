package implementacion;

import aerolinea.*; 
import data.Datos; 
import java.util.ArrayList;

public class Principal implements Datos {
    
    private ArrayList<Vuelos> viajes = new ArrayList<>();
    private ArrayList<Personas> viajeros = new ArrayList<>();

    //main
    public static void main(String[] args) {
        Principal programa = new Principal();
        
        LoginControlador login = new LoginControlador(programa);
        login.iniciar();
    }    
     public void ejecutarSistema() {
        cargarDatos();
        
        // Se imprimen los metodos
        System.out.println(mostrarCategoria());
        System.out.println();
        
        System.out.println("====== ESTADISTICAS DE DESTINOS ======");
        System.out.println(destinoFavorito());
        System.out.println();
        
        System.out.println("====== RECONOCIMIENTO AL PILOTO ======");
        System.out.println(mejorPiloto());
    }

    private Vuelos buscarVuelo(String codigo) {
        for (Vuelos v : viajes) {
            if (v.getVuelo() == Integer.parseInt(codigo)) {
                return v;
            }
        }
        return null;
    }

    //CargarDatos
    public void cargarDatos() {
        viajes.clear();
        viajeros.clear();

        for (int i = 0; i < datos_vuelos.length; i++) {
            String[] partesVuelo = datos_vuelos[i].split(";");
            String aerolinea = partesVuelo[0];
            int numVuelo = Integer.parseInt(partesVuelo[1]);
            String destino = partesVuelo[2];
            
            Vuelos nuevoVuelo = new Vuelos(aerolinea, numVuelo, destino);
            viajes.add(nuevoVuelo);
        }

        for (int i = 0; i < datos_persona.length; i++) {
            String[] partesPersona = datos_persona[i].split(";");
            String tipoRol = partesPersona[partesPersona.length - 1]; 

            switch (tipoRol) {
                case "Pasajero":
                    String numAsiento = partesPersona[0];
                    int valorPasaje = Integer.parseInt(partesPersona[1]);
                    int idPas = Integer.parseInt(partesPersona[2]); 
                    String nombrePas = partesPersona[3];
                    int edadPas = Integer.parseInt(partesPersona[4]);
                    String codigoVueloPas = partesPersona[5];
                    
                    Vuelos vueloPas = buscarVuelo(codigoVueloPas);

                    Pasajero p = new Pasajero(numAsiento, valorPasaje, idPas, nombrePas, edadPas, vueloPas, tipoRol);
                    viajeros.add(p);
                    break;
                    
                case "Azafata":
                    double altura = Double.parseDouble(partesPersona[0]);
                    int idiomas = Integer.parseInt(partesPersona[1]);
                    int idAz = Integer.parseInt(partesPersona[2]); 
                    String nombreAz = partesPersona[3];
                    int edadAz = Integer.parseInt(partesPersona[4]);
                    String codigoVueloAz = partesPersona[5];
                    
                    Vuelos vueloAz = buscarVuelo(codigoVueloAz);
                    
                    Azafata az = new Azafata(altura, idiomas, idAz, nombreAz, edadAz, vueloAz, tipoRol);
                    viajeros.add(az);
                    break;
                    
                case "Piloto":
                    int horas = Integer.parseInt(partesPersona[0]);
                    int idPi = Integer.parseInt(partesPersona[1]); 
                    String nombrePi = partesPersona[2];
                    int edadPi = Integer.parseInt(partesPersona[3]);
                    String codigoVueloPi = partesPersona[4];
                    
                    Vuelos vueloPi = buscarVuelo(codigoVueloPi);

                    Piloto pi = new Piloto(horas, idPi, nombrePi, edadPi, vueloPi, tipoRol);
                    viajeros.add(pi);
                    break;
            }
        }
    }

    //Reporte
    public String mostrarCategoria() {
        String resultado = "====== LISTADO DE PASAJEROS Y TRIPULACION ======\n";
        for (int i = 0; i < viajeros.size(); i++) {
            Personas p = viajeros.get(i);
            p.mostrar(); 
            resultado += "ID: " + p.getId() + " | Nombre: " + p.getNombre() + " | Rol: " + p.getClass().getSimpleName() + "\n";
        }
        return resultado;
    }

    //Destino Favorito
    public String destinoFavorito() {
        String destinoGanador = "";
        int maxPasajeros = -1;
        int dineroGanador = 0;

        for (int i = 0; i < viajes.size(); i++) {
            Vuelos v = viajes.get(i);
            int contadorPasajerosVueloActual = 0;
            int dineroAcumuladoVueloActual = 0;

            for (int j = 0; j < viajeros.size(); j++) {
                Personas p = viajeros.get(j);
                
                if (p instanceof Pasajero && p.getVuelo().equals(v)) {
                    Pasajero tempPasajero = (Pasajero) p;
                    contadorPasajerosVueloActual++;
                    dineroAcumuladoVueloActual += tempPasajero.getValorPasaje();
                }
            }

            if (contadorPasajerosVueloActual > maxPasajeros) {
                maxPasajeros = contadorPasajerosVueloActual;
                destinoGanador = v.getDestino();
                dineroGanador = dineroAcumuladoVueloActual;
            }
        }

        return "Destino con mayor número de pasajeros: " + destinoGanador + "\n" +
               "Cantidad de pasajeros: " + maxPasajeros + "\n" +
               "Monto total recaudado en pasajes: $" + dineroGanador;
    }

    // Mejor Piloto
    public String mejorPiloto() {
        Piloto elMejor = null;
        int maxHoras = -1;

        for (int i = 0; i < viajeros.size(); i++) {
            Personas p = viajeros.get(i);
            
            if (p instanceof Piloto) {
                Piloto pilotoActual = (Piloto) p;
                if (pilotoActual.getHoras() > maxHoras) {
                    maxHoras = pilotoActual.getHoras();
                    elMejor = pilotoActual;
                }
            }
        }

        if (elMejor != null) {
            return "Piloto con mayor experiencia: " + elMejor.getNombre() + "\n" +
                   "Total de horas de vuelo: " + elMejor.getHoras() + " horas";
        } else {
            return "No se encontraron pilotos en el registro.";
        }
    }

    // Getters
    public ArrayList<Vuelos> getViajes() {
        return viajes;
    }

    public ArrayList<Personas> getViajeros() {
        return viajeros;
    }
}
