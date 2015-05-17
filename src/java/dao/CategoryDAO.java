/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Category;

/**
 *
 * @author VolkanOzkan
 */
public interface CategoryDAO 
{
    
    public void addCategory(Category category);
    
    public void editCategory(Category category);
    
    public void deleteCategory(int name);
   
    public Category getCategory(int id);
   
    public List getAllCategories();
    

}

