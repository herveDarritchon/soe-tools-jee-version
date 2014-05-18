package com.hervedarritchon.rpg.mongo_consumer.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {

    @Id
    private String id;

    private String version;

    private String nickname;

    private String emailAddress;

    private String password;

    /**
     * Create a user from nickname, emailAddress and password.
     * TODO Add version to the storage. Value should be read from properties.
     *
     * @param nickname
     * @param emailAddress
     * @param password
     */
    public User(String nickname, String emailAddress, String password) {
        this.nickname = nickname;
        this.emailAddress = emailAddress;
        this.password = password;
        this.version="1.0";
    }

    public User() {
        super();
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.id).append(this.version).append(this.nickname).append(this.emailAddress).append(this.password).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        return new EqualsBuilder().append(this.id, other.id).append(this.version, other.version).append(this.nickname, other.nickname).append(this.emailAddress, other.emailAddress).append(this.password, other.password).isEquals();
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", version='" + version + '\'' +
                ", nickname='" + nickname + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
