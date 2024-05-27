package com.accenture.practice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Track")
@Data
public class Track {
    @Id
    @Column(name = "TrackId")
    private long trackId;

    @Column(name = "Name")
    private String name;

    @Column(name = "AlbumId")
    private long albumId;

    @Column(name = "MediaTypeId")
    private long mediaTypeId;

    @Column(name = "GenreId")
    private long genreId;

    @Column(name = "Composer")
    private String composer;

    @Column(name = "Milliseconds")
    private int milliseconds;

    @Column(name = "Bytes")
    private int bytes;

    @Column(name = "UnitPrice")
    private float unitPrice;
}
