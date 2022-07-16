package com.idhit.hms.idhithealthclinicclient.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Appointment {

        private Long id;

        private Doctor doctor;

        private String doctorName;

        public String getDoctorName() {
            return doctorName;
        }

        public void setDoctorName(String doctorName) {
            this.doctorName = doctorName;
        }

        private String patientName;
        private String gender;
        private int age;

        //private List<String> symptomps;

        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private Date appointmentDateTime;

        private String status;

        @DateTimeFormat(pattern="HH:mm:ss")
        private String time;

        private String symptoms;

        private Long prescriptionId;

        public Long getPrescriptionId() {
            return prescriptionId;
        }

        public void setPrescriptionId(Long prescriptionId) {
            this.prescriptionId = prescriptionId;
        }

    public String getSymptoms(){
            return symptoms;
        }

        public void setSymptoms(String symptoms){
            this.symptoms = symptoms;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

    public Long getId() {
            return id;
        }

        public Doctor getDoctor() {
            return doctor;
        }

        public void setDoctor(Doctor doctor) {
            this.doctor = doctor;
        }

        public String getPatientName() {
            return patientName;
        }

        public void setPatientName(String patientName) {
            this.patientName = patientName;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setId(Long id) {
            this.id = id;
        }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

        public Date getAppointmentDateTime() {
            return appointmentDateTime;
        }

        public void setAppointmentDateTime(Date appointmentDateTime) {
            this.appointmentDateTime = appointmentDateTime;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", doctor=" + doctor +
                ", doctorName='" + doctorName + '\'' +
                ", patientName='" + patientName + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", appointmentDateTime=" + appointmentDateTime +
                ", status='" + status + '\'' +
                ", symptoms='" + symptoms + '\'' +
                '}';
    }
}
