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
import model.Subcategory;

/**
 *
 * @author VolkanOzkan
 */
@Stateless
@LocalBean
public class SubCategoryDAOImpl implements SubCategoryDAO
{
    @PersistenceContext private EntityManager em;
    
    @Override
    public void addSubcategory(Subcategory subCategory)
    {
        em.persist(subCategory);
    }
    
    @Override
    public void editSubcategory(Subcategory subCategory)
    {
        em.merge(subCategory);
    }
    
    @Override
    public void deleteSubcategory(int id)
    {
        Subcategory subCategory = em.find(Subcategory.class, id);
        em.remove(subCategory);
    }
   
    @Override
    public Subcategory getSubcategory(int id)
    {
        return em.find(Subcategory.class, id);
    }
   
    @Override
    public List getAllSubcategories()
    {
        return em.createNamedQuery("Subcategory.getAll").getResultList();
    }
}
