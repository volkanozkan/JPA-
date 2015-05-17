/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProductDAOImpl;
import dao.SubCategoryDAOImpl;
import dao.SupplierDAOImpl;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product;
import model.Subcategory;
import model.Supplier;
import org.apache.log4j.Logger;

/**
 *
 * @author VolkanOzkan
 */
@WebServlet(name = "ProductServlet", urlPatterns = {"/ProductServlet"})
public class ProductServlet extends HttpServlet {

    @EJB private ProductDAOImpl productDAO;
    @EJB private SupplierDAOImpl supplierDAO;
    @EJB private SubCategoryDAOImpl subCategoryDAO;
    private Logger logger = Logger.getRootLogger();

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
   {
        String proid = request.getParameter("id");
        int id = Integer.valueOf(proid);
        
        String barcod = request.getParameter("barcode");
       
        
        String name = request.getParameter("name");
        
        
        String quantity = request.getParameter("quantity");
        int quantit = Integer.valueOf(quantity);
        
        String price = request.getParameter("price");
        Double pricee = Double.valueOf(price);
        
        
        String attributes = request.getParameter("attributes");
        
        
        String ctgId = request.getParameter("catid");
        int catid = Integer.parseInt(ctgId);
        
        String sup = request.getParameter("supid");
        int supid = Integer.parseInt(sup);
       
        
        String operation = request.getParameter("operation");
        
        Subcategory subcategory = subCategoryDAO.getSubcategory(catid);
        Supplier supplier = supplierDAO.getSupplier(supid);
        
        Product product = new Product(barcod, name, quantit, pricee, attributes, supplier, subcategory);
        product.setBarcode(barcod);
        product.setName(name);
        product.setQuantity(quantit);
        product.setPrice(pricee);
        product.setAttributes(attributes);
        product.setSupplierid(supplier);
        product.setSubcategoryid(subcategory);
        
       if (operation.equalsIgnoreCase("Add")) 
        {
            productDAO.addProduct(product);
            request.setAttribute("product", product);
            logger.debug("Product added : " + name + " to " + subcategory);
        } 
        else if (operation.equalsIgnoreCase("Delete")) 
        {
            productDAO.deleteProduct(id);
        } 
        request.getRequestDispatcher("/AllProducts").forward(request, response);
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
