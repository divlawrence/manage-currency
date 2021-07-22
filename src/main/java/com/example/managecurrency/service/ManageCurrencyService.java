package com.example.managecurrency.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.managecurrency.bean.Currency;
import com.example.managecurrency.repo.ManageCurrencyRepository;

enum Operation
{
    CREATE, UPDATE;
}
@Service
public class ManageCurrencyService {

	
	@Autowired
	ManageCurrencyRepository manageCurrencyRepo;
	
	
	public Currency addConversionFactor(Currency currency){
		System.out.println("Inside add conversion factor - Service");
		System.out.println("Currency" +currency.getCountry_code()+ "" +currency.getConversion_factor());
		Currency savedCurrency =  findCurrencyRecordById(currency,Operation.CREATE);
		return savedCurrency;			
	}
	
	
	public Currency updateConversionFactor(Currency currencytoUpdate){
		System.out.println("Currency" +currencytoUpdate.getCountry_code()+ "" +currencytoUpdate.getConversion_factor());	
		Currency updatedCurrency =  findCurrencyRecordById(currencytoUpdate,Operation.UPDATE);
		return updatedCurrency;	
		
	}
	
	public Currency getConversionFactorByCountryCode(String countryCode){
		Currency currencyFromDB = manageCurrencyRepo.findConversionFactorByCCode(countryCode);
		return currencyFromDB;
		
	}
	
	private Currency findCurrencyRecordById(Currency currencyData,Operation operation) {
		Optional<Currency> currencySavedInDB = manageCurrencyRepo.findById(currencyData.getId());
		if(operation.equals(Operation.CREATE)) {
			if(currencySavedInDB.isPresent()) { 
				System.out.println("Currency present in DB: CREATE");
				currencyData = null;
			} else {
				manageCurrencyRepo.save(currencyData);
			}
		} else if (operation.equals(Operation.UPDATE)) {
			if(currencySavedInDB.isPresent()) { 
				System.out.println("Currency present in DB: UPDATE");
				manageCurrencyRepo.save(currencyData);
			} else {
				currencyData = null;
			}
		}
		
		return currencyData;
	}
		

	
}
