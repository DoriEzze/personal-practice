package com.accenture.practice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Genre")
@Data
public class Genre {
    @Id
    @Column(name = "GenreId")
    private Long genreId;

    @Column(name = "Name")
    private String name;
}
