package spring.aop.board;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("spring/aop/config/board-aop-config.xml");
		ctx.refresh();
		
		BoardDAO bdao = ctx.getBean("boardDAO", BoardDAO.class);
		
		bdao.selectBoard();
		bdao.insertBoard(1);
		bdao.updateBoard(1, "¹«¾ßÈ£");
		bdao.deleteBoard(1);
		
		ctx.close();
	}
}
