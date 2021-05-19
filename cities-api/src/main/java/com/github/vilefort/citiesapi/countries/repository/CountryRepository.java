package com.github.vilefort.citiesapi.countries.repository;

import com.github.vilefort.citiesapi.countries.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Long> {
    Optional<Country> findByName(String name);

}
