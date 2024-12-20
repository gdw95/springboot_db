package com.project.domain;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class PublicData {
	
	@Id
	private Long id;
	private String name;
	private String description;
	

}
