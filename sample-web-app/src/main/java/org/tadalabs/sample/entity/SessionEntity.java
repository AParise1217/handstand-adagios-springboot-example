package org.tadalabs.sample.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Date;

@DynamoDBTable(tableName = "session")
public class SessionEntity {

    private String sessionId;

    private Date initiationDate;
    private Date expirationDate;

    private String address;

    public SessionEntity() {}

    public SessionEntity(String address, Date initiationDate, Date expirationDate) {
        this.address = address;
        this.initiationDate = initiationDate;
        this.expirationDate = expirationDate;
    }

    @DynamoDBHashKey(attributeName = "session_id")
    @DynamoDBAutoGeneratedKey
    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    @DynamoDBAttribute(attributeName="initiation_date")
    public Date getInitiationDate() {
        return initiationDate;
    }

    public void setInitiationDate(Date initiationDate) {
        this.initiationDate = initiationDate;
    }

    @DynamoDBAttribute(attributeName = "expiration_date")
    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    @DynamoDBAttribute(attributeName = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof SessionEntity)) return false;

        SessionEntity that = (SessionEntity) o;

        return new EqualsBuilder()
                .append(sessionId, that.sessionId)
                .append(initiationDate, that.initiationDate)
                .append(expirationDate, that.expirationDate)
                .append(address, that.address)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(sessionId)
                .append(initiationDate)
                .append(expirationDate)
                .append(address)
                .toHashCode();
    }

    @Override
    public String toString() {
        return String.format("SessionEntity{sessionId='%s', initiationDate=%s, expirationDate=%s, address='%s'}",
                sessionId, initiationDate, expirationDate, address);
    }

}
