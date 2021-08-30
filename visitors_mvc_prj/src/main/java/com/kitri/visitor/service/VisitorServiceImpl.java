package com.kitri.visitor.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.kitri.visitor.dao.VisitorDAO;
import com.kitri.visitor.vo.VisitorVO;

// Service용 Component
// Service 단위로 하나의 Transaction으로 잡는다.
@Service
public class VisitorServiceImpl implements VisitorService {
	@Autowired
	private VisitorDAO vdao;	// VisitorDAO와 VisitorDAOImpl을 자동 주입
	
	// transaction 단위로 commit 또는 rollback 처리
	@Autowired
	PlatformTransactionManager transactionManager;
	
	@Override
	public List<VisitorVO> searchVisitors() {
		return vdao.selectVisitors();
	}
	
	@Override
	public VisitorVO searchVisitor(VisitorVO vvo) {
		return vdao.selectVisitor(vvo);
	}

	@Override
	public int registVisitor(VisitorVO vvo) {
		
		// 방법 1 (TransactionManager 직접 이용)
		TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
		
		try {
			vdao.insertVisitor(vvo);
			vvo.setVno(29);
			vvo.setContent("내용 수정");
			
			System.out.println(0/0);
			
			vdao.updateVisitor(vvo);
			transactionManager.commit(status);	// 모든 작업 성공 시 commit
		} catch (Exception e) {
			e.printStackTrace();
			transactionManager.rollback(status);	// 작업 실패 시 rollback
		}
		
		return 0;
		
//		return vdao.insertVisitor(vvo);
	}

	@Override
	public int updateVisitor(VisitorVO vvo) {
		return vdao.updateVisitor(vvo);
	}

	@Override
	public int deleteVisitor(int vno) {
		return vdao.deleteVisitor(vno);
	}

}
