package org.springframework.samples.petclinic.vet.api;

import java.util.List;

public class VetPaginationView {

	private final int totalPages;
	private final long totalElements;
	private final List<VetDto> vets;

	public VetPaginationView(int totalPages, long totalElements, List<VetDto> vets) {
		this.totalPages = totalPages;
		this.totalElements = totalElements;
		this.vets = vets;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public long getTotalElements() {
		return totalElements;
	}

	public List<VetDto> getVets() {
		return vets;
	}
}
