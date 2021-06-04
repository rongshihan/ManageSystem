package DAO;

import model.Shopowncar;

import java.util.List;

//Shopowncar表DAO接口
public interface ShopowncarDAO {
    public Boolean insert(Shopowncar shopowncar);
    public Boolean update(Shopowncar shopowncar);
    public Boolean delete(String shopuser_id,String car_id);
    public Shopowncar findById(String shopuser_id,String car_id);
    public List<Shopowncar> findAll();
}
