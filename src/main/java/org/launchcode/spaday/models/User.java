package org.launchcode.spaday.models;

import javax.validation.constraints.*;

public class User {

    @NotBlank(message = "Username is required!")
    @Size(min=5,max=15,message = "Username should be between 5 and 15 characters long")
    private String username;

    @Email(message = "Please enter a valid email")
    private String email;

    @NotBlank(message = "Password is required!")
    @Size(min = 6,message = "Password must be at least 6 characters long")
    private String password;

    @NotNull(message = "Passwords do not match")
    private String verifyPassword;

    public User() {

    }

    public User(String username, String email, String password) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
    }

    private void checkPassword(){
        if (this.password != null && this.verifyPassword != null && !this.password.equals(this.verifyPassword)){
            verifyPassword = null;
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        checkPassword();
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkPassword();
    }
}
