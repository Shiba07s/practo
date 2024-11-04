package com.brandcit.services;

import java.util.List;

import com.brandcit.constants.DoctorStatus;
import com.brandcit.dtos.DoctorsDto;
import com.brandcit.request.DoctorSearchCriteria;

public interface DoctorProfileService {
	DoctorsDto createDoctor(DoctorsDto doctorDto);
    DoctorsDto updateDoctor(Integer id, DoctorsDto doctorDto);
    DoctorsDto getDoctorById(Integer id);
    List<DoctorsDto> getAllDoctors();
    List<DoctorsDto> getDoctorsBySpecialization(String specialization);
    List<DoctorsDto> getDoctorsByStatus(DoctorStatus status);
    void deleteDoctor(Integer id);
    DoctorsDto updateDoctorStatus(Integer id, DoctorStatus status);
//    List<DoctorsDto> searchDoctors(String keyword);
    boolean verifyDoctorRegistration(String registrationNumber);
    
    List<DoctorsDto> searchDoctors(DoctorSearchCriteria criteria);

}
