package DAO;

import basic.Carinfo;

import java.util.List;

public interface CarinfoDAO {
    public List<Carinfo> findAllByShopId(String shopuser_id);
    public List<Carinfo> findAllByTag(String shopuser_id,String brand,String type);
}