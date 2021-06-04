package basic;

import java.sql.Time;
import java.sql.Timestamp;

public class Cususerapt {
    private String appointment_id;
    private String cususer_id;
    private String brand;
    private String model;
    private String shop_name;
    private String shop_phone;
    private String shop_address;
    private String shop_manager;
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

    public String getCususer_id() {
        return cususer_id;
    }

    public void setCususer_id(String cususer_id) {
        this.cususer_id = cususer_id;
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

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getShop_phone() {
        return shop_phone;
    }

    public void setShop_phone(String shop_phone) {
        this.shop_phone = shop_phone;
    }

    public String getShop_address() {
        return shop_address;
    }

    public void setShop_address(String shop_address) {
        this.shop_address = shop_address;
    }

    public String getShop_manager() {
        return shop_manager;
    }

    public void setShop_manager(String shop_manager) {
        this.shop_manager = shop_manager;
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
