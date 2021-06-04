package server;

import DAO.AppointmentDAO;
import DAO.CarinfoDAO;
import DAO.DAOFactory;
import DAO.ShopaptDAO;
import basic.Carinfo;
import basic.Shopapt;
import model.Appointment;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

@WebServlet(name = "dealingaptServlet",urlPatterns = "/dealingapt")
public class dealingaptServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String shopuserid = (String)session.getAttribute("userid");

        String access = request.getParameter("submit");
        String ap_id = request.getParameter("ap_id");
        String shopinfo = request.getParameter("shopinfo");
        AppointmentDAO apDAO = DAOFactory.getAppointmentDAO();
        Appointment ap = apDAO.findById(ap_id);
        RequestDispatcher view;

        ShopaptDAO shopaptDAO = DAOFactory.getShopaptDAO();
        Shopapt shopapt = shopaptDAO.findByApid(ap_id);
        request.setAttribute("shopapt",shopapt);

        if(access.equals("接受预约")){
            ap.setAp_state("已接受");
            ap.setShopinfo(shopinfo);
            view = request.getRequestDispatcher("ShopPage/funcViewAppointment.jsp");
            if(apDAO.update(ap)){
                request.setAttribute("success","成功接受！");
            }else{
                request.setAttribute("error","发生错误！");
            }
        }else if(access.equals("拒绝预约")){
                ap.setShopinfo(shopinfo);
                ap.setAp_state("已拒绝");
                ap.setPayment(0);
                view = request.getRequestDispatcher("ShopPage/funcViewAppointment.jsp");
                if(apDAO.update(ap)){
                    request.setAttribute("success","成功拒绝！");
                }else{
                    request.setAttribute("error","发生错误！");
                }
        }else if(access.equals("完成预约")){
            String completetime = request.getParameter("complete_time");
            String pay_ment = request.getParameter("payment");
            String description = request.getParameter("description");
            double payment = Double.parseDouble(pay_ment);
            Timestamp complete_time = Timestamp.valueOf(completetime);
            ap.setAp_state("已完成");
            ap.setComplete_time(complete_time);
            ap.setPayment(payment);
            ap.setShopinfo(description);
            view = request.getRequestDispatcher("ShopPage/funcViewAppointment.jsp");
            if(apDAO.update(ap)){
                request.setAttribute("success","预约完成！");
            }else{
                request.setAttribute("error","发生错误！");
            }
        }else{
            view = request.getRequestDispatcher("ShopPage/funcViewAppointment.jsp");
        }
        List<Shopapt> shopapts = shopaptDAO.findAllByShopId(shopuserid);
        request.setAttribute("userapoint",shopapts);
        view.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }
}
