
package implementacion;

import vista.LoginVista;
import vista.ReportesVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginControlador {
    
    private LoginVista ventanaLogin;
    private Principal controladorPrincipal;
    
    public LoginControlador(Principal controladorPrincipal) {
        this.controladorPrincipal = controladorPrincipal;
    }

    public void iniciar() {
        ventanaLogin = new LoginVista();
        ventanaLogin.setLocationRelativeTo(null);
        ventanaLogin.setVisible(true);

        ventanaLogin.conectarBoton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = ventanaLogin.getUsuario();
                String password = ventanaLogin.getPassword();

                if (usuario.equals("admin") && password.equals("avion123")) {
                    ventanaLogin.mostrarMensaje("¡Acceso concedido!");
                    ventanaLogin.dispose();

                    ReportesVista ventanaReportes = new ReportesVista();

                    VistaPrincipalControlador controladorPrincipalMenu = new VistaPrincipalControlador(ventanaReportes, controladorPrincipal);

                    controladorPrincipalMenu.iniciar();
                } else {
                    ventanaLogin.mostrarMensaje("Usuario o contraseña incorrectos.");
                }
            }
        });
    }
    
}
