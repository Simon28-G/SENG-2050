package app;
import org.apache.struts2.ServletActionContext;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IssueDao {
    private Connection connection;

    // Constructor
    public IssueDao() {
        try {
            InitialContext ctx = new InitialContext();
            DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/appDB");
            connection = dataSource.getConnection();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public IssueBean getIssueByID(int issueID) throws SQLException {
        String query = "SELECT * FROM Issues WHERE issueID = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, issueID);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return createIssueFromResultSet(resultSet);
                }
            }
        }
        return null;
    }

    public List<IssueBean> getAllIssues() throws SQLException {
        String query = "SELECT * FROM Issues";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            List<IssueBean> issues = new ArrayList<>();
            while (resultSet.next()) {
                IssueBean issue = createIssueFromResultSet(resultSet);
                issues.add(issue);
            }
            return issues;
        }
    }

    public List<IssueBean> getIssuesByReporterID(int reporterID) throws SQLException {
        String query = "SELECT * FROM Issues WHERE reporterID = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, reporterID);
            try (ResultSet resultSet = statement.executeQuery()) {
                List<IssueBean> issues = new ArrayList<>();
                while (resultSet.next()) {
                    IssueBean issue = createIssueFromResultSet(resultSet);
                    issues.add(issue);
                }
                return issues;
            }
        }
    }

    public void createIssue(IssueBean issue) throws SQLException {
        String query = "INSERT INTO Issues(reporterID, title, description, resolutionDetails, " +
                "reportedDate, resolvedDate, state, category, isKBArticle) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, issue.getReporterID());
            statement.setString(2, issue.getTitle());
            statement.setString(3, issue.getDescription());
            statement.setString(4, issue.getResolutionDetails());
            statement.setTimestamp(5, new java.sql.Timestamp(issue.getDateReported().getTime()));
            statement.setTimestamp(6, issue.getDateResolved() != null ?
                    new java.sql.Timestamp(issue.getDateResolved().getTime()) : null);
            statement.setString(7, issue.getState().name());
            statement.setString(8, issue.getCategory().name());
            statement.setBoolean(9, issue.isKBArticle());
            statement.executeUpdate();
        }
    }

    public void updateIssue(IssueBean issue) throws SQLException {
        String query = "UPDATE Issues SET  ITStaffID = ?, " +
                "resolutionDetails = ?, resolvedDate = ?, state = ?, " +
                "isKBArticle = ? WHERE issueID = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, issue.getStaffID());
            statement.setString(2, issue.getResolutionDetails());
            statement.setTimestamp(3, issue.getDateResolved() != null ?
                    new java.sql.Timestamp(issue.getDateResolved().getTime()) : null);
            statement.setString(4, issue.getState().name());
            //not sure boolean
            statement.setBoolean(5, issue.isKBArticle());
        }

    }

    private IssueBean createIssueFromResultSet(ResultSet resultSet) throws SQLException {
        IssueBean issue = new IssueBean();
        issue.setIssueID(resultSet.getInt("issueID"));
        issue.setReporterID(resultSet.getInt("reporterID"));
        issue.setStaffID(resultSet.getInt("ITStaffID"));
        issue.setTitle(resultSet.getString("title"));
        issue.setDescription(resultSet.getString("description"));
        issue.setResolutionDetails(resultSet.getString("resolutionDetails"));
        issue.setDateReported(resultSet.getTimestamp("reportedDate"));
        issue.setDateResolved(resultSet.getTimestamp("resolvedDate"));
        issue.setState(State.valueOf(resultSet.getString("state")));
        issue.setCategory(Category.valueOf(resultSet.getString("category")));
        issue.setKBArticle(resultSet.getBoolean("isKBArticle"));
        return issue;
    }

    public void saveFileDetails(String originalFileName, String hashedName, int issueId) {
        // Implement the logic to save file details to the database
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO Files (name, hashedName, issueId) VALUES (?, ?, ?)");
            statement.setString(1, originalFileName);
            statement.setString(2, hashedName);
            statement.setInt(3, issueId);
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<File> getFilesByIssueId(int issueId) {
        List<File> files = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM Files WHERE `issueId` = ?");
            statement.setInt(1, issueId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String path = ServletActionContext.getServletContext().getRealPath("/") + "/uploads/" + resultSet.getString("hashedName");
                File file = new File(path);
                files.add(file);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return files;
    }



}

