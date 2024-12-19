package com.project.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{

}
