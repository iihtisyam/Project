package id.clsystem.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

//import java.util.Arrays;
//import java.util.List;

import id.clsystem.model.Doctor;

@Controller
public class DoctorMenuController {

	private String defaultURI="http://localhost:8080/klinik/api/doctors";
	
	@GetMapping("/doctor/list")
	public String getPatients(Model model)
	{
		
		// The URI for Get order Types
		String uri= "http://localhost:8080/klinik/api/doctors";
				
		// Get a list order types from the webs
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Doctor[]> response= restTemplate.getForEntity(uri,Doctor[].class);
				
		//Parse JSON data to array of object
		Doctor doctorsTb[] = response.getBody();
		
		//System.out.println(this.getClass().getSimpleName());
		//System.out.println("Total records: "+ patientsTb.length+"\n");
		
		List<Doctor> doctorList = Arrays.asList(doctorsTb);
		
		model.addAttribute("doctorsTb",doctorList);
		
		return "doc";
		/*
		for (Patient patient:patientsTb) {
			
			System.out.print(patient.getPatientID()+"-");
			System.out.print(patient.getPatientName()+"-");
			System.out.println(patient.getPatientIC());
		}
		
		String message ="check out the message in the console";
		return new ResponseEntity<>(message,HttpStatus.OK);*/
}
	
		
		/**
		 * 
		 * @param patient
		 * @return
		 */
		@RequestMapping("/doctor/save")
		public String updateDoctor(@ModelAttribute Doctor doctor)
		{
			RestTemplate restTemplate = new RestTemplate();
			
			HttpEntity<Doctor> request = new HttpEntity<Doctor>(doctor);
			
			String doctorResponse ="";
			
			if(doctor.getDoctorID()>0)
			{
				
				//PUT
				restTemplate.put(defaultURI, request,Doctor.class);
			}
			else
			{
				//POST
				doctorResponse=restTemplate.postForObject(
						defaultURI, request, String.class);
				
			}
			
			System.out.println(doctorResponse);
			
			return "redirect:/doctor/list";
			
		}
		
		/**
		 * 
		 * 
		 * @param patientID
		 * @param model
		 * @return
		 */
		@GetMapping("/doctor/{doctorID}")
		public String getDoctor(@PathVariable Integer doctorID, Model model)
		{
			String pageTitle= "New doctor";
			Doctor doctor = new Doctor();
			
			if(doctorID > 0)
			{
				String uri= defaultURI + "/"+ doctorID;
				
				RestTemplate restTemplate = new RestTemplate();
				doctor= restTemplate.getForObject(uri,Doctor.class);
				
				//
				pageTitle="Edit Doctor";
			}
			
			model.addAttribute("doctor",doctor);
			model.addAttribute("pageTitle",pageTitle);
			
			
			return "docform";
			//docinfo
		}
		
		
		/**
		 * 
		 * @param patientID
		 * @return
		 */
		@RequestMapping("/doctor/delete/{doctorID}")
		public String deleteDoctor(@PathVariable Integer doctorID)
		{
			String uri =defaultURI +"/{doctorID}";
			
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.delete(uri, Map.of("doctorID",Integer.toString(doctorID)));
			
			
			return "redirect:/doctor/list";
			
		}
	
	
}


	
	


