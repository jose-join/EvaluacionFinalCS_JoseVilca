/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.agenda1.Controlador;

import com.mycompany.agenda1.modelo.persona;
import com.mycompany.agenda1.modelo.persona;
import java.time.LocalDate;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author estudiante
 */
public class personaControladorJPA {
    
    private ObservableList<persona> datoPersona = FXCollections.observableArrayList();
    private EntityManagerFactory emf;
    
    private ObservableList<persona> personData = FXCollections.observableArrayList();
    
    public personaControladorJPA() {
        this.emf = Persistence.createEntityManagerFactory("BaseDatos");
    }
    
    public ObservableList<persona> getDatoPersona() {
        return personData;
    }
    public ObservableList<persona> cargarPersona() {
        ObservableList<persona> datoPersona = FXCollections.observableArrayList();
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<persona> query = em.createQuery("SELECT p FROM Persona p", persona.class);
            List<persona> persona = query.getResultList();

            // Agregar los estudiantes a la lista observable
            datoPersona.addAll(persona);

            return datoPersona;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

        return datoPersona;
    }
    public void insertaPersona(persona pesona) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();
            em.persist(pesona);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    } 
    
}
