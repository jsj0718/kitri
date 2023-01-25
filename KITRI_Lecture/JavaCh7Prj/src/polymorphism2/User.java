package polymorphism2;

public class User {
	static void read(Board board) {
		board.select();
	}
	
	public static void main (String args[]) {
		read(new Board());
		read(new ImgBoard());
		read(new QnaBoard());
		read(new MeetingBoard());
	}
}
