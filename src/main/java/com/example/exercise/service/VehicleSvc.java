package com.example.exercise.service;

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

@Service
public class VehicleSvc {

	@Autowired
	private static Logger logger = LoggerFactory.getLogger(VehicleSvc.class);

	@Autowired
	private VehicleDao vehicleDao;

	@Transactional
	public ArrayList<Vehicle> createVehicles(Vehicles vehicles) throws ApplicationException {

		ArrayList<Vehicle> result = new ArrayList<Vehicle>();
		// Filter Manufacture == FORD OR GM
		ArrayList<Vehicle> removeVW = vehicles.getVehicles().stream().filter(
				v -> v.getManufacturer().toLowerCase().equals("ford") || v.getManufacturer().toLowerCase().equals("gm"))
				.collect(Collectors.toCollection(ArrayList::new));
		// Filter bay_number < 100 or null
		ArrayList<Vehicle> bayNoCheck = removeVW.stream()
				.filter(v -> v.getBay_number() == null || v.getBay_number() < 100)
				.collect(Collectors.toCollection(ArrayList::new));
		if (!bayNoCheck.isEmpty()) {
			for (Vehicle v : bayNoCheck) {
				try {
					result.add(vehicleDao.save(v));
				} catch (Exception e) {
					// TODO: handle exception
					logger.debug("Error", e);
					throw new ApplicationException(e.getMessage());
				}

			}
		}
		return result;
	}

};
