package com.accenture.practice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Album")
@Data
public class Album {

    @Id
    @Column(name = "AlbumId")
    private Long albumId;

    private String title;
    private Long artistId;
}
