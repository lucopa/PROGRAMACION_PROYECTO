package vista;

import javax.swing.*;
import java.awt.*;

public class ListaInterfaz extends JFrame {


    private JTextField idEspacioField;
    private JTextArea descripcionArea;
    private JTextField capacidadField;
    private JRadioButton siOrdenadoresRadioButton;
    private JRadioButton noOrdenadoresRadioButton;
    private JRadioButton siProyectorRadioButton;
    private JRadioButton noProyectorRadioButton;
    private JRadioButton siPizarraRadioButton;
    private JRadioButton noPizarraRadioButton;
    private JTextField nombreField;



    public ListaInterfaz() {



        setTitle("Lista de Espacios");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());



        JPanel formularioPanel = new JPanel(new GridLayout(0, 1));

        this.getContentPane().add(formularioPanel);

        


        formularioPanel.add(new JLabel("ID Espacio:"));
        idEspacioField = new JTextField();
        formularioPanel.add(idEspacioField);

        formularioPanel.add(new JLabel("Descripción:"));
        descripcionArea = new JTextArea();
        formularioPanel.add(new JScrollPane(descripcionArea));

        formularioPanel.add(new JLabel("Capacidad:"));
        capacidadField = new JTextField();
        formularioPanel.add(capacidadField);

        formularioPanel.add(new JLabel("Ordenadores:"));
        ButtonGroup ordenadoresGroup = new ButtonGroup();
        siOrdenadoresRadioButton = new JRadioButton("Sí");
        noOrdenadoresRadioButton = new JRadioButton("No");
        ordenadoresGroup.add(siOrdenadoresRadioButton);
        ordenadoresGroup.add(noOrdenadoresRadioButton);
        formularioPanel.add(siOrdenadoresRadioButton);
        formularioPanel.add(noOrdenadoresRadioButton);

        formularioPanel.add(new JLabel("Proyector:"));
        ButtonGroup proyectorGroup = new ButtonGroup();
        siProyectorRadioButton = new JRadioButton("Sí");
        noProyectorRadioButton = new JRadioButton("No");
        proyectorGroup.add(siProyectorRadioButton);
        proyectorGroup.add(noProyectorRadioButton);
        formularioPanel.add(siProyectorRadioButton);
        formularioPanel.add(noProyectorRadioButton);

        formularioPanel.add(new JLabel("Pizarra:"));
        ButtonGroup pizarraGroup = new ButtonGroup();
        siPizarraRadioButton = new JRadioButton("Sí");
        noPizarraRadioButton = new JRadioButton("No");
        pizarraGroup.add(siPizarraRadioButton);
        pizarraGroup.add(noPizarraRadioButton);
        formularioPanel.add(siPizarraRadioButton);
        formularioPanel.add(noPizarraRadioButton);

        formularioPanel.add(new JLabel("Nombre:"));
        nombreField = new JTextField();
        formularioPanel.add(nombreField);

        add(formularioPanel, BorderLayout.CENTER);

        JPanel botonesPanel = new JPanel(new FlowLayout());

        JButton retrocederButton = new JButton("<<");
        JButton insertarButton = new JButton("Insertar");
        JButton borrarButton = new JButton("Borrar");
        JButton actualizarButton = new JButton("Actualizar");
        JButton avanzarButton = new JButton(">>");



        botonesPanel.add(retrocederButton);
        botonesPanel.add(insertarButton);
        botonesPanel.add(borrarButton);
        botonesPanel.add(actualizarButton);
        botonesPanel.add(avanzarButton);



        add(botonesPanel, BorderLayout.SOUTH);



        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ListaInterfaz();
            }
        });
    }
}





