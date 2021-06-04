package custo_server;

import DAO.*;
import algorithm.CarRecommend;
import basic.Carview;
import basic.KeyValuePair;
import model.Car;
import model.Customeruser;
import model.Shopuser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "log",urlPatterns = {"/log"})
public class log extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userid = request.getParameter("username");
        String password = request.getParameter("password");

        String access = request.getParameter("submit");
        RequestDispatcher view;

        if(access.equals("立即注册")){
            view = request.getRequestDispatcher("WEB-INF/CustPage/cusregister.jsp");
        }
        else
        {
            if(userid.equals(""))
            {
                request.setAttribute("msg0", "请输入用户名");
                view  = request.getRequestDispatcher("WEB-INF/CustPage/cuslogin.jsp");
            }
            else if(password.equals(""))
            {
                request.setAttribute("msg1", "请输入密码");
                view  = request.getRequestDispatcher("WEB-INF/CustPage/cuslogin.jsp");
            }
            else {
                HttpSession session = request.getSession();
                session.setMaxInactiveInterval(3600);
                session.setAttribute("userid",userid);

                CustomeruserDAO customeruserdao  = DAOFactory.getCustometuserDAO();
                Customeruser customeruser = customeruserdao.findById(userid);

                CarviewDAO carviewDAO = DAOFactory.getCarviewDAO();
                List<Carview> carviews = carviewDAO.findAll();
                session.setAttribute("allshopcars",carviews);

                if (customeruser.getPswd()!=null&&customeruser.getPswd().equals(password)) {
                  //密码正确进入主页面
                    CarDAO cardao = DAOFactory.getCarDAO();
                    List<Car> cars = cardao.findAll();
                    List<KeyValuePair> lists =new ArrayList<KeyValuePair>();
                    for(Car car:cars) {
                        lists.add(new KeyValuePair(car.getBrand(),car.getModel()));
                    }
                    session.setAttribute("lists",lists);

                    ShopuserDAO shopuserDAO  = DAOFactory.getShopuserDAO();
                    List<Shopuser> shopusers = shopuserDAO.findAll();
                    session.setAttribute("shopusers",shopusers);

                    NewsDAO newsDAO = DAOFactory.getNewsDAO();
                    request.setAttribute("news",newsDAO.findAllToday());

                    //计算每辆车的推荐度算法的应用
                    CarRecommend carRecommend = new CarRecommend();
                    carRecommend.setCarBrand_priority();
                    carRecommend.setCarType_priority();
                    carRecommend.setCarPrice_priority();
                    Map<Carview,Double> car_priority = new HashMap<Carview, Double>();
                    for(Carview carview:carviews)
                    {
                        car_priority.put(carview,carRecommend.findcar_priority(carview));
                    }

                    car_priority=carRecommend.sortByComparator(car_priority);
                    session.setAttribute("car_priority",car_priority);

                    view = request.getRequestDispatcher("WEB-INF/CustPage/main.jsp");
                } else {
                    request.setAttribute("msg2", "用户名或密码错误");
                    view = request.getRequestDispatcher("WEB-INF/CustPage/cuslogin.jsp");

                }
            }
        }
        view.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
