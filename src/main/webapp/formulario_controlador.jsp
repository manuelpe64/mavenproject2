<%-- 
    Document   : formulario_controlador
    Created on : 28/09/2021, 7:59:00 p. m.
    Author     : Ing Juan Manuel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String nombre = request.getParameter("txtNombre");
            String tipoid = request.getParameter("selTipoid");
            String id = request.getParameter("txtId");
            out.println("Id: "+id+" - Nombre"+nombre+" - Tipo: "+tipoid);
            
            
        %>
    </body>
</html>
