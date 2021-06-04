package server;

import DAO.DAOFactory;
import DAO.ViewcarrecordDAO;
import basic.Cusviewcar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "viewinfoServlet",urlPatterns = "/viewinfo")
public class viewinfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String Shopuserid = (String)session.getAttribute("userid");
        String brand = request.getParameter("brand");
        request.setAttribute("brand",brand);
        String model = request.getParameter("model");
        request.setAttribute("model",model);
        ViewcarrecordDAO viewcarrecordDAO = DAOFactory.getViewcarrecordDAO();
        List<Cusviewcar> cvcList = viewcarrecordDAO.findAllCus(Shopuserid,brand,model);
        request.setAttribute("cvcList",cvcList);
        RequestDispatcher view;
        view = request.getRequestDispatcher("ShopPage/viewCusrecord.jsp");
        view.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
