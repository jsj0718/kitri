package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.di.log.BoardDAO;
import spring.di.log.Log;
import spring.di.log.NormalLog;
import spring.di.log.TimeStampLog;

@Configuration
public class BoardConfig {
	@Bean
	public BoardDAO bdao() {
		// setter ���
		BoardDAO bdao = new BoardDAO();
		bdao.setL(log());
		return bdao;
		
		// ������ �Լ� ���
//		return new BoardDAO(log());
	}
	
//	@Bean
//	public Log log() {
//		return new NormalLog();
//	}
	
	@Bean
	public Log log() {
		return new TimeStampLog();
	}
}
