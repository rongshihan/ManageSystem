package server;

import DAO.CarDAO;
import DAO.DAOFactory;
import DAO.ViewcarrecordDAO;
import DAO.ViewrecordDAO;
import Draw.BarChart;
import Draw.TimeSeriesChart;
import basic.Count;
import model.Car;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DrawChartServlet",urlPatterns = "/DrawChartServlet")
public class DrawChartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String userid = (String)session.getAttribute("userid");

        ViewcarrecordDAO viewcarrecordDAO = DAOFactory.getViewcarrecordDAO();
        List<Count> counts = viewcarrecordDAO.Count(userid);

        String graphURL = "";
        request.setAttribute("graphURL", graphURL);
        String submit = request.getParameter("submit");
        if (submit.equals("BarChart")) {
            BarChart barChart = new BarChart();
            CategoryDataset dataset = barChart.setDataSet(counts);
            JFreeChart chart = barChart.BarChart(dataset);
            try {
                String filename = ServletUtilities.saveChartAsJPEG(chart, 1000, 600, null, session);
                graphURL = request.getContextPath() + "/servlet/DisplayChart?filename=" + filename;
                request.setAttribute("graphURL", graphURL);
            } catch (Exception e) {
            }
            request.getRequestDispatcher("ShopPage/funcDataAnalyze.jsp").forward(request,response);
        }
        else {
            TimeSeriesChart timeSeriesChart = new TimeSeriesChart();
            DefaultPieDataset dataset = timeSeriesChart.createDataset(counts);
            JFreeChart chart1 = timeSeriesChart.TimeSeriesChart(dataset);
            try {
                String filename = ServletUtilities.saveChartAsPNG(chart1, 700, 600, null, session);
                graphURL = request.getContextPath() + "/servlet/DisplayChart?filename=" + filename;
                request.setAttribute("graphURL", graphURL);
            } catch (Exception e) {
            }
            request.getRequestDispatcher("ShopPage/funcDataAnalyze.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
