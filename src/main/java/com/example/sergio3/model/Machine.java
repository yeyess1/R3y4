package com.example.sergio3.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table (name="machine")
public class Machine implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer ID;
    private String BRAND;
    private Integer YEAR;
    private String DESCRIPTION;
    private String NAME;

    @ManyToOne
    @JoinColumn(name ="categoryId")
    @JsonIgnoreProperties("machines")
    private Category category;

    @OneToMany (cascade = {CascadeType.PERSIST},mappedBy="machine")
    @JsonIgnoreProperties({"machine", "Client"})
    private List<Message> messages;

    @OneToMany (cascade = {CascadeType.PERSIST},mappedBy="machine")
    @JsonIgnoreProperties({"machine", "Client"})
    private List<Reservation> reservaciones;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getBRAND() {
        return BRAND;
    }

    public void setBRAND(String BRAND) {
        this.BRAND = BRAND;
    }

    public Integer getYEAR() {
        return YEAR;
    }

    public void setYEAR(Integer YEAR) {
        this.YEAR = YEAR;
    }

    public String getDESCRIPTION() {return DESCRIPTION;}

    public void setDESCRIPTION(String DESCRIPTION) {this.DESCRIPTION = DESCRIPTION;}

    public String getNAME() {return NAME;}

    public void setNAME(String NAME) {this.NAME = NAME;}

    public Category getCategory() {return category;}

    public void setCategory(Category category) {this.category = category;}

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Reservation> getReservation() {return reservaciones;}

    public void setReservation(List<Reservation> reservaciones) {this.reservaciones = reservaciones;
    }
    
}
