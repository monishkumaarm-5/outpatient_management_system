package com.infosys.eDoctor.reposatory;

import com.infosys.eDoctor.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    List<Doctor> findBySpeciality(String speciality);
}