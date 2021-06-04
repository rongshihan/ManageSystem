package server;

import DAO.DAOFactory;
import DAO.ShopRegcusDAO;
import basic.ShopRegcus;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "ViewRegServlet",urlPatterns = "/ViewRegServlet")
public class ViewRegServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String shopuserid = (String)session.getAttribute("userid");

        String cususer_id = request.getParameter("cususer_id");

        String cus_name = request.getParameter("cus_name");


        String brand = request.getParameter("brand");


        String model = request.getParameter("model");


        ShopRegcusDAO shopRegcusDAO = DAOFactory.getShopRegcusDAO();
        List<ShopRegcus> shopRegcuses = shopRegcusDAO.findByCon(shopuserid,cususer_id,cus_name,brand,model);
        request.setAttribute("shopowncar",shopRegcuses);
        request.getRequestDispatcher("ShopPage/funcViewReg.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
