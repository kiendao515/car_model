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
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "CartServlet",urlPatterns = "/addtocart")
public class CartServlet extends HttpServlet {
    ProductService productService= new ProductServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int quantity=1;
        int id = Integer.parseInt(request.getParameter("id"));
        double price=0;
        if(id!=0){
            try {
                Product product= productService.getDetailProduct(id);
                if(product!=null){
                    if(request.getParameter("quantity")!=null){
                        quantity=Integer.parseInt(request.getParameter("quantity"));
                    }
                    HttpSession session=request.getSession();
                    if(session.getAttribute("order")==null){
                        Order order= new Order();
                        order.setId(UUID.randomUUID().toString());
                        List<Item> list=new ArrayList<>();
                        Item item= new Item();
                        item.setQuantity(quantity);
                        item.setPrice(product.getPrice());
                        item.setProduct(product);
                        list.add(item);
                        order.setItems(list);
                        session.setAttribute("order",order);
                        System.out.println(list);

                        // tinh tien
                        for(Item item1:list){
                            price= price + item1.getQuantity() * item1.getPrice();
                        }
                    }else {
                        Order order=(Order) session.getAttribute("order");
                        order.setId(UUID.randomUUID().toString());
                        List<Item> list=order.getItems();
                        boolean check =false;

                        for (Item item:list) {
                            if(item.getProduct().getId()==product.getId()){
                                item.setQuantity(quantity+item.getQuantity());
                                check=true;
                            }
                        }
                        if(check==false){
                            Item item= new Item();
                            item.setQuantity(quantity);
                            item.setProduct(product);
                            item.setPrice(product.getPrice());
                            list.add(item);
                        }
                        // tính tiền
                        for(Item item:list){
                            price= price + item.getQuantity() * item.getPrice();
                        }

                        // luu lai order tren session
                        session.setAttribute("order",order);
                    }
                }
                request.setAttribute("total",price);
                request.setAttribute("sum",price+20000);
                request.getRequestDispatcher("cart").forward(request,response);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }else {
            request.getRequestDispatcher("cart").forward(request,response);
        }
    }

    public static void main(String[] args) {

    }
}
