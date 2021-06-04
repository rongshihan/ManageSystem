package server;
import DAO.DAOFactory;
import DAO.ShopaptDAO;
import basic.Shopapt;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@SuppressWarnings("serial")
public class HandleBookingServlet extends HttpServlet {
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher view;


        HttpSession session = request.getSession();
        String shopuserid = (String)session.getAttribute("userid");

        ShopaptDAO shopaptDAO = DAOFactory.getShopaptDAO();
        String apstate = request.getParameter("appointstate");
        String aptype = request.getParameter("appointtype");
        String cusname = request.getParameter("customername");
        String ap_id = request.getParameter("ap_id");

        List<Shopapt> apList = shopaptDAO.findAllByTag(shopuserid,apstate,aptype,cusname,ap_id);

        request.setAttribute("userapoint",apList);
        view=request.getRequestDispatcher("ShopPage/funcViewAppointment.jsp");
        view.forward(request,response);
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);

    }
}
