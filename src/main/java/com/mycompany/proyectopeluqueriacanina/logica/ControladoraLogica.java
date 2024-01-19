package com.mycompany.proyectopeluqueriacanina.logica;

import com.mycompany.proyectopeluqueriacanina.persistencia.ControladoraPersistencia;
import java.util.List;

/**
 *
 * @author crDT
 */
public class ControladoraLogica {
    
    // instancia de la controladora de persistencia
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void guardar(String nombreM, String razaM, String colorM, String observaciones, String alergico, String atEspecial, String nombreD, String cellD) {
        
        //Creamos el dueño y asignamos sus valores
        Owner mOwner = new Owner();
        mOwner.setNombreOwner(nombreD);
        mOwner.setCelOwner(cellD);
        
        //Creamos la mascota y asignamos sus valores
        Mascota mascota = new Mascota();
        mascota.setNombre(nombreM);
        mascota.setRaza(razaM);
        mascota.setColor(colorM);
        mascota.setAlergico(alergico);
        mascota.setAtencion_especial(atEspecial);
        mascota.setObservaciones(observaciones);
        
        // asignamos el dueño a la mascota
        mascota.setPetOwner(mOwner);
        
        controlPersis.guardar(mOwner,mascota);
    }

    public List<Mascota> traerMascotas() {
        
        return controlPersis.traerMascotas();
    }

    public void borrarMascota(int num_Cliente) {
        controlPersis.borrarMascota(num_Cliente);
    }

    public void editarMascota(int num_Cliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Mascota traerMascota(int num_Cliente) {
        return controlPersis.traerMascota(num_Cliente);
    }

    public void modificarRegistro(Mascota mPet, String nombreM, String razaM, String colorM, String observaciones, String alergico, String atEspecial,
            String nombreD, String cellD) {
        
        //------------Gestion de la Mascota ---------- 
        
        //Cargo los datos de mascota
        mPet.setNombre(nombreM);
        mPet.setRaza(razaM);
        mPet.setColor(colorM);
        mPet.setObservaciones(observaciones);
        mPet.setAlergico(alergico);
        mPet.setAtencion_especial(atEspecial);
        
        // modifico Mascota
        controlPersis.modificarMascota(mPet);
        
        //------------Gestion del Owner ---------- 
        
        //Traigo al owner original
        Owner mOwner = this.buscarOwner(mPet.getPetOwner().getId_Owner());
        
        // le cargo los nuevos datos
        mOwner.setNombreOwner(nombreD);
        mOwner.setCelOwner(cellD);
        
        //llamar al modificador de Owner
        this.modificarOwner(mOwner);
        
        
    }

    private Owner buscarOwner(int id_Owner) {
        return controlPersis.traerOwner(id_Owner);
    }

    private void modificarOwner(Owner mOwner) {
        controlPersis.modificarOwner(mOwner);
    }
    
    
}
