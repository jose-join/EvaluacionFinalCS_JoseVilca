/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.agenda1.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(catalog = "javafx", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "Persona.seleccionaTodos", query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Persona.seleccionaPorId", query = "SELECT p FROM Persona p WHERE p.PersonaId = :PersonaId")})
public class persona implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "personaId", nullable = false)    
    private Integer personaId;
    
    @Column(name = "Nombre", length = 30)
    private String firstName;
    @Column(name = "apellido", length = 30)
    private String lastName;
    @Column(name = "calle", length = 30)
    private String street;
    @Column(name = "codigoPostal", length = 30)
    private String postalCode;
    @Column(name = "ciudad", length = 30)
    private String city;
    @Column(name = "cumpleaños", length = 30)
    private LocalDate birthday;

    public persona() {
        this(null,null);
    }

     
    public persona(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        
        this.postalCode = "123";
        this.street = "jiron28";
        this.city = "cusco";
        this.birthday = LocalDate.of(1999, 2, 21);
    }    
    
    
    public Integer getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Integer personaId) {
        this.personaId = personaId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
    
    
    // Propiedades de JavaFX para su uso en JavaFX UI
    public IntegerProperty personaIdProperty() {
        if (personaId != null) {
            return new SimpleIntegerProperty(personaId.intValue());
        } else {
            return new SimpleIntegerProperty(0); 
        }
    }
    public StringProperty firstNameProperty() {
        return new SimpleStringProperty(firstName);
    }
    public StringProperty lastNameaProperty() {
        return new SimpleStringProperty(lastName);
    }
    public StringProperty streetProperty() {
        return new SimpleStringProperty(street);
    }
    public StringProperty postalCodeProperty() {
        return new SimpleStringProperty(postalCode);
    }
    public StringProperty cityProperty() {
        return new SimpleStringProperty(city);
    }
    public ObjectProperty<LocalDate> birthdayProperty() {
        return new SimpleObjectProperty<>(birthday);
    }
       
    
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personaId != null ? personaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof persona)) {
            return false;
        }
        persona other = (persona) object;
        if ((this.personaId == null && other.personaId != null) || (this.personaId != null && !this.personaId.equals(other.personaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.agendafx.modelo.persona[ id=" + personaId + " ]";
    }

}
