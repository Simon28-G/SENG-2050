package app;

import java.util.ArrayList;

/**
 * Class describing an IT staff member.
 */
public class StaffBean extends PersonBean {
    
    /**
     * Unique identification number of the staff member.
     */
    private Integer staffId;
    /**
     * List of the issues assigned to the staff member.
     */
    private ArrayList<Integer> issuesAssigned;



    public void assignIssue(int issueId) {
        
    }

    public void addIssueToKB(int issueId) {
        
    }














    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public ArrayList<Integer> getIssuesAssigned() {
        return issuesAssigned;
    }

    public void setIssuesAssigned(ArrayList<Integer> issuesAssigned) {
        this.issuesAssigned = issuesAssigned;
    }
}
