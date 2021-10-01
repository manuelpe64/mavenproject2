<%-- 
    Document   : formulario
    Created on : 21/09/2021, 7:44:17 a. m.
    Author     : Ing Juan Manuel
--%>

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
        <form method="post" action="formulario_controlador.jsp">
            
            <div class="mb-3">
                <label for="exampleFormControlInput2" class="form-label">Nombre</label>
                <input type="text" class="form-control" id="txtNombre" name="txtNombre" value="">
            </div>
            
            <div class="mb-3">
                <label for="Producto" class="form-label">Tipo de Identificación</label>
                <select id= "selTipoid" class="form-select" name="selTipoid">
                <option selected disabled value="">Seleccione...</option>
                <option value="Carné diplomatico">Carné diplomatico</option>   
                <option value="Cédula Ciudadania">Cédula Ciudadania</option>
                <option value="Cédula de Extranjería">Cédula de Extranjería</option>
                <option value="NIT">NIT</option>
                <option value="Pasaporte">Pasaporte</option>
                </select>
            </div>
            <div class="mb-3">
                <label for="exampleFormControlInput2" class="form-label">Número de Identificación</label>
                <input type="text" class="form-control" id="txtId" name="txtId" value="">
            </div>
            <div class="mb-3">
                <label for="exampleFormControlInput3" class="form-label">E-mail</label>
                <input type="text" class="form-control" id="txtEmail" name="txtEmail" value="">
            </div>
            <div class="mb-3">
                <label for="exampleFormControlInput4" class="form-label">Dirección</label>
                <input type="text" class="form-control" id="txtDireccion" name="txtDireccion" value="">
            </div>
            
            <label for="inputPassword5" class="form-label">Contraseña</label>
            <input type="password" id="txtcontraseña" class="form-control" name="txtcontraseña" aria-describedby="passwordHelpBlock">
            <div id="passwordHelpBlock" class="form-text">
              Su contraseña debe contener entre 8-20 caracteres de longitud, contener letras y numeros, no debe contener espacios ni caracteres especiales.
            </div>
            
            <label for="inputPassword6" class="form-label">Confirme Contraseña</label>
            <input type="password" id="inputPassword6" class="form-control" aria-describedby="passwordHelpBlock">
            <div id="passwordHelpBlock" class="form-text">
              
            </div>
            
            <div class="mb-3">
                <label for="Producto" class="form-label">Producto a solicitar</label>
                <select id="selTipoproducto" class="form-select" name="selTipoproducto">
                <option selected disabled value="">Seleccione...</option>
                <option value="Producto 1">Producto 1</option>   
                <option value="Producto 2">Producto 2</option>   
                </select>
            </div>
            
            <div class="form-check">
                <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                <label class="form-check-label" for="flexCheckDefault">
                  Acepto terminos y condiciones
                </label>
            </div>
            
            <button type="submit" class="btn btn-primary" id="btnSubmit" name="btnSubmit" value="nuevo" >Solicitar</button>
            <button type="submit" class="btn btn-secondary">Cancelar</button>
        </form>
        </div>
    </body>
</html>
