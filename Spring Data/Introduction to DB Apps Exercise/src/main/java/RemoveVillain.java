import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class RemoveVillain {
    private static final String SELECT_VILLAIN_NAME_BY_ID = "SELECT name FROM villains WHERE id = ?;";

    private static final String SELECT_COUNT_OF_RELEASED_MINION = "SELECT COUNT(*) AS m_count FROM minions_villains WHERE villain_id = ?;";

    private static final String REMOVE_MINIONS_VILLAINS_BY_VILLAIN_ID = "DELETE mv FROM minions_villains AS mv WHERE villain_id = ?;";

    private static final String  REMOVE_VILLAIN_BY_ID = "DELETE v FROM villains AS v WHERE id = ?;";

    public static void run() throws SQLException {
        System.out.println("Enter villain id!");
        Scanner scanner = new Scanner(System.in);
        int villainId = scanner.nextInt();

        Connection connection = Connector.getConnection();

        PreparedStatement selectVillainId = connection.prepareStatement(SELECT_VILLAIN_NAME_BY_ID);
        selectVillainId.setInt(1, villainId);

        ResultSet getVillainName = selectVillainId.executeQuery();
        if (!getVillainName.next()) {
            System.out.println("No such villain was found");
            connection.close();
            return;
        }

        String villainName = getVillainName.getString("name");

        PreparedStatement selectCountOfMinions = connection.prepareStatement(SELECT_COUNT_OF_RELEASED_MINION);
        selectCountOfMinions.setInt(1, villainId);

        ResultSet getCountOfMinions = selectCountOfMinions.executeQuery();
        getCountOfMinions.next();
        int countOfMinions = getCountOfMinions.getInt(1);

        connection.setAutoCommit(false);

        PreparedStatement statementDeleteFromMinionsVillains = connection.prepareStatement(REMOVE_MINIONS_VILLAINS_BY_VILLAIN_ID);
        statementDeleteFromMinionsVillains.setInt(1, villainId);
        statementDeleteFromMinionsVillains.executeUpdate();

        PreparedStatement deleteFromVillain = connection.prepareStatement(REMOVE_VILLAIN_BY_ID);
        deleteFromVillain.setInt(1, villainId);
        deleteFromVillain.executeUpdate();

        connection.commit();


        System.out.printf("%s was deleted%n", villainName);
        System.out.printf("%d minions released%n", countOfMinions);

        connection.close();
    }
}
