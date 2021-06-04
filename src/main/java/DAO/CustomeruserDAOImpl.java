package DAO;

import dbcon.DBConnect;
import model.Customeruser;

import javax.servlet.RequestDispatcher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//Customeruser表DAO实现接口
//含标准insert,update,delete,select（查询返回单个对象或返回对象List两种方法)查询方法
public class CustomeruserDAOImpl implements CustomeruserDAO {


    public Boolean insert(Customeruser cu) {
        DBConnect dbc = new DBConnect();
        Connection conn = dbc.getConnection();
        String sql = "insert into customeruser values (?,?,?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,cu.getCususer_id());
            ps.setString(2,cu.getPswd());
            ps.setString(3,cu.getCus_name());
            ps.setString(4,cu.getCus_phone());
            ps.setString(5,cu.getSex());
            ps.setDate(6,cu.getBirthday());
            ps.setString(7,cu.getAddress());

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

    public Boolean update(Customeruser cu){
        DBConnect dbc = new DBConnect();
        Connection conn = dbc.getConnection();
        String sql = "update customeruser set cususer_id=?,pswd=?,cus_name=?,cus_phone=?,sex=?,birthday=?,address=? where cususer_id=?";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,cu.getCususer_id());
            ps.setString(2,cu.getPswd());
            ps.setString(3,cu.getCus_name());
            ps.setString(4,cu.getCus_phone());
            ps.setString(5,cu.getSex());
            ps.setDate(6,cu.getBirthday());
            ps.setString(7,cu.getAddress());
            ps.setString(8,cu.getCususer_id());

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

    public Boolean delete(String cususer_id){
        DBConnect dbc = new DBConnect();
        Connection conn = dbc.getConnection();
        String sql = "delete from customeruser where cususer_id=?";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,cususer_id);

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

    public Customeruser findById(String cususer_id){
        DBConnect dbc = new DBConnect();
        Connection conn = dbc.getConnection();
        Customeruser cu = new Customeruser();
        String sql = "select * from customeruser where cususer_id=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,cususer_id);
            rs = ps.executeQuery();
            while(rs.next()){
                cu.setCususer_id(rs.getString(1));
                cu.setPswd(rs.getString(2));
                cu.setCus_name(rs.getString(3));
                cu.setCus_phone(rs.getString(4));
                cu.setSex(rs.getString(5));
                cu.setBirthday(rs.getDate(6));
                cu.setAddress(rs.getString(7));
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
        return cu;
    }

    public List<Customeruser> findAll(){
        DBConnect dbc = new DBConnect();
        Connection conn = dbc.getConnection();
        List<Customeruser> cusList = new ArrayList<Customeruser>();
        String sql = "select * from customeruser";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Customeruser cu = new Customeruser();
                cu.setCususer_id(rs.getString(1));
                cu.setPswd(rs.getString(2));
                cu.setCus_name(rs.getString(3));
                cu.setCus_phone(rs.getString(4));
                cu.setSex(rs.getString(5));
                cu.setBirthday(rs.getDate(6));
                cu.setAddress(rs.getString(7));

                cusList.add(cu);
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
        return cusList;
    }
}
