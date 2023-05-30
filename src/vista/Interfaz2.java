package vista;

import controlador.EspacioController;
import modelo.Espacio;
import modelo.EspacioDAO;
import modelo.EspacioDAOImp;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class Interfaz2 extends JFrame{
    private JTextField id_espacio;
    private JTextField nombre;
    private JTextArea descripcion;
    private JRadioButton ordenadorSi;
    private JRadioButton ordenadorNo;
    private JRadioButton proyectorSi;
    private JRadioButton proyectorNo;
    private JRadioButton pizarraSi;
    private JRadioButton pizarraNo;
    private JTextField capacidad;
    private JPanel panel1;
    private JButton actualizarButton;
    private JButton delante;
    private JButton detras;
    private JButton borrarButton;
    private JButton insertarButton;

    private int indiceEspacioActual;
    private EspacioController espacioController;

    public void setEspacioController(EspacioController espacioController) {
        this.espacioController = espacioController;
    }

    public Interfaz2()  {
        crearVista();

        insertarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int idEspacio = Integer.parseInt(id_espacio.getText());
                    String descripcion2 = descripcion.getText();
                    int capacidad2 = Integer.parseInt(capacidad.getText());
                    int ordenadores = ordenadorSi.isSelected() ? 1 : 0;
                    int proyector = proyectorSi.isSelected() ? 1 : 0;
                    int pizarra = pizarraSi.isSelected() ? 1 : 0;
                    String nombre2 = nombre.getText();

                    Espacio nuevoEspacio = new Espacio(idEspacio, descripcion2, capacidad2, ordenadores, pizarra, proyector, nombre2, 0);

                   espacioController.agregarEspacio(nuevoEspacio);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Interfaz2.this, "Error de formato en los campos numéricos");
                }


            }

        });
        borrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int idEspacio = Integer.parseInt(id_espacio.getText());
                    EspacioDAO espacioDAO = new EspacioDAOImp();
                    
                    espacioController.eliminarEspacio(idEspacio);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Interfaz2.this, "Error de formato en los campos numéricos");
                }
            }
        });

        delante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    indiceEspacioActual=0;
                    if (id_espacio.getText().compareTo("") != 0) {//si  no esta vacio, va a empezar a avanzar desde el primer elemento
                        int idEspacio = Integer.parseInt(id_espacio.getText());
                        indiceEspacioActual=idEspacio;
                    }

                    List<Espacio> espacios = espacioController.obtenerTodosLosEspacios();
                    if(espacios==null) {

                        return;
                    }
                    if(indiceEspacioActual==espacios.size()){  //si hemos llegado al ultimo espacio, no avanza
                        JOptionPane.showMessageDialog(Interfaz2.this,"No se puede avanzar");
                        return;
                    }

                    Espacio espacio = espacios.get(indiceEspacioActual);
                    id_espacio.setText(String.valueOf(espacio.getId_espacio()));
                    descripcion.setText(espacio.getDescripcion());
                    capacidad.setText(String.valueOf(espacio.getCapacidad()));
                    ordenadorSi.setSelected(espacio.getOrdenadores()==1);
                    ordenadorNo.setSelected(espacio.getOrdenadores()==0);
                    proyectorSi.setSelected(espacio.getProyector()==1);
                    proyectorNo.setSelected(espacio.getProyector()==0);
                    pizarraSi.setSelected(espacio.getPizarra()==1);
                    pizarraNo.setSelected(espacio.getPizarra()==0);
                    nombre.setText(String.valueOf(espacio.getNombre()));
                    indiceEspacioActual++;

                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        detras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                List<Espacio> espacios = null;

                espacios = espacioController.obtenerTodosLosEspacios();

                if(espacios==null) {
                    return;
                }
                if (id_espacio.getText().compareTo("") != 0) {//si  no esta vacio, va a empezar a avanzar desde el primer elemento
                    int idEspacio = Integer.parseInt(id_espacio.getText());
                    indiceEspacioActual=idEspacio-1;
                }
                else {
                    indiceEspacioActual=espacios.size();
                }
                indiceEspacioActual--;

                if (indiceEspacioActual<0){
                    JOptionPane.showMessageDialog(Interfaz2.this,"No se puede retroceder");
                    return;
                }
                Espacio espacio = espacios.get(indiceEspacioActual);
                id_espacio.setText(String.valueOf(espacio.getId_espacio()));
                descripcion.setText(espacio.getDescripcion());
                capacidad.setText(String.valueOf(espacio.getCapacidad()));
                ordenadorSi.setSelected(espacio.getOrdenadores()==1);
                ordenadorNo.setSelected(espacio.getOrdenadores()==0);
                proyectorSi.setSelected(espacio.getProyector()==1);
                proyectorNo.setSelected(espacio.getProyector()==0);
                pizarraSi.setSelected(espacio.getPizarra()==1);
                pizarraNo.setSelected(espacio.getPizarra()==0);
                nombre.setText(String.valueOf(espacio.getNombre()));

            }
        });
        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int idEspacio = Integer.parseInt(id_espacio.getText());
                    String descripcion2 = descripcion.getText();
                    int capacidad2 = Integer.parseInt(capacidad.getText());
                    int ordenadores = ordenadorSi.isSelected() ? 1 : 0;
                    int proyector = proyectorSi.isSelected() ? 1 : 0;
                    int pizarra = pizarraSi.isSelected() ? 1 : 0;
                    String nombre2 = nombre.getText();

                    Espacio espacioActualizado = new Espacio(idEspacio, descripcion2, capacidad2, ordenadores, pizarra, proyector, nombre2, 0);


                  espacioController.actualizarEspacio(espacioActualizado, idEspacio);


                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Interfaz2.this, "Error de formato en los campos numéricos");
                }
            }
        });
            }


    public void limpiarCampos() {
        id_espacio.setText("");
        descripcion.setText("");
        capacidad.setText("");
        ordenadorSi.setSelected(false);
        ordenadorNo.setSelected(false);
        proyectorSi.setSelected(false);
        proyectorNo.setSelected(false);
        pizarraSi.setSelected(false);
        pizarraNo.setSelected(false);
        nombre.setText("");

    }

    private void crearVista() {
        setTitle("ESPACIOS");
        Container container = getContentPane();
        container.add(panel1);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(800,800);
        setResizable(false);


    }


    public void mostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(Interfaz2.this, mensaje);
        
    }




}
