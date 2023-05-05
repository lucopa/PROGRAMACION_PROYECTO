import java.sql.Connection;
import java.sql.SQLException;
public class TestConexion {
    public static void main(String[] args) {
        try {
            ConexionSingleton conexionSingleton1 = ConexionSingleton.getConexionSingleton();
            Connection conexion1 = conexionSingleton1.getConnection();
            Connection conexion2 = conexionSingleton1.getConnection();
            ConexionSingleton conexionSingleton2 = ConexionSingleton.getConexionSingleton();
            Connection conexion3 = conexionSingleton2.getConnection();
            System.out.println(conexion1);
            System.out.println(conexion2);
            System.out.println(conexion3);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
