package com.accenture.practice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Artist")
@Data
public class Artist {
    @Id
    @Column(name = "ArtistId")
    private Long artistId;

    @Column(name = "Name")
    private String name;
}
