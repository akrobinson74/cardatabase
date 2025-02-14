package com.packt.cardatabase;


import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.CarRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CardatabaseApplication implements CommandLineRunner {
  private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);

  private final CarRepository repository;

  public CardatabaseApplication(CarRepository repository) {
    this.repository = repository;
  }

  public static void main(String[] args) {
    SpringApplication.run(CardatabaseApplication.class, args);
    logger.info("Application started");
  }

  @Override
  public void run(String... args) {
    // Fetch all cars and log to console
    for (Car car : repository.findAll()) {
      logger.info("brand: {}, model: {}", car.getBrand(), car.getModel());
    }
  }
}
