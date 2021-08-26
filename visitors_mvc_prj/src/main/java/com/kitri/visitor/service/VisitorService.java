package com.kitri.visitor.service;

import java.util.ArrayList;

import com.kitri.visitor.vo.VisitorVO;

public interface VisitorService {
	public ArrayList<VisitorVO> searchVisitors();
	public int registVisitor(VisitorVO vvo);
	public int updateVisitor(VisitorVO vvo);
	public int deleteVisitor(VisitorVO vvo);
}
