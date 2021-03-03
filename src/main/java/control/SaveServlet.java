package control;

import entity.Account;
import service.CategoryService;
import service.ProductService;
import service.UserService;
import service_impl.CategoryServiceImpl;
import service_impl.ProductServiceImpl;
import service_impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "SaveServlet",urlPatterns = "/save")
public class SaveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        UserService userService= new UserServiceImpl();
        request.setCharacterEncoding("UTF-8");
        int id= Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        String image=request.getParameter("image");
        String price=(request.getParameter("price")).replaceAll("[^\\d.]", "").replace(".","");
        String ratio=request.getParameter("ratio");
        String description=request.getParameter("description");
        int categoryID= Integer.parseInt(request.getParameter("category"));
        try {
            userService.updateProduct(name,ratio,price,image,categoryID,description,id);
            response.sendRedirect("manager");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
