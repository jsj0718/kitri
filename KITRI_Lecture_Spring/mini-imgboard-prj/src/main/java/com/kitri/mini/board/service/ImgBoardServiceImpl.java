package com.kitri.mini.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitri.mini.board.dao.ImgBoardDAO;
import com.kitri.mini.board.vo.ImgBoardVO;

@Service
public class ImgBoardServiceImpl implements ImgBoardService {
	@Autowired
	private ImgBoardDAO ibdao;
	
	@Override
	public List<ImgBoardVO> searchImgBoards(Map<String, String> map) {

		return ibdao.selectImgBoards(map);
	}

	@Override
	public boolean registImgBoard(ImgBoardVO ibvo) {
		int result = ibdao.insertImgBoard(ibvo);
		if (result != 0) {
			return true;
		}
		return false;
	}

}
