package app;

import java.util.ArrayList;

/**
 * Bean representing a specific user.
 */
public class UserBean extends PersonBean{
    
    /**
     * Unique ID number identifying the user.
     */
    private int userId;
    /**
     * List of issues the user has reported.
     */
    private ArrayList<IssueBean> listIssues;


    public UserBean() {
        
    }



    public IssueBean reportIssue(String title, String description,
            String category, ArrayList<String> keywords,
            ArrayList<InputFileBean> filesAndImages) {

        IssueBean issue = new IssueBean();

        return issue;
    }
    


    public IssueBean viewIssue(int issueId) {
        
        IssueBean issue = new IssueBean();

        return issue;
    }




    public void addComment(int issueId, String content) {
        
    }



    public void resolveIssue(int issueId) {
        
    }





    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int id) {
        this.userId = id;
    }

    public ArrayList<IssueBean> getListIssues() {
        return listIssues;
    }

    public void setListIssues(ArrayList<IssueBean> listIssues) {
        this.listIssues = listIssues;
    }

}