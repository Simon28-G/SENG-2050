package app;

import java.util.Date;

/**
 * Bean representing an Issue, with all of its characteristics
 * and  associated methods.
 */
public class IssueBean {
    
    /**
     * Unique ID number for the issue.
     */
    private int issueId;
    /**
     * Unique ID number for the reporter of the issue.
     */
    private int reporterId;
    /**
     * Unique ID number for the staff member assigned to the issue.
     */
    private int staffId;
    /**
     * Title of the issue.
     */
    private String title;
    /**
     * Description of the issue.
     */
    private String description;
    /**
     * Details regarding the resolution of the issue.
     */
    private String resolutionDetails;
    /**
     * Date the issue was reported.
     */
    private Date dateReported;
    /**
     * Date the issue was declared as "resolved".
     */
    private Date dateResolved;
    /**
     * State of the issue. Can be NEW, IN_PROGRESS,
     * WAITING_THIRD_PARTY, WAITING_REPORTER, COMPLETED,
     * NOT_ACCEPTED, RESOLVED.
     */
    private State state;
    /**
     * Category attributed to the issue. Can be NETWORK,
     * SOFTWARE, HARDWARE, EMAIL or ACCOUNT.
     */
    private Category category;


    
    /**
     * Creates an Issue based on the element retreived.
     * @param title : the title of the issue
     * @param description : the description of the issue
     * @param category : the category of the issue
     * @param reporterId : the ID number of the reporter
     */
    public void create(String title, String description, Category category,
            int reporterId) {

    }
    

    public void addComment(int commentId) {

    }
    

    public void resolveIssue(String resolutionDetails, Date dateResolved) {
        
    }



    /**
     * Updates the state of the issue.
     * @param newState : the new issue state
     */
    public void updateState(State newState) {
        
    }




    // Getter and setter for 'issueId'
    public int getIssueId() {
        return issueId;
    }
    
    public void setIssueId(int issueId) {
        this.issueId = issueId;
    }
    
    // Getter and setter for 'reporterId'
    public int getReporterId() {
        return reporterId;
    }
    
    public void setReporterId(int reporterId) {
        this.reporterId = reporterId;
    }
    
    // Getter and setter for 'staffId'
    public int getStaffId() {
        return staffId;
    }
    
    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }
    
    // Getter and setter for 'title'
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    // Getter and setter for 'description'
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    // Getter and setter for 'resolutionDetails'
    public String getResolutionDetails() {
        return resolutionDetails;
    }
    
    public void setResolutionDetails(String resolutionDetails) {
        this.resolutionDetails = resolutionDetails;
    }
    
    // Getter and setter for 'dateReported'
    public Date getDateReported() {
        return dateReported;
    }
    
    public void setDateReported(Date dateReported) {
        this.dateReported = dateReported;
    }
    
    // Getter and setter for 'dateResolved'
    public Date getDateResolved() {
        return dateResolved;
    }
    
    public void setDateResolved(Date dateResolved) {
        this.dateResolved = dateResolved;
    }
    
    // Getter and setter for 'state'
    public State getState() {
        return state;
    }
    
    public void setState(State state) {
        this.state = state;
    }
    
    // Getter and setter for 'category'
    public Category getCategory() {
        return category;
    }
    
    public void setCategory(Category category) {
        this.category = category;
    }

}