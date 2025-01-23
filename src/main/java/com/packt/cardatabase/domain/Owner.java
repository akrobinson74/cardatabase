package com.packt.cardatabase.domain;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Owner {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long ownerid;
	private String firstname, lastname;
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL, mappedBy="owner")
	private List<Car> cars;
	
	public Owner() {
	}
	
	public Owner(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public Owner(Owner other) {
		this.ownerid = other.ownerid;
		this.firstname = other.firstname;
		this.lastname = other.lastname;
		this.cars = other.cars;
	}

	public Long getOwnerid() {
		return ownerid;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	
	public void setOwnerid(Long ownerid) {
		this.ownerid = ownerid;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cars, firstname, lastname, ownerid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Owner other = (Owner) obj;
		return Objects.equals(cars, other.cars) && Objects.equals(firstname, other.firstname)
				&& Objects.equals(lastname, other.lastname) && Objects.equals(ownerid, other.ownerid);
	}

	@Override
	public String toString() {
		return "Owner [ownerid=" + ownerid + ", firstname=" + firstname + ", lastname=" + lastname + ", cars=" + cars
				+ "]";
	}
	
	
}
