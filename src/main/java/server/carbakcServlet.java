package server;

import DAO.CarinfoDAO;
import DAO.DAOFactory;
import basic.Carinfo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "carbakcServlet",urlPatterns = "/carback")
public class carbakcServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String shopuser_id = request.getParameter("userid");

        CarinfoDAO carinfoDAO = DAOFactory.getCarinfoDAO();
        List<Carinfo> carinfos = carinfoDAO.findAllByShopId(shopuser_id);
        request.setAttribute("searchcars",carinfos);
        RequestDispatcher view = request.getRequestDispatcher("ShopPage/funcViewCar.jsp");
        view.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
