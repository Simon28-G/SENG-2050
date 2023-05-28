package app;

/**
 * Parent class defining a general person. It can be a simple user or an IT staff member.
 */
public class PersonBean {

    /**
     * Username of the general user.
     */
    private String username;
    /**
     * Password of the general user.
     */
    private String password;
    /**
     * User's first name. They can have multiple.
     */
    private String firstName;
    /**
     * User's last name.
     */
    private String lastName;
    /**
     * User's e-mail address.
     */
    private String email;
    /**
     * User's contact number.
     */
    private String contactNumber;
    

    public PersonBean() {
        
    }



    // Username
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    // Password
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    // First Name
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    // Last Name
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    // Email
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    // Contact Number
    public String getContactNumber() {
        return contactNumber;
    }
    
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    
}