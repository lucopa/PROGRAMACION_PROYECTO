package controlador;

import modelo.Espacio;
import modelo.EspacioDAO;
import vista.Interfaz2;

import java.sql.SQLException;
import java.util.List;

public class EspacioController {
    private Interfaz2 vista;
    private EspacioDAO espacioDAO;

    public EspacioController(Interfaz2 vista, EspacioDAO espacioDAO) {
        this.vista = vista;
        this.espacioDAO = espacioDAO;
    }

    public void agregarEspacio(Espacio espacio) {
        try {
            boolean exito = espacioDAO.insertarEspacio(espacio);
            if (exito) {
                vista.mostrarMensaje("Espacio agregado exitosamente");
                vista.limpiarCampos();
            } else {
                vista.mostrarMensaje("Error al agregar el espacio");
            }
        } catch (SQLException e) {
            vista.mostrarMensaje("Error de base de datos: " + e.getMessage());
        }
    }

    public void eliminarEspacio(int idEspacio) {
        try {
            boolean exito = espacioDAO.eliminarEspacioPorID(idEspacio);
            if (exito) {
                vista.mostrarMensaje("Espacio eliminado exitosamente");
                vista.limpiarCampos();
            } else {
                vista.mostrarMensaje("Error al eliminar el espacio");
            }
        } catch (SQLException e) {
            vista.mostrarMensaje("Error de base de datos: " + e.getMessage());
        }
    }

    public void actualizarEspacio(Espacio newEspacio, int idEspacio) {
        try {
            boolean exito = espacioDAO.actualizarEspacioPorID(newEspacio, idEspacio);
            if (exito) {
                vista.mostrarMensaje("Espacio actualizado exitosamente");
                vista.limpiarCampos();
            } else {
                vista.mostrarMensaje("Error al actualizar el espacio");
            }
        } catch (SQLException e) {
            vista.mostrarMensaje("Error de base de datos: " + e.getMessage());
        }
    }

    public Espacio obtenerEspacio(int idEspacio) {
        try {
            Espacio espacio = espacioDAO.obtenerEspacioPorID(idEspacio);
            if (espacio != null) {
                return espacio;
            } else {
                vista.mostrarMensaje("El espacio no existe");
            }
        } catch (SQLException e) {
            vista.mostrarMensaje("Error de base de datos: " + e.getMessage());
        }
        return null;
    }

    public List<Espacio> obtenerTodosLosEspacios() {
        try {
            List<Espacio> espacios = espacioDAO.obtenerTodosLosEspacios();
            if (!espacios.isEmpty()) {
                return espacios;
            } else {
                vista.mostrarMensaje("No hay espacios disponibles");
            }
        } catch (SQLException e) {
            vista.mostrarMensaje("Error de base de datos: " + e.getMessage());
        }
        return null;
    }


}

