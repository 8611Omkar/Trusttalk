package com.example.Trusttalk.model;

import java.time.LocalDate;

//import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
//import lombok.experimental.PackagePrivate;
//import org.springframework.data.annotation.Id;
@Data
@Document(collection = "users")
public class User {

    @id
    private Long id;
    
	private String username;
	private String password;  
	private String email;
	private String status;
    private LocalDate createdAt;
    

  /*  public void setId(String id) //{
        this.id = id;
    }//

    public String getUsername() //{
        return username;
    }//

    public void setUsername(String username)// {
        this.username = username;
    }
//
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }*/

}
