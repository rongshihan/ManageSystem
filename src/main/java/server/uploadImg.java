
package server;

import DAO.CarDAO;
import DAO.CarinfoDAO;
import DAO.DAOFactory;
import DAO.ShopowncarDAO;
import basic.Carinfo;
import model.Car;
import model.Shopowncar;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class uploadImg extends HttpServlet {
    // 上传文件存储目录
    private static final String UPLOAD_DIRECTORY = "image";

    // 上传配置
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
    public void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        // 检测是否为多媒体上传
        if (!ServletFileUpload.isMultipartContent(request)) {
            // 如果不是则停止
            PrintWriter writer = response.getWriter();
            writer.println("Error: 表单必须包含 enctype=multipart/form-data");
            writer.flush();
            return;
        }

        // 配置上传参数
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 设置内存临界值 - 超过后将产生临时文件并存储于临时目录中
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // 设置临时存储目录
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        ServletFileUpload upload = new ServletFileUpload(factory);

        // 设置最大文件上传值
        upload.setFileSizeMax(MAX_FILE_SIZE);

        // 设置最大请求值 (包含文件和表单数据)
        upload.setSizeMax(MAX_REQUEST_SIZE);

        // 中文处理
        upload.setHeaderEncoding("UTF-8");

        // 构造临时路径来存储上传的文件
        // 这个路径相对当前应用的目录
        String uploadPath = request.getServletContext().getRealPath("./") + UPLOAD_DIRECTORY;


        List<String> pList = new ArrayList<String>();
        String fileName=null;
        // 如果目录不存在则创建
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        try {
            // 解析请求的内容提取文件数据
            @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(request);

            if (formItems != null && formItems.size() > 0) {
                // 迭代表单数据
                for (FileItem item : formItems) {
                    // 处理不在表单中的字段
                    if (!item.isFormField()) {
                        fileName = new File(item.getName()).getName();
                        String filePath = uploadPath + File.separator + fileName;
                        File storeFile = new File(filePath);
                        // 在控制台输出文件的上传路径
                        System.out.println(filePath);
                        // 保存文件到硬盘
                        item.write(storeFile);
                        request.setAttribute("message",
                                "文件上传成功!");
                        continue;
                    }else {
                        String list = item.getString("UTF-8");
                        pList.add(list);
                        continue;
                    }
                }
            }
        } catch (Exception ex) {
            request.setAttribute("message",
                    "错误信息: " + ex.getMessage());
        }

        HttpSession session = request.getSession();
        String shopuserid = (String)session.getAttribute("userid");
        String carid = pList.get(0);
        ShopowncarDAO shopowncarDAO = DAOFactory.getShopowncarDAO();
        Shopowncar shopowncar = shopowncarDAO.findById(shopuserid,carid);

        String OrgImg = shopowncar.getPic_url();
        if(OrgImg.equals("")){
            shopowncar.setPic_url(UPLOAD_DIRECTORY + File.separator + fileName);
        }
        else {
            String[] imgs = OrgImg.split("--");
            if (imgs.length < 6) {
                shopowncar.setPic_url(OrgImg + "--" + UPLOAD_DIRECTORY + File.separator + fileName);
            } else {
                shopowncar.setPic_url(OrgImg.replaceAll(imgs[0] + "--", "") + "--" + UPLOAD_DIRECTORY + File.separator + fileName);
            }
        }
        shopowncarDAO.update(shopowncar);

        CarDAO carDAO = DAOFactory.getCarDAO();
        Car car = carDAO.findById(carid);

        request.setAttribute("brand",car.getBrand());
        request.setAttribute("model",car.getModel());
                // 跳转到 message.jsp
        //商家的车辆信息
        request.setAttribute("message","上传成功！");
        request.setAttribute("soc",shopowncar);

        request.getRequestDispatcher("ShopPage/ChangeCarInfo.jsp").forward(request,response);
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

