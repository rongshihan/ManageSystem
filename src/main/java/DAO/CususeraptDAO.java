package DAO;

import basic.Cususerapt;

import java.util.List;

public interface CususeraptDAO {
    public Cususerapt findByApid(String ap_id);
    public List<Cususerapt> findAllByCusid(String cususer_id);
}
