import org.junit.Test;

import java.sql.*;

public class JDBCTest {
    @Test
    public void connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql:///java_console_store","root","root");
        PreparedStatement preparedStatement = connection.prepareStatement("select  * from admin");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            System.out.println(resultSet.getString(1));
        }
    }
}
