package com.kitri.mini.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitri.mini.user.dao.ImgUserDAO;
import com.kitri.mini.user.vo.ImgUserVO;

@Service
public class ImgUserServiceImpl implements ImgUserService {
	@Autowired
	private ImgUserDAO iudao;	// VisitorDAO와 VisitorDAOImpl을 자동 주입
	
	@Override
	public boolean loginCheckImgUser(ImgUserVO iuvo) {
		ImgUserVO vo = iudao.selectImgUser(iuvo);
		if (vo == null) {
			return false;			
		}
		return true;
	}

	@Override
	public boolean registImgUser(ImgUserVO iuvo) {
		int result = iudao.insertImgUser(iuvo);
		if (result != 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean idCheckImgUser(String id) {
		int result = iudao.selectIdCheck(id);
		
		if (result == 0) {
			return true;
		}
		return false;
	}
}
