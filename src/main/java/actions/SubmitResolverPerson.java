package actions;

import app.*;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;
import java.util.List;

public class SubmitResolverPerson extends ActionSupport {
    private int issueID;
    private int staffId;
    private IssueDao issueDao = new IssueDao();
    private List<IssueBean> issuesList;
    public List<IssueBean> getIssuesList() {
        return issuesList;
    }

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

            HttpSession session = ServletActionContext.getRequest().getSession();
            PersonBean person = (PersonBean) session.getAttribute("user");

            if (person instanceof UserBean){
                issuesList = issueDao.getIssuesByReporterID(((UserBean) person).getUserId());
            } else if ((person instanceof StaffBean)||(person instanceof ManagerBean)) {
                issuesList = issueDao.getAllIssues();
            }

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