package actions;

import app.Category;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;
import java.util.ArrayList;

public class DropMenu extends ActionSupport {
    private String selectedCategory;
    private List<String> dropDownValues;

    public String execute() {
        // Populate the dropDownValues list with the desired values
        dropDownValues = new ArrayList<>();
        dropDownValues.add("NETWORK");
        dropDownValues.add("SOFTWARE");
        dropDownValues.add("HARDWARE");
        dropDownValues.add("EMAIL");
        dropDownValues.add("ACCOUNT");

        return SUCCESS;
    }

    // Getters and setters
    public String getSelectedCategory() {
        return selectedCategory;
    }

    public void setSelectedCategory(String selectedCategory) {
        this.selectedCategory = selectedCategory;
    }

    public List<String> getDropDownValues() {
        return this.dropDownValues;
    }

    public void setDropDownValues(ArrayList<String> dropDownValues) {
        this.dropDownValues = dropDownValues;
    }
}
