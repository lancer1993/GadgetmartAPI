package beans;
// Generated Dec 23, 2020 12:16:54 AM by Hibernate Tools 4.3.1

/**
 * Role generated by hbm2java
 */
public class Role implements java.io.Serializable {

    private Integer idrole;
    private String role;

    public Role() {
    }

    public Role(String role) {
        this.role = role;
    }

    public Integer getIdrole() {
        return this.idrole;
    }

    public void setIdrole(Integer idrole) {
        this.idrole = idrole;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}