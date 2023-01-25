package spring.di.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("bdao")
public class BoardDAO {
	@Autowired
	@Qualifier("tsl")
	private Log l;
	
	public BoardDAO() {}
	
	// ������ �Լ� ����
	public BoardDAO(Log l) {
		this.l = l;
	}
	
	// setter ����
	public void setL(Log l) {
		this.l = l;
	}

	public void selectBoard() {
		l.printLog("�Խ��� �� ��ȸ");
	}
	
	public void insertBoard() {
		l.printLog("�Խ��� �� ���");
	}
}
