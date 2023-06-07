package actions;

import app.IssueDao;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class DownloadAction extends ActionSupport {

    private int issueID;

    public int getIssueID() {
        return issueID;
    }

    private String fileName; // The name of the file to be downloaded
    private InputStream fileInputStream; // The input stream for the file

    // Action method
    public String execute() throws Exception {
        // Logic to retrieve the file and set its name and input stream
        IssueDao issueDao = new IssueDao();

        File file = issueDao.getFilesByIssueId(issueID).get(0);
        fileName = file.getName();
        fileInputStream = new FileInputStream(file);
        return SUCCESS;
    }

    // Getter and setter methods for fileName and fileInputStream
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public InputStream getFileInputStream() {
        return fileInputStream;
    }

    public void setFileInputStream(InputStream fileInputStream) {
        this.fileInputStream = fileInputStream;
    }
}
