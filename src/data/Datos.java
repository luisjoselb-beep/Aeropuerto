package data;


public interface Datos {
    // Formato: CODIGO_VUELO;AEROLINEA;DESTINO
    String[] datos_vuelos = {
        "V001;Avianca;Bogota",
        "V002;Laser;Caracas",
        "V003;Rutaca;Porlamar"
    };
    
    // Para las personas, usamos un truco sencillo: el 5to dato define el ROL.
    // Pasajero: NumAsiento;ValorPasaje;ID;Nombre;Edad;Vuelo;Pasajero
    // Azafata:  Altura;Idiomas;ID;Nombre;Edad;Vuelo;Azafata
    // Piloto:   HorasDeVuelo;ID;Nombre;Edad;Vuelo;Piloto
    String[] datos_persona = {
        "101;Pedro Perez;25;V001;Pasajero;12A;450",
        "102;Maria Rojas;30;V001;Azafata;1.68;3",
        "103;Carlos Sanchez;42;V001;Piloto;1500",
        "104;Ana Colmenares;19;V001;Pasajero;14B;380",
        "105;Luis Ramirez;28;V002;Pasajero;05C;520",
        "106;Juan Hernandez;50;V002;Piloto;900",
        "107;Diana Moreno;31;V002;Azafata;1.72;2",
        "108;Gabriela Soler;34;V003;Pasajero;02A;600"
    };

}
