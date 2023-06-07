package auth;

import app.ManagerBean;
import app.PersonBean;
import app.UserBean;
import app.UserDao;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;

public class AuthAction extends ActionSupport {
    private CredentialHolder credentialHolder;

    // UserDao instance
    private UserDao userDao = new UserDao();

    public CredentialHolder getCredentialHolder() {
        return credentialHolder;
    }

    public void setCredentialHolder(CredentialHolder credentialHolder) {
        this.credentialHolder = credentialHolder;
    }

    @Override
    public String execute() {
        // Retrieve user by username
        PersonBean person = userDao.getUserByUsername(credentialHolder.getUsername());
        HttpSession session = ServletActionContext.getRequest().getSession();

        if (person != null && userDao.validatePassword(person, credentialHolder.getPassword())) {
            // Store user information in the session
            session.setAttribute("user", person);

            if(person instanceof UserBean)
            {
                return "success-user";
            } else if (person instanceof ManagerBean) {
                return "success-manager";
            }
            else{
                return "success-staff";
            }
        } else {
            addActionError("Invalid username or password");
            return ERROR;
        }
    }
}

