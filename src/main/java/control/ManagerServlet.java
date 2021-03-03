package control;

import dao.ProductDao;
import dao_impl.ProductDaoImpl;
import entity.Account;
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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ManagerServlet",urlPatterns = "/manager")
public class ManagerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session= request.getSession();
        Account account=(Account) session.getAttribute("acc");
        int id=account.getId();// id cua user
        ProductService productService= new ProductServiceImpl();
        CategoryService categoryService= new CategoryServiceImpl();
        try {
            List<Product> list=productService.getProductBySellerID(id);
            List<Category> listC=categoryService.findAllProduct();
            request.setAttribute("list2",list);
            request.setAttribute("listCategory",listC);
            request.getRequestDispatcher("ManagerProduct.jsp").forward(request,response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
