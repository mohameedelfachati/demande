package com.cm.demandemisedisposition.domain;

import java.io.File;
import java.util.Date;

public class Voiture {
  private int id;
  private String typeVehicule;
  private String marque;
  private String modele;
  private String usage;
  private String typecarburant;
  private String matricule;
  private String nChassi;
  private int capacite;
  private double puissancefiscal;
  private Date datemiscirculation;
  private Date dateacquisition;
  private String affectationdivision;
  private String affectationService;
  private String beneficiaire;
  private double kilometrage;
  private File pieceJointe;
  private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeVehicule() {
        return typeVehicule;
    }

    public void setTypeVehicule(String typeVehicule) {
        this.typeVehicule = typeVehicule;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public String getTypecarburant() {
        return typecarburant;
    }

    public void setTypecarburant(String typecarburant) {
        this.typecarburant = typecarburant;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getnChassi() {
        return nChassi;
    }

    public void setnChassi(String nChassi) {
        this.nChassi = nChassi;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public double getPuissancefiscal() {
        return puissancefiscal;
    }

    public void setPuissancefiscal(double puissancefiscal) {
        this.puissancefiscal = puissancefiscal;
    }

    public Date getDatemiscirculation() {
        return datemiscirculation;
    }

    public void setDatemiscirculation(Date datemiscirculation) {
        this.datemiscirculation = datemiscirculation;
    }

    public Date getDateacquisition() {
        return dateacquisition;
    }

    public void setDateacquisition(Date dateacquisition) {
        this.dateacquisition = dateacquisition;
    }

    public String getAffectationdivision() {
        return affectationdivision;
    }

    public void setAffectationdivision(String affectationdivision) {
        this.affectationdivision = affectationdivision;
    }

    public String getAffectationService() {
        return affectationService;
    }

    public void setAffectationService(String affectationService) {
        this.affectationService = affectationService;
    }

    public String getBeneficiaire() {
        return beneficiaire;
    }

    public void setBeneficiaire(String beneficiaire) {
        this.beneficiaire = beneficiaire;
    }

    public double getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(double kilometrage) {
        this.kilometrage = kilometrage;
    }

    public File getPieceJointe() {
        return pieceJointe;
    }

    public void setPieceJointe(File pieceJointe) {
        this.pieceJointe = pieceJointe;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
