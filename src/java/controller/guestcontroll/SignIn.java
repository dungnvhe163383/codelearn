/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.guestcontroll;

import dao.*;
import entity.*;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author okanh
 */
public class SignIn extends HttpServlet {

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
        String user=request.getParameter("username");
        String pass=request.getParameter("password");
        AccountDAO dao= new AccountDAO();
        MentorDAO mentordao=new MentorDAO();
        MenteeDAO menteedao= new MenteeDAO();
        Account acc=dao.getAccount(user, pass);
       
        if(acc==null){
            request.setAttribute("error", "wrong username or password");
            request.getRequestDispatcher("SignIn.jsp").forward(request, response);
        }else {
            int role = dao.checkrole(acc.getId());
            if (role == 2) {
                Mentor mentor = mentordao.getMentorbyAccID(acc.getId());
                request.getSession().setAttribute("getmentor", mentor);
            }
            if (role == 1) {
                Mentee mentee = menteedao.getMenteebyAccID(acc.getId());
                List<Mentor> list=mentordao.getAllMentor();
                List<Skill> listskill=mentordao.getallskill();
                request.getSession().setAttribute("getmentee", mentee);
                request.getSession().setAttribute("listallmentor", list);
                request.getSession().setAttribute("listallskill", listskill);
            }

            request.getSession().setAttribute("account", acc);
            request.getRequestDispatcher("ViewTop3Mentor").forward(request, response);
            //chuy?n trang ko truy?n data
//            response.sendRedirect("ViewTop3Mentor");
        }
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
