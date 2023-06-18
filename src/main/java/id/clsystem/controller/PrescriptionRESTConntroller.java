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

import id.clsystem.model.Prescription;
import id.clsystem.repository.PrescriptionRepository;



@RestController
@RequestMapping("/api/prescription")
public class PrescriptionRESTConntroller {

	@Autowired
	private PrescriptionRepository prescriptionRepository;
	
	@GetMapping
	public List<Prescription> getPrescription(){
		return prescriptionRepository.findAll();
	}
	
	@GetMapping ("{prescriptionID}")
	public Prescription getPrescription(@PathVariable long prescriptionID) //get orders
	 {
		 
		Prescription prescription=prescriptionRepository.findById(prescriptionID).get();
		
		 return prescription;
	}
	
	@PostMapping()
	public Prescription insertPrescription(@RequestBody Prescription prescription) //get orders
	 {
		 return prescriptionRepository.save(prescription);
	}
	
	@PutMapping()
	public Prescription updatePrescription(@RequestBody Prescription prescription) //get orders
	 {
		 return prescriptionRepository.save(prescription);
	}
	
	@DeleteMapping("{prescriptionID}")
	public ResponseEntity<HttpStatus> deletePrescription(@PathVariable long prescriptionID ) //get orders
	 {
		prescriptionRepository.deleteById(prescriptionID);
		 
		 return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
