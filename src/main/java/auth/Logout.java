package auth;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;

public class Logout extends ActionSupport {

    public String execute() throws Exception{

        try {
            HttpSession session = ServletActionContext.getRequest().getSession();
            session.removeAttribute("user");
            return SUCCESS;
        } catch (Exception e){
            e.printStackTrace();
            return ERROR;
        }
    }
}