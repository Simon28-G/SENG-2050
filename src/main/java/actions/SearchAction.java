package actions;

import com.opensymphony.xwork2.ActionSupport;

public class SearchAction extends ActionSupport {
    private String searchQuery;

    public String getSearchQuery(){return this.searchQuery;}
    public void setSearchQuery(String search){this.searchQuery = search;}

    @Override
    public String execute() {
        // database query using the searchQuery value
        System.out.println("Performing search for: " + searchQuery);
        return SUCCESS;
    }
}