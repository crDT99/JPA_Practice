
package com.mycompany.proyectopeluqueriacanina.logica;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;

@Entity
public class Owner implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int id_Owner;
    private String nombre_owner;
    private String cell_owner;

    public Owner() {
    }

    public Owner(int id_Owner, String nombre_owner, String cell_owner) {
        this.id_Owner = id_Owner;
        this.nombre_owner = nombre_owner;
        this.cell_owner = cell_owner;
    }

    public int getId_Owner() {
        return id_Owner;
    }

    public void setId_Owner(int id_Owner) {
        this.id_Owner = id_Owner;
    }

    public String getNombreOwner() {
        return nombre_owner;
    }

    public void setNombreOwner(String nombre_owner) {
        this.nombre_owner = nombre_owner;
    }

    public String getCelOwner() {
        return cell_owner;
    }

    public void setCelOwner(String cell_owner) {
        this.cell_owner = cell_owner;
    }
    
    
    
    
    
}
