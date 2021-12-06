package com.maharaja.security.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    @Id
    private String id;
    private String Name;
    private String Email;
    private String Password;

}
