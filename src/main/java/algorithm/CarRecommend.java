package algorithm;

import DAO.DAOFactory;
import DAO.ViewcarrecordDAO;
import basic.Carview;

import java.util.*;

//车辆推荐算法
public class CarRecommend {
    private Map<String,Double> carType_priority = new HashMap<String, Double>();
    private Map<String,Double> carBrand_priority = new HashMap<String, Double>();
    private Map<Double,Double> carPrice_priority = new HashMap<Double, Double>();

    public void setCarPrice_priority() {
        Map<Double,Double> carPrice_priority = new HashMap<Double, Double>();
        carPrice_priority.put(0.0,500000.0);
        carPrice_priority.put(500000.0,1000000.0);
        carPrice_priority.put(1000000.0,2000000.0);
        carPrice_priority.put(2000000.0,3000000.0);
        carPrice_priority.put(3000000.0,4000000.0);
        carPrice_priority.put(4000000.0,5000000.0);
        carPrice_priority.put(5000000.0,10000000.0);
        this.carPrice_priority = carPrice_priority;
    }


    public void setCarBrand_priority() {
        ViewcarrecordDAO viewcarrecordDAO = DAOFactory.getViewcarrecordDAO();
        Map<String,Integer> carBrandMap  = viewcarrecordDAO.findBrandCount();
        Map<String,Double> carBrand_priority = new HashMap<String, Double>();
        double num = viewcarrecordDAO.findAllCount();
        for (Map.Entry<String, Integer> entry : carBrandMap.entrySet()) {
            carBrand_priority.put(entry.getKey(),(double) entry.getValue()/num);
        }
        this.carBrand_priority = carBrand_priority;
    }

    public void setCarType_priority() {
        ViewcarrecordDAO viewcarrecordDAO = DAOFactory.getViewcarrecordDAO();
        Map<String,Integer> typeCount  = viewcarrecordDAO.findTypeCount();
        Map<String,Double> carType_priority = new HashMap<String, Double>();
        double num = viewcarrecordDAO.findAllCount();
        for (Map.Entry<String, Integer> entry : typeCount.entrySet()) {
            carType_priority.put(entry.getKey(),(double) entry.getValue()/num);
        }
        this.carType_priority = carType_priority;
    }

    public double findcar_priority(Carview carview){
        ViewcarrecordDAO viewcarrecordDAO = DAOFactory.getViewcarrecordDAO();
        double priority;
        double carbrand_pt;
        double cartype_pt;
        double carprice_pt = 0;
        if(carBrand_priority.get(carview.getBrand())!=null) {
            carbrand_pt = carBrand_priority.get(carview.getBrand());
        }
        else{
            carbrand_pt = 0;
        }
        if(carType_priority.get(carview.getType())!=null) {
            cartype_pt = carType_priority.get(carview.getType());
        }
        else{
            cartype_pt = 0;
        }
        for(Map.Entry<Double,Double> entry:carPrice_priority.entrySet()) {
            double min  = entry.getKey();
            double max = entry.getValue();
            if(min<carview.getPrice()&&carview.getPrice()<max) {
                double numeretor = viewcarrecordDAO.findPriceCount(min,max);
                double denominator = viewcarrecordDAO.findAllCount();
                carprice_pt = numeretor/denominator;
            }
        }
        priority = carbrand_pt + cartype_pt + carprice_pt;
        return priority;
    }

    public Map sortByComparator(Map unsortMap){
        List list = new LinkedList(unsortMap.entrySet());
        Collections.sort(list, new Comparator()
        {
            public int compare(Object o1, Object o2)
            {
                return ((Comparable) ((Map.Entry) (o2)).getValue())
                        .compareTo(((Map.Entry) (o1)).getValue());
            }
        });
        Map sortedMap = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry)it.next();
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;

    }
}

