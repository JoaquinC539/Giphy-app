package seekopjc.demo.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import java.sql.PreparedStatement;
import jakarta.servlet.http.HttpServletRequest;
import seekopjc.demo.config.DBCon;
import seekopjc.demo.models.Favorito;


@Service
public class FavoriteService {
    
    public ArrayList<Object> index(HttpServletRequest request){
        try {
            Connection connection = DBCon.connection();
            String sql = "CREATE TABLE IF NOT EXISTS favorites (id INT PRIMARY KEY AUTO_INCREMENT, gif_url varchar(100))";
            Statement statement = connection.createStatement();
            statement.execute(sql);            
            ResultSet resultSet = statement.executeQuery("SELECT * FROM favorites");
            ArrayList<Object> response=new ArrayList<Object>();
            while (resultSet.next()) {
                Favorito fav=new Favorito();
                fav.setId(resultSet.getInt("id"));
                fav.setGifurl(resultSet.getString("gif_url"));
                response.add(fav);
            }        
        connection.close();
        statement.close();
        resultSet.close();
        return response;
        } catch (Exception e) {
            System.out.println(e);
            
            
            return null;
        }
    }
    public Favorito save (Favorito fav) throws SQLException{
        Connection connection = DBCon.connection();
        String sql = "CREATE TABLE IF NOT EXISTS favorites (id INT PRIMARY KEY AUTO_INCREMENT, gif_url varchar(100))";
            Statement statement = connection.createStatement();
            statement.execute(sql);
        sql = "INSERT INTO favorites (gif_url) values (?) ";
        PreparedStatement ps=connection.prepareStatement(sql);
        ps.setString(1, fav.getGifurl());
        int pso=ps.executeUpdate();
        ps.close();
        statement.close();
        connection.close();
        fav.setId(pso);
        return fav;
    }
    public Integer delete (Integer id){
        try {
            Connection connection = DBCon.connection();
            String sql = "CREATE TABLE IF NOT EXISTS favorites (id INT PRIMARY KEY AUTO_INCREMENT, gif_url varchar(100))";
            Statement statement = connection.createStatement();
            sql="DELETE FROM favorites WHERE id="+id;
            statement.executeUpdate(sql);
            statement.close();
            connection.close();
            return id;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
