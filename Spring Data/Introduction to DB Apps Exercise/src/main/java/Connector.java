import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public enum Connector {
    ;

    static Connection getConnection () throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "12345");

        return DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", properties);
    }
}
