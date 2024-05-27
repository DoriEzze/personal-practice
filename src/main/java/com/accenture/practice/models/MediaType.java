package com.accenture.practice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "MediaType")
@Data
public class MediaType {
    @Id
    @Column(name = "MediaTypeId")
    private Long mediaTypeId;

    @Column(name = "Name")
    private String name;
}
