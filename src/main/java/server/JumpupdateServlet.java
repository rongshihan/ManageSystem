package server;

import DAO.CarDAO;
import DAO.DAOFactory;
import DAO.ShopowncarDAO;
import model.Car;
import model.Shopowncar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "JumpupdateServlet",urlPatterns = "/jumpupdate")
public class JumpupdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        RequestDispatcher view;
        String shopuser_id = (String) session.getAttribute("userid");
        String action = request.getParameter("action");
        String brand = request.getParameter("brand");
        request.setAttribute("brand", brand);
        String model = request.getParameter("model");
        request.setAttribute("model", model);
        CarDAO carDAO = DAOFactory.getCarDAO();
        Car c = carDAO.findByBrandModel(brand, model);
        request.setAttribute("car",c);
        ShopowncarDAO shopowncarDAO = DAOFactory.getShopowncarDAO();
        Shopowncar soc = shopowncarDAO.findById(shopuser_id, c.getCar_id());
        request.setAttribute("soc",soc);
        if(action.equals("update")) {
             view = request.getRequestDispatcher("ShopPage/ChangeCarInfo.jsp");
        }else{
             view = request.getRequestDispatcher("ShopPage/carDetail.jsp");
        }
        view.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
