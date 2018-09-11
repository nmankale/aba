package com.airaavat.aba.model;

import javax.persistence.*;

import org.hibernate.annotations.GeneratorType;

import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.util.Date;

@Entity()
@Table(name = "aba_users")
public class Users implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	Long id;
	
	@Column(name = "name", length = 100)
	private String name;
	
	@Column(name = "password", length = 8)
	private String password;
	
	@Column(name = "active")
	private boolean active;
	
	/*@Temporal(TemporalType.TIMESTAMP)
	@JsonSerialize(using = JsonSerializer.class)*/
	
	@Column(name = "created_date")
	private Date createdDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		if (id != other.id)
			return false;
		return true;
	}

	
}
