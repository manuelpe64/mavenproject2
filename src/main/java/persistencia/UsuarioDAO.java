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
                Usuario j = new Usuario(id,nombre,tipoid,identificacion,email,direccion,contraseña,producto);
                lista.add(j);
            }
        } catch (SQLException ex) {
            return null;
        }
        return lista;
    }
        
}
