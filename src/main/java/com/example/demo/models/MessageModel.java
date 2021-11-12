package com.example.demo.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "mensaje")
public class MessageModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idMessage;

    private String messageText;

    @ManyToOne
    @JoinColumn(name = "maquinaId")
    @JsonIgnoreProperties({ "messages", "reservations" }) 
    private MachineModel machine;

    @ManyToOne
    @JoinColumn(name = "clientesId")
    @JsonIgnoreProperties({ "messages", "reservations" }) 
    private ClientModel client;

    public ClientModel getClient() {
        return client;
    }

    public MachineModel getMachine() {
        return machine;
    }

    public void setMachine(MachineModel machine) {
        this.machine = machine;
    }

    public void setClient(ClientModel client) {
        this.client = client;
    }

    public Long getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Long idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

}
