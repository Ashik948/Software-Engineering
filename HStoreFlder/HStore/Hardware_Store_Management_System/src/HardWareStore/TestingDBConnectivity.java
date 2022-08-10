package HardWareStore;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Mahmud
 */
public class TestingDBConnectivity {

    static Connection connection;
    static PreparedStatement prestm;
    static ResultSet resultset;

    static public String StatusQuery(String Query, String SubQuery) {

        String URL = "jdbc:mysql://localhost/invsysdb";

        try {
            connection = (Connection) DriverManager.getConnection(URL, "root", "");
            prestm = connection.prepareStatement(Query);

            resultset = prestm.executeQuery();

            while (resultset.next()) {

                Query = resultset.getString(SubQuery);

                System.out.println(Query);

                System.out.println("Successful");
            }
        } catch (SQLException ex) {

            System.out.println("Unsuccessful");
        }

        return Query;
    }

    public static void main(String[] args) {
        StatusQuery("SELECT SUM(PPrice) FROM orders", "SUM(PPrice)");
    }

}
