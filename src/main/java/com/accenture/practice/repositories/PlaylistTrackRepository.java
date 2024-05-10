package com.accenture.practice.repositories;

import com.accenture.practice.models.PlaylistTrack;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistTrackRepository extends CrudRepository<PlaylistTrack, Long> {
}
