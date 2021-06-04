package custo_server;

import DAO.CustomeruserDAO;
import DAO.DAOFactory;
import model.Customeruser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "regist",urlPatterns = {"/regist"})
public class regist extends HttpServlet {
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("username");
        String pswd = request.getParameter("password");
        String chkpswd = request.getParameter("chkpassword");
        String phone = request.getParameter("phone");
        String name = request.getParameter("name");
        String sex = request.getParameter("gender");
        String address = request.getParameter("address");
        String birthday = request.getParameter("birthday");

        RequestDispatcher view;

        CustomeruserDAO customeruserdao = DAOFactory.getCustometuserDAO();
        Customeruser customeruser = customeruserdao.findById(id);

        if(customeruser.getCususer_id()!=null)
        {
            request.setAttribute("msg","该用户名已被注册!");
            view=request.getRequestDispatcher("WEB-INF/CustPage/cusregister.jsp");

        }else if(!pswd.equals(chkpswd)){
            request.setAttribute("chkpswd","请确认两次密码保持一致!");
            view=request.getRequestDispatcher("WEB-INF/CustPage/cusregister.jsp");
        }
        else
        {
            customeruser = new Customeruser();
            customeruser.setCususer_id(id);
            customeruser.setPswd(pswd);
            customeruser.setCus_phone(phone);
            customeruser.setAddress(address);
            customeruser.setBirthday(Date.valueOf(birthday));
            customeruser.setSex(sex);
            customeruser.setCus_name(name);


            if(customeruserdao.insert(customeruser)){
                request.setAttribute("success","注册成功！");
                view = request.getRequestDispatcher("WEB-INF/CustPage/cuslogin.jsp");
            }
            else{
                request.setAttribute("failed","注册失败！请重新注册");
                view = request.getRequestDispatcher("WEB-INF/CustPage/cusregister.jsp");
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
