/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.ProductDAOImpl;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import model.Product;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import org.junit.Test;
/**
 *
 * @author VolkanOzkan
 */
public class ProductTest {
    
    Product product;
    ProductDAOImpl acc;
        private static EntityManager em = null;

    public ProductTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        if (em == null) {
            em = (EntityManager) Persistence.createEntityManagerFactory("SoftwareHwPU").createEntityManager();
        }
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testInsertProduct()
    {
          em.getTransaction().begin();
//        acc = new ProductDAOImpl();
        product = new Product();
       
        product.setId(66);
        product.setBarcode("552123134");
    
        
        Product pro = null;
       em.persist(product);
//        try {
//            em.persist(product);
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        } 
//        finally {
//            if (pro != null) {
//                acc.deleteProduct(pro.getId());
//            }
//        }
    }
    
    
//    @Test
//    public void testProductCount()
//    {
//         em.getTransaction().begin();
//         
//        acc = ProductDAOImpl.getInstance();
//		assertEquals(1, em.createNamedQuery("Product.getAll").getResultList().size());
//    }
}
