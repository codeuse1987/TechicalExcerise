package com.example.exercise.rest;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exercise.cmn.ApplicationException;
import com.example.exercise.cmn.ResponsePacker;
import com.example.exercise.enity.Vehicle;
import com.example.exercise.model.Vehicles;
import com.example.exercise.service.VehicleSvc;

@Validated
@RestController
@RequestMapping
public class RestControler extends ResponsePacker{

	@Autowired
	private VehicleSvc vehicleSvc;

	@PostMapping(value = "/vehicles")
	public ResponseEntity<?> createVehicles(@RequestBody Vehicles body) throws ApplicationException {
//		try {
//			ArrayList<Vehicle> data = vehicleSvc.createVehicles(body);
//			return ResponseEntity.ok(data);
//		} catch (Exception e) {
//			return new ResponseEntity<Exception>(HttpStatus.BAD_REQUEST);
		if (body == null) {
			throw new ApplicationException("Code1", "Msg");
		}

		try {
			ArrayList<Vehicle> data = vehicleSvc.createVehicles(body);
			return this.processResult(data);
		} catch (Exception e) {
			return this.processResult(e);
		}

	}

	@GetMapping(value = "/get")
	public ResponseEntity<?> apiCheck() {
		return new ResponseEntity<Exception>(HttpStatus.OK);

	}

};