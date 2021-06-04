package server;

import DAO.CarDAO;
import DAO.CusowncarDAO;
import DAO.CustomeruserDAO;
import DAO.DAOFactory;
import model.Car;
import model.Cusowncar;
import model.Customeruser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "RegisterCarServlet",urlPatterns = "/RegisterCarServlet")
public class RegisterCarServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String plate_number = request.getParameter("plate_number");
        CusowncarDAO cusowncarDAO = DAOFactory.getCusowncarDAO();
        Cusowncar cusowncar = cusowncarDAO.findById(plate_number);
        if (cusowncar.getPlate_number() != null) {
            request.setAttribute("plate_number_error", "车牌号已存在");
        }

        HttpSession session = request.getSession();
        String shopuserid = (String) session.getAttribute("userid");


        String cusid = request.getParameter("userid");


        CustomeruserDAO customeruserDAO = DAOFactory.getCustometuserDAO();
        Customeruser customeruser = customeruserDAO.findById(cusid);

        if (customeruser.getCususer_id() == null) {
            request.setAttribute("cusid_error", "客户id不存在");
        }

        String brand = request.getParameter("brand");
        String model = request.getParameter("model");

        CarDAO carDAO = DAOFactory.getCarDAO();
        Car car = carDAO.findByBrandModel(brand, model);
        if (car.getCar_id() == null) {
            request.setAttribute("carid_error", "车辆不存在");
        }

        String register_time = request.getParameter("register_time");

        Date time = Date.valueOf(register_time);

        String pay_price = request.getParameter("pay_price");


        Cusowncar cusowncar1 = new Cusowncar();
        cusowncar1.setPlate_number(plate_number);
        cusowncar1.setShopuser_id(shopuserid);
        cusowncar1.setCususer_id(cusid);
        cusowncar1.setCar_id(car.getCar_id());
        cusowncar1.setRegister_time(time);
        cusowncar1.setPayment(Double.parseDouble(pay_price));

        CusowncarDAO cusowncarDAO1 = DAOFactory.getCusowncarDAO();
        if(cusowncarDAO1.insert(cusowncar1)){
            request.setAttribute("success","登记成功！");
        }else {
            request.setAttribute("error","登记失败！");
        }


        request.getRequestDispatcher("ShopPage/funcRegister.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
