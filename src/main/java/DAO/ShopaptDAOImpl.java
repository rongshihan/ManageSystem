package DAO;

import basic.Shopapt;
import dbcon.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShopaptDAOImpl implements ShopaptDAO {


    public Shopapt findByApid(String ap_id){
        DBConnect dbc = new DBConnect();
        Connection conn = dbc.getConnection();
        Shopapt shopapt = new Shopapt();
        String sql = "select * from shopapt where appointment_id=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,ap_id);
            rs = ps.executeQuery();
            while(rs.next()){
                shopapt.setAppointment_id(rs.getString(1));
                shopapt.setShopuser_id(rs.getString(2));
                shopapt.setBrand(rs.getString(3));
                shopapt.setModel(rs.getString(4));
                shopapt.setCus_name(rs.getString(5));
                shopapt.setCus_phone(rs.getString(6));
                shopapt.setAp_type(rs.getString(7));
                shopapt.setAp_time(rs.getTimestamp(8));
                shopapt.setAp_state(rs.getString(9));
                shopapt.setComplete_time(rs.getTimestamp(10));
                shopapt.setPayment(rs.getDouble(11));
                shopapt.setShopinfo(rs.getString(12));
                shopapt.setCusinfo(rs.getString(13));
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
        return shopapt;
    }

    public List<Shopapt> findAllByShopId(String shopuser_id){
        DBConnect dbc = new DBConnect();
        Connection conn = dbc.getConnection();
        List<Shopapt> shopaptList = new ArrayList<Shopapt>();
        String sql = "select * from shopapt where shopuser_id =? order by ap_time desc";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,shopuser_id);
            rs = ps.executeQuery();
            while(rs.next()){
                Shopapt shopapt = new Shopapt();
                shopapt.setAppointment_id(rs.getString(1));
                shopapt.setShopuser_id(rs.getString(2));
                shopapt.setBrand(rs.getString(3));
                shopapt.setModel(rs.getString(4));
                shopapt.setCus_name(rs.getString(5));
                shopapt.setCus_phone(rs.getString(6));
                shopapt.setAp_type(rs.getString(7));
                shopapt.setAp_time(rs.getTimestamp(8));
                shopapt.setAp_state(rs.getString(9));
                shopapt.setComplete_time(rs.getTimestamp(10));
                shopapt.setPayment(rs.getDouble(11));
                shopapt.setShopinfo(rs.getString(12));
                shopapt.setCusinfo(rs.getString(13));

                shopaptList.add(shopapt);
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
        return shopaptList;
    }

    public List<Shopapt> findAllByTag(String shopuser_id,String apstate,String aptype,String cusname,String ap_id){
        DBConnect dbc = new DBConnect();
        Connection conn = dbc.getConnection();
        List<Shopapt> shopaptList = new ArrayList<Shopapt>();
        String sql = "select * from shopapt where shopuser_id=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        if(!apstate.equals("全部预约"))
        {
            sql+="and ap_state='"+apstate+"'";
        }
        if(!aptype.equals("全部预约"))
        {
            sql+="and ap_type='"+aptype+"'";
        }
        if(!cusname.equals(""))
        {
            sql+="and cus_name='"+cusname+"'";
        }
        if(!ap_id.equals("")){
            sql+="and appointment_id='"+ap_id+"'";
        }
        sql += " order by ap_time desc";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,shopuser_id);
            rs = ps.executeQuery();
            while(rs.next()){
                Shopapt shopapt = new Shopapt();
                shopapt.setAppointment_id(rs.getString(1));
                shopapt.setShopuser_id(rs.getString(2));
                shopapt.setBrand(rs.getString(3));
                shopapt.setModel(rs.getString(4));
                shopapt.setCus_name(rs.getString(5));
                shopapt.setCus_phone(rs.getString(6));
                shopapt.setAp_type(rs.getString(7));
                shopapt.setAp_time(rs.getTimestamp(8));
                shopapt.setAp_state(rs.getString(9));
                shopapt.setComplete_time(rs.getTimestamp(10));
                shopapt.setPayment(rs.getDouble(11));
                shopapt.setShopinfo(rs.getString(12));
                shopapt.setCusinfo(rs.getString(13));

                shopaptList.add(shopapt);
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
        return shopaptList;
    }

}