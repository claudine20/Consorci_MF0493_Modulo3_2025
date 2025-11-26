package com.ironhack.cardb.service;

import com.ironhack.cardb.model.Car;
import com.ironhack.cardb.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    CarRepository repository;

    public List<Car> findAll() {
        return repository.findAll();
    }

    public Optional<Car> findById(Long id) {
        return repository.findById(id);
    }

    public Car save(Car car) {
        return repository.save(car);
    }

    public Optional<Car> update(Long id, Car updatedCar) {
        Optional<Car> carRepo = repository.findById(id);
        if (carRepo.isEmpty()) {
            return Optional.empty();
        }
        Car myCar = carRepo.get();
        myCar.setId(id);
        return Optional.of(repository.save(myCar));
    }

    public boolean delete(Long id) {
        repository.deleteById(id);
        return true;
    }
}
