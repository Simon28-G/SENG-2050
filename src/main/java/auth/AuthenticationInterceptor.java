package auth;

import app.UserBean;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;

public class AuthenticationInterceptor implements Interceptor {
    @Override
    public void init() {
        System.out.println("AuthenticationInterceptor initialized");
    }

    @Override
    public void destroy() {
        System.out.println("AuthenticationInterceptor destroyed");
    }

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        HttpSession session = ServletActionContext.getRequest().getSession();
        // Retrieve user information from the session
        UserBean user = (UserBean) session.getAttribute("user");

        if (user != null) {
            // User is authenticated, proceed with the action
            return invocation.invoke();
        } else {
            // User is not authenticated, redirect to login page
            return "login";
        }
    }

}

