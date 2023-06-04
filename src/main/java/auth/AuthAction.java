package auth;

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
        UserBean user = userDao.getUserByUsername(credentialHolder.getUsername());
        HttpSession session = ServletActionContext.getRequest().getSession();

        if (user != null && userDao.validatePassword(user, credentialHolder.getPassword())) {
            // Store user information in the session
            session.setAttribute("user", user);

            return SUCCESS;
        } else {
            addActionError("Invalid username or password");
            return ERROR;
        }
    }
}

