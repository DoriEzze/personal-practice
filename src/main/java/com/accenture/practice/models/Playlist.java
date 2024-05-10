package com.accenture.practice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Playlist")
public class Playlist {
    @Id
    @Column(name = "PlaylistId")
    private Long playlistId;

    private String name;

}
