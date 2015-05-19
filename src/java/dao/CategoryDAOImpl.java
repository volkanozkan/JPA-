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
import model.*;

/**
 *
 * @author VolkanOzkan
 */
@Stateless
@LocalBean
public class CategoryDAOImpl implements CategoryDAO
{
    @PersistenceContext private EntityManager em;
    
    @Override
    public void addCategory(Category category)
    {
        em.persist(category);
    }
    
    @Override
    public void editCategory(Category category)
    {
        em.merge(category);
    }
    @Override
    public void deleteCategory(int id)
    {
        Category category = em.find(Category.class, id);
        em.remove(category);
    }
     @Override  
    public Category getCategory(int id)
    {
        return em.find(Category.class, id);
    }
     @Override  
    public List getAllCategories()
    {
        return em.createNamedQuery("Category.getAll").getResultList();
    }
    
    //    public List getCategory3(int id) {
//         Query query = em.createNamedQuery("Category.findById2");
//          query.setParameter("id", id);
//          return query.getResultList();
//    }
}

