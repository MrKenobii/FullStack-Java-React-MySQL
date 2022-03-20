package com.anilduyguc.questionapp.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    Long id;
    String username;
    String password;
}
