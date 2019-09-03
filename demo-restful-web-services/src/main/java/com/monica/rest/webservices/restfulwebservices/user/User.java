package com.monica.rest.webservices.restfulwebservices.user;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
public class User {
	@Id
	@GeneratedValue
	private int id;
	@Size(min = 2, message = "name should be more than 2 characters")
	private String name;
	@Past(message = "DOB should always be in past")
	private Date DOB;
	@OneToMany(mappedBy="user")
	private List<Post> posts;
	
	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

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

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", DOB=" + DOB + "]";
	}

	public User(int id, String name, Date dOB) {
		super();
		this.id = id;
		this.name = name;
		DOB = dOB;
	}

	public User() {
	}

	public User(String name, Date dOB) {
		super();
		this.name = name;
		DOB = dOB;
	}

}
