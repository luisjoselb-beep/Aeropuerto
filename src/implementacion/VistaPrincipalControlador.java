package implementacion;

import vista.ReportesVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaPrincipalControlador {
    
    private ReportesVista vista;
    private Principal modelo;

    public VistaPrincipalControlador(ReportesVista vista, Principal modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }
    
    //Pantalla Reporte
    public void iniciar() {
        vista.setSize(750, 480);
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        modelo.cargarDatos();

        //Boton Cargar Datos
        vista.getBtnCargarDatos().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista.cambiarTamanoTextoNormal(14);
                modelo.cargarDatos();
                vista.setReporteTexto("¡Datos cargados y procesados con éxito!");
            }
        });

        // Boton Reporte
        vista.getBtnReporte().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista.cambiarTamanoTextoNormal(14);
                String reporte = modelo.mostrarCategoria();
                vista.setReporteTexto(reporte);
            }
        });

        //Boton Piloto destacado
        vista.getBtnPiloto().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista.cambiarTamanoTextoNormal(14);
                String piloto = modelo.mejorPiloto();
                vista.setReporteTexto(piloto);
            }
        });

        //Boton Destino Favorito
        vista.getBtnDestino().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista.cambiarTamanoTextoNormal(14);
                String destino = modelo.destinoFavorito();
                vista.setReporteTexto(destino);
            }
        });
    }
}