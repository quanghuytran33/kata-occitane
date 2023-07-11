package org.springframework.samples.petclinic.vet.api;


public class SpecialtyDto {

	private final String name;

	public SpecialtyDto(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
