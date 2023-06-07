package app;

import java.io.File;
import java.util.Date;

/**
 * Bean representing an Issue, with all of its characteristics
 * and  associated methods.
 */
public class IssueBean {
    
    /**
     * Unique ID number for the issue.
     */
    private int issueID;
    /**
     * Unique ID number for the reporter of the issue.
     */
    private int reporterID;
    /**
     * Unique ID number for the staff member assigned to the issue.
     */
    private int staffID;
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
    private File file;

    private boolean isKBArticle;


    
    /**
     * Creates an Issue based on the element retreived.
     * @param title : the title of the issue
     * @param description : the description of the issue
     * @param category : the category of the issue
     * @param reporterID : the ID number of the reporter
     * @param isKBArticle : a boolean value if it is a KB article
     */
    public void create(String title, String description, Category category,
            int reporterID) {

    }
    

    public void addComment(int commentID) {

    }
    

    public void resolveIssue(String resolutionDetails, Date dateResolved) {
        
    }



    /**
     * Updates the state of the issue.
     * @param newState : the new issue state
     */
    public void updateState(State newState) {
        
    }




    // Getter and setter for 'issueID'
    public int getIssueID() {
        return issueID;
    }
    
    public void setIssueID(int issueID) {
        this.issueID = issueID;
    }
    
    // Getter and setter for 'reporterID'
    public int getReporterID() {
        return reporterID;
    }
    
    public void setReporterID(int reporterID) {
        this.reporterID = reporterID;
    }
    
    // Getter and setter for 'staffID'
    public int getStaffID() {
        return staffID;
    }
    
    public void setStaffID(int staffID) {
        this.staffID = staffID;
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
        return this.category;
    }
    
    public void setCategory(Category category) {
        this.category = category;
    }

    public File getFile() {
        return this.file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public boolean isKBArticle() {
        return isKBArticle;
    }

    public void setKBArticle(boolean KBArticle) {
        isKBArticle = KBArticle;
    }
}