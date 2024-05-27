package com.accenture.practice.repositories;

import org.springframework.data.repository.CrudRepository;

import com.accenture.practice.models.Playlist;

public interface PlaylistRepository extends CrudRepository<Playlist, Long>{
}
