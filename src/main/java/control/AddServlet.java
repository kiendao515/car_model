package control;

import entity.Account;
import service.UserService;
import service_impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AddServlet",urlPatterns = "/add")
public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        UserService userService= new UserServiceImpl();
        String name=request.getParameter("name");
        String image=request.getParameter("image");
        double price= Double.parseDouble(request.getParameter("price"));
        String ratio=request.getParameter("ratio");
        String description=request.getParameter("description");
        int categoryID= Integer.parseInt(request.getParameter("category"));
        HttpSession session=request.getSession();
        Account account =(Account) session.getAttribute("acc");
        int sellerID=account.getId();// lay sellerID o tren session
        try {
            userService.insertProduct(name,ratio,price,image,categoryID,description,sellerID);
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
