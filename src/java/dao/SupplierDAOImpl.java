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
import model.Supplier;

/**
 *
 * @author VolkanOzkan
 */
@Stateless
@LocalBean
public class SupplierDAOImpl implements SupplierDAO
{
    
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public List getAllSuppliers()
    {
        return em.createNamedQuery("Supplier.getAll").getResultList();
    }
    
    @Override
    public Supplier getSupplier(int id)
    {
        return em.find(Supplier.class, id);
    }
    
}
