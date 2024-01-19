package com.mycompany.proyectopeluqueriacanina.persistencia;

import com.mycompany.proyectopeluqueriacanina.logica.Mascota;
import com.mycompany.proyectopeluqueriacanina.logica.Owner;
import com.mycompany.proyectopeluqueriacanina.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author crDT
 */
public class ControladoraPersistencia {
    
    // instancias a los JpaControlers de las clases entidad:
    MascotaJpaController mascotaJpa = new MascotaJpaController();
    OwnerJpaController ownerJpa = new OwnerJpaController();

    public void guardar(Owner mOwner, Mascota mascota) {
        
        // crear en la BD el dueño
        ownerJpa.create(mOwner);
        
        // crear en la BD la mascota
        mascotaJpa.create(mascota);
        
    }

    public List<Mascota> traerMascotas() {
        return mascotaJpa.findMascotaEntities();

    }

    public void borrarMascota(int num_Cliente) {
        try {
            mascotaJpa.destroy(num_Cliente);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Mascota traerMascota(int num_Cliente) {
        return mascotaJpa.findMascota(num_Cliente);
    }

    public void modificarMascota(Mascota mPet) {
        try {
            mascotaJpa.edit(mPet);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Owner traerOwner(int id_Owner) {
        return ownerJpa.findOwner(id_Owner);
    }

    public void modificarOwner(Owner mOwner) {
        try {
            ownerJpa.edit(mOwner);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
    