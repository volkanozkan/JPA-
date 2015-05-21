/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.ProductDAOImpl;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import model.Category;
import model.Product;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author VolkanOzkan
 */
public class TestProduct {
    
    public TestProduct() {
    }
    
    @BeforeClass
    public static void setUpClass() {
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
    @SuppressWarnings("CallToThreadDumpStack")
    public void testInsertProduct() throws SQLException 
    {
        
        String name = "TEST" + System.currentTimeMillis();
        double tax = 0;
        int id = 0;
        
        ProductDAOImpl productDAO = new ProductDAOImpl();
       
        Product pro = new Product();
        pro.setId(id);
        pro.setName(name);
       
        Category catRtr = null; 
         
        try 
        {
            productDAO.addProduct(pro);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        } 
        finally 
        {
            if (catRtr != null) 
            {
                productDAO.deleteProduct(catRtr.getId());
            }
        }
    }
    
    @Test
    @SuppressWarnings("CallToThreadDumpStack")
    public void testGetAllProduct() throws SQLException 
    {
        ProductDAOImpl productDAO = new ProductDAOImpl();

        List list = new LinkedList();
        
        try
        {
           list = productDAO.getAllProducts();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        } 
    }
}
