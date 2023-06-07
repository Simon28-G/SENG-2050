package auth;

import app.*;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class AuthAction extends ActionSupport {
    private CredentialHolder credentialHolder;

    // UserDao instance
    private PersonDao personDao = new PersonDao();
    private IssueDao issueDao = new IssueDao();
    private List<IssueBean> issuesList;

    public List<IssueBean> getIssuesList() {
        return issuesList;
    }

    public CredentialHolder getCredentialHolder() {
        return credentialHolder;
    }

    public void setCredentialHolder(CredentialHolder credentialHolder) {
        this.credentialHolder = credentialHolder;
    }

    @Override
    public String execute() throws SQLException {
        // Retrieve user by username
        PersonBean person = personDao.getUserByUsername(credentialHolder.getUsername());
        HttpSession session = ServletActionContext.getRequest().getSession();

        if (person != null && personDao.validatePassword(person, credentialHolder.getPassword())) {
            // Store user information in the session
            session.setAttribute("user", person);


            if(person instanceof UserBean)
            {
                issuesList = issueDao.getIssuesByReporterID(((UserBean) person).getUserId());
                return "success-user";
            } else if (person instanceof ManagerBean) {
                issuesList = issueDao.getAllIssues();

                return "success-manager";
            }
            else if (person instanceof StaffBean) {
                issuesList = issueDao.getAllIssues();
                return "success-staff";
            } else {
                addActionError("Database error: user type not defined.");
                return ERROR;
            }
        } else {
            addActionError("Invalid username or password.");
            return ERROR;
        }
    }
}

