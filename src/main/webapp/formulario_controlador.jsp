<%-- 
    Document   : formulario_controlador
    Created on : 28/09/2021, 7:59:00 p. m.
    Author     : Ing Juan Manuel
--%>

<%@page import="logica.ColeccionUsuarios"%>
<%@page import="logica.Usuario"%>
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
        <h1 class="mb-3">Usuario creado exitosamente</h1>
        <form method="post" action="formulario.jsp" class="needs-validation" novalidate>
        <%
            
            String nombre = request.getParameter("txtNombre");
            String tipoid = request.getParameter("selTipoid");
            int identificacion = Integer.parseInt(request.getParameter("txtId"));
            String email = request.getParameter("txtEmail");
            String direccion = request.getParameter("txtDireccion");
            String contraseña = request.getParameter("txtcontraseña");
            String producto = request.getParameter("selTipoproducto");
            String accion = request.getParameter("btnSubmit");
            Usuario j = null;
            
            /*j = new Usuario(nombre, tipoid, identificacion, email, direccion, contraseña, producto);
            int id=j.getId();
            out.println("Usuario ID ES : "+tipoid);*/
                       
            if (accion.equals("nuevo")) {
                j = new Usuario(nombre, tipoid, identificacion, email, direccion, contraseña, producto);
            }
            
            ColeccionUsuarios logicaUsuarios = new ColeccionUsuarios();
            boolean guardado = logicaUsuarios.guardarUsuario(j);
            if (guardado == true) {
                out.println("Usuario guardado exitosamente, su trámite se encuentra en proceso de solicitud");
            } else {
                out.println("Información de usuario no se guardó.");
            }
            
            
        %>
        
        <button type="submit" class="btn btn-primary" id="btnSubmit" name="btnSubmit" value="nuevo" >Regresar a registro</button>
        </form>
        </div>
        
        </body>
</html>
