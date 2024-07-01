package com.example.exercise.service.impl;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.exercise.cmn.ApplicationException;
import com.example.exercise.dao.VehicleDao;
import com.example.exercise.enity.Vehicle;
import com.example.exercise.model.Vehicles;
import com.example.exercise.service.VehicleSvc;

@Service
public class VehicleSvcImpl implements VehicleSvc {

	@Autowired
	private static Logger logger = LoggerFactory.getLogger(VehicleSvcImpl.class);

	@Autowired
	private VehicleDao vehicleDao;

	@Override
	@Transactional
	public ArrayList<Vehicle> createVehicles(Vehicles vehicles) throws ApplicationException {

		ArrayList<Vehicle> result = new ArrayList<Vehicle>();

		// Filter Manufacture == FORD OR GM
		ArrayList<Vehicle> filtedMfrs = vehicles.getVehicles().stream().filter(
				v -> v.getManufacturer().toLowerCase().equals("ford") || v.getManufacturer().toLowerCase().equals("gm"))
				.collect(Collectors.toCollection(ArrayList::new));

		// Filter bay_number < 100 or null
		ArrayList<Vehicle> filtedBayNo = filtedMfrs.stream()
				.filter(v -> v.getBay_number() == null || v.getBay_number() < 100)
				.collect(Collectors.toCollection(ArrayList::new));

		if (filtedBayNo.isEmpty()) {
			throw new ApplicationException("Code", "Msg");
		}

		// Pre check any non-unique VIN, if do return error
		ArrayList<Vehicle> existed = vehicleDao.findByVinIn(
				filtedBayNo.stream().map(v -> v.getVin()).collect(Collectors.toCollection(ArrayList::new)));
		if (!existed.isEmpty()) {
			throw new ApplicationException("Code1", "Msg");
		}

		for (Vehicle v : filtedBayNo) {
			Vehicle saved = vehicleDao.save(v);
			result.add(saved);
		}
		return result;
	}

};
