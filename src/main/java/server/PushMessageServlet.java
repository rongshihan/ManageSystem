package server;

import DAO.DAOFactory;
import DAO.NewsDAO;
import model.News;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static jdk.nashorn.internal.runtime.regexp.joni.Syntax.Java;

@WebServlet(name = "PushMessageServlet",urlPatterns = "/PushMessageServlet")
public class PushMessageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String shopuserid = (String)session.getAttribute("userid");
        Date utilDate=new Date();
        java.sql.Date sqlDate=new java.sql.Date(utilDate.getTime());
        String title = request.getParameter("title");
        String message = request.getParameter("message");
        News news = new News();
        news.setShopuser_id(shopuserid);
        news.setTime(sqlDate);
        news.setTitle(title);
        news.setContent(message);

        NewsDAO newsDAO = DAOFactory.getNewsDAO();
        boolean bool = newsDAO.insert(news);
        if(bool)
        {
            request.setAttribute("success","上传成功！");
        }
        else
        {
            request.setAttribute("error","上传失败！请检查您的标题长度");
        }
        request.getRequestDispatcher("ShopPage/funcPushMsg.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
