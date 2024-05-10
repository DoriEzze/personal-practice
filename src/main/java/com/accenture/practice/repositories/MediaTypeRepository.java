package com.accenture.practice.repositories;

import com.accenture.practice.models.MediaType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MediaTypeRepository extends CrudRepository<MediaType, Long> {
}
