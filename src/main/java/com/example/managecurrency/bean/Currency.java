package com.example.managecurrency.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "currency")
public class Currency {
	
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name = "COUNTRY_CODE")
	private String country_code;
	
	@Column(name = "CONVERSION_FACTOR")
	private double conversion_factor;
	
	
	/**
	 * 
	 */
	public Currency() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


	/**
	 * @param id
	 * @param country_code
	 * @param conversion_factor
	 */
	public Currency(int id, String country_code, double conversion_factor) {
		super();
		this.id = id;
		this.country_code = country_code;
		this.conversion_factor = conversion_factor;
	}




	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * @return the country_code
	 */
	public String getCountry_code() {
		return country_code;
	}


	/**
	 * @param country_code the country_code to set
	 */
	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}


	/**
	 * @return the conversion_factor
	 */
	public double getConversion_factor() {
		return conversion_factor;
	}


	/**
	 * @param conversion_factor the conversion_factor to set
	 */
	public void setConversion_factor(double conversion_factor) {
		this.conversion_factor = conversion_factor;
	}
	
	
}
