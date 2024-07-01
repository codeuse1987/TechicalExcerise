package com.example.exercise.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.exercise.enity.Vehicle;

public interface VehicleDao extends JpaRepository<Vehicle, Integer> {

	public ArrayList<Vehicle> findByVinIn(ArrayList<String> vins);

}
