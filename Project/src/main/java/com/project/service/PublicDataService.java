package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.persistence.PublicDataRepository;

@Service
public class PublicDataService {
	
	@Autowired
	private ApiService apiService;
	
	@Autowired
	private PublicDataRepository publicDataRepository;
	
	@Transactional
	public void

}
