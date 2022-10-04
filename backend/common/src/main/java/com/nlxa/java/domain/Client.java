package com.nlxa.java.domain;

import com.nlxa.java.dto.client.AddClientRequest;
import com.nlxa.java.dto.client.DeleteClientRequest;
import com.nlxa.java.dto.client.UpdateClientRequest;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "client")
public class Client implements Serializable {

    @Id
    @Column(name = "client_id")
    @GeneratedValue(generator = "ID")
    @GenericGenerator(
            name = "ID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String client_id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;

    public Client() {}

    public Client(AddClientRequest request) {
        this.client_id = "";
        this.firstName = request.getFirstName();
        this.lastName = request.getLastName();
    }

    public Client(DeleteClientRequest request) {
        this.client_id = request.getClient_id();
    }

    public Client(UpdateClientRequest request) {
        this.client_id = request.getClient_id();
        this.firstName = request.getFirstName();
        this.lastName = request.getLastName();
    }
}
