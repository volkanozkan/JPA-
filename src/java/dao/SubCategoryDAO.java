/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Subcategory;

/**
 *
 * @author VolkanOzkan
 */
public interface SubCategoryDAO
{
    public void addSubcategory(Subcategory subCategory);
    
    public void editSubcategory(Subcategory subCategory);
    
    public void deleteSubcategory(int id);
   
    public Subcategory getSubcategory(int id);
   
    public List getAllSubcategories();
}
