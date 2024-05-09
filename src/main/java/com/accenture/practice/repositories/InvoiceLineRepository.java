package com.accenture.practice.repositories;

import com.accenture.practice.models.InvoiceLine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceLineRepository extends CrudRepository<InvoiceLine, Long> {
}
