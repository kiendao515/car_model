package control;

import entity.Item;
import entity.Order;
import entity.Product;
import service.ProductService;
import service_impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

@WebServlet(name = "RemoveServlet",urlPatterns = "/remove")
public class RemoveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    private int isExisting(int id, List<Item> cart) throws SQLException, ClassNotFoundException {
        ProductService productService= new ProductServiceImpl();
        Product product=productService.getDetailProduct(id);
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getProduct().getId()==product.getId()) {
                return i;
            }
        }
        return -1;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        double price =0;
        String price2=null;
        try {
            if(session!=null){
                Order order =(Order) session.getAttribute("order");
                List<Item> list= order.getItems();
                int index = isExisting(Integer.parseInt(request.getParameter("id")), list);
                list.remove(index);
                System.out.println(order);
                session.setAttribute("order",order);

                // tinh lai tien
                for(Item item:list){
                    price= price+ Double.parseDouble(item.getPrice())* item.getQuantity();
                    price2= NumberFormat.getCurrencyInstance(new Locale("vi", "VN")).format(price);
                }
            }
            request.setAttribute("total",price2);
            if(session.getAttribute("order").equals(null)){
                request.setAttribute("sum",0);
            }else {
                request.setAttribute("sum",price+20000);
            }
            request.getRequestDispatcher("cart").forward(request,response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
