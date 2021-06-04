package server;

import DAO.*;
import basic.Carinfo;
import basic.Countinfo;
import basic.ShopRegcus;
import basic.Shopapt;
import model.Shopowncar;
import model.Shopuser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.FactoryConfigurationError;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SwitchPage",urlPatterns = "/SwitchPage")
public class SwitchPage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String Shopuserid = (String)session.getAttribute("userid");
        session.setAttribute("userid",Shopuserid);
        String page = request.getParameter("page");
        RequestDispatcher view;
        if(page.equals("homepage")){
            view = request.getRequestDispatcher("ShopPage/firstpage.jsp");
        }else if(page.equals("funcpage")){
            view = request.getRequestDispatcher("ShopPage/funcOverview.jsp");
        }else if(page.equals("setpage")){
            ShopuserDAO shopuserDAO = DAOFactory.getShopuserDAO();
            Shopuser shopuser = shopuserDAO.findById(Shopuserid);
            request.setAttribute("shopuser",shopuser);
            view = request.getRequestDispatcher("ShopPage/set.jsp");
        }else if(page.equals("helppage")){
            view = request.getRequestDispatcher("ShopPage/help.jsp");
        }else if(page.equals("funcViewCar")){
            CarinfoDAO carinfoDAO = DAOFactory.getCarinfoDAO();
            List<Carinfo> carinfos = carinfoDAO.findAllByShopId(Shopuserid);
            request.setAttribute("searchcars",carinfos);
            view = request.getRequestDispatcher("ShopPage/funcViewCar.jsp");
        }else if(page.equals("funcUploadCar")){
            view = request.getRequestDispatcher("ShopPage/funcUploadCar.jsp");
        }else if(page.equals("funcViewAppointment")){
            ShopaptDAO shopaptDAO = DAOFactory.getShopaptDAO();
            List<Shopapt> shopapts  = shopaptDAO.findAllByShopId(Shopuserid);
            request.setAttribute("userapoint",shopapts);
            view = request.getRequestDispatcher("ShopPage/funcViewAppointment.jsp");
        }else if(page.equals("funcPushMsg")){
            view = request.getRequestDispatcher("ShopPage/funcPushMsg.jsp");
        }else if(page.equals("funcRegister")){
            view = request.getRequestDispatcher("ShopPage/funcRegister.jsp");
        }else if(page.equals("funcViewRecord")){
            ViewcarrecordDAO viewcarrecordDAO = DAOFactory.getViewcarrecordDAO();
            List<Countinfo> countinfos = viewcarrecordDAO.findAllByShopId(Shopuserid);
            request.setAttribute("countinfos",countinfos);
            view = request.getRequestDispatcher("ShopPage/funcViewRecord.jsp");
        }else if(page.equals("funcDataAnalyze")){
            view = request.getRequestDispatcher("ShopPage/funcDataAnalyze.jsp");
        }else if(page.equals("log")){
            view = request.getRequestDispatcher("index.jsp");
        }
        else{
            ShopRegcusDAO shopRegcusDAO = DAOFactory.getShopRegcusDAO();
            List<ShopRegcus> shopRegcuses = shopRegcusDAO.findByCon(Shopuserid,"","","","");
            request.setAttribute("shopowncar",shopRegcuses);
            view = request.getRequestDispatcher("ShopPage/funcViewReg.jsp");
        }
        view.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);
    }
}
