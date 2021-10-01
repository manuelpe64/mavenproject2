/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import org.testng.Assert;
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
    
    /*@Test
    public void verificarCargaJugutes(){
        UsuarioDAO dao = new UsuarioDAO();
        Assert.assertTrue(dao.consultarUsuario().size()>0, "No se cargaron datos. ");
    }*/
    
}
