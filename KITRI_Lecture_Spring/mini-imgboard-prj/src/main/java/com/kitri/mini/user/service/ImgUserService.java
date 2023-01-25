package com.kitri.mini.user.service;

import com.kitri.mini.user.vo.ImgUserVO;

public interface ImgUserService {
	public boolean loginCheckImgUser(ImgUserVO iuvo);
	public boolean registImgUser(ImgUserVO iuvo);
	public boolean idCheckImgUser(String id);
}
