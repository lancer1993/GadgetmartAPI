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
public class AuthKey implements Serializable{
    
    private String authKey;

    /**
     * @return the authKey
     */
    public String getAuthKey() {
        return authKey;
    }

    /**
     * @param authKey the authKey to set
     */
    public void setAuthKey(String authKey) {
        this.authKey = authKey;
    }
    
}
