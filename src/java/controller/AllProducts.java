/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Singleton.SingletonObject;
import dao.ProductDAOImpl;
import factoryCurrency.Currency;
import factoryCurrency.CurrencyFactory;
import java.io.IOException;
import java.util.LinkedList;
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
@WebServlet(name = "AllProducts", urlPatterns = {"/AllProducts"})
public class AllProducts extends HttpServlet 
{
    
    @EJB private ProductDAOImpl productDAO;
    private Logger logger = Logger.getRootLogger();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        
        //Get object 
         SingletonObject object = SingletonObject.getInstance();
         //show the message
         object.showMessage();
        
        
        
        List list = productDAO.getAllProducts();
        request.setAttribute("list", list);
        
        if(request.getParameter("currency") != null)
        {
            String country = request.getParameter("currency");
            Currency currency = CurrencyFactory.createCurrency(country);
            String symbol = currency.getSymbol();
            List list2 = new LinkedList();
            list2.add(symbol);
            request.setAttribute("list2", list2);
            
        }
        else
        {
            String country = "Turkey" ;
            Currency currency = CurrencyFactory.createCurrency(country);
            String symbol = currency.getSymbol();
            List list2 = new LinkedList();
            list2.add(symbol);
            request.setAttribute("list2", list2);
        }
        request.getRequestDispatcher("allproducts.jsp").forward(request, response);
        logger.debug("Products are listed..");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
