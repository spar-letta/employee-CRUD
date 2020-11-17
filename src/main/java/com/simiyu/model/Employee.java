/**
 * 
 */
package com.simiyu.model;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * @author enock
 *
 */
@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	private long phone;
	private long id_no;
	private Rank rank;
	
	
	public Employee() {
		
	}

	public Employee(String name, long phone, long id_no, Rank rank) {
		this.name = name;
		this.phone = phone;
		this.id_no = id_no;
		this.rank = rank;
	}

	
	public Employee(long id, String name, long phone, long id_no, Rank rank) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.id_no = id_no;
		this.rank = rank;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public long getId_no() {
		return id_no;
	}

	public void setId_no(long id_no) {
		this.id_no = id_no;
	}

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}	

	

	
	
}
