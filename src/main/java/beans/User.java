package beans;
// Generated Dec 23, 2020 12:16:54 AM by Hibernate Tools 4.3.1

import java.io.Serializable;
import java.util.Date;
/**
 * User generated by hbm2java
 */
public class User implements Serializable {

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    private Integer iduser;
    private String name;
    private String email;
    private String password;
    private String salt;
    private String phone;
    private Date birthday;
    private String gender;
    private String address;
    private String nic;
    private boolean enabled;
    private Date dateCreated;
    private Date lastUpdated;

    public User() {
    }

    public User(Integer iduser, String name, String email, String password, String salt, String phone, Date birthday, String gender, String address, String nic, boolean enabled, Date dateCreated, Date lastUpdated) {
        this.iduser = iduser;
        this.name = name;
        this.email = email;
        this.password = password;
        this.salt = salt;
        this.phone = phone;
        this.birthday = birthday;
        this.gender = gender;
        this.address = address;
        this.nic = nic;
        this.enabled = enabled;
        this.dateCreated = dateCreated;
        this.lastUpdated = lastUpdated;
    }   
    
    public Integer getIduser() {
        return this.iduser;
    }

    public void setIduser(Integer iduser) {
        this.iduser = iduser;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return this.salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean getEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Date getDateCreated() {
        return this.dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastUpdated() {
        return this.lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

}
