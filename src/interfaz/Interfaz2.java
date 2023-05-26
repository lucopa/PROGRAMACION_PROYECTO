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
