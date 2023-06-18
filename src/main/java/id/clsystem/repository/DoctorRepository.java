package id.clsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import id.clsystem.model.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}
