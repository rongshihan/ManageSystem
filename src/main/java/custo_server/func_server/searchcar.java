package custo_server.func_server;

import DAO.CarviewDAO;
import DAO.DAOFactory;
import basic.Carview;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "searchcar",urlPatterns = {"/searchcar"})
public class searchcar extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String min_price = request.getParameter("min_price");
        String max_price = request.getParameter("max_price");
        String con = request.getParameter("con");
        CarviewDAO carviewDAO = DAOFactory.getCarviewDAO();
        List<Carview> carviews = carviewDAO.findAllByCon(con,min_price,max_price);
        request.setAttribute("cars",carviews);
        RequestDispatcher view;
        view = request.getRequestDispatcher("WEB-INF/CustPage/testdrive.jsp");
        view.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);
    }
}
