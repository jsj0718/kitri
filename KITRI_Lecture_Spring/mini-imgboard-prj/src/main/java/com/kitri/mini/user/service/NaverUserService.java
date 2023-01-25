package com.kitri.mini.user.service;

import com.kitri.mini.user.vo.NaverUserVO;

public interface NaverUserService {
	public NaverUserVO searchNaverUser(String email);
	public int registNaverUser(NaverUserVO nuvo);
}
