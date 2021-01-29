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
public class MainResponse implements Serializable{

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
    
    private String response;
    private int code;

    @Override
    public String toString() {
        return "MainResponse{" + "response=" + response + ", code=" + code + '}';
    }   
    
}
