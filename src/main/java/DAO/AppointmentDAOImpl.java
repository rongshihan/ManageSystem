package DAO;


import dbcon.DBConnect;
import model.Appointment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//Appointment表DAO实现接口
//含标准insert,update,delete,select（查询返回单个对象或返回对象List两种方法)查询方法
public class AppointmentDAOImpl implements AppointmentDAO {


    public Boolean insert(Appointment a) {
        DBConnect dbc = new DBConnect();
        Connection conn = dbc.getConnection();
        String sql = "insert into appointment values (?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,a.getAppointment_id());
            ps.setString(2,a.getCususer_id());
            ps.setString(3,a.getShopuser_id());
            ps.setString(4,a.getCar_id());
            ps.setTimestamp(5,a.getAp_time());
            ps.setString(6,a.getAp_type());
            ps.setString(7,a.getAp_state());
            ps.setTimestamp(8,a.getComplete_time());
            ps.setDouble(9,a.getPayment());
            ps.setString(10,a.getShopinfo());
            ps.setString(11,a.getCusinfo());

            ps.executeUpdate();
            if(ps!=null){
                ps.close();
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            dbc.closeDB();
        }
    }

    public Boolean update(Appointment a){
        DBConnect dbc = new DBConnect();
        Connection conn = dbc.getConnection();
        String sql = "update appointment set appointment_id=?,cususer_id=?,shopuser_id=?,car_id=?,ap_time=?," +
                "ap_type=?,ap_state=?,complete_time=?,payment=?,shopinfo=?,cusinfo=? where appointment_id=?";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,a.getAppointment_id());
            ps.setString(2,a.getCususer_id());
            ps.setString(3,a.getShopuser_id());
            ps.setString(4,a.getCar_id());
            ps.setTimestamp(5,a.getAp_time());
            ps.setString(6,a.getAp_type());
            ps.setString(7,a.getAp_state());
            ps.setTimestamp(8,a.getComplete_time());
            ps.setDouble(9,a.getPayment());
            ps.setString(10,a.getShopinfo());
            ps.setString(11,a.getCusinfo());
            ps.setString(12,a.getAppointment_id());

            ps.executeUpdate();
            if(ps!=null){
                ps.close();
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            dbc.closeDB();
        }
    }

    public Boolean delete(String ap_id){
        DBConnect dbc = new DBConnect();
        Connection conn = dbc.getConnection();
        String sql = "delete from appointment where appointment_id=?";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,ap_id);

            ps.executeUpdate();
            if(ps!=null){
                ps.close();
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            dbc.closeDB();
        }
    }

    public Appointment findById(String ap_id){
        DBConnect dbc = new DBConnect();
        Connection conn = dbc.getConnection();
        Appointment apt = new Appointment();
        String sql = "select * from appointment where appointment_id=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,ap_id);
            rs = ps.executeQuery();
            if(rs.next()){
                apt.setAppointment_id(rs.getString(1));
                apt.setCususer_id(rs.getString(2));
                apt.setShopuser_id(rs.getString(3));
                apt.setCar_id(rs.getString(4));
                apt.setAp_time(rs.getTimestamp(5));
                apt.setAp_type(rs.getString(6));
                apt.setAp_state(rs.getString(7));
                apt.setComplete_time(rs.getTimestamp(8));
                apt.setPayment(rs.getDouble(9));
                apt.setShopinfo(rs.getString(10));
                apt.setCusinfo(rs.getString(11));
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
        return apt;
    }

    public List<Appointment> findAll(){
        DBConnect dbc = new DBConnect();
        Connection conn = dbc.getConnection();
        List<Appointment> apList = new ArrayList<Appointment>();
        String sql = "select * from appointment";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Appointment apt = new Appointment();
                apt.setAppointment_id(rs.getString(1));
                apt.setCususer_id(rs.getString(2));
                apt.setShopuser_id(rs.getString(3));
                apt.setCar_id(rs.getString(4));
                apt.setAp_time(rs.getTimestamp(5));
                apt.setAp_type(rs.getString(6));
                apt.setAp_state(rs.getString(7));
                apt.setComplete_time(rs.getTimestamp(8));
                apt.setPayment(rs.getDouble(9));
                apt.setShopinfo(rs.getString(10));
                apt.setCusinfo(rs.getString(11));
                apList.add(apt);
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
        return apList;
    }
}
