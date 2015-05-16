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
import model.Supplier;

/**
 *
 * @author VolkanOzkan
 */
@Stateless
@LocalBean
public class SupplierDAO {
    
    @PersistenceContext
    private EntityManager em;
    
    public List getAllSuppliers() {
        return em.createNamedQuery("Supplier.getAll").getResultList();
    }
    
    public Supplier getSupplier(int id)
    {
        return em.find(Supplier.class, id);
    }
    
}
