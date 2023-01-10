package com.minimalistic.lajn.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.minimalistic.lajn.achievement.Achievement;

import lombok.Data;


@Component
@Entity(name = "user")
@Table(name = "users")
@Data
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "age")
	private Integer age;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "achievement_id", referencedColumnName = "id")
	private List<Achievement> achievement = new ArrayList<>();
	

}

