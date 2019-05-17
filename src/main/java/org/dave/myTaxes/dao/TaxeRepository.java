package org.dave.myTaxes.dao;

import java.util.List;

import org.dave.myTaxes.entities.Entreprise;
import org.dave.myTaxes.entities.TVA;
import org.dave.myTaxes.entities.Taxe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxeRepository extends JpaRepository<Taxe, Long> {
 public List<Taxe> findByEntreprise(Entreprise e);

}
