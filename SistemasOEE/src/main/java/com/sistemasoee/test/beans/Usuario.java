package com.sistemasoee.test.beans;

import javax.persistence.*;
 
import org.hibernate.validator.constraints.NotEmpty;
 
@Entity
@Table(name = "Usuario")
public class Usuario {
	
	 @Id
     @Column
     @GeneratedValue(strategy=GenerationType.AUTO)
     private int id;
      
     @NotEmpty
     @Column
     private String nombre;
      
     @NotEmpty
     @Column
     private String edad;

     @NotEmpty
     @Column
     private String email;
      
     @NotEmpty
     @Column
     private String contrasena;
      
     public int getId() {
         return id;
     }
     public void setId(int id) {
         this.id = id;
     }
     public String getNombre() {
         return nombre;
     }
     public void setNombre(String nombre) {
         this.nombre = nombre;
     }
     public String getEdad() {
         return edad;
     }
     public void setEdad(String edad) {
         this.edad = edad;
     }
     public String getEmail() {
         return email;
     }
     public void setEmail(String email) {
         this.email = email;
     }
     public String getContrasena() {
         return contrasena;
     }
     public void setContrasena(String contrasena) {
         this.contrasena = contrasena;
     }
}
