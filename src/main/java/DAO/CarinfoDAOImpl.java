package DAO;

import basic.Carinfo;
import dbcon.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarinfoDAOImpl implements CarinfoDAO{


    public List<Carinfo> findAllByShopId(String shopuser_id){
        DBConnect dbc = new DBConnect();
        Connection conn = dbc.getConnection();
        List<Carinfo> carinfoList = new ArrayList<Carinfo>();
        String sql = "select * from carinfo where shopuser_id=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,shopuser_id);
            rs = ps.executeQuery();
            while(rs.next()){
                Carinfo carinfo = new Carinfo();
                carinfo.setShopuser_id(rs.getString(1));
                carinfo.setBrand(rs.getString(2));
                carinfo.setModel(rs.getString(3));
                carinfo.setType(rs.getString(4));
                carinfo.setStock(rs.getInt(5));
                carinfo.setPrice(rs.getDouble(6));
                carinfo.setPic_url(rs.getString(7));

                carinfoList.add(carinfo);
            }
            if(ps!=null){
                ps.close();
            }
            if(rs!=null){
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbc.closeDB();
        }
        return  carinfoList;
    }

    public List<Carinfo> findAllByTag(String shopuser_id,String brand,String type){
        DBConnect dbc = new DBConnect();
        Connection conn = dbc.getConnection();
        List<Carinfo> carinfos = new ArrayList<Carinfo>();
        String sql = "select * from carinfo where shopuser_id=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        if(!(brand.equals("")))
        {
            sql+="and brand='"+brand+"'";
        }
        if(!type.equals("")){
            sql+="and type='"+type+"'";
        }
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,shopuser_id);
            rs = ps.executeQuery();
            while(rs.next()){
                Carinfo carinfo = new Carinfo();
                carinfo.setShopuser_id(rs.getString(1));
                carinfo.setBrand(rs.getString(2));
                carinfo.setModel(rs.getString(3));
                carinfo.setType(rs.getString(4));
                carinfo.setStock(rs.getInt(5));
                carinfo.setPrice(rs.getDouble(6));
                carinfo.setPic_url(rs.getString(7));

                carinfos.add(carinfo);
            }
            if(ps!=null){
                ps.close();
            }
            if(rs!=null){
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbc.closeDB();
        }
        return carinfos;
    }
}