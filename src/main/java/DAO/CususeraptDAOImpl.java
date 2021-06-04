package DAO;

import basic.Cususerapt;
import dbcon.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CususeraptDAOImpl implements CususeraptDAO {


    public Cususerapt findByApid(String ap_id){
        DBConnect dbc = new DBConnect();
        Connection conn = dbc.getConnection();
        Cususerapt cuapt = new Cususerapt();
        String sql = "select * from cususerapt where appointment_id=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,ap_id);
            rs = ps.executeQuery();
            while(rs.next()){
                cuapt.setAppointment_id(rs.getString(1));
                cuapt.setCususer_id(rs.getString(2));
                cuapt.setBrand(rs.getString(3));
                cuapt.setModel(rs.getString(4));
                cuapt.setShop_name(rs.getString(5));
                cuapt.setShop_phone(rs.getString(6));
                cuapt.setShop_address(rs.getString(7));
                cuapt.setShop_manager(rs.getString(8));
                cuapt.setAp_type(rs.getString(9));
                cuapt.setAp_time(rs.getTimestamp(10));
                cuapt.setAp_state(rs.getString(11));
                cuapt.setComplete_time(rs.getTimestamp(12));
                cuapt.setPayment(rs.getDouble(13));
                cuapt.setShopinfo(rs.getString(14));
                cuapt.setCusinfo(rs.getString(15));
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
        return cuapt;
    }

    public List<Cususerapt> findAllByCusid(String cususer_id) {
        DBConnect dbc = new DBConnect();
        Connection conn = dbc.getConnection();
        List<Cususerapt> cususerapts = new ArrayList<Cususerapt>();
        String sql = "select * from cususerapt where cususer_id=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,cususer_id);
            rs = ps.executeQuery();
            while(rs.next()){
                Cususerapt cuapt = new Cususerapt();
                cuapt.setAppointment_id(rs.getString(1));
                cuapt.setCususer_id(rs.getString(2));
                cuapt.setBrand(rs.getString(3));
                cuapt.setModel(rs.getString(4));
                cuapt.setShop_name(rs.getString(5));
                cuapt.setShop_phone(rs.getString(6));
                cuapt.setShop_address(rs.getString(7));
                cuapt.setShop_manager(rs.getString(8));
                cuapt.setAp_type(rs.getString(9));
                cuapt.setAp_time(rs.getTimestamp(10));
                cuapt.setAp_state(rs.getString(11));
                cuapt.setComplete_time(rs.getTimestamp(12));
                cuapt.setPayment(rs.getDouble(13));
                cuapt.setShopinfo(rs.getString(14));
                cuapt.setCusinfo(rs.getString(15));
                cususerapts.add(cuapt);
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
        return cususerapts;
    }
}
