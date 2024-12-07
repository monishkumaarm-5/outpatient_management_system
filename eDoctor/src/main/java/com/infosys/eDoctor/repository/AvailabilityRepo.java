package com.infosys.eDoctor.repository;

import com.infosys.eDoctor.entity.Availability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvailabilityRepo extends JpaRepository<Availability, Integer> {
    List<Availability> findByDoctorId(String doctorId);
}
