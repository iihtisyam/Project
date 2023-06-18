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

import id.clsystem.model.Patient;

@Controller
public class PatientMenuController {

	private String defaultURI="http://localhost:8080/klinik/api/patients";
	
	@GetMapping("/patient/list")
	public String getPatients(Model model)
	{
		
		// The URI for Get order Types
		String uri= "http://localhost:8080/klinik/api/patients";
				
		// Get a list order types from the webs
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Patient[]> response= restTemplate.getForEntity(uri,Patient[].class);
				
		//Parse JSON data to array of object
		Patient patientsTb[] = response.getBody();
		
		//System.out.println(this.getClass().getSimpleName());
		//System.out.println("Total records: "+ patientsTb.length+"\n");
		
		List<Patient> patientList = Arrays.asList(patientsTb);
		
		model.addAttribute("patientsTb",patientList);
		
		return "ordertypes";
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
		@RequestMapping("/patient/save")
		public String updatePatient(@ModelAttribute Patient patient)
		{
			RestTemplate restTemplate = new RestTemplate();
			
			HttpEntity<Patient> request = new HttpEntity<Patient>(patient);
			
			String patientResponse ="";
			
			if(patient.getPatientID()>0)
			{
				
				//PUT
				restTemplate.put(defaultURI, request,Patient.class);
			}
			else
			{
				//POST
				patientResponse=restTemplate.postForObject(
						defaultURI, request, String.class);
				
			}
			
			System.out.println(patientResponse);
			
			return "redirect:/patient/list";
			
		}
		
		/**
		 * 
		 * 
		 * @param patientID
		 * @param model
		 * @return
		 */
		@GetMapping("/patient/{patientID}")
		public String getPatient(@PathVariable Integer patientID, Model model)
		{
			String pageTitle= "New Patient";
			Patient patient = new Patient();
			
			if(patientID > 0)
			{
				String uri= defaultURI + "/"+ patientID;
				
				RestTemplate restTemplate = new RestTemplate();
				patient= restTemplate.getForObject(uri,Patient.class);
				
				//
				pageTitle="Edit Patient";
			}
			
			model.addAttribute("patient",patient);
			model.addAttribute("pageTitle",pageTitle);
			
			
			return "ordertypeinfo";
		}
		
		
		/**
		 * 
		 * @param patientID
		 * @return
		 */
		@RequestMapping("/patient/delete/{patientID}")
		public String deletePatient(@PathVariable Integer patientID)
		{
			String uri =defaultURI +"/{patientID}";
			
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.delete(uri, Map.of("patientID",Integer.toString(patientID)));
			
			
			return "redirect:/patient/list";
			
		}
	
	
}


	
	


