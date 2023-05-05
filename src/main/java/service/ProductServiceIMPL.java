package service;

import model.Cart;
import model.Product;
import util.ConnectionDb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceIMPL {
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();
        try {
            Connection con = ConnectionDb.getConnection();
            PreparedStatement pre = con.prepareStatement("SELECT *FROM Product");
            ResultSet rs = pre.executeQuery();
            while (rs.next()){
                Product product =new Product();
                product.setProductId(rs.getInt("id"));
                product.setProductName(rs.getString("name"));
                product.setTitle(rs.getString("title"));
                product.setPrice(rs.getFloat("price"));
                product.setQuantity(rs.getInt("quantity"));
                product.setImage(rs.getString("image"));
                productList.add(product);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return productList;
    }
    public boolean addProductToCart(Product product){
        List<Cart> cartList = null;
        try {
            Connection con = ConnectionDb.getConnection();
            PreparedStatement pre = con.prepareStatement("insert into cart values (?,?,?)");
            ResultSet rs = pre.executeQuery();
            while (rs.next()){
                pre.setInt(1,product.getProductId());
                pre.setInt(2,product.getProductId());
                pre.setInt(3,product.getQuantity());
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }
}
