package com.example.exercise.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.exercise.enity.Vehicle;

public interface VehicleDao extends CrudRepository<Vehicle, Integer> {

}
