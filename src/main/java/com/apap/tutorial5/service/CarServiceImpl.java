package com.apap.tutorial5.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.tutorial5.model.CarModel;
import com.apap.tutorial5.repository.CarDb;

@Service
@Transactional
public class CarServiceImpl implements CarService {

	@Autowired
	private CarDb carDb;

	
	@Override	
	public void addCar(CarModel car) {
		carDb.save(car);
		
	}
	@Override
	public void deleteCar(CarModel car) {
		System.out.println("tes");
		System.out.println(car.getId());
		System.out.println(car);
		carDb.delete(car);	
	}
	@Override
	public CarModel findCarById(Long id) {
		return carDb.findById(id).get();
	}
	
	@Override
	public void updateData(CarModel updateCar, Long carId) {
		CarModel oldCar = carDb.findById(carId).get();
		oldCar.setBrand(updateCar.getBrand());
		oldCar.setAmount(updateCar.getAmount());
		oldCar.setPrice(updateCar.getPrice());
		oldCar.setType(updateCar.getType());
		carDb.save(oldCar);
	}
	@Override
	public List<CarModel> sortByPrice(Long dealer_id) {
		return carDb.findByDealerIdOrderByPriceDesc(dealer_id);
	}
	

}
