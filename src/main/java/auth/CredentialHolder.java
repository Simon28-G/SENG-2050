package auth;

public class CredentialHolder {
    private final String username;
    private final String password;

    public CredentialHolder(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
