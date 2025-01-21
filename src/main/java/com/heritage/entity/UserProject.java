package com.heritage.entity;

import jakarta.persistence.*;

import org.springframework.stereotype.Component;

import lombok.Data;


@Component
@Entity
@Table(name = "achievements")
@Data
public class UserProject {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;
	@Column(name = "published_on")
	private java.sql.Timestamp publishedOn;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private UserEntity user;

}
