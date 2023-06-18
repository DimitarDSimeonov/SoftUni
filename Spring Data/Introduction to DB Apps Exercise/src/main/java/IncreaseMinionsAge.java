import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

public class IncreaseMinionsAge {

    private static final String UPDATE_MINIONS_AGE = "UPDATE minions " +
                                                        "SET `age` = `age` + 1 " +
                                                        "WHERE id = ?;";

    private static final String UPDATE_MINIONS_NAME = "UPDATE minions " +
                                                        "SET `name` = LOWER(`name`)" +
                                                        "WHERE id = ?;";

    private static final String SELECT_MINIONS = "SELECT name, age FROM minions;";

    public static void run() throws SQLException {
        System.out.println("Enter the input");
        Scanner scanner = new Scanner(System.in);
        int[] minionsIds = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Connection connection = Connector.getConnection();

        PreparedStatement updateMinionsAge = connection.prepareStatement(UPDATE_MINIONS_AGE);
        PreparedStatement updateMinionsName = connection.prepareStatement(UPDATE_MINIONS_NAME);

        for (int i = 0; i < minionsIds.length; i++) {
            updateMinionsAge.setInt(1, minionsIds[i]);
            updateMinionsAge.execute();

            updateMinionsName.setInt(1, minionsIds[i]);
            updateMinionsName.execute();
        }

        PreparedStatement selectMinions = connection.prepareStatement(SELECT_MINIONS);
        ResultSet getMinions = selectMinions.executeQuery();

        while (getMinions.next()) {
            System.out.println(getMinions.getString("name") + " " + getMinions.getInt("age"));
        }

        connection.close();
    }
}
