package basic;


import java.sql.Date;
import java.sql.Timestamp;

public class Shopapt {
    private String appointment_id;
    private String shopuser_id;
    private String brand;
    private String model;
    private String cus_name;
    private String cus_phone;
    private String ap_type;
    private Timestamp ap_time;
    private String ap_state;
    private Timestamp complete_time;
    private double payment;
    private String shopinfo;
    private String cusinfo;

    public String getAppointment_id() {
        return appointment_id;
    }

    public void setAppointment_id(String appointment_id) {
        this.appointment_id = appointment_id;
    }

    public String getShopuser_id() {
        return shopuser_id;
    }

    public void setShopuser_id(String shopuser_id) {
        this.shopuser_id = shopuser_id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCus_name() {
        return cus_name;
    }

    public void setCus_name(String cus_name) {
        this.cus_name = cus_name;
    }

    public String getCus_phone() {
        return cus_phone;
    }

    public void setCus_phone(String cus_phone) {
        this.cus_phone = cus_phone;
    }

    public String getAp_type() {
        return ap_type;
    }

    public void setAp_type(String ap_type) {
        this.ap_type = ap_type;
    }

    public Timestamp getAp_time() {
        return ap_time;
    }

    public void setAp_time(Timestamp ap_time) {
        this.ap_time = ap_time;
    }

    public String getAp_state() {
        return ap_state;
    }

    public void setAp_state(String ap_state) {
        this.ap_state = ap_state;
    }

    public Timestamp getComplete_time() {
        return complete_time;
    }

    public void setComplete_time(Timestamp complete_time) {
        this.complete_time = complete_time;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public String getShopinfo() {
        return shopinfo;
    }

    public void setShopinfo(String shopinfo) {
        this.shopinfo = shopinfo;
    }

    public String getCusinfo() {
        return cusinfo;
    }

    public void setCusinfo(String cusinfo) {
        this.cusinfo = cusinfo;
    }
}
