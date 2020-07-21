package com.project.covid19tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.covid19tracker.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

}
