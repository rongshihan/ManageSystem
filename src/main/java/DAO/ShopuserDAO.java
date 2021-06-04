package DAO;

import model.Shopuser;

import java.sql.Date;
import java.util.List;

//Shopuser表DAO接口
public interface ShopuserDAO {
    public Boolean insert(Shopuser shopuser);
    public Boolean update(Shopuser shopuser);
    public Boolean delete(String shopuser_id);
    public Shopuser findById(String shopuser_id);
    public List<Shopuser> findAll();
    public Shopuser findByNameAdd(String name,String address);
}
