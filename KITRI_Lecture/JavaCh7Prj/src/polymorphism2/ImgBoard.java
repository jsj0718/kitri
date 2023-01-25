package polymorphism2;

public class ImgBoard extends Board {
	String img;
	
	@Override
	void select() {
		System.out.println("Image 게시판 조회");
	}
}
