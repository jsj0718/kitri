package polymorphism2;

public class MeetingBoard extends Board {
	String meeting;
	
	@Override
	void select() {
		System.out.println("미팅 게시판 조회");
	}
}
