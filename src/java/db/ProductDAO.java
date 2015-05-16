/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Product;

/**
 *
 * @author VolkanOzkan
 */
@Stateless
@LocalBean
public class ProductDAO 
{
    @PersistenceContext private EntityManager em;
    
    public void addProduct(Product product)
    {
        em.persist(product);
    }
    
    public void editProduct(Product product)
    {
        em.merge(product);
    }
    
    public void deleteProduct(int name)
    {
        Product product = em.find(Product.class, name);
        em.remove(product);
    }
   
    public Product getProduct(int id)
    {
        return em.find(Product.class, id);
    }
   
    public List getAllProducts()
    {
        return em.createNamedQuery("Product.getAll").getResultList();
    }
}
