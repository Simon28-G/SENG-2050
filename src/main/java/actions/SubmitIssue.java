package actions;

import app.*;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.util.Date;
import java.util.Map;

public class SubmitIssue extends ActionSupport {
    private UserBean user;
    private IssueBean issue;
    private IssueDao issueDao = new IssueDao();

    public IssueBean getIssue() {
        return issue;
    }

    public void setIssue(IssueBean issue) {
        this.issue = issue;
    }

    @Override
    public String execute() throws Exception {
        try{
            user = (UserBean) ServletActionContext.getContext().getSession().get("user");
            Date date = new Date();
            issue.setDateReported(date);
            issue.setState(State.NEW);
            issue.setReporterID(user.getUserId());
            issueDao.createIssue(issue);
            return SUCCESS;

        } catch (Exception e){
            e.printStackTrace();
            return ERROR;
        }

    }
}