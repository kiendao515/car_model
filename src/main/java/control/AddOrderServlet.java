package control;

import entity.Order;
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
import java.util.UUID;

@WebServlet(name = "AddOrderServlet",urlPatterns = "/client")
public class AddOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       response.setContentType("text/html;charset=UTF-8");
       request.setCharacterEncoding("UTF-8");
        HttpSession session= request.getSession();
        Order order=(Order) session.getAttribute("order");
        String orderID= order.getId();
        String name =request.getParameter("name");
        String tel= request.getParameter("tel");
        String address=request.getParameter("address");
        UserService userService= new UserServiceImpl();
        System.out.println(orderID);
        try {
            userService.insertOrder(orderID,name,tel,address);
            session.removeAttribute("order");
            System.out.println("removerd r");
            response.sendRedirect("home");
//            request.getRequestDispatcher("home").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
