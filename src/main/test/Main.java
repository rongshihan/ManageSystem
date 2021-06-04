

import DAO.*;
import algorithm.CarRecommend;
import basic.Carinfo;
import basic.Carview;
import basic.Count;
import basic.Shopapt;
import model.Shopuser;

import java.sql.Timestamp;
import java.util.*;

public class Main {

    public static void main(String []args) {
        ViewcarrecordDAO viewcarrecordDAO = DAOFactory.getViewcarrecordDAO();
        List<Count> counts = viewcarrecordDAO.Count("amcarshop");
        Iterator iterator = counts.iterator();
        while(iterator.hasNext()){
            //Car car = (Car) iterator.next();
            Count count = (Count) iterator.next();
            System.out.println(count.getShopuser_id());
            System.out.println(count.getBrandmodel());
            System.out.println(count.getCount());
        }
    }
}
