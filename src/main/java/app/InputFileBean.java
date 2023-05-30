package app;

import java.io.File;
import java.util.Date;

/**
 * Class describing an input file attached to an issue.
 */
public class InputFileBean {
    
    /**
     * The file passed as input.
     */
    private File file;
    /**
     * The name of the file.
     */
    private String name;
    /**
     * The hashed name of the input file.
     */
    private String hashedName;
    /**
     * Identification number of the input file's owner.
     */
    private int ownerId;
    /**
     * Date at which the file was submitted.
     */
    private Date date;


    

    public void hash() {
        
    }








    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHashedName() {
        return hashedName;
    }

    public void setHashedName(String hashedName) {
        this.hashedName = hashedName;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
