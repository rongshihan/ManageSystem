package server;

import DAO.DAOFactory;
import DAO.ViewcarrecordDAO;
import basic.Countinfo;

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

@WebServlet(name = "ViewrecordServlet",urlPatterns = "/viewrecord")
public class ViewrecordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String shopuserid = (String)session.getAttribute("userid");
        String brand = request.getParameter("brand");
        String model = request.getParameter("model");
        String start = request.getParameter("start");
        String end = request.getParameter("end");
        ViewcarrecordDAO viewcarrecordDAO = DAOFactory.getViewcarrecordDAO();
        List<Countinfo> countinfos = viewcarrecordDAO.findCountByCon(shopuserid,brand,model,start,end);
        request.setAttribute("countinfos",countinfos);
        RequestDispatcher view;
        view = request.getRequestDispatcher("ShopPage/funcViewRecord.jsp");
        view.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
