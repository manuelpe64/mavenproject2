<%-- 
    Document   : eliminar_usuario
    Created on : 8/10/2021, 11:41:51 a. m.
    Author     : Ing Juan Manuel
--%>

<%@page import="persistencia.ConexionBD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>

        <div class="container mt-5">
        <h1 class="mb-3">Usuario Eliminado</h1>
        <form method="post" action="usuarios_lista.jsp">
            <%
              
                int idDB = Integer.parseInt(request.getParameter("idDB"));
                out.println("Id Usuario eliminado "+ idDB);
                ConexionBD con = new ConexionBD();
                        String sql = "UPDATE usuarios "+
                                     "SET activo = 0 " + 
                                     "WHERE id = '"+idDB+"' ";
                        int filas = con.ejecutarUpdate(sql);
                        con.desconectar();
  
            %>
        <button type="submit" class="btn btn-primary" id="btnSubmit" name="btnSubmit" value="nuevo" >Regresar a la lista</button>
        </form>    
        </div>
    </body>
</html>
