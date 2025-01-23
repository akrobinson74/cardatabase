package com.packt.cardatabase.domain;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Car {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String brand, color, model, registrationNumber;
	private int modelYear, price;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="owner")
	private Owner owner;
	
	public Car() {
		
	}
	
	public Car(
		String brand,
		String color,
		String model,
		int modelYear,
		int price,
		String registrationNumber,
		Owner owner
	) {
		super();
		this.brand = brand;
		this.color = color;
		this.model = model;
		this.modelYear = modelYear;
		this.price = price;
		this.registrationNumber = registrationNumber;
		this.owner = owner;
	}

	public long getId() {
		return id;
	}

	public String getBrand() {
		return brand;
	}

	public String getColor() {
		return color;
	}

	public String getModel() {
		return model;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public int getModelYear() {
		return modelYear;
	}

	public int getPrice() {
		return price;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public void setModelYear(int modelYear) {
		this.modelYear = modelYear;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(brand, color, id, model, modelYear, owner, price, registrationNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		return Objects.equals(brand, other.brand) && Objects.equals(color, other.color) && id == other.id
				&& Objects.equals(model, other.model) && modelYear == other.modelYear
				&& Objects.equals(owner, other.owner) && price == other.price
				&& Objects.equals(registrationNumber, other.registrationNumber);
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", brand=" + brand + ", color=" + color + ", model=" + model + ", registrationNumber="
				+ registrationNumber + ", modelYear=" + modelYear + ", price=" + price + ", owner=" + owner + "]";
	}
}
