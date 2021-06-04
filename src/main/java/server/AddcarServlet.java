package server;
import DAO.CarDAO;
import DAO.CarDAOImpl;
import DAO.DAOFactory;
import DAO.ShopowncarDAO;
import model.Car;
import model.Shopowncar;
/*import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;*/

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@SuppressWarnings("serial")
public class AddcarServlet extends HttpServlet {
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String shopuserid = (String)session.getAttribute("userid");

        String brand = request.getParameter("brand");
        String model = request.getParameter("model");

        CarDAO carDAO = DAOFactory.getCarDAO();
        Car car = carDAO.findByBrandModel(brand,model);
        String stock = request.getParameter("stock");
        String price = request.getParameter("price");
        String description = request.getParameter("description");

        if(stock.equals("")||price.equals("")||description.equals("")) {
            request.setAttribute("error","请将属性填完整");
        }
        else{
            Shopowncar shopowncar = new Shopowncar();
            shopowncar.setCar_id(car.getCar_id());
            shopowncar.setShopuser_id(shopuserid);
            shopowncar.setStock(Integer.parseInt(stock));
            shopowncar.setPrice(Double.parseDouble(price));
            shopowncar.setDescription(description);

            ShopowncarDAO shopowncarDAO = DAOFactory.getShopowncarDAO();
            if(shopowncarDAO.insert(shopowncar)) {
                request.setAttribute("success", "添加成功");
            }
            else{
                request.setAttribute("error","添加失败");
            }
        }
            request.getRequestDispatcher("ShopPage/funcUploadCar.jsp").forward(request, response);

    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);

    }
}

