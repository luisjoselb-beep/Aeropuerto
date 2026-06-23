
package implementacion;

import vista.LoginVista;
import vista.ReportesVista;//**************
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginControlador {
    
    private LoginVista ventanaLogin;
    private Principal controladorPrincipal; // Referencia al main de tu compañero
    private ReportesVista ventanaReportes; //**********************
    
    // El constructor recibe la clase de tu compañero para poder despertarla luego
    public LoginControlador(Principal controladorPrincipal) {
        this.controladorPrincipal = controladorPrincipal;
    }

    public void iniciar() {
        ventanaLogin = new LoginVista();
        ventanaLogin.setLocationRelativeTo(null); // Centra la ventana
        ventanaLogin.setVisible(true);            // Muestra el JFrame

        // Añadimos el comportamiento al botón ingresar
        ventanaLogin.conectarBoton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = ventanaLogin.getUsuario();
                String password = ventanaLogin.getPassword();

                // Validamos credenciales de forma académica
                if (usuario.equals("admin") && password.equals("unet2026")) {
                    ventanaLogin.mostrarMensaje("¡Acceso concedido!");
                    ventanaLogin.dispose(); // Cerramos el login
                    
                    // =========================================================
                    //  3. AQUÍ ABRIMOS LA PANTALLA DE REPORTES
                    // =========================================================
                    ventanaReportes = new ReportesVista();
                    
                    // Centra la pantalla de reportes en el monitor
                    ventanaReportes.setLocationRelativeTo(null); 
                    
                    // Hace visible la nueva ventana
                    ventanaReportes.setVisible(true);
                    // LE DECIMOS AL CÓDIGO DE TU COMPAÑERO QUE YA PUEDE CORRER
                    //controladorPrincipal.ejecutarSistema(); 
                } else {
                    ventanaLogin.mostrarMensaje("Usuario o contraseña incorrectos.");
                }
            }
        });
    }
    
}
