package com.heritage.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Value;


@Component
@Entity(name = "user")
@Table(name = "users")
@Data
public class UserEntity {
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String id;
	@Column(name = "userID")
	private String userId;
	@Column(nullable=false, length=120)
	public String email;
	@Column(name = "encrypted_password")
    private String encryptedPassword;
	@Column(name = "role")
    private String role;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "age")
	private Integer age;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "achievement_id", referencedColumnName = "id")
	private List<UserProject> achievement = new ArrayList<>();


	//public void setEncryptedPassword(String encryptedPassword) {
	//	this.Password = encryptedPassword;
		// TODO Auto-generated method stub
		
	}
	


