package id.clsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import id.clsystem.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
