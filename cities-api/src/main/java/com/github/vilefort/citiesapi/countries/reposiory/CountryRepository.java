package com.github.vilefort.citiesapi.countries.reposiory;

import com.github.vilefort.citiesapi.countries.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
