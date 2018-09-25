package com.apap.tutorial3.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.apap.tutorial3.model.CarModel;

/**
 * 
 * CarInMemoryService
 *
 */
@Service
public class CarInMemoryService implements CarService {
	private List<CarModel> archiveCar;
	
	public CarInMemoryService() {
		archiveCar = new ArrayList<>();
	}

	@Override
	public void addCar(CarModel car) {
		archiveCar.add(car);
		
	}

	@Override
	public List<CarModel> getCarList() {
		return archiveCar;
	}

	@Override
	public CarModel getCarDetail(String id) {
		for (CarModel car : archiveCar) {
			if (car.getId().equals(id)) {
				return car;
			}
		}
		return null;
	}
	
	@Override
	public boolean checkCar(String id) {
		for(int i = 0; i < archiveCar.size(); i++) {
			CarModel selectedCar = archiveCar.get(i);
			if(selectedCar.getId().equals(id)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void updateAmount(String id, String amount) {
		CarModel selectedCar = getCarDetail(id);
		selectedCar.setAmount(Integer.parseInt(amount));
	}
	
	public void delete(String id) {
		CarModel selectedCar = getCarDetail(id);
		archiveCar.remove(selectedCar);
	}
}
