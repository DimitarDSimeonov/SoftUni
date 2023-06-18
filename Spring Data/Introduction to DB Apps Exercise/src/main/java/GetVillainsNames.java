import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetVillainsNames {

   private static final String SQL_QUERY = "SELECT v.name, COUNT(DISTINCT mv.minion_id) AS count_of_minions FROM villains AS v " +
           "JOIN minions_villains AS mv ON mv.villain_id = v.id " +
           "GROUP BY v.id " +
           "HAVING count_of_minions > 15 " +
           "ORDER BY count_of_minions DESC;";

   public static void run () throws SQLException {

       Connection connection = Connector.getConnection();

      PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY);

      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
         System.out.print(resultSet.getString(1));
         System.out.print(" ");
         System.out.print(resultSet.getInt(2));
         System.out.println();
      }

      connection.close();
   }
}
