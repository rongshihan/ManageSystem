package DAO;

import dbcon.DBConnect;
import model.Shopuser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//Shopuser表DAO实现接口
//含标准insert,update,delete,select（查询返回单个对象或返回对象List两种方法)查询方法
public class ShopuserDAOImpl implements ShopuserDAO {


    public Boolean insert(Shopuser su) {
        DBConnect dbc = new DBConnect();
        Connection conn = dbc.getConnection();
        String sql = "insert into shopuser values (?,?,?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,su.getShopuser_id());
            ps.setString(2,su.getPswd());
            ps.setString(3,su.getShop_name());
            ps.setString(4,su.getShop_phone());
            ps.setString(5,su.getShop_address());
            ps.setString(6,su.getShop_manager());
            ps.setString(7,su.getDescription());

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

    public Boolean update(Shopuser su){
        DBConnect dbc = new DBConnect();
        Connection conn = dbc.getConnection();
        String sql = "update shopuser set shopuser_id=?,pswd=?,shop_name=?,shop_phone=?,shop_address=?,shop_manager=?," +
                "description=? where shopuser_id=?";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,su.getShopuser_id());
            ps.setString(2,su.getPswd());
            ps.setString(3,su.getShop_name());
            ps.setString(4,su.getShop_phone());
            ps.setString(5,su.getShop_address());
            ps.setString(6,su.getShop_manager());
            ps.setString(7,su.getDescription());
            ps.setString(8,su.getShopuser_id());

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

    public Boolean delete(String shopuser_id){
        DBConnect dbc = new DBConnect();
        Connection conn = dbc.getConnection();
        String sql = "delete from shopuser where shopuser_id=?";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,shopuser_id);

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

    public Shopuser findById(String shopuser_id){
        DBConnect dbc = new DBConnect();
        Connection conn = dbc.getConnection();
        Shopuser su = new Shopuser();
        String sql = "select * from shopuser where shopuser_id=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,shopuser_id);
            rs = ps.executeQuery();
            if(rs.next()){
                su.setShopuser_id(rs.getString(1));
                su.setPswd(rs.getString(2));
                su.setShop_name(rs.getString(3));
                su.setShop_phone(rs.getString(4));
                su.setShop_address(rs.getString(5));
                su.setShop_manager(rs.getString(6));
                su.setDescription(rs.getString(7));
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
        return su;
    }

    public List<Shopuser> findAll(){
        DBConnect dbc = new DBConnect();
        Connection conn = dbc.getConnection();
        List<Shopuser> suList = new ArrayList<Shopuser>();
        String sql = "select * from shopuser";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Shopuser su = new Shopuser();
                su.setShopuser_id(rs.getString(1));
                su.setPswd(rs.getString(2));
                su.setShop_name(rs.getString(3));
                su.setShop_phone(rs.getString(4));
                su.setShop_address(rs.getString(5));
                su.setShop_manager(rs.getString(6));
                su.setDescription(rs.getString(7));
                suList.add(su);
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
        return suList;
    }

    public Shopuser findByNameAdd(String name, String address) {
        DBConnect dbc = new DBConnect();
        Connection conn = dbc.getConnection();
        Shopuser su = new Shopuser();
        String sql = "select * from shopuser where shop_name=? and shop_address=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,address);
            rs = ps.executeQuery();
            while(rs.next()){
                su.setShopuser_id(rs.getString(1));
                su.setPswd(rs.getString(2));
                su.setShop_name(rs.getString(3));
                su.setShop_phone(rs.getString(4));
                su.setShop_address(rs.getString(5));
                su.setShop_manager(rs.getString(6));
                su.setDescription(rs.getString(7));
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
        return su;
    }
}
