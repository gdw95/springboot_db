package com.rubypaper.service;

import org.springframework.data.domain.Page;

import com.rubypaper.domain.Board;

public interface BoardService {

	void insertBoard(Board board);
	void updateBoard(Board board);
	void deleteBoard(Board board);
	Board getBoard(Board board);
	
	Page<Board> getBoardList(Board board);
}
