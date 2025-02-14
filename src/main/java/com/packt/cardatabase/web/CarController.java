package com.packt.cardatabase.web;

import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.CarInput;
import com.packt.cardatabase.domain.CarRepository;
import com.packt.cardatabase.domain.OwnerRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {
  private final CarRepository carRepository;
  private final OwnerRepository ownerRepository;

  public CarController(CarRepository carRepository, OwnerRepository ownerRepository) {
    this.carRepository = carRepository;
    this.ownerRepository = ownerRepository;
  }

  @GetMapping("/cars")
  public Iterable<Car> getCars() {
    return carRepository.findAll();
  }

  @PostMapping("/cars")
  public Car addCar(@RequestBody CarInput carInput) {
    Car newCar = new Car(
            carInput.brand(),
            carInput.color(),
            carInput.model(),
            carInput.modelYear(),
            carInput.price(),
            carInput.registrationNumber(),
            ownerRepository.findById(carInput.ownerId()).orElse(null)
    );
    return carRepository.save(newCar);
  }
  
  @GetMapping("/cars/{id}")
  public Car getCar(@PathVariable Long id) {
    return carRepository.findById(id).orElse(null);
  }

  @DeleteMapping("/cars/{id}")
  public void deleteCar(@PathVariable Long id) {
    Car carToBeRemoved = carRepository.findById(id).orElse(null);
    if (carToBeRemoved != null) carRepository.delete(carToBeRemoved);
    else throw new IllegalArgumentException(String.format("No car found with id '%s'", id));
  }
  
  @PutMapping("/cars/{id}")
  public Car updateCar(@RequestBody CarInput car, @PathVariable Long id) {
    Car carToBeUpdated = carRepository.findById(id).orElse(null);
    if (carToBeUpdated != null) {
      carToBeUpdated.setBrand(car.brand());
      carToBeUpdated.setColor(car.color());
      carToBeUpdated.setModel(car.model());
      carToBeUpdated.setModelYear(car.modelYear());
      carToBeUpdated.setOwner(ownerRepository.findById(car.ownerId()).orElse(null));
      carToBeUpdated.setPrice(car.price());
      carToBeUpdated.setRegistrationNumber(car.registrationNumber());
      carRepository.save(carToBeUpdated);
    }
    return carToBeUpdated;
  }
}
