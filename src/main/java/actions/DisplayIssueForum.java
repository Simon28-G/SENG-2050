package actions;

import app.*;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class DisplayIssueForum extends ActionSupport {

    private IssueDao issueDao = new IssueDao();
    private List<IssueBean> issuesList;


    public List<IssueBean> getIssuesList() {
        return issuesList;
    }


    public String execute() throws SQLException {

        HttpSession session = ServletActionContext.getRequest().getSession();
        PersonBean person = (PersonBean) session.getAttribute("user");

        if (person instanceof UserBean){
            issuesList = issueDao.getIssuesByReporterID(((UserBean) person).getUserId());
        } else if ((person instanceof StaffBean)||(person instanceof ManagerBean)) {
            issuesList = issueDao.getAllIssues();
        }
        return SUCCESS;
    }
}