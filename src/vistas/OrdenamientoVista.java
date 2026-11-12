package vistas;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrdenamientoVista extends JFrame {

    private JButton btnOrdenarBurbuja;
    private JButton btnOrdenarRapido;
    private JButton btnOrdenarInsercion;
    private JButton btnOrdenarMezcla;
    private JToolBar tbOrdenamiento;
    private JComboBox cmbCriterio;
    private JTextField txtTiempo;
    private JButton btnBuscar;
    private JTextField txtBuscar;

    private JTable tblDocumentos;

    private String[] encabezados = new String[] { "#", "Primer Apellido", "Segundo Apellido", "Nombres", "Documento" };

    public OrdenamientoVista() {

        tbOrdenamiento = new JToolBar();
        btnOrdenarBurbuja = new JButton();
        btnOrdenarInsercion = new JButton();
        btnOrdenarRapido = new JButton();
        btnOrdenarMezcla = new JButton();
        cmbCriterio = new JComboBox();
        txtTiempo = new JTextField();
        txtTiempo.setEditable(false);

        btnBuscar = new JButton();
        txtBuscar = new JTextField();

        tblDocumentos = new JTable();
        JScrollPane spDocumentos=new JScrollPane(tblDocumentos);

        setSize(600, 400);
        setTitle("Ordenamiento Documentos");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        btnOrdenarBurbuja.setIcon(new ImageIcon(getClass().getResource("/iconos/Ordenar.png")));
        btnOrdenarBurbuja.setToolTipText("Ordenar Burbuja");
        tbOrdenamiento.add(btnOrdenarBurbuja);

        btnOrdenarRapido.setIcon(new ImageIcon(getClass().getResource("/iconos/OrdenarRapido.png")));
        btnOrdenarRapido.setToolTipText("Ordenar Rapido");
        tbOrdenamiento.add(btnOrdenarRapido);

        btnOrdenarInsercion.setIcon(new ImageIcon(getClass().getResource("/iconos/OrdenarInsercion.png")));
        btnOrdenarInsercion.setToolTipText("Ordenar Inserción");
        tbOrdenamiento.add(btnOrdenarInsercion);

        btnOrdenarMezcla.setIcon(new ImageIcon(getClass().getResource("/iconos/OrdenarMezcla.png")));
        btnOrdenarMezcla.setToolTipText("Ordenar Mezcla");
        tbOrdenamiento.add(btnOrdenarMezcla);


        cmbCriterio.setModel(new DefaultComboBoxModel(
                new String[] { "Nombre Completo, Tipo de Documento", "Tipo de Documento, Nombre Completo" }));
        tbOrdenamiento.add(cmbCriterio);
        tbOrdenamiento.add(txtTiempo);

        btnBuscar.setIcon(new ImageIcon(getClass().getResource("/iconos/Buscar.png")));
        btnBuscar.setToolTipText("Buscar");
        tbOrdenamiento.add(btnBuscar);
        tbOrdenamiento.add(txtBuscar);

        getContentPane().add(tbOrdenamiento, BorderLayout.NORTH);
        getContentPane().add(spDocumentos, BorderLayout.CENTER);

        String nombreArchivo = System.getProperty("user.dir")
                + "/src/datos/Datos.csv";
    }

    // getters
    public int getCriterio() {
        return cmbCriterio.getSelectedIndex();
    }

    // setters
    public void setOrdenarBurbuja(ActionListener evento) {
        btnOrdenarBurbuja.addActionListener(evento);
    }

    public void setOrdenarRapido(ActionListener evento) {
        btnOrdenarRapido.addActionListener(evento);
    }

    public void setOrdenarInsercion(ActionListener evento) {
        btnOrdenarInsercion.addActionListener(evento);
    }

    public void setBuscar(ActionListener evento) {
        btnBuscar.addActionListener(evento);
    }

    // metodos publicos
    public void mostrarDatos(String[] encabezados, String[][] datos){
        var dtm = new DefaultTableModel(datos, encabezados);
        tblDocumentos.setModel(dtm);
    }
}