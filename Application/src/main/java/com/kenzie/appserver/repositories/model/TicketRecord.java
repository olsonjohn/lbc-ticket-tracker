package com.kenzie.appserver.repositories.model;


import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.kenzie.appserver.converter.UserListConverter;
import com.kenzie.appserver.converter.ZonedDateTimeConverter;
import com.kenzie.appserver.service.model.User;
import org.springframework.data.annotation.Id;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;

@DynamoDBTable(tableName = "Tickets")

public class TicketRecord {
    public static final String TICKETS_INDEX = "TicketsIndex";
    private String ticketSubject;
    private String ticketDescription;
    private ZonedDateTime createdAt;
    private ZonedDateTime finishedAt;
    private TicketStatus ticketStatus;
    @Id
    private String ticketId;
    private String customerId;
    private List<User> users;

//TODO: Add DynamoDB attributes for GSI with CustomerId HashKey for customer ticket history

    @DynamoDBAttribute(attributeName = "subject")
    public String getTicketSubject() {
        return ticketSubject;
    }
    @DynamoDBAttribute(attributeName = "description")
    public String getTicketDescription() {
        return ticketDescription;
    }
    @DynamoDBTypeConverted(converter = ZonedDateTimeConverter.class)
    @DynamoDBAttribute(attributeName = "created")
    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }
    @DynamoDBTypeConverted(converter = ZonedDateTimeConverter.class)
    @DynamoDBAttribute(attributeName = "finished")
    public ZonedDateTime getFinishedAt() {
        return finishedAt;
    }
    //@DynamoDBRangeKey(attributeName = "status")
    @DynamoDBAttribute(attributeName = "ticketStatus")
    @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.S)
    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }
    @DynamoDBHashKey(attributeName = "ticketId")
    public String getTicketId() {
        return ticketId;
    }
    @DynamoDBAttribute(attributeName = "customerId")
    @DynamoDBIndexHashKey(globalSecondaryIndexName =TICKETS_INDEX, attributeName = "customerId")
    public String getCustomerId() {return customerId;}
    @DynamoDBAttribute(attributeName = "users")
    @DynamoDBTypeConverted(converter = UserListConverter.class)
    public List<User> getUsers() {return users;}

    public void setTicketSubject(String ticketSubject) {
        this.ticketSubject = ticketSubject;
    }

    public void setTicketDescription(String ticketDescription) {
        this.ticketDescription = ticketDescription;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setFinishedAt(ZonedDateTime finishedAt) {
        this.finishedAt = finishedAt;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public void setCustomerId(String customerId) {this.customerId = customerId;}

    public void setUsers(List<User> users) {this.users = users;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TicketRecord)) return false;
        TicketRecord that = (TicketRecord) o;
        return Objects.equals(getTicketId(), that.getTicketId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTicketId());
    }
}
