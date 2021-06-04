package DAO;

import basic.Shopapt;

import java.util.List;

public interface ShopaptDAO {
    public Shopapt findByApid(String ap_id);
    public List<Shopapt> findAllByShopId(String shopuser_id);
    public List<Shopapt> findAllByTag(String shopuser_id,String apstate,String aptype,String cusname,String ap_id);

}