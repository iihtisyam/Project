package id.clsystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="patient")
public class Patient {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //The annotation represents the field as the primary key and the value of the key auto incremental
	@Column (name="patientID") //The name of @Column refers to the column named orderTypeId in the table OrderType.
	private int patientID;

	@Column (name="patientName")
	private String patientName;
	@Column (name="patientIC")
	private String patientIC;
	
	@Column (name="patientPhoneNum") //The name of @Column refers to the column named orderTypeId in the table OrderType.
	private String patientPhoneNum;
	
	@Column (name="dOB")
	private String dOB;
	@Column (name="patientAddress")
	private String patientAddress;

	public int getPatientID() {
		return patientID;
	}

	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}
	
	public String getPatientName() {
		return patientName;
	}
	
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	
	public String getPatientIC() {
		return patientIC;
	}
	
	public void setPatientIC(String patientIC) {
		this.patientIC = patientIC;
	}
	
	public String getPatientPhoneNum() {
		return patientPhoneNum;
	}
	
	public void setPatientPhoneNum(String patientPhoneNum) {
		this.patientPhoneNum = patientPhoneNum;
	}
	
	public String getdOB() {
		return dOB;
	}
	public void setdOB(String dOB) {
		this.dOB = dOB;
	}
	
	public String getPatientaddress() {
		return patientAddress;
	}
	
	public void setPatientaddress(String patientaddress) {
		this.patientAddress = patientaddress;
	}
	
}
