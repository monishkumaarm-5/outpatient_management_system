package com.infosys.eDoctor.repository;

import com.infosys.eDoctor.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor, String> {
    Optional<Doctor> findByEmail(String email);
}
