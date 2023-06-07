package app;

import auth.PasswordUtils;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonDao {
   private Connection connection;

    public PersonDao() {
        try {
            InitialContext ctx = new InitialContext();
            DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/appDB");
            connection = dataSource.getConnection();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public PersonBean getUserByUsername(String username) {
        UserBean user = null;
        StaffBean staff = null;
        ManagerBean manager = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Users WHERE username = ?");
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("userId");
                String password = resultSet.getString("password");
                int isStaff = resultSet.getInt("isStaff");
                int isManager = resultSet.getInt("isManager");
                if ((isStaff == 0)&&(isManager == 0)){
                    user = new UserBean();
                    user.setUserId(id);
                    user.setUsername(username);
                    user.setPassword(password);
                    return user;
                } else if ((isStaff == 1)&&(isManager == 0)){
                    staff = new StaffBean();
                    staff.setStaffId(id);
                    staff.setUsername(username);
                    staff.setPassword(password);
                    return staff;
                } else if ((isStaff == 0)&&(isManager == 1)){
                    manager = new ManagerBean();
                    manager.setManagerId(id);
                    manager.setUsername(username);
                    manager.setPassword(password);
                    return manager;
                } else{
                    System.out.println("Person is neither a User, a Staff member or a Manager.");
                }

            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean validatePassword(PersonBean user, String inputPassword) {
        return user != null && PasswordUtils.isPasswordMatch(inputPassword, user.getPassword());
    }

}
