package com.example.sergio3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
    @Table(name="Reservation")
    public class Reservation implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer idReservation;
        private Date startDate;
        private Date devolutionDate;
        private String status="created";
        private String score;

        @ManyToOne
        @JoinColumn(name ="id")
        @JsonIgnoreProperties("reservations")
        private Machine machine;

        @ManyToOne
        @JoinColumn(name ="idClient")
        @JsonIgnoreProperties({"reservations", "messages"})
        private Client cliente;

        public Integer getIdReservation() {
            return idReservation;
        }

        public void setIdReservation(Integer idReservation) {
            this.idReservation = idReservation;
        }

        public Date getStartDate() {return startDate;}

        public void setStartDate(Date starDate) {
            this.startDate = starDate;
        }

        public Date getDevolutionDate() {
            return devolutionDate;
        }

        public void setDevolutionDate(Date devolutionDate) {
            this.devolutionDate = devolutionDate;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }

        public Machine getMachine() {
            return machine;
        }

        public void setMachine(Machine machine) {
            this.machine = machine;
        }

        public Client getClient() {
            return cliente;
        }

        public void setClient(Client cliente) {
            this.cliente = cliente;
        }
    }
