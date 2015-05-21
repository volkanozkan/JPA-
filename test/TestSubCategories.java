/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.SubCategoryDAOImpl;
import java.sql.SQLException;
import model.Category;
import model.Subcategory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author VolkanOzkan
 */
public class TestSubCategories {
    
    public TestSubCategories() {
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
    public void testInsertSubCategory() throws SQLException 
    {
        
        String name = "TEST" + System.currentTimeMillis();
        int id = 0;
        
        SubCategoryDAOImpl dao = new SubCategoryDAOImpl();
       
        Subcategory sub = new Subcategory();
        sub.setId(id);
        sub.setName(name);
       
        Category catRtr = null; 
         
        try 
        {
            dao.addSubcategory(sub);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        } 
        finally 
        {
            if (catRtr != null) 
            {
                dao.deleteSubcategory(catRtr.getId());
            }
        }
    }
}