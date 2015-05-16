/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.CategoryDAO;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Category;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author VolkanOzkan
 */
@WebServlet(name = "CategoryServlet", urlPatterns = {"/CategoryServlet"})
public class CategoryServlet extends HttpServlet {

    @EJB
    private CategoryDAO categoryDAO;

    private Logger logger = Logger.getRootLogger();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        
        String ctgId = request.getParameter("id");
        int id = Integer.valueOf(ctgId);
       
        String name = request.getParameter("name");
        
        Double tax = 0.0;
        tax = Double.parseDouble(request.getParameter("tax"));
  
        String operation = request.getParameter("operation");

        Category category = new Category(name, tax);
        category.setName(name);
        category.setTax(tax);

        if (operation.equalsIgnoreCase("Add")) 
        {
            categoryDAO.addCategory(category);
            request.setAttribute("category", category);
            logger.debug("Category added : " + name);
        } 
        else if (operation.equalsIgnoreCase("Edit")) 
        {
            category.setId(Integer.parseInt(ctgId));
            try 
            {
                categoryDAO.editCategory(category);
                logger.debug("Category Edited : " + name);
            }
            catch (Exception ex) 
            {
            }
        }
        else if (operation.equalsIgnoreCase("Delete")) 
        {
            categoryDAO.deleteCategory(id);
            logger.debug("Category deleted: " + name);
        } 
        request.getRequestDispatcher("/AllCategories").forward(request, response);
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
