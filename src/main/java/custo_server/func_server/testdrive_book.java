package custo_server.func_server;

import DAO.*;
import basic.Carview;
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

@WebServlet(name = "testdrive_book",urlPatterns = {"/testdrive_book"})
public class testdrive_book extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int ap_num = (int)(Math.random()*100000000);
        String ap_id = Integer.toString(ap_num);
        HttpSession session = request.getSession();
        String cuid = (String) session.getAttribute("userid");
        String shopuserid = (String) session.getAttribute("shopuserid");
        String carid = (String) session.getAttribute("carid");
        String ap_time = request.getParameter("ap_time");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = df.parse(ap_time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Timestamp timestamp = new Timestamp(date.getTime());
        String ap_type = "试驾预约";
        String ap_state = "待接受";
        String Message = new String(request.getParameter("Message").getBytes("ISO8859-1"),"UTF-8");
        Appointment appointment = new Appointment();
        appointment.setAppointment_id(String.valueOf(ap_id));
        appointment.setCususer_id(cuid);
        appointment.setShopuser_id(shopuserid);
        appointment.setCar_id(carid);
        appointment.setAp_time(timestamp);
        appointment.setAp_type(ap_type);
        appointment.setAp_state(ap_state);
        appointment.setPayment(0);
        appointment.setCusinfo(Message);

        AppointmentDAO appointmentDAO = DAOFactory.getAppointmentDAO();
        if (appointmentDAO.insert(appointment)) {
            request.getRequestDispatcher("WEB-INF/CustPage/transaction.html").forward(request, response);
        }
        else
        {
            String car_id = request.getParameter("carid");
            session.setAttribute("carid",car_id);

            String shopuser_id = request.getParameter("shopuserid");
            session.setAttribute("shopuserid",shopuser_id);

            CarviewDAO carviewDAO = DAOFactory.getCarviewDAO();
            Carview carview = carviewDAO.findById(car_id,shopuser_id);
            request.setAttribute("car",carview);
            request.setAttribute("error", "预约提交失败");
            request.getRequestDispatcher("WEB-INF/CustPage/testsingle.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
