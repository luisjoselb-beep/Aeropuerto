package implementacion;

import Aerolinea.*; // Importamos el modelo
import data.Datos;   // Importamos la interfaz de datos
import java.util.ArrayList;

public class Principal implements Datos {
    
    // Atributos privados exigidos por el enunciado
    private ArrayList<vuelos> viajes = new ArrayList<>();
    private ArrayList<Personas> viajeros = new ArrayList<>();

    public static void main(String[] args) {
        Principal programa = new Principal();
        
        // Ejecución ordenada del flujo
        programa.cargarDatos();
        
        System.out.println("====== LISTADO DE PASAJEROS Y TRIPULACION ======");
        programa.mostrarCategoria();
        System.out.println();
        
        System.out.println("====== ESTADISTICAS DE DESTINOS ======");
        programa.destinoFavorito();
        System.out.println();
        
        System.out.println("====== RECONOCIMIENTO AL PILOTO ======");
        programa.mejorPiloto();
    }

    // Procesa los vectores de texto y llena las listas de objetos
    public void cargarDatos() {
        // 1. Cargar los vuelos
        for (int i = 0; i < datos_vuelos.length; i++) {
            String[] partesVuelo = datos_vuelos[i].split(";");
            String numVuelo = partesVuelo[0];
            String aerolinea = partesVuelo[1];
            String destino = partesVuelo[2];
            
            vuelos nuevoVuelo = new vuelos(aerolinea, numVuelo, destino);
            viajes.add(nuevoVuelo);
        }

        // 2. Cargar las personas
        for (int i = 0; i < datos_persona.length; i++) {
            String[] partesPersona = datos_persona[i].split(";");
            
            String id = partesPersona[0];
            String nombre = partesPersona[1];
            int edad = Integer.parseInt(partesPersona[2]);
            String vuelo = partesPersona[3];
            String tipoRol = partesPersona[4]; // Nos dice qué objeto crear

            // Evaluamos el rol para instanciar la clase hija correcta
            switch (tipoRol) {
                case "Pasajero":
                    String asiento = partesPersona[5];
                    int valorPasaje = Integer.parseInt(partesPersona[6]);
                    Pasajero p = new Pasajero(id, nombre, edad, vuelo, asiento, valorPasaje);
                    viajeros.add(p);
                    break;
                    
                case "Azafata":
                    double altura = Double.parseDouble(partesPersona[5]);
                    int idiomas = Integer.parseInt(partesPersona[6]);
                    Azafata az = new Azafata(id, nombre, edad, vuelo, altura, idiomas);
                    viajeros.add(az);
                    break;
                    
                case "Piloto":
                    int horas = Integer.parseInt(partesPersona[5]);
                    Piloto pi = new Piloto(id, nombre, edad, vuelo, horas);
                    viajeros.add(pi);
                    break;
            }
        }
    }

    // Muestra la información de cada viajero usando polimorfismo
    public void mostrarCategoria() {
        for (int i = 0; i < viajeros.size(); i++) {
            Personas p = viajeros.get(i);
            p.mostrar(); // Llama automáticamente al mostrar de cada subclase
        }
    }

    // Determina el destino con más pasajeros y su dinero recaudado
    public void destinoFavorito() {
        String destinoGanador = "";
        int maxPasajeros = -1;
        int dineroGanador = 0;

        // Recorremos cada vuelo disponible en el sistema
        for (int i = 0; i < viajes.size(); i++) {
            vuelos v = viajes.get(i);
            int contadorPasajerosVueloActual = 0;
            int dineroAcumuladoVueloActual = 0;

            // Contamos cuántos pasajeros pertenecen a este vuelo específico
            for (int j = 0; j < viajeros.size(); j++) {
                Personas p = viajeros.get(j);
                
                // Solo nos interesan los pasajeros (la tripulación no paga pasaje)
                if (p instanceof Pasajero && p.getVuelo().equals(v.getVuelo())) {
                    Pasajero tempPasajero = (Pasajero) p; // Casteo
                    contadorPasajerosVueloActual++;
                    dineroAcumuladoVueloActual += tempPasajero.getValorPasaje();
                }
            }

            // Si este destino supera al máximo encontrado antes, actualizamos
            if (contadorPasajerosVueloActual > maxPasajeros) {
                maxPasajeros = contadorPasajerosVueloActual;
                destinoGanador = v.getDestino();
                dineroGanador = dineroAcumuladoVueloActual;
            }
        }

        System.out.println("Destino con mayor numero de pasajeros: " + destinoGanador);
        System.out.println("Cantidad de pasajeros: " + maxPasajeros);
        System.out.println("Monto total recaudado en pasajes: $" + dineroGanador);
    }

    // Busca al piloto con más horas registradas
    public void mejorPiloto() {
        Piloto elMejor = null;
        int maxHoras = -1;

        for (int i = 0; i < viajeros.size(); i++) {
            Personas p = viajeros.get(i);
            
            // Filtramos únicamente a los pilotos
            if (p instanceof Piloto) {
                Piloto pilotoActual = (Piloto) p;
                
                if (pilotoActual.getHoras() > maxHoras) {
                    maxHoras = pilotoActual.getHoras();
                    elMejor = pilotoActual;
                }
            }
        }

        // Imprimimos el resultado validando que exista al menos uno
        if (elMejor != null) {
            System.out.println("Piloto con mayor experiencia: " + elMejor.getNombre());
            System.out.println("Total de horas de vuelo: " + elMejor.getHoras() + " horas");
        } else {
            System.out.println("No se encontraron pilotos en el registro.");
        }
    }
}