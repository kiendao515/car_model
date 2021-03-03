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
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@WebServlet(name = "CartServlet",urlPatterns = "/addtocart")
public class CartServlet extends HttpServlet {
    ProductService productService= new ProductServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        int quantity=1;
        int id = Integer.parseInt(request.getParameter("id"));
        double price=0;
        String price2=null;
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
                        item.setPrice(product.getPrice().replaceAll("[^\\d.]", "").replace(".",""));
                        item.setProduct(product);
                        list.add(item);
                        order.setItems(list);
                        session.setAttribute("order",order);
                        System.out.println(list);

                        // tinh tien
                        for(Item item1:list){
                            price= price + item1.getQuantity()*Double.valueOf(item1.getPrice());
                            price2= NumberFormat.getCurrencyInstance(new Locale("vi", "VN")).format(price);
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
                            item.setPrice(product.getPrice().replaceAll("[^\\d.]", "").replace(".",""));
                            list.add(item);
                        }
                        // tính tiền
                        for(Item item:list){
                            System.out.println(item.getPrice());
                            price= price + item.getQuantity() * Double.valueOf(item.getPrice());
                            price2= NumberFormat.getCurrencyInstance(new Locale("vi", "VN")).format(price);
                        }

                        // luu lai order tren session
                        session.setAttribute("order",order);
                    }
                }
                request.setAttribute("total",price2);
                request.setAttribute("vatFee",NumberFormat.getCurrencyInstance(new Locale("vi","VN")).format(0));
                request.setAttribute("shipFee",NumberFormat.getCurrencyInstance(new Locale("vi","VN")).format(20000));
                request.setAttribute("sum",NumberFormat.getCurrencyInstance(new Locale("vi", "VN")).format(price+20000));
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
