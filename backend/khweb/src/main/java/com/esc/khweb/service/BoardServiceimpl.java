package com.esc.khweb.service;

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

    @Override
    public void goodCount(Long boardNo) throws Exception {
        boardRepository.goodCount(boardNo);
    }

    @Override
    public void badCount(Long boardNo) throws Exception {
        boardRepository.badCount(boardNo);
    }

    @Override
    public void report(Long boardNo,String reportWord) throws Exception {
        boardRepository.report(boardNo,reportWord);
    }

    @Override
    public void boardModify(BoardRequest boardRequest, Long boardNo) throws Exception {
        String title = boardRequest.getTitle();
        String content = boardRequest.getContent();
        String img = boardRequest.getImg();
        boardRepository.boardModifyAtTitle(title,boardNo);
        boardRepository.boardModifyAtcontent(content,boardNo);
           boardRepository.boardModifyAtimg(img,boardNo);
           }

@Override
public void DeleteBoard(Long boardNo) throws Exception {
        boardRepository.deleteById(boardNo);
        }

@Override
public List<Board> getTargetList(String target) throws Exception {
        return boardRepository.getTargetList(target);
        }
        }
