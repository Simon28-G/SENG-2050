package app;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StaffDao {
    private Connection connection;

    public StaffDao() {
        try {
            InitialContext ctx = new InitialContext();
            DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/appDB");
            connection = dataSource.getConnection();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public StaffBean getStaffByID(int staffID) throws SQLException {
        String query = "SELECT * FROM Users WHERE userId = ? AND isStaff = 1";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, staffID);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return createStaffFromResultSet(resultSet);
                }
            }
        }
        return null;
    }

    public List<StaffBean> getAllStaff() throws SQLException {
        String query = "SELECT * FROM Users WHERE isStaff = 1";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            List<StaffBean> staffList = new ArrayList<>();
            while (resultSet.next()) {
                StaffBean staff = createStaffFromResultSet(resultSet);
                staffList.add(staff);
            }
            return staffList;
        }
    }

    private StaffBean createStaffFromResultSet(ResultSet resultSet) throws SQLException {
        StaffBean staff = new StaffBean();
        staff.setStaffId(resultSet.getInt("userID"));
        staff.setUsername(resultSet.getString("userName"));
        staff.setFirstName(resultSet.getString("firstName"));
        staff.setLastName(resultSet.getString("surname"));
        staff.setEmail(resultSet.getString("email"));
        staff.setContactNumber(resultSet.getString("phoneNum"));
        return staff;
    }
}

