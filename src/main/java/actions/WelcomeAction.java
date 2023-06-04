package actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;

public class WelcomeAction  extends ActionSupport {
    @Override
    public String execute() {
        HttpSession session = ServletActionContext.getRequest().getSession();
        if(session.getAttribute("user") != null){
            return "success";
        }
        return "error";
    }

}
