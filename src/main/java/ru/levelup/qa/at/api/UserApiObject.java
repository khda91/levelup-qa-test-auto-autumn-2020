package ru.levelup.qa.at.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
//@JsonIgnoreProperties(ignoreUnknown = true)
public class UserApiObject {

    private long id;
    private String name;
    private String job;
    private String createdAt;

    @JsonProperty("updatedAt")
    private String updatedDate;

    public UserApiObject() {
    }

    public UserApiObject(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public String toString() {
        return "UserApiObject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedDate='" + updatedDate + '\'' +
                '}';
    }
}
