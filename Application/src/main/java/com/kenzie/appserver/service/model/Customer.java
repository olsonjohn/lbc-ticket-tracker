package com.kenzie.appserver.service.model;

import com.kenzie.appserver.controller.model.CustomerCreateRequest;
import com.kenzie.appserver.controller.model.CustomerUpdateRequest;
import com.kenzie.appserver.repositories.model.CustomerRecord;

import java.util.Objects;

import static java.util.UUID.randomUUID;

public class Customer {
    private String id;
    private String firstName;
    private String lastName;
    private String address;
    private String emailAddress;
    private String phoneNumber;

    public Customer(String id,
                    String firstName,
                    String lastName,
                    String address,
                    String emailAddress,
                    String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }

    public Customer(CustomerRecord customerRecord) {
        this.id = customerRecord.getId();
        this.firstName = customerRecord.getFirstName();
        this.lastName = customerRecord.getLastName();
        this.address = customerRecord.getAddress();
        this.emailAddress = customerRecord.getEmailAddress();
        this.phoneNumber = customerRecord.getPhoneNumber();
    }

    public Customer(CustomerCreateRequest customerCreateRequest) {
        this.id = randomUUID().toString();
        this.firstName = customerCreateRequest.getFirstName();
        this.lastName = customerCreateRequest.getLastName();
        this.address = customerCreateRequest.getAddress();
        this.emailAddress = customerCreateRequest.getEmailAddress();
        this.phoneNumber = customerCreateRequest.getPhoneNumber();
    }

    public Customer(CustomerUpdateRequest customerUpdateRequest) {
        this.id = customerUpdateRequest.getId();
        this.firstName = customerUpdateRequest.getFirstName();
        this.lastName = customerUpdateRequest.getLastName();
        this.address = customerUpdateRequest.getAddress();
        this.emailAddress = customerUpdateRequest.getEmailAddress();
        this.phoneNumber = customerUpdateRequest.getPhoneNumber();
    }

    public Customer() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id)
                && Objects.equals(firstName, customer.firstName)
                && Objects.equals(lastName, customer.lastName)
                && Objects.equals(address, customer.address)
                && Objects.equals(emailAddress, customer.emailAddress)
                && Objects.equals(phoneNumber, customer.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, address, emailAddress, phoneNumber);
    }
}
