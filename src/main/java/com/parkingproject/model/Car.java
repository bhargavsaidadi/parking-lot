package com.parkingproject.model;

/**
 * Model object to represent a car.
 */
public class Car {
	private String registrationNumber;
	private String driver_name;
	private int age;
	private int slotNumber;
	

	public int getSlotNumber() {
		return slotNumber;
	}

	public void setSlotNumber(int slotNumber) {
		this.slotNumber = slotNumber;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public String getDriver() {
		return driver_name;
	}

	public int getAge() {
		return age;
	}

	public Car(final String registrationNumber, final String driver_name, final int age) {
		this.registrationNumber = registrationNumber;
		this.driver_name = driver_name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Car [registrationNumber=" + registrationNumber + ", driver=" + driver_name + ", age=" + age + "]";
	}
	
}
