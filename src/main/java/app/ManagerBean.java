package app;

/**
 * Class describing an IT Manager.
 */
public class ManagerBean extends StaffBean {
    

    public SystemStatisticsBean viewSystemStatistics() {

        SystemStatisticsBean stats = new SystemStatisticsBean();

        return stats;
    }
    

    public void assignIssue(int issueId, int staffId) {
        
    }


}
