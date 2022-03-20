package com.anilduyguc.questionapp.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "like_amount")
@Data
public class Like {
    @Id
    Long id;
    Long postId;
    Long userId;
}
