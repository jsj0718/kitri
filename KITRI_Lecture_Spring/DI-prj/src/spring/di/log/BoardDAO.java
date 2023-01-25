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
	
	// 생성자 함수 주입
	public BoardDAO(Log l) {
		this.l = l;
	}
	
	// setter 주입
	public void setL(Log l) {
		this.l = l;
	}

	public void selectBoard() {
		l.printLog("게시판 글 조회");
	}
	
	public void insertBoard() {
		l.printLog("게시판 글 등록");
	}
}
