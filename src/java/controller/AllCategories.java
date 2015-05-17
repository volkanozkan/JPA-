/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import dao.CategoryDAOImpl;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;


/**
 *
 * @author VolkanOzkan
 */
@WebServlet(name = "AllCategories", urlPatterns = {"/AllCategories"})
public class AllCategories extends HttpServlet {
    
   @EJB private CategoryDAOImpl categoryDAO;
   private Logger logger = Logger.getRootLogger();
    
    
   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        List list = categoryDAO.getAllCategories();
        request.setAttribute("list", list);
        request.getRequestDispatcher("allcategories.jsp").forward(request, response);
        
        logger.debug("Categories are listed..");
        
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
