package id.clsystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="appointment")
public class Appointment {
		//@GeneratedValue(strategy=GenerationType.IDENTITY) //The annotation represents the field as the primary key and the value of the key auto incremental
	@Id
	@Column (name="AppointmentID") //The name of @Column refers to the column named orderTypeId in the table OrderType.
	private String appointmentID;
	
	@Column (name="PatientID")
	private String patientID;
	
	@Column (name="DoctorID")
	private String doctorID;
	
	@Column (name="AppointmentDate")
	private String appointmentDate;
	
	@Column (name="roomID")
	private String RoomID;
	
	@Column (name="slotID")
	private String SlotID;
	

	public String getAppointmentID() {
		return appointmentID;
	}

	public void setAppointmentID(String appointmentID) {
		this.appointmentID = appointmentID;
	}

	public String getPatientID() {
		return patientID;
	}

	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}

	public String getDoctorID() {
		return doctorID;
	}

	public void setDoctorID(String doctorID) {
		this.doctorID = doctorID;
	}

	public String getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	
	public String getRoomID() {
		return RoomID;
	}

	public void setRoomID(String roomID) {
		RoomID = roomID;
	}
	
	public String getSlotID() {
		return SlotID;
	}

	public void setSlotID(String slotID) {
		SlotID = slotID;
	}


}


