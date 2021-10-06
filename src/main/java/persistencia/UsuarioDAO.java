/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import logica.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeMap;


/**
 *
 * @author Ing Juan Manuel
 */
public class UsuarioDAO {
    
    public ArrayList<Usuario> consultarUsuario(){
        ArrayList<Usuario> lista = new ArrayList<>();
        ConexionBD con = new ConexionBD();
        ResultSet rs = con.ejecutarQuery("SELECT id, nombre, tipoid, identificacion, email, direccion, contraseña, producto, aceptaterminos, activo FROM dbusuarios.usuarios ");
        try{
            while (rs.next()){
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String tipoid = rs.getString("tipoid");
                int identificacion = rs.getInt("identificacion");
                String email = rs.getString("email");
                String direccion = rs.getString("direccion");
                String contraseña = rs.getString("contraseña");
                String producto = rs.getString("producto");
                Usuario j = new Usuario(nombre,tipoid,identificacion,email,direccion,contraseña,producto);
                lista.add(j);
            }
        } catch (SQLException ex) {
            return null;
        }
        return lista;
    }
    
    public int guardarNuevoUsuario(Usuario j) {
        ConexionBD con = new ConexionBD();
        String nombre = j.getNombre();
        String tipoid = j.getTipoid();
        int identificacion = j.getIdentificacion();
        String email = j.getEmail();
        String direccion = j.getDireccion();
        String contraseña = j.getContraseña();
        String producto = j.getProducto();
        
        String sql = "INSERT INTO usuarios (nombre, tipoid,identificacion,email,direccion,contraseña,producto) "+
                     "VALUES ('"+nombre+"', '"+tipoid+"', '"+identificacion+"', '"+email+"', '"+direccion+"', '"+contraseña+"', '"+producto+"') ";
        ResultSet rs = con.ejecutarInsert(sql);
        int id = 0;
        try {
            if (rs.next()){
                id = rs.getInt(1);
            }
        } catch (SQLException ex) {
            con.desconectar();
            return 0; 
        }
        con.desconectar();
        return id;
    }
    public int guardarUsuarioExistente(Usuario j) {
        ConexionBD con = new ConexionBD();
        int id = j.getId();
        String nombre = j.getNombre();
        String tipoid = j.getTipoid();
        int identificacion = j.getIdentificacion();
        String email = j.getEmail();
        String direccion = j.getDireccion();
        String contraseña = j.getContraseña();
        String producto = j.getProducto();
        
        String sql = "UPDATE usuarios "+
                     "SET nombre = '" + nombre + "' , tipoid = " + tipoid + " , identificacion = '" + identificacion + "', email = " + email + ", direccion = '" + direccion + ", contraseña = '" + contraseña + ", producto = '" + producto + "' " + 
                     "WHERE id = " + id + " ";
        int filas = con.ejecutarUpdate(sql);
        con.desconectar();
        return filas;
    }
    public TreeMap<Integer, String> cargarTiposUsuarios() {
        TreeMap<Integer, String> listaTipos = new TreeMap<Integer, String>();
        ConexionBD con = new ConexionBD();
        ResultSet rs = con.ejecutarQuery("SELECT id, tipo FROM tipos_usuarios ");
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String tipo = rs.getString("tipo");
                listaTipos.put(id, tipo);
            }
        } catch (SQLException ex) {
            con.desconectar();
            return null;
        }
        con.desconectar();
        return listaTipos;
    }
    
    /**
     * Cargar los diferentes estados de usuarios desde la BD
     * @return un treemap con la lista de los estados de usuarios
     */
    public TreeMap<Integer, String> cargarEstadosUsuarios() {
        TreeMap<Integer, String> listaEstados = new TreeMap<Integer, String>();
        ConexionBD con = new ConexionBD();
        ResultSet rs = con.ejecutarQuery("SELECT id, estado FROM estados_usuarios ");
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String estado = rs.getString("estado");
                listaEstados.put(id, estado);
            }
        } catch (SQLException ex) {
            con.desconectar();
            return null;
        }
        con.desconectar();
        return listaEstados;
    }
     /*public ArrayList<Usuario> consultarUsuariosPorFiltro(String filtro) {
        ArrayList<Usuario> lista = new ArrayList<>();
        ConexionBD con = new ConexionBD();
        String sql = "SELECT j.id, j.nombre, j.tipousuario_id, t.tipo, j.fechacompra, j.estadousuario_id, e.estado, j.disponibilidad " +
                     "FROM usuarios j " +
                     "JOIN tipos_usuarios t ON (j.tipousuario_id = t.id) " +
                     "JOIN estados_usuarios e ON (j.estadousuario_id = e.id) " +
                     "WHERE j.nombre LIKE '%" + filtro + "%' " +
                     "OR t.tipo LIKE '%" + filtro + "%' " +
                     "OR e.estado LIKE '%" + filtro + "%' " +
                     "OR j.disponibilidad LIKE '%" + filtro + "%' ";
        ResultSet rs = con.ejecutarQuery(sql);
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                int idTipo = rs.getInt("tipousuario_id");
                String fechaCompra = rs.getString("fechacompra");
                int idEstado = rs.getInt("estadousuario_id");
                String disponibilidad = rs.getString("disponibilidad");
                Usuario j = new Usuario(id, nombre, idTipo, fechaCompra, idEstado, disponibilidad);
                lista.add(j);
            }
        } catch (SQLException ex) {
            con.desconectar();
            return null;
        }
        con.desconectar();
        return lista;
    }*/
    /**
     * Envía la sentencia SQL para obtener la información de 1 usuario específico y estructura
     * la respuesta en un objeto de tipo Usuario
     * @param idAConsultar el id del usuario para consultar
     * @return un objeto de tipo Usuario con la información cargada o null
     */
    public Usuario consultarUsuarios(int idAConsultar) {
        Usuario j = null;
        ConexionBD con = new ConexionBD();
        String sql = "SELECT id, nombre, tipoid, identificacion, email, direccion, contraseña, producto, aceptaterminos, activo " +
                     "FROM usuarios "+
                     "WHERE id = " + idAConsultar + " ";
        ResultSet rs = con.ejecutarQuery(sql);
        try {
            if (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String tipoid = rs.getString("tipoid");
                int identificacion = rs.getInt("identificacion");
                String email = rs.getString("email");
                String direccion = rs.getString("direccion");
                String contraseña = rs.getString("contraseña");
                String producto = rs.getString("producto");
                String disponibilidad = rs.getString("disponibilidad");
                j = new Usuario(nombre, tipoid, identificacion, email, direccion, contraseña, producto);
            }
        } catch (SQLException ex) {
            con.desconectar();
            return j;
        }
        con.desconectar();
        return j;
    }
}
