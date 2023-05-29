import controlador.Controladores;
import vista.Interfaz2;

public class Main {
    public static void main(String[] args) {
        Interfaz2 vista = new Interfaz2();
        Controladores controladores= new Controladores(vista);
        controladores.arrancar();
    }
}
