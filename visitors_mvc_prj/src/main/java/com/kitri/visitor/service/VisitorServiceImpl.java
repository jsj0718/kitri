package com.kitri.visitor.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitri.visitor.dao.VisitorDAO;
import com.kitri.visitor.vo.VisitorVO;

// Service용 Component
@Service
public class VisitorServiceImpl implements VisitorService {
	@Autowired
	private VisitorDAO vdao;	// VisitorDAO와 VisitorDAOImpl을 자동 주입
	
	@Override
	public ArrayList<VisitorVO> searchVisitors() {
		return vdao.selectVisitors();
	}

	@Override
	public int registVisitor(VisitorVO vvo) {
		return 0;
	}

	@Override
	public int updateVisitor(VisitorVO vvo) {
		return 0;
	}

	@Override
	public int deleteVisitor(VisitorVO vvo) {
		return 0;
	}

}
