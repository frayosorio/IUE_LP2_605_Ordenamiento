import controladores.OrdenamientoControlador;
import vistas.OrdenamientoVista;

public class App {
    public static void main(String[] args) throws Exception {
        var vista = new OrdenamientoVista();
        vista.setVisible(true);

        var controlador = new OrdenamientoControlador(vista);
    }
}
