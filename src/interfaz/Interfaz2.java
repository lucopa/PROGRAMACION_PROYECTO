package interfaz;

import javax.swing.*;
import java.awt.*;

public class Interfaz2 extends JFrame{
    private JTextField textField1;
    private JTextField textField2;
    private JTextArea textArea1;
    private JRadioButton siRadioButton;
    private JRadioButton noRadioButton;
    private JRadioButton siRadioButton1;
    private JRadioButton noRadioButton1;
    private JRadioButton siRadioButton2;
    private JRadioButton noRadioButton2;
    private JTextField textField3;
    private JPanel panel1;
    private JButton actualizarButton;
    private JButton button4;
    private JButton button5;
    private JButton borrarButton;
    private JButton insertarButton;


    public Interfaz2()  {
        crearVista();


<<<<<<< Updated upstream
=======
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
                        indiceEspacioActual=idEspacio-1;
                    }
                    EspacioDAO espacioDAO = new EspacioDAOImp();
                    List<Espacio> espacios = espacioDAO.obtenerTodosLosEspacios();
                    if(espacios.isEmpty()) {
                        JOptionPane.showMessageDialog(Interfaz2.this,"No hay espacios");
                        return;
                    }
                    if(indiceEspacioActual==espacios.size()-1){  //si hemos llegado al ultimo espacio, no avanza
                        JOptionPane.showMessageDialog(Interfaz2.this,"No se puede avanzar");
                        return;
                    }
                    indiceEspacioActual++;
                    Espacio espacio = espacios.get(indiceEspacioActual);
                    id_espacio.setText(String.valueOf(espacio.getId_espacio()));
                    descripcion.setText(espacio.getDescripcion());
                    capacidad.setText(String.valueOf(espacio.getCapacidad()));
                    ordenadorSi.setText(String.valueOf(espacio.getOrdenadores()));
                    ordenadorNo.setText(String.valueOf(espacio.getOrdenadores()));
                    proyectorSi.setText(String.valueOf(espacio.getProyector()));
                    proyectorNo.setText(String.valueOf(espacio.getProyector()));
                    pizarraSi.setText(String.valueOf(espacio.getPizarra()));
                    pizarraNo.setText(String.valueOf(espacio.getPizarra()));
                    nombre.setText(String.valueOf(espacio.getNombre()));

                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        detras.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
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
                    ordenadorSi.setText(String.valueOf(espacio.getOrdenadores()));
                    ordenadorNo.setText(String.valueOf(espacio.getOrdenadores()));
                    proyectorSi.setText(String.valueOf(espacio.getProyector()));
                    proyectorNo.setText(String.valueOf(espacio.getProyector()));
                    pizarraSi.setText(String.valueOf(espacio.getPizarra()));
                    pizarraNo.setText(String.valueOf(espacio.getPizarra()));
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
>>>>>>> Stashed changes
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
