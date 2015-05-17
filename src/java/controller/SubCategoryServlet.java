/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CategoryDAOImpl;
import dao.SubCategoryDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ejb.EJB;
import model.Subcategory;
import model.Category;
import org.apache.log4j.Logger;

/**
 *
 * @author VolkanOzkan
 */
@WebServlet(name = "SubCategoryServlet", urlPatterns = {"/SubCategoryServlet"})
public class SubCategoryServlet extends HttpServlet {

    @EJB private SubCategoryDAOImpl subCategoryDAO;
     
    @EJB private CategoryDAOImpl categoryDAO;
    
    private Logger logger = Logger.getRootLogger();


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String subCtgId = request.getParameter("id");
        int id = Integer.valueOf(subCtgId);
       
        String name = request.getParameter("name");
        
        String description = request.getParameter("description");
        
        String ctgId = request.getParameter("catid");
        int catid = Integer.parseInt(ctgId);
        
        String operation = request.getParameter("operation");
        
        Category category = categoryDAO.getCategory(catid);
        
        Subcategory subcategory = new Subcategory(name, description);
        subcategory.setName(name);
        subcategory.setDescription(description);
        subcategory.setCategoryid(category);

       if (operation.equalsIgnoreCase("Add")) 
        {
            subCategoryDAO.addSubcategory(subcategory);
            request.setAttribute("subcategory", subcategory);
            logger.debug("SubCategory added : " + name);

        } 
        else if (operation.equalsIgnoreCase("Edit")) 
        {
            subcategory.setId(Integer.parseInt(subCtgId));
            try 
            {
                subCategoryDAO.editSubcategory(subcategory);
                logger.debug("SubCategory edited : " + name);
            }
            catch (Exception ex) 
            {
            }
        }
        else if (operation.equalsIgnoreCase("Delete")) 
        {
            subCategoryDAO.deleteSubcategory(id);
            logger.debug("SubCategory deleted : " + name);

        } 
        request.getRequestDispatcher("/AllSubCategories").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
