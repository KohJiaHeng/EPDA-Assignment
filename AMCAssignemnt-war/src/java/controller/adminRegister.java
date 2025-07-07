/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Manager;
import model.ManagerFacade;
import model.UserAccount;

/**
 *
 * @author kohji
 */
@WebServlet(name = "adminRegister", urlPatterns = {"/adminRegister"})
public class adminRegister extends HttpServlet {
   @EJB
    private ManagerFacade managerFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String name = request.getParameter("x");
            String password = request.getParameter("y");
            String role = request.getParameter("z"); 

            Manager a = new Manager(name, password, role);
            managerFacade.create(a);

            System.out.println("Manager created: " + name);
            response.sendRedirect("loginPage.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        processRequest(request, response);
    }
}