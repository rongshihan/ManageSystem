package custo_server.func_server;

import DAO.*;
import algorithm.GenerateApid;
import model.Appointment;
import model.Car;
import model.Shopuser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "MR_BookServlet",urlPatterns = "/MR_BookServlet")
public class MR_BookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String ap_id = new GenerateApid().generate();

        HttpSession session = request.getSession();
        String cuid = (String)session.getAttribute("userid");

        String brand = new String(request.getParameter("brand").getBytes("ISO8859-1"),"UTF-8");
        String model = new String(request.getParameter("model").getBytes("ISO8859-1"),"UTF-8");
        //根据brand，model查找车id
        CarDAO carDAO = DAOFactory.getCarDAO();
        Car car = carDAO.findByBrandModel(brand,model);
        String shop =new String(request.getParameter("shop").getBytes("ISO8859-1"),"UTF-8");
        String[] shopname = shop.split("-");
        String adress = shopname[1];
        String ShopName = shopname[0];
        //根据address，name查找经销商id
        ShopuserDAO shopuserDAO = DAOFactory.getShopuserDAO();
        Shopuser shopuser = shopuserDAO.findByNameAdd(ShopName,adress);
        String book = new String(request.getParameter("book").getBytes("ISO8859-1"),"UTF-8");
        String ap_time = request.getParameter("ap_time");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = df.parse(ap_time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Timestamp timestamp = new Timestamp(date.getTime());
        String ap_state = "待接受";
        String Message = new String(request.getParameter("Message").getBytes("ISO8859-1"),"UTF-8");
        Appointment appointment = new Appointment();
        appointment.setAppointment_id(ap_id);
        appointment.setCususer_id(cuid);
        appointment.setShopuser_id(shopuser.getShopuser_id());
        appointment.setCar_id(car.getCar_id());
        appointment.setAp_time(timestamp);
        appointment.setAp_type(book);
        appointment.setAp_state(ap_state);
        appointment.setCusinfo(Message);

        AppointmentDAO appointmentDAO = DAOFactory.getAppointmentDAO();
        if(appointmentDAO.insert(appointment)) {
            request.setAttribute("success", "预约提交成功");
            request.getRequestDispatcher("WEB-INF/CustPage/transaction.html").forward(request, response);
        }
        else {
            request.setAttribute("error", "预约提交失败");
            request.getRequestDispatcher("WEB-INF/CustPage/reserve.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);
    }
}
