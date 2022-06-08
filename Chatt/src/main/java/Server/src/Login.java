package Server.src;

import java.sql.*;

public class Login {
    private final String jdbcURL = "jdbc:postgresql://localhost:5432/Users";
    private final String username = "postgres";
    private final String password = "123456";

    public int loginAttempt(String user, String pass)
    {
        try {
            Connection con = DriverManager.getConnection(jdbcURL, username, password);
            String select = "SELECT * FROM users WHERE users.username = '" + user +
                    "' AND users.password = '" + pass +"';";
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(select);
            if (result.next()) {
                con.close();
                return 1;
            }
            else
            {

                con.close();
                return 2;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

}
