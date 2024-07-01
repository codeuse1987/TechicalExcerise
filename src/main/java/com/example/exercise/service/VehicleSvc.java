package com.example.exercise.service;

import java.util.ArrayList;

import com.example.exercise.cmn.ApplicationException;
import com.example.exercise.enity.Vehicle;
import com.example.exercise.model.Vehicles;

public interface VehicleSvc {
	public ArrayList<Vehicle> createVehicles(Vehicles vehicles) throws ApplicationException;
}
