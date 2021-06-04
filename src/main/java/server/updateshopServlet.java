package server;

import DAO.DAOFactory;
import DAO.ShopuserDAO;
import model.Shopuser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "updateshopServlet",urlPatterns = "/updateshop")
public class updateshopServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String Shopuserid = (String)session.getAttribute("userid");
        String shop_phone = request.getParameter("shop_phone");
        String shop_address = request.getParameter("shop_address");
        String shop_manager = request.getParameter("shop_manager");
        String description = request.getParameter("description");
        ShopuserDAO shopuserDAO = DAOFactory.getShopuserDAO();
        Shopuser shopuser = shopuserDAO.findById(Shopuserid);
        shopuser.setShop_phone(shop_phone);
        shopuser.setShop_address(shop_address);
        shopuser.setShop_manager(shop_manager);
        shopuser.setDescription(description);
        boolean update = shopuserDAO.update(shopuser);
        if(update){
            request.setAttribute("success","更新成功！");
        }else{
            request.setAttribute("failed","更新失败！");
        }
        request.setAttribute("shopuser",shopuser);
        RequestDispatcher view;
        view = request.getRequestDispatcher("ShopPage/set.jsp");
        view.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
