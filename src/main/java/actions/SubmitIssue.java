package actions;

import app.UserBean;
import app.IssueBean;
import app.CommentBean;
import app.Category;
import app.State;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.io.File;
import java.util.Date;
import java.util.Map;

public class SubmitIssue extends ActionSupport {
    private UserBean user = (UserBean) getSession().get("user");
    private IssueBean issue;
    private String title;
    private String description;
    private State status;
    private Category category;
    private Map<String, Object> session;
    private File file;
    private String fileName;

    //SETTERS AND GETTERS
    public Map<String, Object> getSession(){
        return ActionContext.getContext().getSession();
    }

    public void setSession(){
        session = ActionContext.getContext().getSession();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public State getStatus() {
        return status;
    }

    public void setStatus(State status) {
        this.status = State.NEW;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String execute() throws Exception {
        try{
            issue.setReporterId(user.getUserId());
            issue.setTitle(title);
            Date date = new Date();
            issue.setDateReported(date);
            issue.setState(State.NEW);
            issue.setCategory(getCategory());

            if (file != null){
                this.file = file;
            }

            return SUCCESS;
        } catch (Exception e){
            e.printStackTrace();
            return ERROR;
        }

    }
}