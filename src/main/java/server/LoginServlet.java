package server;

import DAO.*;
import basic.KeyValuePair;
import basic.Shopapt;
import model.Car;
import model.Shopuser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        String userid = request.getParameter("username");
        String password = request.getParameter("password");

        String access = request.getParameter("submit");
        RequestDispatcher view;
        if(access.equals("立即注册")){
            view = request.getRequestDispatcher("ShopPage/register.jsp");
        }
        else
        {
            if(userid.equals(""))
            {
                request.setAttribute("msg0", "请输入用户名");
                view  = request.getRequestDispatcher("index.jsp");
            }
            else if(password.equals(""))
            {
                request.setAttribute("msg1", "请输入密码");
                view  = request.getRequestDispatcher("index.jsp");
            }
            else {
                HttpSession session = request.getSession();
                session.setMaxInactiveInterval(3600);
                session.setAttribute("userid",userid);
                ShopuserDAO shopuserdao = DAOFactory.getShopuserDAO();
                Shopuser shopuser = shopuserdao.findById(userid);
                if (shopuser.getPswd()!=null&&shopuser.getPswd().equals(password)) {
                    CarDAO cardao = DAOFactory.getCarDAO();
                    List<Car> cars = cardao.findAll();
                   List<KeyValuePair> lists =new ArrayList<KeyValuePair>();
                    for(Car car:cars) {
                        lists.add(new KeyValuePair(car.getBrand(),car.getModel()));

                    }
                    session.setAttribute("list",lists);

                    request.setAttribute("userid",userid);

                    CarinfoDAO carinfoDAO = DAOFactory.getCarinfoDAO();
                    request.setAttribute("cars",carinfoDAO.findAllByShopId(userid));

                    view = request.getRequestDispatcher("ShopPage/firstpage.jsp");
                } else {
                    request.setAttribute("msg2", "用户名或密码错误！");
                    view = request.getRequestDispatcher("index.jsp");

                }
            }
        }
        view.forward(request,response);
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);

    }
}