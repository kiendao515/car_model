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

@WebServlet(name = "EditServlet",urlPatterns = "/edit")
public class EditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        ProductService productService= new ProductServiceImpl();
        CategoryService categoryService= new CategoryServiceImpl();
        request.setCharacterEncoding("UTF-8");
        int productID= Integer.parseInt(request.getParameter("id"));
        try {
            Product product= productService.getDetailProduct(productID);
            product.setPrice(product.getPrice().replaceAll("[^\\d.]", "").replace(".",""));
            List<Category> listC=categoryService.findAllProduct();
            request.setAttribute("listCategory",listC);
            request.setAttribute("detail",product);
            request.getRequestDispatcher("Edit.jsp").forward(request,response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
