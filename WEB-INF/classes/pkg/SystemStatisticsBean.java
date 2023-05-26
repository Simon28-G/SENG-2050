package pkg;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class describing the statistics of the system.
 */
public class SystemStatisticsBean {

    /**
     * Identification number for the statistics generation.
     */
    private int statisticId;
    /**
     * Number of issues per category.
     */
    private HashMap<Category, Integer> numberOfIssuesPerCategory;
    /**
     * Number of issues per state.
     */
    private HashMap<State, Integer> numberOfIssuesPerState;
    /**
     * Number of issues per staff member.
     */
    private HashMap<String, Integer> numberOfIssuesPerStaff;
    /**
     * Average resolution time for an issue.
     */
    private double averageResolutionTime;
    /**
     * 
     */
    private int knowledgeBaseUtilization;
    /**
     * 5 longest unresolved issues.
     */
    private ArrayList<IssueBean> top5LongestUnresolvedIssues;















    public int getStatisticId() {
        return statisticId;
    }

    public void setStatisticId(int statisticId) {
        this.statisticId = statisticId;
    }

    public HashMap<Category, Integer> getNumberOfIssuesPerCategory() {
        return numberOfIssuesPerCategory;
    }

    public void setNumberOfIssuesPerCategory(HashMap<Category, Integer> numberOfIssuesPerCategory) {
        this.numberOfIssuesPerCategory = numberOfIssuesPerCategory;
    }

    public HashMap<State, Integer> getNumberOfIssuesPerState() {
        return numberOfIssuesPerState;
    }

    public void setNumberOfIssuesPerState(HashMap<State, Integer> numberOfIssuesPerState) {
        this.numberOfIssuesPerState = numberOfIssuesPerState;
    }

    public HashMap<String, Integer> getNumberOfIssuesPerStaff() {
        return numberOfIssuesPerStaff;
    }

    public void setNumberOfIssuesPerStaff(HashMap<String, Integer> numberOfIssuesPerStaff) {
        this.numberOfIssuesPerStaff = numberOfIssuesPerStaff;
    }

    public double getAverageResolutionTime() {
        return averageResolutionTime;
    }

    public void setAverageResolutionTime(double averageResolutionTime) {
        this.averageResolutionTime = averageResolutionTime;
    }

    public int getKnowledgeBaseUtilization() {
        return knowledgeBaseUtilization;
    }

    public void setKnowledgeBaseUtilization(int knowledgeBaseUtilization) {
        this.knowledgeBaseUtilization = knowledgeBaseUtilization;
    }

    public ArrayList<IssueBean> getTop5LongestUnresolvedIssues() {
        return top5LongestUnresolvedIssues;
    }

    public void setTop5LongestUnresolvedIssues(ArrayList<IssueBean> top5LongestUnresolvedIssues) {
        this.top5LongestUnresolvedIssues = top5LongestUnresolvedIssues;
    }
}
