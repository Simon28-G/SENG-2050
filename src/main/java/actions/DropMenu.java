package actions;

import app.Category;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;

public class DropMenu extends ActionSupport {
    private ArrayList<Category> dropDownValues;

    @Override
    public String execute() throws Exception {

        try{
            dropDownValues = new ArrayList<>();
            dropDownValues.add(Category.ACCOUNT);
            dropDownValues.add(Category.EMAIL);
            dropDownValues.add(Category.HARDWARE);
            dropDownValues.add(Category.NETWORK);
            dropDownValues.add(Category.SOFTWARE);
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }
}