package model;

/**
*
*/
import jakarta.persistence.*;
@Entity
@Table(name = "employee")

public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "telNo")
	private String telNo;
	
	@Column(name = "position")
	private String position;
	
	public Employee() {
	}
	
//	Constructor
	public Employee(String name, String telNo, String position) {
		this.name = name;
		this.telNo = telNo;
		this.position = position;
	}
	
//	Generate getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelNo() {
		return telNo;
	}
	public void setTelNo(String telNo) {
	
	this.telNo = telNo;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
//	Generate output structure
	@Override
	public String toString() {
		return "Employee Details {Id = " + id + ", Name = " + name + ", Telephone = " + telNo + ", Position = " + position + "}";
	}

}
