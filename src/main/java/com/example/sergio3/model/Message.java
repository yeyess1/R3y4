package com.example.sergio3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

    @Entity
    @Table(name="Message")
    public class Message implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer idMessage;
        private String messageText;

        @ManyToOne
        @JoinColumn(name ="id")
        @JsonIgnoreProperties({"messages","client", "reservation"})
        private Machine machine;

        @ManyToOne
        @JoinColumn(name ="clientid")
        @JsonIgnoreProperties({"messages","client", "reservation"})
        private Client client; //ojo el Client.Cliente client esta diferente que en la grabacion

        public Integer getIdMessage() {
            return idMessage;
        }

        public void setIdMessage(Integer idMessage) {
            this.idMessage = idMessage;
        }

        public String getMessageText() {
            return messageText;
        }

        public void setMessageText(String messageText) {
            this.messageText = messageText;
        }

        public Machine getMachine() {
            return machine;
        }

        public void setMachine(Machine machine) {
            this.machine = machine;
        }

        public Client getClient() {
            return client;
        }

        public void setClient(Client client) {
            this.client = client;
        }
    }

