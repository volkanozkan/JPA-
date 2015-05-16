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
import model.Subcategory;

/**
 *
 * @author VolkanOzkan
 */
@Stateless
@LocalBean
public class SubCategoryDAO
{
    @PersistenceContext private EntityManager em;
    
    public void addSubcategory(Subcategory subCategory)
    {
        em.persist(subCategory);
    }
    
    public void editSubcategory(Subcategory subCategory)
    {
        em.merge(subCategory);
    }
    
    public void deleteSubcategory(int name)
    {
        Subcategory subCategory = em.find(Subcategory.class, name);
        em.remove(subCategory);
    }
   
    public Subcategory getSubcategory(int id)
    {
        return em.find(Subcategory.class, id);
    }
   
    public List getAllSubcategories()
    {
        return em.createNamedQuery("Subcategory.getAll").getResultList();
    }
}
