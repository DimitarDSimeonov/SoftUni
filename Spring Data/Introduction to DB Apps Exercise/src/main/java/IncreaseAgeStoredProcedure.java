import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class IncreaseAgeStoredProcedure {

    private static final String CALL_PROCEDURE = "CALL usp_get_older(?);";

    private static final String SELECT_MINION = "SELECT name, age FROM minions WHERE id = ?;";

    public static void run() throws SQLException {
        System.out.println("Enter minion id");
        Scanner scanner = new Scanner(System.in);
        int minionId = scanner.nextInt();

        Connection connection = Connector.getConnection();
        PreparedStatement callProcedure = connection.prepareStatement(CALL_PROCEDURE);
        callProcedure.setInt(1, minionId);
        callProcedure.execute();

        PreparedStatement selectMinion = connection.prepareStatement(SELECT_MINION);
        selectMinion.setInt(1, minionId);
        ResultSet getMinion = selectMinion.executeQuery();
        getMinion.next();

        System.out.println(getMinion.getString("name") + " " + getMinion.getInt("age"));

        connection.close();
    }
}
