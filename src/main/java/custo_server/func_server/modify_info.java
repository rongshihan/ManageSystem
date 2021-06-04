package custo_server.func_server;

import DAO.CustomeruserDAO;
import DAO.DAOFactory;
import model.Customeruser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "modify_info",urlPatterns = "/modify")
public class modify_info extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String phone = request.getParameter("phone");
        String sex = request.getParameter("sex");
        String address = request.getParameter("address");
        Date birthday = Date.valueOf(request.getParameter("birthday"));

        HttpSession session = request.getSession();
        String userid = (String)session.getAttribute("userid");
        CustomeruserDAO customeruserDAO = DAOFactory.getCustometuserDAO();
        Customeruser customeruser = customeruserDAO.findById(userid);

        RequestDispatcher view;
        if(!phone.equals("")){
            customeruser.setCus_phone(phone);
        }
        if(!sex.equals("")){
            customeruser.setSex(sex);
        }
        if(!address.equals("")){
            customeruser.setAddress(request.getParameter("address"));
        }
        customeruser.setBirthday(birthday);
        customeruserDAO.update(customeruser);
        view = request.getRequestDispatcher("WEB-INF/CustPage/information.jsp");
        request.setAttribute("user_info",customeruser);
        view.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);
    }
}
