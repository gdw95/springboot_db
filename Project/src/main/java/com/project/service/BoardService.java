package com.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.domain.Board;
import com.project.persistence.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
	private final BoardRepository boardRepo;
	
	public List<Board> getBoards() {
		return boardRepo.findAll();
	}
	
	public Board getBoard(Long id) {
		return boardRepo.findById(id).get();
	}

}

//주소창으로 h2-콘솔 들어가서 select * from board