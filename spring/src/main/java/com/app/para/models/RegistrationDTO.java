package com.app.para.models;


public class RegistrationDTO {
    private String email;
    private String username;
    private String password;

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    private String verificationCode;
    private boolean enabled;

    public RegistrationDTO(){
        super();
    }

    public RegistrationDTO(String email, String username, String password){
        super();
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public String getUsername(){
        return this.username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return this.password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String toString(){
        return "Registration info: username: " + this.username + " password: " + this.password;
    }

    public String getEmail() {
        return this.email;
    }
}