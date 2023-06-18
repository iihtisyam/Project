package id.clsystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="prescription")
public class Prescription {
	
	

	 //The annotation represents the field as the primary key and the value of the key auto incremental
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="PrescriptionID") //The name of @Column refers to the column named orderTypeId in the table OrderType.
	private int prescription;
	@Column (name="Date")
	private String date;
	@Column (name="MedicationDetails")
	private String medicationDetails;

	
	public int getPrescription() {
		return prescription;
	}
	public void setPrescription(int prescription) {
		this.prescription = prescription;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getMedicationDetails() {
		return medicationDetails;
	}
	public void setMedicationDetails(String medicationDetails) {
		this.medicationDetails = medicationDetails;
	}


}

