package vista;

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

                    EspacioDAO espacioDAO = new EspacioDAOImp();
                    boolean exito = espacioDAO.insertarEspacio(nuevoEspacio);

                    if (exito) {
                        JOptionPane.showMessageDialog(Interfaz2.this, "Espacio insertado correctamente");
                        // Limpiar los campos después de la inserción
                        limpiarCampos();
                    } else {
                        JOptionPane.showMessageDialog(Interfaz2.this, "Error al insertar el espacio");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Interfaz2.this, "Error de formato en los campos numéricos");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(Interfaz2.this, "Error de base de datos: " + ex.getMessage());
                }


            }

        });
        borrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int idEspacio = Integer.parseInt(id_espacio.getText());
                    EspacioDAO espacioDAO = new EspacioDAOImp();
                    boolean exito = espacioDAO.eliminarEspacioPorID(idEspacio);

                    if (exito) {
                        JOptionPane.showMessageDialog(Interfaz2.this, "Espacio borrado correctamente");
                        // Limpiar los campos después de la inserción
                        limpiarCampos();
                    } else {
                        JOptionPane.showMessageDialog(Interfaz2.this, "Error al borrar el espacio");
                    }

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
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
                    EspacioDAO espacioDAO = new EspacioDAOImp();
                    List<Espacio> espacios = espacioDAO.obtenerTodosLosEspacios();
                    if(espacios.isEmpty()) {
                        JOptionPane.showMessageDialog(Interfaz2.this,"No hay espacios");
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
                try {
                    EspacioDAO espacioDAO = new EspacioDAOImp();
                    List<Espacio> espacios = null;

                        espacios = espacioDAO.obtenerTodosLosEspacios();

                    if(espacios.isEmpty()) {
                        JOptionPane.showMessageDialog(Interfaz2.this, "No hay espacios");
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

                } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
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

                    EspacioDAO espacioDAO = new EspacioDAOImp();
                    boolean exito = espacioDAO.actualizarEspacioPorID(espacioActualizado, idEspacio);

                    if (exito) {
                        JOptionPane.showMessageDialog(Interfaz2.this, "Espacio actualizado correctamente");

                    } else {
                        JOptionPane.showMessageDialog(Interfaz2.this, "Error al actualizar el espacio");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Interfaz2.this, "Error de formato en los campos numéricos");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(Interfaz2.this, "Error de base de datos: " + ex.getMessage());

                    System.out.println("prueba");
                }
            }
        });
            }


    private void limpiarCampos() {
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


    public static void main(String[] args) {
        JFrame frame = new Interfaz2();
        frame.setVisible(true);



    }


}
