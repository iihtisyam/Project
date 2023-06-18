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
import id.clsystem.repository.AppointmentRepository;
import id.clsystem.model.Appointment;



@RestController
@RequestMapping("/api/appointments")
public class AppointmentRESTController{

	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@GetMapping
	public List<Appointment> getAppointments(){
		return appointmentRepository.findAll();
	}
	
	@GetMapping ("{AppointmentID}")
	public Appointment getAppointment(@PathVariable long appointmentID) //get orders
	 {
		 
		Appointment appointment=appointmentRepository.findById(appointmentID).get();
		
		 return appointment;
	}
	
	@PostMapping()
	public Appointment insertAppointment(@RequestBody Appointment appointment) //get orders
	 {
		 return appointmentRepository.save(appointment);
	}
	
	@PutMapping()
	public Appointment updateAppointment(@RequestBody Appointment appointment) //get orders
	 {
		 return appointmentRepository.save(appointment);
	}
	
	@DeleteMapping("{patientID}")
	public ResponseEntity<HttpStatus> deleteAppointment(@PathVariable long appointmentID ) //get orders
	 {
		appointmentRepository.deleteById(appointmentID);
		 
		 return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
