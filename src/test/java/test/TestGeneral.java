/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import logica.Usuario;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import persistencia.ConexionBD;
import persistencia.UsuarioDAO;

/**
 *
 * @author Ing Juan Manuel
 */
public class TestGeneral {
    
    @Test
    
    public void verificarConexion(){
        ConexionBD con = new ConexionBD();
        Assert.assertTrue(con.isConectado(), "No hay conexión creada. ");
        con.desconectar();
        Assert.assertFalse(con.isConectado(),"No se cerró conexión. ");
    }
    @Ignore
    public void verificarInsercionUsuario() {
        UsuarioDAO dao = new UsuarioDAO();
        Usuario j = new Usuario("Usuario de prueba", "cc", 0, "email", "direccion", "contraseña", "producto");
        int id = dao.guardarNuevoUsuario(j);
        Assert.assertTrue(id > 0, "No se guardó dato de un usuario. ");
        String sql = "DELETE FROM usuarios WHERE id = " + id;
        ConexionBD con = new ConexionBD();
        int cant = con.ejecutarUpdate(sql);
        Assert.assertTrue(cant == 1, "No se logró hacer limpieza del dato de prueba de un usuario ingresado. ");
        con.desconectar();
    }
    /*@Test
    public void verificarCargaJugutes(){
        UsuarioDAO dao = new UsuarioDAO();
        Assert.assertTrue(dao.consultarUsuario().size()>0, "No se cargaron datos. ");
    }*/
    
}
