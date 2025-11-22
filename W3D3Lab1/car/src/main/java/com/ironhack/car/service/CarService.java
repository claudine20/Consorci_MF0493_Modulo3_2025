package com.ironhack.car.service;

import com.ironhack.car.model.Car;
import org.springframework.stereotype.Service;

import java.util.*;

/*
* CRUD:
* C - Create
* R - Retrieve
* U - Update
* D - Delete
* */
@Service
public class CarService {
    private final Map<Long, Car> cars = new HashMap<>();
    private long nextId = 1L;

    public List<Car> findAll() {
        return new ArrayList<>(cars.values());
    }

    public Optional<Car> findById(Long id) {
        return Optional.ofNullable(cars.get(id));
    }

    public Car save(Car car) {
        car.setId(nextId++);
        cars.put(car.getId(), car);
        return car;
    }

    public Optional<Car> update(Long id, Car updatedCar) {
        if (!cars.containsKey(id)) {
            return Optional.empty();
        }
        updatedCar.setId(id);
        cars.put(id, updatedCar);
        return Optional.of(updatedCar);
    }

    public boolean delete(Long id) {
        return cars.remove(id) != null;
    }
}
