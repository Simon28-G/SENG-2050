package actions;

import app.Category;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;
import java.util.ArrayList;

public class DropMenu extends ActionSupport {
    private String selectedCategory;
    private List<String> categoryList;

    public String execute() {
        return SUCCESS;
    }

    // Getters and setters
    public String getSelectedCategory() {
        return selectedCategory;
    }

    public void setSelectedCategory(String selectedCategory) {
        this.selectedCategory = selectedCategory;
    }

    public List<String> getCategoryList() {
        return this.categoryList;
    }

    public void setCategoryList(ArrayList<String> categoryList) {
        this.categoryList = categoryList;
    }

    public String getDefaultCategory() {
        return "NETWORK";
    }

    public String initializeCategoryList(){
        // Populate the categoryList list with the desired values
        categoryList = new ArrayList<>();
        categoryList.add("NETWORK");
        categoryList.add("SOFTWARE");
        categoryList.add("HARDWARE");
        categoryList.add("EMAIL");
        categoryList.add("ACCOUNT");
        return NONE;
    }
}
