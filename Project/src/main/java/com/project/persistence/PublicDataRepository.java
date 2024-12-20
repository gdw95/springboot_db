package com.project.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.domain.PublicData;

public interface PublicDataRepository extends JpaRepository<PublicData, Long>{

}
