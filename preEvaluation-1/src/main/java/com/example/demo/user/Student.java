package com.example.demo.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Student {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
 
    private Integer regId;
    
    private Integer intitutionId;
 
    private Integer studentId;
        
    private String firstName;
    
    private String lastName;
   
    private String regdate;
      
    private String dateofBirth;

    private String age;
    
    private String gender;
       
    private Integer nid;
        
    private String occupation;

    /*@Column(name = "address")
    private string address;*/
      
    private String street;
      
    private String postOffice;
       
    private String upazilla;
       
    private String district;
   
    private String division;
    
    private Integer contact;
        
    private String email;
   
    private String created_on;
     
    private String created_by;    
    private String degree; 
    private String institute;    
    private String completion_year;
    
    private Integer grade;

    public Student() {
    	
    }

public Student(Integer regId, Integer intitutionId, Integer studentId, String firstName, String lastName,
			String regdate, String dateofBirth, String age, String gender, Integer nid, String occupation,
			String street, String postOffice, String upazilla, String district, String division, Integer contact,
			String email, String created_on, String created_by, String degree, String institute, String completion_year,
			Integer grade) {
		super();
		this.regId = regId;
		this.intitutionId = intitutionId;
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.regdate = regdate;
		this.dateofBirth = dateofBirth;
		this.age = age;
		this.gender = gender;
		this.nid = nid;
		this.occupation = occupation;
		this.street = street;
		this.postOffice = postOffice;
		this.upazilla = upazilla;
		this.district = district;
		this.division = division;
		this.contact = contact;
		this.email = email;
		this.created_on = created_on;
		this.created_by = created_by;
		this.degree = degree;
		this.institute = institute;
		this.completion_year = completion_year;
		this.grade = grade;
	}




public long getId() {
	return id;
}



public void setId(long id) {
	this.id = id;
}



public Integer getRegId() {
	return regId;
}



public void setRegId(Integer regId) {
	this.regId = regId;
}



public Integer getIntitutionId() {
	return intitutionId;
}



public void setIntitutionId(Integer intitutionId) {
	this.intitutionId = intitutionId;
}



public Integer getStudentId() {
	return studentId;
}



public void setStudentId(Integer studentId) {
	this.studentId = studentId;
}



public String getFirstName() {
	return firstName;
}



public void setFirstName(String firstName) {
	this.firstName = firstName;
}



public String getLastName() {
	return lastName;
}



public void setLastName(String lastName) {
	this.lastName = lastName;
}



public String getRegdate() {
	return regdate;
}



public void setRegdate(String regdate) {
	this.regdate = regdate;
}



public String getDateofBirth() {
	return dateofBirth;
}



public void setDateofBirth(String dateofBirth) {
	this.dateofBirth = dateofBirth;
}



public String getAge() {
	return age;
}



public void setAge(String age) {
	this.age = age;
}



public String getGender() {
	return gender;
}



public void setGender(String gender) {
	this.gender = gender;
}



public Integer getNid() {
	return nid;
}



public void setNid(Integer nid) {
	nid = nid;
}



public String getOccupation() {
	return occupation;
}



public void setOccupation(String occupation) {
	this.occupation = occupation;
}



public String getStreet() {
	return street;
}



public void setStreet(String street) {
	this.street = street;
}



public String getPostOffice() {
	return postOffice;
}



public void setPostOffice(String postOffice) {
	this.postOffice = postOffice;
}



public String getUpazilla() {
	return upazilla;
}



public void setUpazilla(String upazilla) {
	this.upazilla = upazilla;
}



public String getDistrict() {
	return district;
}



public void setDistrict(String district) {
	this.district = district;
}



public String getDivision() {
	return division;
}



public void setDivision(String division) {
	this.division = division;
}



public Integer getContact() {
	return contact;
}



public void setContact(Integer contact) {
	this.contact = contact;
}



public String getEmail() {
	return email;
}



public void setEmail(String email) {
	this.email = email;
}



public String getCreated_on() {
	return created_on;
}



public void setCreated_on(String created_on) {
	this.created_on = created_on;
}



public String getCreated_by() {
	return created_by;
}



public void setCreated_by(String created_by) {
	this.created_by = created_by;
}



public String getDegree() {
	return degree;
}



public void setDegree(String degree) {
	this.degree = degree;
}



public String getInstitute() {
	return institute;
}



public void setInstitute(String institute) {
	this.institute = institute;
}



public String getCompletion_year() {
	return completion_year;
}



public void setCompletion_year(String completion_year) {
	this.completion_year = completion_year;
}



public Integer getGrade() {
	return grade;
}



public void setGrade(Integer grade) {
	this.grade = grade;
}






}
