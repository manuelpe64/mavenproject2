<%-- 
    Document   : usuarios_lista
    Created on : 5/10/2021, 7:05:10 p. m.
    Author     : Ing Juan Manuel
--%>

<%@page import="logica.Usuario"%>
<%@page import="logica.LogicaUsuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <title>Lista de usuarios</title>
    </head>
    <body>
     <div class="container mt-5"> 
            <h3 class="mb-3">Lista de usuarios</h3>
            <hr>
            <%
                String filtro = (request.getParameter("txtFiltro") == null) ? "" : request.getParameter("txtFiltro");
            %>
            <div class="row">
                <form method="GET" class="col-sm-10">
                    <div class="row mb-3">
                        <label for="txt1" class="col-form-label col-sm-2">Filtrar</label>
                        <input type="text" class="col-form-control col-sm-9" id="txtFiltro" name="txtFiltro" value="<%= filtro %>" placeholder="por nombre, tipo ID, producto o ID">
                        <button type="submit" class="btn btn-light col-sm-1"><i class="bi bi-search"></i></button>                    
                    </div>
                </form>
                <a href="formulario.jsp?accion=nuevo" class="col-sm-2"><button type="submit" class="btn btn-primary" id="btnNuevo">Nuevo usuario</button></a>
            </div>
            <form>
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">Id</th>
                            <th scope="col">Nombre</th>
                            <th scope="col">Tipo</th>
                            <th scope="col">Numero ID</th>
                            <th scope="col">Direccion</th>
                            <th scope="col">Correo</th>
                            <th scope="col">Producto</th>
                        </tr>
                    </thead>
                    <%
                        LogicaUsuarios logicaUsuarios = new LogicaUsuarios();
                        boolean hayDatos;
                        if (filtro.equals("") ) {
                            hayDatos = logicaUsuarios.cargarTodosLosUsuarios();
                        }
                        else {
                            hayDatos = logicaUsuarios.cargarTodosLosUsuarios();
                        }
                        
                    %>
                    <tbody>
                        <% if (hayDatos) { %>
                        <%  for (Usuario j : logicaUsuarios.getLista()) {%>
                        <tr>
                            <td scope="row"><%= j.getId()%></td>
                            <td><%= j.getNombre()%></td>
                            <td><%= j.getTipoid()%></td>
                            <td><%= j.getIdentificacion()%></td>
                            <%--<td><%= logicaUsuarios.getTipoUsuario(j.getIdentificacion()) %></td>
                            <td><%= logicaUsuarios.getEstadoUsuario(j.getIdentificacion()) %></td>--%>
                            <td><%= j.getDireccion() %></td>
                            <td><%= j.getEmail()%></td>
                            <td><%= j.getProducto()%></td>
                            <td>
                                <a href="formulario.jsp?accion=editar&id=<%= j.getId() %>"><button type="button" class="btn btn-success"><i class="bi bi-pencil-fill"></i></button></a>
                                <a href="eliminar_usuario.jsp"><button type="button" class="btn btn-danger"><i class="bi bi-trash"></i></button></a>
                            </td>
                        </tr>
                        <% } %>
                        <% } else { %>
                        <tr>
                            <td colspan="5">No hay datos</td>
                        </tr>
                        <% }%>
                    </tbody>
                </table>
            </form>
        </div>
    </body>
</html>
