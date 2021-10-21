package com.esc.khweb.Service;

import com.esc.khweb.controller.request.BoardRequest;
import com.esc.khweb.entity.Board;

import java.util.List;
import java.util.Optional;

public interface BoardService {

    public  void boardRegister (BoardRequest boardRequest) throws  Exception;

    public List<Board> getBoardList () throws  Exception;

    public Optional<Board> getBoard(Long boardNo)throws  Exception;

    public void viewcount(Long boardNo) throws  Exception;

}
