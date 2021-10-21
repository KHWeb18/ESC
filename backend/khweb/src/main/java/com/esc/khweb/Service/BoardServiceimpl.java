package com.esc.khweb.Service;

import com.esc.khweb.controller.request.BoardRequest;
import com.esc.khweb.entity.Board;
import com.esc.khweb.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardServiceimpl implements  BoardService{

    @Autowired
    BoardRepository boardRepository;

    @Override
    public void boardRegister(BoardRequest boardRequest) throws Exception {

        Board board = new Board(boardRequest.getMemberId(), boardRequest.getTitle(), boardRequest.getContent(), boardRequest.getImg(), boardRequest.getCategory());

        boardRepository.save(board);
    }

    @Override
    public List<Board> getBoardList() throws Exception {
        return boardRepository.findAll(Sort.by(Sort.Direction.DESC,"boardNo"));
    }

    @Override
    public Optional<Board> getBoard(Long boardNo) throws Exception {
        return boardRepository.findById(boardNo);
    }

    @Override
    public void viewcount(Long boardNo) throws Exception {
        boardRepository.viewcount(boardNo);
    }
}
