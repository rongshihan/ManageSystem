package DAO;

import basic.ShopRegcus;

import java.util.List;

public interface ShopRegcusDAO {
    public List<ShopRegcus> findByCon(String shopuser_id, String cususer_id, String cus_name, String brand, String model);
}
