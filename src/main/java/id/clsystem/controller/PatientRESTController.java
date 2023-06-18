package id.clsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.clsystem.model.Patient;
import id.clsystem.repository.PatientRepository;

@RestController
@RequestMapping("/api/patients")
public class PatientRESTController {

	@Autowired
	private PatientRepository patientRepository;
	
	@GetMapping
	public List<Patient> getPatients(){
		return patientRepository.findAll();
	}
	
	@GetMapping ("{patientID}")
	public Patient getPatient(@PathVariable long patientID) //get orders
	 {
		 
		 Patient patient=patientRepository.findById(patientID).get();
		
		 return patient;
	}
	
	@PostMapping()
	public Patient insertPatient(@RequestBody Patient patient){
		 
		return patientRepository.save(patient);
	}
	
	@PutMapping()
	public Patient updatePatient(@RequestBody Patient patient) //get orders
	 {
		 return patientRepository.save(patient);
	}
	
	@DeleteMapping("{patientID}")
	public ResponseEntity<HttpStatus> deletePatient(@PathVariable Long patientID ) //get orders
	 {
		 patientRepository.deleteById(patientID);
		 
		 return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
