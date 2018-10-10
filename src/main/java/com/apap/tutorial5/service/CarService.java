package com.apap.tutorial5.service;

import java.util.List;

import com.apap.tutorial5.model.CarModel;

public interface CarService {
	void addCar(CarModel car);
	void deleteCar(CarModel car);
	CarModel findCarById(Long id);
	
	
	void updateData(CarModel updateCarData, Long carId);
	List<CarModel> sortByPrice(Long dealer_id);
}
