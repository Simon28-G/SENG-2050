package app;

import auth.PasswordUtils;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
   private Connection connection;

    public UserDao() {
        try {
            InitialContext ctx = new InitialContext();
            DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/appDB");
            connection = dataSource.getConnection();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public UserBean getUserByUsername(String username) {
        UserBean user = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Users WHERE username = ?");
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("userId");
                String password = resultSet.getString("password");
                user = new UserBean();
                user.setUserId(id);
                user.setUsername(username);
                user.setPassword(password);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public boolean validatePassword(UserBean user, String inputPassword) {
        return user != null && PasswordUtils.isPasswordMatch(inputPassword, user.getPassword());
    }

    public void logout(){
        try {
            connection.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
