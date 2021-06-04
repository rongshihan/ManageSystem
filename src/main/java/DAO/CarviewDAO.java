package DAO;

import basic.Carview;

import java.util.List;

public interface CarviewDAO {
    public List<Carview> findAll();
    public List<Carview> findAllByCon(String con, String min, String max);
    public Carview findById(String car_id,String shopuser_id);

}
