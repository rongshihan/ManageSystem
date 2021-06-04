package custo_server;

import DAO.*;
import basic.Carview;
import basic.Cususerapt;
import basic.Viewcarrecord;
import model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@WebServlet(name = "jumpPage",urlPatterns = "/jump")
public class jumpPage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pagename=request.getParameter("action");
        RequestDispatcher view;
        HttpSession session = request.getSession();
        String user_id = (String)session.getAttribute("userid");
        if(pagename.equals("homepage"))
        {
            NewsDAO newsDAO = DAOFactory.getNewsDAO();
            request.setAttribute("news",newsDAO.findAllToday());

            view = request.getRequestDispatcher("WEB-INF/CustPage/main.jsp");
        }else if(pagename.equals("personal_info")){
            CustomeruserDAO customeruserDAO = DAOFactory.getCustometuserDAO();
            Customeruser customeruser = customeruserDAO.findById(user_id);
            request.setAttribute("user_info",customeruser);
            view = request.getRequestDispatcher("WEB-INF/CustPage/information.jsp");
        }
        else if(pagename.equals("testdrive")){
            CarviewDAO carviewDAO = DAOFactory.getCarviewDAO();
            List<Carview> carviews  = carviewDAO.findAll();
            request.setAttribute("cars",carviews);
            view = request.getRequestDispatcher("WEB-INF/CustPage/testdrive.jsp");
        }
        else if(pagename.equals("viewcar")){
            view = request.getRequestDispatcher("WEB-INF/CustPage/gallery.html");
        }
        else if(pagename.equals("apt_record")){
            CususeraptDAO cususeraptDAO  = DAOFactory.getCususeraptDAO();
            List<Cususerapt> cususerapts = cususeraptDAO.findAllByCusid(user_id);
            request.setAttribute("cususerapts",cususerapts);
            view = request.getRequestDispatcher("WEB-INF/CustPage/appointmentView.jsp");
        }
        else if(pagename.equals("appoint_detail")) {
            String apt_id = request.getParameter("value");
            CususeraptDAO cususeraptDAO = DAOFactory.getCususeraptDAO();
            Cususerapt cususerapt = cususeraptDAO.findByApid(apt_id);
            request.setAttribute("cususerapt",cususerapt);
            view = request.getRequestDispatcher("WEB-INF/CustPage/recordDetail.jsp");
        }
        else if(pagename.equals("car_detail")) {
            String car_id = request.getParameter("carid");
            session.setAttribute("carid",car_id);

            String shopuser_id = request.getParameter("shopuserid");
            session.setAttribute("shopuserid",shopuser_id);

           CarviewDAO carviewDAO = DAOFactory.getCarviewDAO();
           Carview carview = carviewDAO.findById(car_id,shopuser_id);
            request.setAttribute("car",carview);
            //插入浏览时间到数据库
            ViewrecordDAO viewrecordDAO   = DAOFactory.getViewrecordDAO();
            Viewrecord viewrecord = new Viewrecord();
            viewrecord.setShopuser_id(shopuser_id);
            Timestamp view_time = new java.sql.Timestamp(new java.util.Date().getTime());
            viewrecord.setView_time(view_time);
            viewrecord.setCar_id(car_id);
            viewrecord.setCususer_id(user_id);
            viewrecordDAO.insert(viewrecord);
            view = request.getRequestDispatcher("WEB-INF/CustPage/testsingle.jsp");
        }
        else if(pagename.equals("viewhistory")){
            ViewcarrecordDAO viewcarrecordDAO = DAOFactory.getViewcarrecordDAO();
            List<Viewcarrecord> vcrList = viewcarrecordDAO.findAllByCusId(user_id);
            request.setAttribute("vcrList",vcrList);

            view = request.getRequestDispatcher("WEB-INF/CustPage/viewhistory.jsp");
        }else if(pagename.equals("trendslist")){
            NewsDAO newsDAO = DAOFactory.getNewsDAO();
            request.setAttribute("news",newsDAO.findAllToday());
            view = request.getRequestDispatcher("WEB-INF/CustPage/trendslist.jsp");
        }else if(pagename.equals("trends")){
            String title = request.getParameter("title");
            String shopuser_id = request.getParameter("shopuser_id");

            java.util.Date utilDate=new Date();
            java.sql.Date sqlDate=new java.sql.Date(utilDate.getTime());
            NewsDAO newsDAO = DAOFactory.getNewsDAO();
            News news = newsDAO.findById(shopuser_id,sqlDate,title);
            ShopuserDAO shopuserDAO = DAOFactory.getShopuserDAO();
            Shopuser shopuser = shopuserDAO.findById(shopuser_id);
            request.setAttribute("shopname",shopuser.getShop_name());
            request.setAttribute("title",news.getTitle());
            request.setAttribute("content",news.getContent());
            view = request.getRequestDispatcher("WEB-INF/CustPage/trends.jsp");
        } else if(pagename.equals("help")){
            view = request.getRequestDispatcher("WEB-INF/CustPage/cusHelp.html");
        }else{
            view = request.getRequestDispatcher("WEB-INF/CustPage/reserve.jsp");
        }
        view.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                doPost(request,response);
    }
}
