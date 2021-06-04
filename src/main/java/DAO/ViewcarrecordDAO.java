package DAO;

import basic.Count;
import basic.Countinfo;
import basic.Cusviewcar;
import basic.Viewcarrecord;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public interface ViewcarrecordDAO {
    public List<Countinfo> findAllByShopId(String shopuser_id);
    public List<Countinfo> findCountByCon(String shopuser_id, String brand, String model, String start, String end);
    public List<Viewcarrecord> findAllByCusId(String cususer_id);
    public List<Cusviewcar> findAllCus(String shopuser_id, String brand, String model);
    public Map<String,Integer> findBrandCount();
    public Map<String,Integer> findTypeCount();
    public int findPriceCount(double min,double max);
    public int findAllCount();
    public List<Count> Count(String shopuser_id);
}
