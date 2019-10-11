<%-- 
    Document   : viewCart
    Created on : Oct 10, 2019, 9:24:46 PM
    Author     : Thanh Tran
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% ArrayList<String> listOfItems = (ArrayList<String>)session.getAttribute("listOfItems"); %>
        <% String item = (String)session.getAttribute("item"); %>
        
        <h1> You successfully added <%= item %> </h1>
        <h1>Items in Cart</h1>
        <ul>
            <% for (String listOfItem: listOfItems){ %>
                <li><%= listOfItem %></li>
            <% } %>
        </ul>
        
        <a href ="index.html">Back to Index</a>;
    </body>
</html>
