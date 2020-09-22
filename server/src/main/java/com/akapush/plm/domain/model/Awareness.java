package com.akapush.plm.domain.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "AWARENESS")
public class Awareness {

    @Id
    @Column(name = "AWA_ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_plm_awarness_awa_id")
    @SequenceGenerator(name = "seq_plm_awarness_awa_id", sequenceName = "seq_plm_awarness_awa_id")
    private Long id;

    @Column(name = "AWA_NAME")
    private String name;

    @Column(name = "AWA_DATE")
    private Date date;

    @JoinColumn(name = "TYPE_DDV_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private DropDownValue type;

    @JoinColumn(name = "PUBLIC_DDV_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private DropDownValue publicType;

    @Column(name = "AWA_SIGNATURE")
    private Boolean signature;

    @Column(name = "AWA_ESTIMATION")
    private Integer estimation;

    @Column(name = "AWA_ADDRESS1")
    private String address1;

    @Column(name = "AWA_ADDRESS2")
    private String address2;

    @Column(name = "AWA_ZIP_CODE")
    private String zipCode;

    @Column(name = "AWA_CITY")
    private String city;

    @JoinColumn(name = "GEOGRAPHIC_FOCUS_DDV_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private DropDownValue geographicFocus;

    @Column(name = "AWA_ORGANISER_STRUCTURE")
    private String organiserStructure;

    @Column(name = "AWA_CONTACT")
    private String contact;

    @Column(name = "AWA_COMMENT")
    private String comment;


    @Column(name = "AWA_ACTIVE")
    private Boolean active;

    @ManyToMany()
    @JoinTable(name = "USER_AWARENESS", joinColumns = {@JoinColumn(name = "AWA_ID")}, inverseJoinColumns = {
            @JoinColumn(name = "USR_ID")})
    private List<User> users;

    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(name = "YOUNG_AWARENESS", joinColumns = {@JoinColumn(name = "AWA_ID")}, inverseJoinColumns = {
            @JoinColumn(name = "YOU_ID")})
    private List<Young> youngs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public DropDownValue getType() {
        return type;
    }

    public void setType(DropDownValue type) {
        this.type = type;
    }

    public DropDownValue getPublicType() {
        return publicType;
    }

    public void setPublicType(DropDownValue publicType) {
        this.publicType = publicType;
    }

    public Boolean getSignature() {
        return signature;
    }

    public void setSignature(Boolean signature) {
        this.signature = signature;
    }

    public Integer getEstimation() {
        return estimation;
    }

    public void setEstimation(Integer estimation) {
        this.estimation = estimation;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public DropDownValue getGeographicFocus() {
        return geographicFocus;
    }

    public void setGeographicFocus(DropDownValue geographicFocus) {
        this.geographicFocus = geographicFocus;
    }

    public String getOrganiserStructure() {
        return organiserStructure;
    }

    public void setOrganiserStructure(String organiserStructure) {
        this.organiserStructure = organiserStructure;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Young> getYoungs() {
        return youngs;
    }

    public void setYoungs(List<Young> youngs) {
        this.youngs = youngs;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Awareness other = (Awareness) obj;
        if (id == null) {
            return (other.id == null);
        } else
            return id.equals(other.id);
    }

}
