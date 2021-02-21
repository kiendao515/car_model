package control;

import service.UserService;
import service_impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "SignupServlet",urlPatterns = "/register")
public class SignupServlet extends HttpServlet {
    UserService userService= new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username= request.getParameter("user");
        String pass= request.getParameter("password");
        String gmail=request.getParameter("email");
        String cfpass=request.getParameter("repassword");
        try {
            if(userService.checkUserExist(username)||!pass.equals(cfpass)){
                request.setAttribute("error2","Username existed or wrong password");
                response.sendRedirect("Loginn.jsp");
            }else {
                userService.register(username,pass,gmail);
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
