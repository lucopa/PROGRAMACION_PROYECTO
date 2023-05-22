package modelo;

import java.sql.SQLException;
import java.util.List;

public interface EspacioDAO {
    boolean insertarEspacio(Espacio espacio) throws SQLException;
    boolean eliminarEspacioPorID(int id_espacio) throws SQLException;
    boolean actualizarEspacioPorID(Espacio newEspacio, int id_espacio) throws SQLException;
    Espacio obtenerEspacioPorID(int id_espacio) throws SQLException;
    List<Espacio> obtenerTodosLosEspacios() throws SQLException;
}
