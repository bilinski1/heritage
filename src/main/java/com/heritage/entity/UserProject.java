package com.heritage.entity;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "achievements")
public class UserProject {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity userEntity;


	//@OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
	//private Set<UserProject> userProjects;


}
