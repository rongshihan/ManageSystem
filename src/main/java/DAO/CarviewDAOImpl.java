package DAO;

import basic.Carview;
import dbcon.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarviewDAOImpl implements CarviewDAO {


    public List<Carview> findAll(){
        DBConnect dbc = new DBConnect();
        Connection conn = dbc.getConnection();
        List<Carview> cvList = new ArrayList<Carview>();
        String sql = "select * from carview";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Carview cv = new Carview();
                cv.setShopuser_id(rs.getString(1));
                cv.setShop_name(rs.getString(2));
                cv.setShop_phone(rs.getString(3));
                cv.setShop_address(rs.getString(4));
                cv.setCar_id(rs.getString(5));
                cv.setBrand(rs.getString(6));
                cv.setModel(rs.getString(7));
                cv.setColor(rs.getString(8));
                cv.setSeats(rs.getString(9));
                cv.setType(rs.getString(10));
                cv.setPower(rs.getString(11));
                cv.setPrice(rs.getDouble(12));
                cv.setPic_url(rs.getString(13));
                cv.setDescription(rs.getString(14));
                cvList.add(cv);
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
        return cvList;
    }

    public List<Carview> findAllByCon(String con, String min, String max) {
        DBConnect dbc = new DBConnect();
        Connection conn = dbc.getConnection();
        List<Carview> cvList = new ArrayList<Carview>();
        String sql = "select * from carview where brand REGEXP ? and price between ? and ?";
        if(min.equals("")){
            min = "0";
        }
        if(max.equals("")){
            max = "100000000000000000";
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            if(!con.equals("")) {
                ps = conn.prepareStatement(sql);
                ps.setString(1, con);
                ps.setString(2, min);
                ps.setString(3, max);
                rs = ps.executeQuery();
            }
            else {
                sql = "select * from carview where price between ? and ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, min);
                ps.setString(2, max);
                System.out.println(sql);
                rs = ps.executeQuery();
            }
            while(rs.next()){
                Carview cv = new Carview();
                cv.setShopuser_id(rs.getString(1));
                cv.setShop_name(rs.getString(2));
                cv.setShop_phone(rs.getString(3));
                cv.setShop_address(rs.getString(4));
                cv.setCar_id(rs.getString(5));
                cv.setBrand(rs.getString(6));
                cv.setModel(rs.getString(7));
                cv.setColor(rs.getString(8));
                cv.setSeats(rs.getString(9));
                cv.setType(rs.getString(10));
                cv.setPower(rs.getString(11));
                cv.setPrice(rs.getDouble(12));
                cv.setPic_url(rs.getString(13));
                cv.setDescription(rs.getString(14));
                cvList.add(cv);
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
        return cvList;
    }

    public Carview findById(String car_id,String shopuser_id) {
        DBConnect dbc = new DBConnect();
        Connection conn = dbc.getConnection();
        Carview cv = new Carview();
        String sql = "select * from carview where car_id=? and shopuser_id=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,car_id);
            ps.setString(2,shopuser_id);
            rs = ps.executeQuery();
            while(rs.next()){
                cv.setShopuser_id(rs.getString(1));
                cv.setShop_name(rs.getString(2));
                cv.setShop_phone(rs.getString(3));
                cv.setShop_address(rs.getString(4));
                cv.setCar_id(rs.getString(5));
                cv.setBrand(rs.getString(6));
                cv.setModel(rs.getString(7));
                cv.setColor(rs.getString(8));
                cv.setSeats(rs.getString(9));
                cv.setType(rs.getString(10));
                cv.setPower(rs.getString(11));
                cv.setPrice(rs.getDouble(12));
                cv.setPic_url(rs.getString(13));
                cv.setDescription(rs.getString(14));
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
        return cv;
    }
}
