package control;

import entity.Category;
import entity.Product;
import service.CategoryService;
import service.ProductService;
import service_impl.CategoryServiceImpl;
import service_impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "SearchServlet",urlPatterns = "/search")
public class SearchServlet extends HttpServlet {
    ProductService productService= new ProductServiceImpl();
    CategoryService categoryService= new CategoryServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     response.setContentType("text/html;charset=UTF-8");
     request.setCharacterEncoding("UTF-8");
     String text=request.getParameter("txt");
        try {
            List<Product> list= productService.getProductSearched(text);
            request.setAttribute("listProduct",list);
            request.setAttribute("abc",text);
            List<Category> listC=categoryService.findAllProduct();
            Product newestProduct= productService.getNewestProduct();
            request.setAttribute("listCategory",listC);
            request.setAttribute("newestProduct",newestProduct);
            request.getRequestDispatcher("/Home.jsp").forward(request,response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
