/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;


public class Usuario {

    
    private String nombre;
    private String tipoid;
    private int identificacion;
    private int id;
    private String email;
    private String direccion;
    private String contraseña;
    private String producto;

    public Usuario() {
        this.nombre = "";
        this.id = 0;
        this.identificacion = 0;
        this.email = "";
        this.tipoid = "";
        this.direccion = "";
        this.producto = "";
        this.contraseña = "";
    }
         
    public Usuario(String nombre, String tipoid, int identificacion, String email, String direccion, String contraseña, String producto) {
        
        this.id=0;
        this.nombre = nombre;
        this.tipoid = tipoid;
        this.identificacion = identificacion;
        this.email = email;
        this.direccion = direccion;
        this.contraseña = contraseña;
        this.producto = producto;
    }
            
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }
    
    public String getTipoid() {
        return tipoid;
    }

    public void setTipoid(String tipoid) {
        this.tipoid = tipoid;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    public String toString(){
        String mensaje = "Nombre del Usuario: " + this.nombre;
        return mensaje;
         }    
}
