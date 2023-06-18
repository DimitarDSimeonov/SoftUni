import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AddMinion {

    private static final String SELECT_TOWN_ID = "SELECT id FROM towns " +
                                                 "WHERE name = ?;";

    private static final String INSERT_TOWN = "INSERT INTO towns(name) " +
                                                "VALUE (?);";

    private static  final String SELECT_VILLAIN_ID = "SELECT id FROM villains " +
                                                        "WHERE name = ?;";

    private static final String INSERT_VILLAIN = "INSERT INTO villains (name, evilness_factor) " +
                                                    "VALUES (?, 'evil');";

    private static final String INSERT_MINION = "INSERT INTO minions (name, age, town_id) " +
                                                    "VALUES (?, ?, ?);";

    private static final String SELECT_MINION_ID = "SELECT id FROM minions " +
                                                        "WHERE name = ?;";

    private static final String INSERT_MINION_VILLAIN = "INSERT INTO minions_villains (minion_id, villain_id) " +
                                                            "VALUES (?, ?);";

    public static void run() throws SQLException {
        System.out.println("Insert input");
        Scanner scanner = new Scanner(System.in);
        String[] minionInput = scanner.nextLine().split(" ");
        String villainName = scanner.nextLine().split(" ")[1];
        String minionName = minionInput[1];
        int minionAge = Integer.parseInt(minionInput[2]);
        String town = minionInput[3];

        Connection connection = Connector.getConnection();

        PreparedStatement selectTownId = connection.prepareStatement(SELECT_TOWN_ID);
        selectTownId.setString(1, town);

        ResultSet selectedTownId = selectTownId.executeQuery();
        int townId;

        if (!selectedTownId.next()) {
            PreparedStatement insertTown = connection.prepareStatement(INSERT_TOWN);
            insertTown.setString(1, town);
            insertTown.executeUpdate();
            ResultSet afterInsert = selectTownId.executeQuery();
            afterInsert.next();
            townId = afterInsert.getInt("id");
            System.out.printf("Town %s was added to the database.%n", town);
        }else {
            townId = selectedTownId.getInt("id");
        }


        PreparedStatement selectVillainId = connection.prepareStatement(SELECT_VILLAIN_ID);
        selectVillainId.setString(1, villainName);

        ResultSet selectedVillainId = selectVillainId.executeQuery();
        int villainId;
        if (!selectedVillainId.next()) {
            PreparedStatement insertVillain = connection.prepareStatement(INSERT_VILLAIN);
            insertVillain.setString(1, villainName);
            insertVillain.executeUpdate();
            System.out.printf("Villain %s was added to the database.%n", villainName);
            ResultSet afterInsert = selectVillainId.executeQuery();
            afterInsert.next();
            villainId = afterInsert.getInt("id");
        }else {
            villainId = selectedVillainId.getInt("id");
        }

        PreparedStatement insertMinion = connection.prepareStatement(INSERT_MINION);
        insertMinion.setString(1, minionName);
        insertMinion.setInt(2, minionAge);
        insertMinion.setInt(3, townId);
        insertMinion.executeUpdate();

        PreparedStatement selectMinionId = connection.prepareStatement(SELECT_MINION_ID);
        selectMinionId.setString(1, minionName);

        ResultSet selectedMinionID = selectMinionId.executeQuery();
        selectedMinionID.next();
        int minionId = selectedMinionID.getInt(1);

        PreparedStatement insertMinionsVillains = connection.prepareStatement(INSERT_MINION_VILLAIN);
        insertMinionsVillains.setInt(1, minionId);
        insertMinionsVillains.setInt(2, villainId);
        insertMinionsVillains.executeUpdate();
        System.out.printf("Successfully added %s to be minion of %s.%n", minionName, villainName);

        connection.close();
    }
}
