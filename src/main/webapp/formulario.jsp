<%-- 
    Document   : formulario
    Created on : 21/09/2021, 7:44:17 a. m.
    Author     : Ing Juan Manuel
--%>

<%@page import="logica.LogicaUsuarios"%>
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
        <h1 class="mb-3">Formulario Solicitud de Producto</h1>
        <hr>
          <%
                String accion = request.getParameter("accion");
                int id;
                String nombre = "";
                String idTipo = "Seleccione...";
                int idnumero = 0;
                String email = "";
                String direccion = "";
                String contraseña = "";
                String producto = "Seleccione...";
                
                
                if (accion.equals("editar")) {
                    id = Integer.parseInt(request.getParameter("id"));
                    LogicaUsuarios logicaUsuarios = new LogicaUsuarios();
                    Usuario j = logicaUsuarios.cargarUnUsuario(id);
                    nombre = j.getNombre();
                    idTipo = j.getTipoid();
                    idnumero = j.getIdentificacion();
                    email = j.getEmail();
                    direccion = j.getDireccion();
                    contraseña = j.getContraseña();
                    producto = j.getProducto();
                                      
                    
                }
                else {
                    id = 0;
                }
            %>
        <form method="post" action="formulario_controlador.jsp" class="needs-validation" novalidate>
            
            <div class="mb-3">
                <label for="exampleFormControlInput0" class="form-label">Id</label>
                <input type="text" class="form-control" id="txtIdBD" name="txtIdBD" value="<%= id %>" readonly>
            </div>        
            
            <div class="mb-3">
                <label for="exampleFormControlInput2" class="form-label">Nombre</label>
                <input type="text" class="form-control" id="txtNombre" name="txtNombre" value="<%= nombre %>" required>
                <div class="valid-feedback">Ok válido</div>
                <div class="invalid-feedback">Complete el campo</div>
            </div>
            
            <div class="mb-3">
                <label for="Producto" class="form-label">Tipo de Identificación</label>
                <select id= "selTipoid" class="form-select" name="selTipoid" required>
                <option selected value="<%= idTipo %>"><%= idTipo %></option>
                <option value="Carné diplomatico">Carné diplomatico</option>   
                <option value="Cédula Ciudadania">Cédula Ciudadania</option>
                <option value="Cédula de Extranjería">Cédula de Extranjería</option>
                <option value="NIT">NIT</option>
                <option value="Pasaporte">Pasaporte</option>
                </select>
            </div>
            <div class="mb-3">
                <label for="exampleFormControlInput2" class="form-label">Número de Identificación</label>
                <input type="text" class="form-control" id="txtId" name="txtId" value="<%= idnumero %>">
            </div>
            <div class="mb-3">
                <label for="exampleFormControlInput3" class="form-label">E-mail</label>
                <input type="text" class="form-control" id="txtEmail" name="txtEmail" value="<%= email %>">
            </div>
            <div class="mb-3">
                <label for="exampleFormControlInput4" class="form-label">Dirección</label>
                <input type="text" class="form-control" id="txtDireccion" name="txtDireccion" value="<%= direccion %>">
            </div>
            
            <label for="inputPassword5" class="form-label">Contraseña</label>
            <input type="password" id="txtcontraseña" class="form-control" name="txtcontraseña" aria-describedby="passwordHelpBlock" value="<%= contraseña %>">
            <div id="passwordHelpBlock" class="form-text">
              Su contraseña debe contener entre 8-20 caracteres de longitud, contener letras y numeros, no debe contener espacios ni caracteres especiales.
            </div>
            
            <label for="inputPassword6" class="form-label">Confirme Contraseña</label>
            <input type="password" id="inputPassword6" class="form-control" aria-describedby="passwordHelpBlock" value="<%= contraseña %>">
            <div id="passwordHelpBlock" class="form-text">
              
            </div>
            
            <div class="mb-3">
                <label for="Producto" class="form-label">Producto a solicitar</label>
                <select id="selTipoproducto" class="form-select" name="selTipoproducto">
                <option selected value="<%= producto %>"><%= producto %></option>
                <option value="Producto 1">Producto 1</option>   
                <option value="Producto 2">Producto 2</option>   
                </select>
            </div>
            
            <div class="form-check">
                <input class="form-check-input" type="checkbox" value="checked" id="flexCheckDefault" required>
                <label class="form-check-label" for="flexCheckDefault">
                  Acepto terminos y condiciones
                </label>
                 <div class="invalid-feedback">
                    You must agree before submitting.
                 </div>
            </div>
            
            <button type="submit" class="btn btn-primary" id="btnSubmit" name="btnSubmit" value="<%= accion %>" >Solicitar</button>
            
            
        </form>
            <a href="usuarios_lista.jsp" class="col-sm-2"><button type="submit" class="btn btn-secundary" id="btnNuevo">Cancelar</button></a>
        </div>
    </body>
</html>
