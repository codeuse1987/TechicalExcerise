package com.example.exercise.model;

import java.util.ArrayList;

import com.example.exercise.enity.Vehicle;

import jakarta.validation.Valid;

public class Vehicles {
	
	public ArrayList< @Valid Vehicle> vehicles;

	public ArrayList<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(ArrayList<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

}