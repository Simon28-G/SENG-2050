package actions;

import app.IssueBean;
import app.IssueDao;
import com.opensymphony.xwork2.ActionSupport;

import java.sql.SQLException;
import java.util.List;

public class DisplayIssuePage extends ActionSupport {

    private int issueID;
    private IssueBean issue;

    public void setIssueID(int issueID) {this.issueID = issueID;}

    public int getIssueID(){return this.issueID;}

    public IssueBean getIssue() {
        return issue;
    }

    public void setIssue(IssueBean issue) {
        this.issue = issue;
    }

    public String execute() throws SQLException {

        try {
            IssueDao issueDao = new IssueDao();
            issue = issueDao.getIssueByID(issueID);
            System.out.println(issue.getTitle());
            return SUCCESS;
        } catch (SQLException e){
            return ERROR;
        }
    }
}