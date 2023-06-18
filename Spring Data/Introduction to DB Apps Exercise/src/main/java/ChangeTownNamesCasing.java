import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChangeTownNamesCasing {

    private static final String SELECT_TOWN_BY_COUNTRY_NAME = "SElECT name from towns  " +
                                                                "WHERE country = ?;";

    private static final  String UPDATE_TOWN_NAME = "UPDATE towns " +
                                                        "SET name = UPPER(name) " +
                                                        "WHERE country = ?;";
    public static void run() throws SQLException {
        System.out.println("Enter the country");
        Scanner scanner = new Scanner(System.in);
        String country = scanner.nextLine();

        Connection connection = Connector.getConnection();
        PreparedStatement getTowns = connection.prepareStatement(SELECT_TOWN_BY_COUNTRY_NAME);
        getTowns.setString(1, country);

        ResultSet towns = getTowns.executeQuery();

        if (!towns.next()) {
            System.out.println("No town names were affected.");
            connection.close();
            return;
        }
        List<String> changedTowns = new ArrayList<>();

        PreparedStatement updateTowns = connection.prepareStatement(UPDATE_TOWN_NAME);
        updateTowns.setString(1, country);
        updateTowns.executeUpdate();

        ResultSet upperTownName = getTowns.executeQuery();
        while (upperTownName.next()) {
            changedTowns.add(upperTownName.getString("name"));
        }

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d town names were affected.", changedTowns.size())).append(System.lineSeparator());
        sb.append("[");
        for (int i = 0; i < changedTowns.size(); i++) {
            sb.append(changedTowns.get(i));
            if (i != changedTowns.size() - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
        connection.close();
    }
}
