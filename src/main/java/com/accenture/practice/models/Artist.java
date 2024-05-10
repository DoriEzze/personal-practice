package com.accenture.practice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Artist {

    @Id
    @Column(name = "ArtistId")
    private Long artistId;

    @Column(name = "Name")
    private String name;
}
