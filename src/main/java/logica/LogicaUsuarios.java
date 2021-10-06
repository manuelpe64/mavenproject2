/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import java.util.TreeMap;
import persistencia.UsuarioDAO;

/**
 *
 * @author Ing Juan Manuel
 */
public class LogicaUsuarios {
    private ArrayList<Usuario> lista;
    
    /**
     * Obtiene una lista de usuarios
     * @return una estructura de datos con los datos de los usuarios requeridos
     */
    public ArrayList<Usuario> getLista() {
        return lista;
    }
    
    /**
     * Obtiene el nombre del tipo de juguete dado el id correspondiente
     * @param key el id del tipo
     * @return el nombre del tipo de juguete
     */
    public String getTipoUsuario(int key) {
        UsuarioDAO dao = new UsuarioDAO();
        TreeMap<Integer, String> listaTiposUsuarios = dao.cargarTiposUsuarios();
        String value = listaTiposUsuarios.get(key);
        return value;
    }
    
    /**
     * Obtiene la lista de los tipos de usuarios
     * @return un treemap con los tipos de usuarios
     */
    public TreeMap<Integer, String> getTiposUsuarios() {
        UsuarioDAO dao = new UsuarioDAO();
        TreeMap<Integer, String> listaTiposUsuarios = dao.cargarTiposUsuarios();
        return listaTiposUsuarios;
    }
    
    /**
     * Obtiene el nombre del estado de juguete dado el id correspondiente
     * @param key el id del estado
     * @return el nombre del estado de juguete
     */
    public String getEstadoUsuario(int key) {
        UsuarioDAO dao = new UsuarioDAO();
        TreeMap<Integer, String> listaEstadosUsuarios = dao.cargarEstadosUsuarios();
        String value = listaEstadosUsuarios.get(key);
        return value;
    }
    
    /**
     * Obtiene la lista de los estados de usuarios
     * @return un treemap con los estados de usuarios
     */
    public TreeMap<Integer, String> getEstadosUsuarios() {
        UsuarioDAO dao = new UsuarioDAO();
        TreeMap<Integer, String> listaEstadosUsuarios = dao.cargarEstadosUsuarios();
        return listaEstadosUsuarios;
    }
    
    /**
     * Carga la información de todos los usuarios de la base de datos
     * @return true si carga los usuarios, o false si no se logró cargar
     */
    public boolean cargarTodosLosUsuarios() {
        UsuarioDAO dao = new UsuarioDAO();
        lista = dao.consultarUsuario();
        if (lista.size() > 0) {
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * Carga la información de ciertos usuarios de la base de datos mediante filtro
     * @return true si carga los usuarios, o false si no se logró cargar
     */
    /*public boolean cargarUsuariosPorFiltro(String filtro) {
        UsuarioDAO dao = new UsuarioDAO();
        lista = dao.consultarUsuariosPorFiltro(filtro);
        if (lista.size() > 0) {
            return true;
        }
        else {
            return false;
        }
    }*/
    
    /**
     * Carga la información de un solo juguete de la base de datos
     * @return true si carga los usuarios, o false si no se logró cargar
     */
    public Usuario cargarUnUsuario(int id) {
        UsuarioDAO dao = new UsuarioDAO();
        Usuario j = dao.consultarUsuarios(id);
        return j;
    }
    
    /**
     * Guarda la información de un juguete capturada desde el formulario
     * @param j un objeto con los datos de un juguete específico
     * @return true si guarda el juguete en la base de datos, o false si no lo guarda
     */
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