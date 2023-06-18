import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class GetMinionNames {


    private static final String SQL_GET_VILLAIN_NAME = "SELECT name from villains " +
                                                        "where id = ?;";
    private static final String SQL_GET_MINIONS_NAME_AND_AGE_BY_VILLAIN_ID =
            "SELECT name, age FROM minions AS m  " +
                    "JOIN minions_villains AS mv ON m.id = mv.minion_id " +
                    "WHERE mv.villain_id = ?;";

    public static void run() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the villain id");
        int villainId = scanner.nextInt();
        Connection connection = Connector.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_VILLAIN_NAME);
        preparedStatement.setInt(1, villainId);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (!resultSet.next()) {
            System.out.printf("No villain with ID %d exists in the database.", villainId);
            connection.close();
            return;
        }

        System.out.printf("Villain: %s%n", resultSet.getString(1));

        PreparedStatement prepStatement = connection.prepareStatement(SQL_GET_MINIONS_NAME_AND_AGE_BY_VILLAIN_ID);
        prepStatement.setInt(1, villainId);

        ResultSet resultSetMinion = prepStatement.executeQuery();
        int countOfMinions = 1;

        while (resultSetMinion.next()) {
            System.out.printf("%d. %s %d%n",countOfMinions, resultSetMinion.getString(1), resultSetMinion.getInt(2));
            countOfMinions++;
        }
        connection.close();
    }
}
