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
}
