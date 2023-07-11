package org.springframework.samples.petclinic.vet.mapper;

import org.springframework.samples.petclinic.vet.api.SpecialtyDto;
import org.springframework.samples.petclinic.vet.api.VetDto;
import org.springframework.samples.petclinic.vet.dao.Vet;
import org.springframework.stereotype.Component;

import java.util.List;

public class Vet2VetDtoMapper {
	public VetDto convert(Vet vet) {
		List<SpecialtyDto> specialties = vet.getSpecialties()
			.stream()
			.map(specialty -> new SpecialtyDto(specialty.getName()))
			.toList();
		return new VetDto(vet.getId(), vet.getFirstName(), vet.getLastName(), specialties);
	}
}
