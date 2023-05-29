package com.example.addressbook.model;

import com.example.addressbook.dto.AddressDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class AddressBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int personId;
    private String fullName;
    private String address;
    private String city;
    private String state;
    private String phoneNum;

    @CollectionTable(name = "email", joinColumns = @JoinColumn(name = "id"))
    private String email;

    public AddressBook(AddressDTO addressDTO) {
        this.fullName = addressDTO.getFullName();
        this.address = addressDTO.getAddress();
        this.city = addressDTO.getCity();
        this.state = addressDTO.getState();
        this.phoneNum = addressDTO.getPhoneNum();
        this.email = addressDTO.getEmail();
    }

    public AddressBook(int personId, AddressDTO addressDTO) {
        this.personId = personId;
        this.fullName = addressDTO.getFullName();
        this.address = addressDTO.getAddress();
        this.city = addressDTO.getCity();
        this.state = addressDTO.getState();
        this.phoneNum = addressDTO.getPhoneNum();
        this.email = addressDTO.getEmail();
    }
}
