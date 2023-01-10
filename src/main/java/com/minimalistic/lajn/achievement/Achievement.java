package com.minimalistic.lajn.achievement;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.minimalistic.lajn.user.User;

import lombok.Data;


@Component
@Entity
@Table(name = "achievements")
@Data
public class Achievement {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;
	@Column(name = "published_on")
	private java.sql.Timestamp publishedOn;
	public Achievement() {
	}

}
