/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custom_beans;

import java.math.BigDecimal;

/**
 *
 * @author Terance Wijesuriya
 */
public class MainOrderDetails {

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getItemTotal() {
        return itemTotal;
    }

    public void setItemTotal(BigDecimal itemTotal) {
        this.itemTotal = itemTotal;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getProductImage() {
        return productImage;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getProductWarrentyPeriod() {
        return productWarrentyPeriod;
    }

    public String getDeliveryPeriod() {
        return deliveryPeriod;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setProductWarrentyPeriod(String productWarrentyPeriod) {
        this.productWarrentyPeriod = productWarrentyPeriod;
    }

    public void setDeliveryPeriod(String deliveryPeriod) {
        this.deliveryPeriod = deliveryPeriod;
    }

    private String productCode;
    private String productImage;
    private int quantity;
    private String productWarrentyPeriod;
    private String deliveryPeriod;
    private BigDecimal itemTotal;
    private String productName;
    
}
