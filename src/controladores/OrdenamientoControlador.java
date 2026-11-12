package controladores;

import servicios.DocumentoServicio;
import vistas.OrdenamientoVista;

public class OrdenamientoControlador {

    private OrdenamientoVista vista;

    public OrdenamientoControlador(OrdenamientoVista vista) {
        this.vista = vista;

        this.vista.mostrarDatos(DocumentoServicio.getEncabezados(), null);
        this.vista.setOrdenarBurbuja(evento -> ordenarBurbuja());
        this.vista.setOrdenarRapido(evento -> ordenarRapido());
    }

    private void ordenarBurbuja() {

    }

    private void ordenarRapido() {

    }

}
