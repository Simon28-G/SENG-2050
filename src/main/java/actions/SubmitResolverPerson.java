package actions;

import app.IssueBean;
import app.IssueDao;
import com.opensymphony.xwork2.ActionSupport;

public class SubmitResolverPerson extends ActionSupport {
    private int issueID;
    private int staffId;
    private IssueDao issueDao = new IssueDao();

    public int getIssueID() {
        return issueID;
    }

    public void setIssueID(int issueID) {
        this.issueID = issueID;
    }

    public int getStaffId() {
        return staffId;
    }

    @Override
    public String execute() throws Exception {

        try {
            IssueBean issue = issueDao.getIssueByID(issueID);
            issue.setStaffID(staffId);
            issueDao.updateIssue(issue);
            return SUCCESS;

        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }

    }
}