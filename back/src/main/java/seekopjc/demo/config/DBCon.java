package seekopjc.demo.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;public class DBCon {
    public static Connection connection() throws SQLException{
        String jdbcURL = "jdbc:h2:mem:gifs";
 
        Connection connection = DriverManager.getConnection(jdbcURL);
       
        return connection;
        
        
    }
    public static void closeConnection(Connection conn) throws SQLException{
        conn.close();
    }
    public static void closeConnection(ResultSet rs) throws SQLException{
        rs.close();
    }
    public static void closeConnection(PreparedStatement ps) throws SQLException{
        ps.close();
    }
}
