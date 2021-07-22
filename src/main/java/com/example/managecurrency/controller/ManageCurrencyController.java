package com.example.managecurrency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.managecurrency.bean.Currency;
import com.example.managecurrency.service.ManageCurrencyService;

@RestController
@RequestMapping("/currency")
public class ManageCurrencyController {

	@Autowired
	ManageCurrencyService manageCurrencyService;

	@PostMapping("/create")
	public ResponseEntity<?> addConversionFactor(@RequestBody Currency currency) {
		System.out.println("Inside add conversion factor");
		System.out.println("Currency" + currency.getCountry_code() + "" + currency.getConversion_factor());
		Currency currencySaved = manageCurrencyService.addConversionFactor(currency);
		if (currencySaved != null) {
			return new ResponseEntity<Currency>(currencySaved, HttpStatus.OK);
		} else {
			System.out.println("Return 400");
			return new ResponseEntity<String>("Record already present", HttpStatus.NOT_FOUND);
		}

	}

	@PutMapping("/update")
	public ResponseEntity<?> updateConversionFactor(@RequestBody Currency currency) {
		Currency currencyUpdated = manageCurrencyService.updateConversionFactor(currency);
		if (currencyUpdated != null) {
			return new ResponseEntity<Currency>(currencyUpdated, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Record not found for updation",HttpStatus.NOT_FOUND);
		}

	}
	
	
	@GetMapping("/get/{country_code}")
	public ResponseEntity<String> getConversionFactor(@PathVariable("country_code") String countryCode){
	    
		Currency currencyRetrieved = manageCurrencyService.getConversionFactorByCountryCode(countryCode);
		if(currencyRetrieved != null) {
			String conversionFactor_str = Double.toString(currencyRetrieved.getConversion_factor());
			return new ResponseEntity<String>(conversionFactor_str, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Record does not exist", HttpStatus.NOT_FOUND);
		}		
		
	}
}
