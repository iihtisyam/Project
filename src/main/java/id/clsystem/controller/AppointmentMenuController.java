package id.clsystem.controller;

import java.util.List;
import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import id.clsystem.model.Appointment;


@Controller
public class AppointmentMenuController {

	@GetMapping("/appointment/list")
	public String getAppointment(Model model){
		
		String uri = "http://localhost:8080/klinik/api/appointments";
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Appointment[]> response = restTemplate.getForEntity(uri,  Appointment[].class);
		
		Appointment appointments[] = response.getBody();
		
		/*System.out.print(this.getClass().getSimpleName());
		System.out.println("Total Appointments: " + appointments.length + "\n");
		
		for(id.clsystem.model.Appointment Appointment:appointments) {
			
			System.out.print(Appointment.getAppointmentID() + "-");
			System.out.print(Appointment.getPatientID() + "-");
			System.out.print(Appointment.getDoctorID() + "-");
			System.out.print(Appointment.getAppointmentDate() + "-");
			System.out.print(Appointment.getRoomID() + "-");
			System.out.println(Appointment.getSlotID());
			
		}
		
		String message = "Check out the message in console";
		return new ResponseEntity<>(message, HttpStatus.OK);*/
		
		List<Appointment> appointmentList = Arrays.asList(appointments);
		
		model.addAttribute("appointments", appointmentList);
		
		return "appointments";
		
	}
	
	
	
	
}
