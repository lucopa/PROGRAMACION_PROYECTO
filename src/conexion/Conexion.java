package conexion;

import org.sqlite.SQLiteConfig;

import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Properties;
public class Conexion {

        public static void main(String[] args) {
            // final String url_db = "jdbc:sqlite:SQLs/script.sql";
            Properties properties = new Properties();
            try {
                properties.load(Files.newBufferedReader(
                        Paths.get("conexion/config.properties")));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            String driver = properties.getProperty("driver");
            String bd =  properties.getProperty("bd");
            System.out.println(driver + bd);
            SQLiteConfig config = new SQLiteConfig();
            config.enforceForeignKeys(true);
            try (Connection conexion = DriverManager.getConnection(
                    driver + bd, config.toProperties())) {
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

