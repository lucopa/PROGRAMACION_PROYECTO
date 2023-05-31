package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAOImp implements ReservaDAO {
    private static final Connection conexion;

    static {
        try {
            conexion = ConexionSingleton.getConexionSingleton().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean insertarUsuario(Reserva reserva) throws SQLException {
        String sql = " INSERT INTO reserva (codigo_reserva,fecha_reserva,duracion,hora,motivo,id_espacio) VALUES ( ?, ?,?,?,?,?);";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, reserva.getCodigo_reserva());
        sentencia.setString(2, reserva.getFecha_reserva());
        sentencia.setInt(3, reserva.getDuracion());
        sentencia.setInt(4, reserva.getHora());
        sentencia.setString(5, reserva.getMotivo());
        //sentencia.setInt(6, reserva.getId_espacio());
        sentencia.setNull(6,Types.NULL);
        int exito = sentencia.executeUpdate();
        if (sentencia != null)
            sentencia.close();
        return exito == 1;
    }

    @Override
    public boolean eliminarReservaPorCodigo(int codigo_reserva) throws SQLException {
        String sql = " DELETE FROM Reserva WHERE codigo_reserva = ?;";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, codigo_reserva);
        int exito = sentencia.executeUpdate();
        if (sentencia != null)
            sentencia.close();
        return exito == 1;
    }

    @Override
    public boolean actualizarReservaPorCodigo(Reserva newReserva, int codigo_reserva) throws SQLException {
        String sql = "UPDATE Reserva SET fecha_reserva= ?,duracion=?,hora=?,motivo=?,id_espacio=? WHERE codigo_reserva = ?;";
        PreparedStatement sentencia = conexion.prepareStatement(sql);

        sentencia.setString(1, newReserva.getFecha_reserva());
        sentencia.setInt(2,newReserva.getDuracion());
        sentencia.setInt(3,newReserva.getHora());
        sentencia.setString(4, newReserva.getMotivo());
        sentencia.setInt(5,newReserva.getId_espacio());
        sentencia.setInt(6, newReserva.getCodigo_reserva());
        int exito = sentencia.executeUpdate();
        if (sentencia != null)
            sentencia.close();
        return exito == 1;
    }

    @Override
    public Reserva obtenerReservaPorCodigo(int codigo_reserva) throws SQLException {
        Reserva reserva = null;
        String sql = "select * from reserva  where codigo_reserva = ?;";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, codigo_reserva);
        ResultSet resultado = sentencia.executeQuery();
        while (resultado.next()){
            int codigo = resultado.getInt("codigo");
            String fecha_reserva = resultado.getString("fecha_reserva");
            int duracion    = resultado.getInt("duracion");
            int hora    = resultado.getInt("hora");
            String motivo = resultado.getString("motivo");
            //int id_espacio    = resultado.getInt("id_espacio");
            int id_espacio=0;
            reserva= new Reserva(codigo_reserva, fecha_reserva, duracion,hora,motivo,id_espacio);
        }
        if (resultado != null)
            resultado.close();
        if (sentencia != null)
            sentencia.close();
        return reserva;
    }


    @Override
    public List<Reserva> obtenerTodosLasReservas() throws SQLException {
        List<Reserva> reservas = new ArrayList<>();
        String sql = "select * from reserva;";
        Statement sentencia = conexion.createStatement();
        ResultSet resultado = sentencia.executeQuery(sql);
        while (resultado.next()){
            int codigo = resultado.getInt("codigo");
            String fecha_reserva = resultado.getString("fecha_reserva");
            int duracion    = resultado.getInt("duracion");
            int hora    = resultado.getInt("hora");
            String motivo = resultado.getString("motivo");
            //int id_espacio    = resultado.getInt("id_espacio");
            int id_espacio=0;
            Reserva reserva= new Reserva(codigo, fecha_reserva, duracion,hora,motivo,id_espacio);
            reservas.add(reserva);
        }
        if (resultado != null)
            resultado.close();
        if (sentencia != null)
            sentencia.close();
        return reservas;
    }
    }

