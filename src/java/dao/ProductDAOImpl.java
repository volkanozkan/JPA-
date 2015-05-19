/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

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
public class ProductDAOImpl implements ProductDAO
{
    @PersistenceContext private EntityManager em;
    
    @Override
    public void addProduct(Product product)
    {
        em.persist(product);
    }
    
    @Override
    public void editProduct(Product product)
    {
        em.merge(product);
    }
    
    @Override
    public void deleteProduct(int id)
    {
        Product product = em.find(Product.class, id);
        em.remove(product);
    }
   
    @Override
    public Product getProduct(int id)
    {
        return em.find(Product.class, id);
    }
   
    @Override
    public List getAllProducts()
    {
        return em.createNamedQuery("Product.getAll").getResultList();
    }
    
}
