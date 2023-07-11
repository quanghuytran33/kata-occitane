package org.springframework.samples.petclinic.vet.api;


import jakarta.xml.bind.annotation.XmlElement;

import java.util.List;

public class VetDto {

	private final Integer id;
	private final String firstName;
	private final String lastName;
	private List<SpecialtyDto> specialties;

	public VetDto(Integer id, String firstName, String lastName, List<SpecialtyDto> specialties) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.specialties = specialties;
	}

	@XmlElement(name = "speciality")
	public List<SpecialtyDto> getSpecialties() {
		return specialties;
	}

	public Integer getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getNrOfSpecialties() {
		return specialties.size();
	}
}
