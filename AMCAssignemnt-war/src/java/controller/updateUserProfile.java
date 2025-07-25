/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Customer;
import model.CustomerFacade;
import model.UserAccount;
import model.UserAccountFacade;

/**
 *
 * @author kohji
 */
@WebServlet(name = "updateUserProfile", urlPatterns = {"/updateUserProfile"})
public class updateUserProfile extends HttpServlet {

    @EJB
    private UserAccountFacade userAccountFacade;

    @EJB
    private CustomerFacade customerFacade;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            // Get form values
            String cusName = request.getParameter("cusName");
            String cusID = request.getParameter("cusID");
            String username = request.getParameter("cusUsername");
        
            // Find customer by ID
            Customer customer = customerFacade.find(cusID);

            if (customer != null) {
                // Update the name
                customer.setCusName(cusName);
                customerFacade.edit(customer);

                // Update session if needed
                request.getSession().setAttribute("customer", customer);
            }

            // === Update UserAccount ===
            UserAccount user = userAccountFacade.findByUsername(username); // assumes same ID is used for both
            if (user != null) {
                if (username != null && !username.isEmpty()) {
                    user.setUsername(cusName);
                }
                userAccountFacade.edit(user);
            }

            // Refresh updated data
            List<Customer> result = customerFacade.findByCusName(customer.getCusName());
            request.setAttribute("customerList", result);

            // Forward back to JSP
            request.getRequestDispatcher("customerPage.jsp").forward(request, response);
        }
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
