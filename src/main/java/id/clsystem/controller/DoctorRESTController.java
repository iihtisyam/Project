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

import id.clsystem.model.Doctor;
import id.clsystem.repository.DoctorRepository;



@RestController
@RequestMapping("/api/doctors")
public class DoctorRESTController {

	@Autowired
	private DoctorRepository doctorRepository;
	
	@GetMapping
	public List<Doctor> Doctors(){
		return doctorRepository.findAll();
	}
	

	@GetMapping ("{doctorID}")
	public Doctor getDoctor(@PathVariable long doctorID) //get orders
	 {
		 
		 Doctor doctor=doctorRepository.findById(doctorID).get();
		
		 return doctor;
}
	
	@PostMapping()
	public Doctor insertDoctor(@RequestBody Doctor doctor) //get orders
	 {
		 return doctorRepository.save(doctor);
	}
	
	@PutMapping()
	public Doctor updateDoctor(@RequestBody Doctor doctor) //get orders
	 {
		 return doctorRepository.save(doctor);
	}
	
	@DeleteMapping("{doctorID}")
	public ResponseEntity<HttpStatus> deleteDoctor(@PathVariable long doctorID ) //get orders
	 {
		doctorRepository.deleteById(doctorID);
		 
		 return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
