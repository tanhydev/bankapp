package project.model;

/* 
 * This a POJO for storing Customer Details
 */

public class Customer {

    private String fname;
    private String nric;
    private String email;

    public String getFname() {
        return fname;
    }
    public void setFname(String fname) {
        this.fname = fname;
    }
    public String getNric() {
        return nric;
    }
    public void setNric(String nric) {
        this.nric = nric;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }


}
