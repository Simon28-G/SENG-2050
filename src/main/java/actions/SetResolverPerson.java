package actions;

import app.IssueBean;
import app.StaffBean;
import app.StaffDao;
import com.opensymphony.xwork2.ActionSupport;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SetResolverPerson extends ActionSupport {
    private int issueID;
    private Map<String, String> staffMap;
    private StaffDao staffDao = new StaffDao();

    public Map<String, String> getStaffMap() {
        return staffMap;
    }

    public int getIssueID() {
        return issueID;
    }

    public void setIssueID(int issueID) {
        this.issueID = issueID;
    }

    @Override
    public String execute() throws Exception {

        try {
            staffMap = new HashMap<>();
            Iterator<StaffBean> it = staffDao.getAllStaff().iterator();
            while(it.hasNext()){
                StaffBean currentStaff = it.next();
                staffMap.put(String.valueOf(currentStaff.getStaffId()), currentStaff.getUsername());
            }
            return SUCCESS;

        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }

    }
}