/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Product;

/**
 *
 * @author VolkanOzkan
 */
public interface ProductDAO 
{
    public void addProduct(Product product);
    
    public void editProduct(Product product);
    
    public void deleteProduct(int id);
   
    public Product getProduct(int id);
   
    public List getAllProducts();
}
