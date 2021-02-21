package control;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LogOutServlet",value= "/logout")
public class LogOutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // session thi dung o doGet
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        if(session != null){
            session.removeAttribute("acc");
            System.out.println("Da remove");
            request.getRequestDispatcher("home").forward(request,response);
        }
    }
}
