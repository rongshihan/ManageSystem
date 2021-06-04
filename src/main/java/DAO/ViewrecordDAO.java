package DAO;

import basic.Count;
import model.Viewrecord;

import java.sql.Timestamp;
import java.util.List;

//Viewrecord表DAO接口
public interface ViewrecordDAO {
    public Boolean insert(Viewrecord vr);
    public Boolean update(Viewrecord vr);
    public Boolean delete(String shopuser_id, String car_id, String cususer_id,Timestamp view_time);
    public Viewrecord findById(String shopuser_id, String car_id, String cususer_id,Timestamp view_time);
    public List<Viewrecord> findAll();

}
