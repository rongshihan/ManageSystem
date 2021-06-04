package DAO;

import basic.ShopRegcus;
import dbcon.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShopRegcusDAOImpl implements ShopRegcusDAO{


    public List<ShopRegcus> findByCon(String shopuser_id, String cususer_id, String cus_name, String brand, String model) {
        DBConnect dbc = new DBConnect();
        Connection conn = dbc.getConnection();
        List<ShopRegcus> srcList = new ArrayList<ShopRegcus>();
        String sql = "select * from shopregcus where shopuser_id=? ";
        if(!cususer_id.equals("")){
            sql += "and cususer_id='"+cususer_id+"'";
        }
        if(!cus_name.equals("")){
            sql += " and cus_name='"+cus_name+"'";
        }
        if(!brand.equals("")){
            sql += " and brand='"+brand+"'";
        }
        if(!model.equals("")){
            sql += " and model='"+model+"'";
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,shopuser_id);
            rs = ps.executeQuery();
            while(rs.next()){
                ShopRegcus src = new ShopRegcus();
                src.setShopuser_id(rs.getString(1));
                src.setCususer_id(rs.getString(2));
                src.setCus_name(rs.getString(3));
                src.setCus_phone(rs.getString(4));
                src.setBrand(rs.getString(5));
                src.setModel(rs.getString(6));
                src.setColor(rs.getString(7));
                src.setRegister_time(rs.getDate(8));
                srcList.add(src);
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
        return srcList;
    }
}
