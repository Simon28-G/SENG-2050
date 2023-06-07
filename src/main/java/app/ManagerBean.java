package app;

/**
 * Class describing an IT Manager.
 */
public class ManagerBean extends StaffBean {

    /**
     * Unique ID number identifying the manager.
     */
    private int managerId;

    public SystemStatisticsBean viewSystemStatistics() {

        SystemStatisticsBean stats = new SystemStatisticsBean();

        return stats;
    }
    

    public void assignIssue(int issueId, int staffId) {
        
    }


    public int getManagerId() {
        return this.managerId;
    }

    public void setManagerId(int id) {
        this.managerId = id;
    }


}
