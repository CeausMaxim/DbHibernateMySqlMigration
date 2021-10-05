package com.example.dbhibernatemysqlmigration.repository;

import com.example.dbhibernatemysqlmigration.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
