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

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    UserService userService= new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username= request.getParameter("user");
        String pass= request.getParameter("password");
        try {
            Account account= userService.getAccount(username,pass);
            if(account==null){
                request.setAttribute("error", "Wrong username or password");
                request.getRequestDispatcher("Loginn.jsp").forward(request,response);
            }else {
//                request.getRequestDispatcher("/home").forward(request,response);
                HttpSession session= request.getSession();
                session.setAttribute("acc",account);
                response.sendRedirect("home");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
