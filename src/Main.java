
import controlador.EspacioController;
import modelo.EspacioDAO;
import modelo.EspacioDAOImp;
import vista.Interfaz2;

public class Main {
    public static void main(String[] args) {

        EspacioDAO espacioDAO = new EspacioDAOImp();
        Interfaz2 vista = new Interfaz2();
        EspacioController controlador = new EspacioController(vista, espacioDAO);

        vista.setEspacioController(controlador);

        vista.setVisible(true);
    }
}

