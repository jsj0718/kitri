package polymorphism2;

public class QnaBoard extends Board {
	String answer;
	
	@Override
	void select() {
		System.out.println("QNA 게시판 조회");
	}
}
