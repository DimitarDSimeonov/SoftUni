import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PrintAllMinionNames {

    private static final String SELECT_ALL_MINIONS_NAMES = "SELECT name FROM minions;";

    public static void run() throws SQLException {
        Connection connection = Connector.getConnection();
        PreparedStatement selectNames = connection.prepareStatement(SELECT_ALL_MINIONS_NAMES);
        ResultSet getMinionsNames = selectNames.executeQuery();

        List<String> allNames = new ArrayList<>();
        while (getMinionsNames.next()) {
            allNames.add(getMinionsNames.getString("name"));
        }

        int lastIndex = allNames.size() - 1;

        for (int i = 0; i < allNames.size() / 2 ; i++) {
            System.out.println(allNames.get(i));
            System.out.println(allNames.get(lastIndex));
            lastIndex--;
        }

        connection.close();
    }
}
