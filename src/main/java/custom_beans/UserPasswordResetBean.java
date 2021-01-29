/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custom_beans;

import java.io.Serializable;

/**
 *
 * @author Terance Wijesuriya
 */
public class UserPasswordResetBean implements Serializable{

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    private String email;
    private String password;
    
}
