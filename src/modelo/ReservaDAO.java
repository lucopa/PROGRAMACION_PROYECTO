package modelo;
import java.sql.SQLException;
import java.util.List;

public interface ReservaDAO {
    boolean insertarUsuario(Reserva reserva) throws SQLException;
    boolean eliminarReservaPorCodigo(int codigo_reserva) throws SQLException;
    boolean actualizarReservaPorCodigo(Reserva newReserva, int codigo_reserva) throws SQLException;
    Reserva obtenerReservaPorCodigo(int codigo_reserva) throws SQLException;
    List<Reserva> obtenerTodosLasReservas() throws SQLException;
}
