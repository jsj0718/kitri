package spring.aop.board;

import org.springframework.stereotype.Component;

@Component
public class BoardDAO {
	public void selectBoard() {
		System.out.println("게시판 글 조회");
	}
	
	public void insertBoard(int bno) {
		System.out.println("게시판 글 " + bno + " 등록");
	}
	
	public void updateBoard(int bno, String update) {
		System.out.println("게시판 글 " + bno + " 내용: " + update + " 수정");
	}
	
	public void deleteBoard(int bno) {
		System.out.println("게시판 글 " + bno + " 삭제");
	}
}
