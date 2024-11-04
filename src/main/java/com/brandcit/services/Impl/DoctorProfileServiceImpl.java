package com.brandcit.services.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.brandcit.constants.DoctorStatus;
import com.brandcit.dtos.DoctorsDto;
import com.brandcit.entities.Doctors;
import com.brandcit.exception.ResourceNotFoundException;
import com.brandcit.repositories.DoctorProfileRepository;
import com.brandcit.request.DoctorSearchCriteria;
import com.brandcit.services.DoctorProfileService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DoctorProfileServiceImpl implements DoctorProfileService {

	private final DoctorProfileRepository doctorProfileRepository;
	private final ModelMapper modelMapper;

	@Override
	public DoctorsDto createDoctor(DoctorsDto doctorDto) {
		Doctors doctors = modelMapper.map(doctorDto, Doctors.class);
		doctors.setStatus(DoctorStatus.UNVERIFIED);
		Doctors save = doctorProfileRepository.save(doctors);
		return modelMapper.map(save, DoctorsDto.class);
	}

	@Override
	public DoctorsDto updateDoctor(Integer id, DoctorsDto doctorDto) {
		Doctors existingDoctor = doctorProfileRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Doctors is not present with this id : " + id));

		DoctorStatus status = existingDoctor.getStatus();
		var createdAt = existingDoctor.getCreatedAt();

		modelMapper.map(doctorDto, existingDoctor);

		existingDoctor.setId(id);
		existingDoctor.setStatus(status);
		existingDoctor.setCreatedAt(createdAt);

		Doctors save = doctorProfileRepository.save(existingDoctor);

		return modelMapper.map(save, DoctorsDto.class);
	}

	@Override
	public DoctorsDto getDoctorById(Integer id) {
		Doctors existingDoctor = doctorProfileRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Doctors is not present with this id : " + id));

		return modelMapper.map(existingDoctor, DoctorsDto.class);
	}

	@Override
	public List<DoctorsDto> getAllDoctors() {
		List<Doctors> all = doctorProfileRepository.findAll();
		return all.stream().map(doctor -> modelMapper.map(doctor, DoctorsDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<DoctorsDto> getDoctorsBySpecialization(String specialization) {
		List<Doctors> bySpecialization = doctorProfileRepository.findBySpecialization(specialization);
		return bySpecialization.stream().map(doctor -> modelMapper.map(doctor, DoctorsDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<DoctorsDto> getDoctorsByStatus(DoctorStatus status) {
		List<Doctors> byStatus = doctorProfileRepository.findByStatus(status);
		return byStatus.stream().map(doctor -> modelMapper.map(doctor, DoctorsDto.class)).collect(Collectors.toList());
	}

	@Override
	public void deleteDoctor(Integer id) {
		Doctors existingDoctor = doctorProfileRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Doctors is not present with this id : " + id));
 
		doctorProfileRepository.delete(existingDoctor);
	}

	@Override
	public DoctorsDto updateDoctorStatus(Integer id, DoctorStatus status) {
		// TODO Auto-generated method stub
		return null;
	}

	 @Override
	    public List<DoctorsDto> searchDoctors(DoctorSearchCriteria criteria) {
	        Specification<Doctors> spec = DoctorSpecification.buildSpecification(criteria);
	        return doctorProfileRepository.findAll(spec)
	                .stream()
	                .map(doctor -> modelMapper.map(doctor, DoctorsDto.class))
	                .collect(Collectors.toList());
	    }

	@Override
	public boolean verifyDoctorRegistration(String registrationNumber) {
		// TODO Auto-generated method stub
		return false;
	}

}
