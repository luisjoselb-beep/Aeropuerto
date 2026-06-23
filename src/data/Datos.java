package data;

public interface Datos {
    // Formato: CODIGO_VUELO;AEROLINEA;DESTINO
    String[] datos_vuelos = {
        "Avianca;V001;Bogota",
        "Avior;V002;Caracas",
        "Conviasa;V003;Amazonas"
    };
    
    
    String[] datos_persona = {
        "12A;450;101;Martín Hernández;25;V001;Pasajero",
        "1.68;3;102;Paola Milena;30;V001;Azafata",
        "1500;103;Carlos Sánchez;42;V001;Piloto",
        "14B;380;104;Ana Beltrán;19;V001;Pasajero",
        "05C;520;105;Luis Ramirez;28;V002;Pasajero",
        "900;106;Sebastian Bautista;50;V002;Piloto",
        "1.72;2;107;Mario Moreno;31;V002;Azafata",
        "02A;600;108;Gabriela Colmenares;34;V003;Pasajero"
    };

}
