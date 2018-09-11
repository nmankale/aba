package com.airaavat.aba.model;


import javax.persistence.*;

import org.hibernate.annotations.GeneratorType;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity()
@Table(name = "aba_organization")
public class Organization implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private Long id;
	
	@Column(name = "name", length = 100)
	private String name;
	
	@Column(name = "address", length = 100)
	private String address;
	
	@Column(name = "country", length = 100)
	private String country;
	
	@Column(name = "created_date")
	private Date createdDate;
	
	
	@ManyToMany
	@JoinTable(name = "org_user", joinColumns = @JoinColumn(name="org_id"), inverseJoinColumns = @JoinColumn(name="user_id") )
	private Set<Users> users = new HashSet();

	
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Set<Users> getUsers() {
		return users;
	}

	public void setUsers(Set<Users> users) {
		this.users = users;
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
		Organization other = (Organization) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
