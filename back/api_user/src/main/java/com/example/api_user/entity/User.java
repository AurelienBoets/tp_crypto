package com.example.api_user.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Getter
@Setter
@Document(collection = "user")
public class User {
    @Id
    private String id;
    private String lastname;
    private String firstname;
    private String email;
    private String password;
}
