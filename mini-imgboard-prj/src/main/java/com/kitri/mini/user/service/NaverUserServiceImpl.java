package com.kitri.mini.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitri.mini.user.dao.NaverUserDAO;
import com.kitri.mini.user.vo.NaverUserVO;

@Service
public class NaverUserServiceImpl implements NaverUserService {
	@Autowired
	private NaverUserDAO nudao;	// VisitorDAO와 VisitorDAOImpl을 자동 주입
	
	@Override
	public NaverUserVO searchNaverUser(String email) {
		return nudao.selectNaverUser(email);
	}

	@Override
	public int registNaverUser(NaverUserVO nuvo) {
		return nudao.insertNaverUser(nuvo);
	}

}
