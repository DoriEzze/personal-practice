package com.accenture.practice.models;

import com.accenture.practice.utils.BlobToByteArray;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.sql.SQLException;

@Entity
@Table(name = "Album")
@Data
public class Album {

    @Id
    @Column(name = "AlbumId")
    private Long albumId;

    @Column(name = "Title")
    private String title;

    @Column(name = "ArtistId")
    private Long artistId;

    @Column(name = "Column1")
    private byte[] column1;

    public void setColumn1(byte[] bytes) throws SQLException {
        bytes = BlobToByteArray.convertToByteArray();
        this.column1 = bytes;
    }
}
