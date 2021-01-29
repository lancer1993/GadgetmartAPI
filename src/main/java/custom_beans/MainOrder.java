/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custom_beans;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Terance Wijesuriya
 */
public class MainOrder implements Serializable{

    public List<MainOrderDetails> getList() {
        return list;
    }

    public void setList(List<MainOrderDetails> list) {
        this.list = list;
    }

    public int getIdUser() {
        return idUser;
    }

    public int getIdReatilers() {
        return idReatilers;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setIdReatilers(int idReatilers) {
        this.idReatilers = idReatilers;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
    
    private int idUser;
    private int idReatilers;
    private double totalAmount;
    private List<MainOrderDetails> list;
    
}
