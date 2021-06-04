package DAO;

import model.Customeruser;

import java.util.List;

//Customeruser表DAO接口
public interface CustomeruserDAO {
    public Boolean insert(Customeruser cu);
    public Boolean update(Customeruser cu);
    public Boolean delete(String cususer_id);
    public Customeruser findById(String cususer_id);
    public List<Customeruser> findAll();
}
