/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import persistencia.UsuarioDAO;

/**
 *
 * @author Ing Juan Manuel
 */
public class ColeccionUsuarios {
    
    private ArrayList<Usuario> lista;
    
    public ArrayList<Usuario> getLista(){
        return lista;
    }
    
    public boolean cargarUsuarios(){
        UsuarioDAO dao = new UsuarioDAO();
        lista = dao.consultarUsuario();
        if (lista.size()>0){
            return true;
            
        }
        else {
            return false;
        }
    }
    
    public boolean guardarUsuario(Usuario j) {
        UsuarioDAO dao = new UsuarioDAO();
        if (j.getId() == 0) {
            int id = dao.guardarNuevoUsuario(j);
            if (id > 0) {
                return true;
            } else {
                return false;
            }
        }
        else {
            int filas = dao.guardarUsuarioExistente(j);
            if (filas == 1) {
                return true;
            } else {
                return false;
            }
        }
    }  
}
