package org.dave.myTaxes.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Collection;

@Entity
public class Entreprise implements Serializable {
    @Id @GeneratedValue
    private Long code;
    @NotNull
    @Size(min=2,max=20)
    private String nom;
    @NotNull
    @Size(min=2,max=23)
    private String email;
    @NotNull
    @Size(min=2,max=40)
    private String raisonSociale;
    @OneToMany(mappedBy = "entreprise",fetch = FetchType.LAZY)
    private Collection<Taxe> taxes;

    public Entreprise() {
    }

    public Entreprise(String nom, String email, String raisonSociale) {
        this.nom = nom;
        this.email = email;
        this.raisonSociale = raisonSociale;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }
    @JsonIgnore
    public Collection<Taxe> getTaxes() {
        return taxes;
    }

    public void setTaxes(Collection<Taxe> taxes) {
        this.taxes = taxes;
    }
}
