package spring.di.log;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class User {
	public static void main(String[] args) {
		// xml 파일은 경로를 찾아줘야 한다.
		AbstractApplicationContext context = new GenericXmlApplicationContext("config/board-config.xml");

		// java 파일은 컴파일된 class 파일을 찾아줘야 한다.
//		AbstractApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);

		BoardDAO bdao = context.getBean("bdao", BoardDAO.class);
		
		bdao.insertBoard();
		bdao.selectBoard();
		
		context.close();
		
	}
}
