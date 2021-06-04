package custo_server.func_server;

import DAO.AppointmentDAO;
import DAO.CususeraptDAO;
import DAO.DAOFactory;
import basic.Cususerapt;
import model.Appointment;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "cus_apt_op",urlPatterns = "/apt_op")
public class cus_apt_op extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        RequestDispatcher view;
        HttpSession session = request.getSession();
        String userid = (String)session.getAttribute("userid");
        if(action.equals("return"))
        {
            //查询出所有预约信息
            CususeraptDAO cususeraptDAO = DAOFactory.getCususeraptDAO();
            List<Cususerapt> cususerapts = cususeraptDAO.findAllByCusid(userid);
            request.setAttribute("cususerapts",cususerapts);
        }
        else {
            //更新预约状态为“已取消”
            AppointmentDAO appointmentDAO = DAOFactory.getAppointmentDAO();
            Appointment appointment = appointmentDAO.findById(action);
            appointment.setAp_state("已取消");
            appointmentDAO.update(appointment);

            CususeraptDAO cususeraptDAO = DAOFactory.getCususeraptDAO();
            List<Cususerapt> cususerapts = cususeraptDAO.findAllByCusid(userid);
            request.setAttribute("cususerapts",cususerapts);
        }
        view=request.getRequestDispatcher("WEB-INF/CustPage/appointmentView.jsp");
        view.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);
    }
}
