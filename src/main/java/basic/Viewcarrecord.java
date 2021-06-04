package basic;

import java.sql.Timestamp;

public class Viewcarrecord {
    private String shopuser_id;
    private String brand;
    private String model;
    private String type;
    private double price;
    private String cususer_id;
    private Timestamp view_time;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCususer_id() {
        return cususer_id;
    }

    public void setCususer_id(String cususer_id) {
        this.cususer_id = cususer_id;
    }

    public Timestamp getView_time() {
        return view_time;
    }

    public void setView_time(Timestamp view_time) {
        this.view_time = view_time;
    }
}
