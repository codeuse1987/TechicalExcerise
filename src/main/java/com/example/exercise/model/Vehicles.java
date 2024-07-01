package com.example.exercise.model;

import java.util.ArrayList;

import com.example.exercise.enity.Vehicle;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public class Vehicles {

	@NotNull
	public ArrayList<@Valid Vehicle> vehicles;

	public ArrayList<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(ArrayList<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public Vehicles() {
	}

	public Vehicles(ArrayList<Vehicle> data) {
		this.vehicles = data;
	}
}