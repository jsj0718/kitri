package spring.di.log;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class User {
	public static void main(String[] args) {
		// xml ������ ��θ� ã����� �Ѵ�.
		AbstractApplicationContext context = new GenericXmlApplicationContext("config/board-config.xml");

		// java ������ �����ϵ� class ������ ã����� �Ѵ�.
//		AbstractApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);

		BoardDAO bdao = context.getBean("bdao", BoardDAO.class);
		
		bdao.insertBoard();
		bdao.selectBoard();
		
		context.close();
		
	}
}
