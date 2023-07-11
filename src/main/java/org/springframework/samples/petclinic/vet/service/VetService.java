package org.springframework.samples.petclinic.vet.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.samples.petclinic.vet.api.VetDto;
import org.springframework.samples.petclinic.vet.api.VetPaginationView;
import org.springframework.samples.petclinic.vet.api.VetsDto;
import org.springframework.samples.petclinic.vet.dao.Vet;
import org.springframework.samples.petclinic.vet.mapper.Vet2VetDtoMapper;
import org.springframework.samples.petclinic.vet.repository.VetRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VetService {

	private final VetRepository vetRepository;
	private final Vet2VetDtoMapper vet2VetDtoMapper;

	public VetService(VetRepository vetRepository) {
		this.vetRepository = vetRepository;
		this.vet2VetDtoMapper = new Vet2VetDtoMapper();
	}

	public VetsDto findAll() {
		VetsDto vetsDto = new VetsDto();
		vetsDto.getVetList()
			.addAll(vetRepository.findAll()
				.stream()
				.map(vet2VetDtoMapper::convert)
				.toList());
		return vetsDto;
	}

	public VetPaginationView findWithPagination(int page) {
		Page<Vet> paginated = findPaginated(page);
		return convertFromPage(paginated);
	}

	private VetPaginationView convertFromPage(Page<Vet> page) {
		return new VetPaginationView(page.getTotalPages(),
			page.getTotalElements(),
			page.stream().map(vet2VetDtoMapper::convert).toList());
	}

	private Page<Vet> findPaginated(int page) {
		int pageSize = 5;
		Pageable pageable = PageRequest.of(page - 1, pageSize);
		return vetRepository.findAll(pageable);
	}
}
