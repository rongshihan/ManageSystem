package model;

import java.sql.Timestamp;

public class Viewrecord {
    private String shopuser_id;
    private String car_id;
    private String cususer_id;
    private Timestamp view_time;

    public String getShopuser_id() {
        return shopuser_id;
    }

    public void setShopuser_id(String shopuser_id) {
        this.shopuser_id = shopuser_id;
    }

    public String getCar_id() {
        return car_id;
    }

    public void setCar_id(String car_id) {
        this.car_id = car_id;
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
