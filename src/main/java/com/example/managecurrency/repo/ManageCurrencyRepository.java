package com.example.managecurrency.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.managecurrency.bean.Currency;

@Repository
public interface ManageCurrencyRepository extends JpaRepository<Currency, Integer> {

	@Query(value = "SELECT c.id,c.country_code,c.conversion_factor FROM Currency c WHERE c.country_code = ?1", nativeQuery = true)
	Currency findConversionFactorByCCode(String country_code);
}
