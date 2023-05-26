package pkg;

import java.util.ArrayList;

/**
 * Describe the Knowledge Base of the application.
 */
public class KnowledgeBaseBean {
    
    /**
     * Identification number for the Knowledge Base.
     */
    private int KBId;
    /**
     * List of articles composing the Knowledge Base.
     */
    private ArrayList<IssueBean> listArticles;



    public void addIssue(int issueId) {
        
    }

    public void viewIssue(int issueId) {

    }


    





    public int getKBId() {
        return KBId;
    }

    public void setKBId(int KBId) {
        this.KBId = KBId;
    }

    public ArrayList<IssueBean> getListArticles() {
        return listArticles;
    }

    public void setListArticles(ArrayList<IssueBean> listArticles) {
        this.listArticles = listArticles;
    }

}
