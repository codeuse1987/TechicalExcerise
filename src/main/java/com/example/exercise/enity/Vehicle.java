package com.example.exercise.enity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "vehicles")
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@JsonProperty("VIN")
	@Column(name = "vin", nullable = false, unique = true)
	private String vin;

	@Column(name = "manufacturer", nullable = false)
	private String manufacturer;

	@Column(name = "bay_number", nullable = true)
	private Integer bay_number;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Integer getBay_number() {
		return bay_number;
	}

	public void setBay_number(Integer bay_number) {
		this.bay_number = bay_number;
	}

	public Vehicle() {

	}

	public Vehicle(String vin, String manufacturer, Integer bay_number) {
		this.setVin(vin);
		this.setManufacturer(manufacturer);
		this.setBay_number(bay_number);
	}

};