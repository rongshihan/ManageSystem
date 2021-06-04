package server;

import DAO.DAOFactory;
import DAO.ShopuserDAO;
import model.Shopuser;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@SuppressWarnings("serial")
public class registerServlet extends HttpServlet {
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("identity");
        String pswd = request.getParameter("password");
        String chkpswd = request.getParameter("chkpassword");
        String shopname = request.getParameter("shopname");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String manager = request.getParameter("manager");
        String description  = request.getParameter("description");

        RequestDispatcher view;

        ShopuserDAO shopuserdao = DAOFactory.getShopuserDAO();
        Shopuser shopuser = shopuserdao.findById(id);

        if(shopuser.getShopuser_id()!=null)
        {
            request.setAttribute("msg","该用户名已被注册!");
            view=request.getRequestDispatcher("ShopPage/register.jsp");

        }else if(!pswd.equals(chkpswd)){
            request.setAttribute("chkpswd","请确认两次密码保持一致!");
            view=request.getRequestDispatcher("ShopPage/register.jsp");
        }
        else
            {
            shopuser = new Shopuser();
            shopuser.setShopuser_id(id);
            shopuser.setPswd(pswd);
            shopuser.setShop_name(shopname);
            shopuser.setShop_phone(phone);
            shopuser.setShop_address(address);
            shopuser.setShop_manager(manager);
            shopuser.setDescription(description);

            if(shopuserdao.insert(shopuser)){
                view = request.getRequestDispatcher("ShopPage/shopRegSuccess.html");
            }else {
                request.setAttribute("failed","注册失败");
                view=request.getRequestDispatcher("ShopPage/register.jsp");
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

