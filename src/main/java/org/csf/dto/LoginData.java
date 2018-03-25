package org.csf.dto;

/**
 * @author Andrew Boytsov
 * @date 25.03.2018
 */

public class LoginData {

    private String login;
    private String password;

    public LoginData() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEmpty() {
        return login.isEmpty() || password.isEmpty();
    }
}
