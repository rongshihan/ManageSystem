package DAO;

import model.Cusowncar;

import java.util.List;

//Cusowncar表DAO接口
public interface CusowncarDAO {
    public Boolean insert(Cusowncar coc);
    public Boolean update(Cusowncar coc);
    public Boolean delete(String plate_number);
    public Cusowncar findById(String plate_number);
    public List<Cusowncar> findAll();
}
