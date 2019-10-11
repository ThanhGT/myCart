/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thanhtran.mycart.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Thanh Tran
 */
public class AddToCart extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try (PrintWriter out = response.getWriter()) {

            HttpSession session = request.getSession();
            //get parameters
            String AddToCart = request.getParameter("AddToCart");
            String DeleteCart = request.getParameter("DeleteCart");
            String ViewCart = request.getParameter("ViewCart");

            // create an array list of strings
            ArrayList<String> listOfItems
                    = (ArrayList<String>) session.getAttribute("listOfItems");

            if (AddToCart != null) {
                // initialize the arrayList to null first
                if (listOfItems == null) {
                    listOfItems = new ArrayList<>();
                }
                
                // get parameter item
                String item = request.getParameter("item");

                // add item to arrayList
                listOfItems.add(item);

                // set the attribute
                session.setAttribute("listOfItems", listOfItems);
                session.setAttribute("item", item);
                
                String format = null;
                format = "You successfully added %s";
                out.print(String.format(format, item));
                
                RequestDispatcher rd = request.getRequestDispatcher("viewCart.jsp");
                rd.forward(request, response);
            }

            if (ViewCart != null) {

                RequestDispatcher rd = request.getRequestDispatcher("viewCart.jsp");
                rd.forward(request, response);

            } else if (DeleteCart != null) {
                RequestDispatcher rd = request.getRequestDispatcher("DeleteCart.do");
                rd.forward(request, response);
            }
        }
    }
}
