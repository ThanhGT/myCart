/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thanhtran.mycart.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Thanh Tran
 */
public class DeleteCart extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        try(PrintWriter out = response.getWriter()){
            HttpSession session = request.getSession();

            String deleteCart = request.getParameter("DeleteCart");

            if (deleteCart != null){

                out.print("<h1>Your cart is Empty</h1>");
                session.invalidate();

            }
            
            out.print("<a href=\"index.html\">Back to Index</a>");
        
        }
    }
}