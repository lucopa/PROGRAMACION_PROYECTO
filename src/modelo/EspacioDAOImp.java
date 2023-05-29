package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EspacioDAOImp implements EspacioDAO{

    private static final Connection conexion;

    static {
        try {
            conexion = ConexionSingleton.getConexionSingleton().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public boolean insertarEspacio(Espacio espacio) throws SQLException {
        String sql = " INSERT INTO espacio ( id_espacio,  descripcion,  capacidad,  ordenadores,  pizarra,  proyector,  nombre,  codigo_reserva) VALUES ( ?, ?,?,?,?,?,?,?);";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, espacio.getId_espacio());
        sentencia.setString(2, espacio.getDescripcion());
        sentencia.setInt(3, espacio.getCapacidad());
        sentencia.setInt(4, espacio.getOrdenadores());
        sentencia.setInt(5, espacio.getPizarra());
        sentencia.setInt(6, espacio.getProyector());
        sentencia.setString(7, espacio.getNombre());
        //sentencia.setInt(8,espacio.getCodigo_reserva());
        sentencia.setNull(8,Types.NULL);
        int exito = sentencia.executeUpdate();
        if (sentencia != null)
            sentencia.close();
        return exito == 1;
    }

    @Override
    public boolean eliminarEspacioPorID(int id_espacio) throws SQLException {
        String sql = " DELETE FROM espacio WHERE id_espacio= ?;";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, id_espacio);
        int exito = sentencia.executeUpdate();
        if (sentencia != null)
            sentencia.close();
        return exito == 1;
    }

    @Override
    public boolean actualizarEspacioPorID(Espacio newEspacio, int id_espacio) throws SQLException {
        String sql = "UPDATE espacio SET  capacidad=?,descripcion=?,ordenadores=?,pizarra=?,proyector=?,nombre=? WHERE id_espacio=?;";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1,newEspacio.getCapacidad());
        sentencia.setString(2,newEspacio.getDescripcion());
        sentencia.setInt(3,newEspacio.getOrdenadores());
        sentencia.setInt(4,newEspacio.getPizarra());
        sentencia.setInt(5,newEspacio.getProyector());
        sentencia.setString(6, newEspacio.getNombre());
        sentencia.setInt(7, newEspacio.getId_espacio());

        int exito = sentencia.executeUpdate();
        if (sentencia != null)
            sentencia.close();
        return exito == 1;
    }

    @Override
    public Espacio obtenerEspacioPorID(int id_espacio) throws SQLException {
        Espacio espacio = null;
        String sql = "select * from espacio  where id_espacio = ?;";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1,id_espacio);
        ResultSet resultado = sentencia.executeQuery();
        while (resultado.next()){
            int id = resultado.getInt("id_espacio");
            String descripcion = resultado.getString("descripcion");
            int capacidad    = resultado.getInt("capacidad");
            int ordenadores    = resultado.getInt("ordenadores");
            int pizarra   = resultado.getInt("pizarra");
            int proyector    = resultado.getInt("proyector");
            String nombre    = resultado.getString("nombre");
            //int codigo_reserva    = resultado.getInt("codigo_reserva");
            int codigo_reserva=0;
            espacio= new Espacio(id_espacio,descripcion,capacidad,ordenadores,proyector,pizarra,nombre,codigo_reserva);
        }
        if (resultado != null)
            resultado.close();
        if (sentencia != null)
            sentencia.close();
        return espacio;
    }

    @Override
    public List<Espacio> obtenerTodosLosEspacios() throws SQLException {
        List<Espacio> espacios= new ArrayList<>();
        String sql = "select * from espacio;";
        Statement sentencia = conexion.createStatement();
        ResultSet resultado = sentencia.executeQuery(sql);
        while (resultado.next()){
            int id = resultado.getInt("id_espacio");
            String descripcion = resultado.getString("descripcion");
            int capacidad    = resultado.getInt("capacidad");
            int ordenadores    = resultado.getInt("ordenadores");
            int pizarra   = resultado.getInt("pizarra");
            int proyector    = resultado.getInt("proyector");
            String nombre    = resultado.getString("nombre");
            //int codigo_reserva    = resultado.getInt("codigo_reserva");
            int codigo_reserva=0;
            Espacio espacio= new Espacio(id,descripcion,capacidad,ordenadores,proyector,pizarra,nombre,codigo_reserva);
            espacios.add(espacio);
        }
        if (resultado != null)
            resultado.close();
        if (sentencia != null)
            sentencia.close();
        return espacios;
    }
}
