package controller;

import model.Cart;
import model.Product;
import service.ProductServiceIMPL;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/product-servlet")
public class ProductServlet extends HttpServlet {
    public List<Product> productList;
    public List<Cart> listCart = new ArrayList<>();
    ProductServiceIMPL productService = new ProductServiceIMPL();

    public void init() {
        productList = productService.findAll();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        showListProduct(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action != null) {
            switch (action) {
                case "CREATE":
                    int id = Integer.parseInt(req.getParameter("productId"));
                    int quantity = Integer.parseInt(req.getParameter("quantity"));
                    Cart cartList = new Cart(id, quantity);
                    boolean check = productService.addProductToCart(cartList.getProduct());
                    productList = productService.findAll();
                    System.out.println("check=======");
                    for (Product s : productList) {
                        if (s.getProductId() == id) {
                            req.setAttribute("productCreate", s);
                            break;
                        }
                    }
                    break;
                case "UPDATE":
                    break;
                default:
                    break;
            }
        }
    }

    public void showListProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list", productList);
        request.getRequestDispatcher("views/product.jsp").forward(request, response);
    }

    public void createCartItem(Cart cart) {
        listCart.add(cart);
    }
}
