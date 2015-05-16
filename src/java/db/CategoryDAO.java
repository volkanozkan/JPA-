/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import model.*;

/**
 *
 * @author VolkanOzkan
 */
@Stateless
@LocalBean
public class CategoryDAO {

    @PersistenceContext
    private EntityManager em;

    public void addCategory(Category category) {
        em.persist(category);
    }

    public void editCategory(Category category) {
        em.merge(category);
    }

    public void deleteCategory(int name) {
        Category category = em.find(Category.class, name);
        em.remove(category);
    }

    public Category getCategory(int id) {
        return em.find(Category.class, id);
    }

    public List getAllCategories() {
        return em.createNamedQuery("Category.getAll").getResultList();
    }
    
//    public List getCategory3(int id) {
//         Query query = em.createNamedQuery("Category.findById2");
//          query.setParameter("id", id);
//          return query.getResultList();
//    }
    
    
}
