package beans;
// Generated Dec 23, 2020 12:16:54 AM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;

/**
 * OrderDetails generated by hbm2java
 */
public class OrderDetails implements java.io.Serializable {

    public BigDecimal getItemTotal() {
        return itemTotal;
    }

    public void setItemTotal(BigDecimal itemTotal) {
        this.itemTotal = itemTotal;
    }

    public Integer getIdorderDetails() {
        return idorderDetails;
    }

    public Orders getOrders() {
        return orders;
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

    public Date getLastUpdatedDateTime() {
        return lastUpdatedDateTime;
    }

    public Date getCreatedDateTime() {
        return createdDateTime;
    }

    public void setIdorderDetails(Integer idorderDetails) {
        this.idorderDetails = idorderDetails;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
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

    public void setLastUpdatedDateTime(Date lastUpdatedDateTime) {
        this.lastUpdatedDateTime = lastUpdatedDateTime;
    }

    public void setCreatedDateTime(Date createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    private Integer idorderDetails;
    private Orders orders;
    private String productCode;
    private String productImage;
    private int quantity;
    private BigDecimal itemTotal;
    private String productWarrentyPeriod;
    private String deliveryPeriod;
    private Date lastUpdatedDateTime;
    private Date createdDateTime;

    public OrderDetails() {
    }

    public OrderDetails(Integer idorderDetails, Orders orders, String productCode, String productImage, int quantity, BigDecimal itemTotal, String productWarrentyPeriod, String deliveryPeriod, Date lastUpdatedDateTime, Date createdDateTime) {
        this.idorderDetails = idorderDetails;
        this.orders = orders;
        this.productCode = productCode;
        this.productImage = productImage;
        this.quantity = quantity;
        this.itemTotal = itemTotal;
        this.productWarrentyPeriod = productWarrentyPeriod;
        this.deliveryPeriod = deliveryPeriod;
        this.lastUpdatedDateTime = lastUpdatedDateTime;
        this.createdDateTime = createdDateTime;
    }

}
