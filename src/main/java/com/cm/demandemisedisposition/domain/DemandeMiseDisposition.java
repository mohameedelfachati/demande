package com.cm.demandemisedisposition.domain;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DemandeMiseDisposition.
 */
@Entity
@Table(name = "demande_mise_disposition")
public class DemandeMiseDisposition implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "matricule")
    private String matricule;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name = "datedemande")
    private LocalDate datedemande;

    @Column(name = "datedebutmisedisposition")
    private LocalDate datedebutmisedisposition;

    @Column(name = "datefinmisedisposition")
    private LocalDate datefinmisedisposition;

    @Column(name = "heurdebut")
    private LocalDate heurdebut;

    @Column(name = "heurfin")
    private LocalDate heurfin;

    @Column(name = "motif")
    private String motif;

    @Column(name = "typevehicule")
    private String typevehicule;

    @Column(name = "lieudepart")
    private String lieudepart;

    @Column(name = "lieuarrive")
    private String lieuarrive;

    @Column(name = "division")
    private String division;

    @Column(name = "services")
    private String services;

    @Column(name = "nombrebenificiaire")
    private Integer nombrebenificiaire;

    @Column(name = "beneficiaire")
    private String beneficiaire;

    @Lob
    @Column(name = "piecejointes")
    private byte[] piecejointes;

    @Column(name = "piecejointes_content_type")
    private String piecejointesContentType;

    @Column(name = "statutdis")
    private String statutdis;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatricule() {
        return matricule;
    }

    public DemandeMiseDisposition matricule(String matricule) {
        this.matricule = matricule;
        return this;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public LocalDate getDatedemande() {
        return datedemande;
    }

    public DemandeMiseDisposition datedemande(LocalDate datedemande) {
        this.datedemande = datedemande;
        return this;
    }

    public void setDatedemande(LocalDate datedemande) {
        this.datedemande = datedemande;
    }

    public LocalDate getDatedebutmisedisposition() {
        return datedebutmisedisposition;
    }

    public DemandeMiseDisposition datedebutmisedisposition(LocalDate datedebutmisedisposition) {
        this.datedebutmisedisposition = datedebutmisedisposition;
        return this;
    }

    public void setDatedebutmisedisposition(LocalDate datedebutmisedisposition) {
        this.datedebutmisedisposition = datedebutmisedisposition;
    }

    public LocalDate getDatefinmisedisposition() {
        return datefinmisedisposition;
    }

    public DemandeMiseDisposition datefinmisedisposition(LocalDate datefinmisedisposition) {
        this.datefinmisedisposition = datefinmisedisposition;
        return this;
    }

    public void setDatefinmisedisposition(LocalDate datefinmisedisposition) {
        this.datefinmisedisposition = datefinmisedisposition;
    }

    public LocalDate getHeurdebut() {
        return heurdebut;
    }

    public DemandeMiseDisposition heurdebut(LocalDate heurdebut) {
        this.heurdebut = heurdebut;
        return this;
    }

    public void setHeurdebut(LocalDate heurdebut) {
        this.heurdebut = heurdebut;
    }

    public LocalDate getHeurfin() {
        return heurfin;
    }

    public DemandeMiseDisposition heurfin(LocalDate heurfin) {
        this.heurfin = heurfin;
        return this;
    }

    public void setHeurfin(LocalDate heurfin) {
        this.heurfin = heurfin;
    }

    public String getMotif() {
        return motif;
    }

    public DemandeMiseDisposition motif(String motif) {
        this.motif = motif;
        return this;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public String getTypevehicule() {
        return typevehicule;
    }

    public DemandeMiseDisposition typevehicule(String typevehicule) {
        this.typevehicule = typevehicule;
        return this;
    }

    public void setTypevehicule(String typevehicule) {
        this.typevehicule = typevehicule;
    }

    public String getLieudepart() {
        return lieudepart;
    }

    public DemandeMiseDisposition lieudepart(String lieudepart) {
        this.lieudepart = lieudepart;
        return this;
    }

    public void setLieudepart(String lieudepart) {
        this.lieudepart = lieudepart;
    }

    public String getLieuarrive() {
        return lieuarrive;
    }

    public DemandeMiseDisposition lieuarrive(String lieuarrive) {
        this.lieuarrive = lieuarrive;
        return this;
    }

    public void setLieuarrive(String lieuarrive) {
        this.lieuarrive = lieuarrive;
    }

    public String getDivision() {
        return division;
    }

    public DemandeMiseDisposition division(String division) {
        this.division = division;
        return this;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getServices() {
        return services;
    }

    public DemandeMiseDisposition services(String services) {
        this.services = services;
        return this;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public Integer getNombrebenificiaire() {
        return nombrebenificiaire;
    }

    public DemandeMiseDisposition nombrebenificiaire(Integer nombrebenificiaire) {
        this.nombrebenificiaire = nombrebenificiaire;
        return this;
    }

    public void setNombrebenificiaire(Integer nombrebenificiaire) {
        this.nombrebenificiaire = nombrebenificiaire;
    }

    public String getBeneficiaire() {
        return beneficiaire;
    }

    public DemandeMiseDisposition beneficiaire(String beneficiaire) {
        this.beneficiaire = beneficiaire;
        return this;
    }

    public void setBeneficiaire(String beneficiaire) {
        this.beneficiaire = beneficiaire;
    }

    public byte[] getPiecejointes() {
        return piecejointes;
    }

    public DemandeMiseDisposition piecejointes(byte[] piecejointes) {
        this.piecejointes = piecejointes;
        return this;
    }

    public void setPiecejointes(byte[] piecejointes) {
        this.piecejointes = piecejointes;
    }

    public String getPiecejointesContentType() {
        return piecejointesContentType;
    }

    public DemandeMiseDisposition piecejointesContentType(String piecejointesContentType) {
        this.piecejointesContentType = piecejointesContentType;
        return this;
    }

    public void setPiecejointesContentType(String piecejointesContentType) {
        this.piecejointesContentType = piecejointesContentType;
    }

    public String getStatutdis() {
        return statutdis;
    }

    public DemandeMiseDisposition statutdis(String statutdis) {
        this.statutdis = statutdis;
        return this;
    }

    public void setStatutdis(String statutdis) {
        this.statutdis = statutdis;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DemandeMiseDisposition)) {
            return false;
        }
        return id != null && id.equals(((DemandeMiseDisposition) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DemandeMiseDisposition{" +
            "id=" + getId() +
            ", matricule='" + getMatricule() + "'" +
            ", datedemande='" + getDatedemande() + "'" +
            ", datedebutmisedisposition='" + getDatedebutmisedisposition() + "'" +
            ", datefinmisedisposition='" + getDatefinmisedisposition() + "'" +
            ", heurdebut='" + getHeurdebut() + "'" +
            ", heurfin='" + getHeurfin() + "'" +
            ", motif='" + getMotif() + "'" +
            ", typevehicule='" + getTypevehicule() + "'" +
            ", lieudepart='" + getLieudepart() + "'" +
            ", lieuarrive='" + getLieuarrive() + "'" +
            ", division='" + getDivision() + "'" +
            ", services='" + getServices() + "'" +
            ", nombrebenificiaire=" + getNombrebenificiaire() +
            ", beneficiaire='" + getBeneficiaire() + "'" +
            ", piecejointes='" + getPiecejointes() + "'" +
            ", piecejointesContentType='" + getPiecejointesContentType() + "'" +
            ", statutdis='" + getStatutdis() + "'" +
            "}";
    }
}
