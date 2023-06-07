package actions;

import app.*;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
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
            //get issueID
            List<IssueBean> issues = issueDao.getIssuesByReporterID(user.getUserId());
            issues.sort((d1, d2) -> d1.getDateReported().compareTo(d2.getDateReported()));
            IssueBean lastIssueInserted = issues.get(issues.size() - 1);
            uploadFile(issueDao, issue, lastIssueInserted.getIssueID());
            return SUCCESS;

        } catch (Exception e){
            e.printStackTrace();
            return ERROR;
        }

    }

    //ALL FILES ARE UPLOADED IN THE WEBAPP FOLDER IN APACHE FOLDER (not in the project itself)
    private void uploadFile(IssueDao issueDao, IssueBean issue, int issueID) throws IOException {
        if(issue != null && issue.getFile() != null) {
            // Generate a hashed name for the file
            String originalFileName = issue.getFile().getName();
            String fileExtension = originalFileName.substring(originalFileName.lastIndexOf('.'));
            String generatedHashedName = generateHashedName(originalFileName) + fileExtension;

            // Save the uploaded file to a directory
            String savePath = ServletActionContext.getServletContext().getRealPath("/") + "uploads\\";
            File fileToSave = new File(savePath, generatedHashedName);
            FileUtils.copyFile(issue.getFile(), fileToSave);

            // Save the file details to the database
            issueDao.saveFileDetails(originalFileName, generatedHashedName, issueID);
        }
    }

    private String generateHashedName(String originalFileName) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashBytes = md.digest(originalFileName.getBytes(StandardCharsets.UTF_8));

            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }
}