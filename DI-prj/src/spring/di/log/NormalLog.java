package spring.di.log;

import org.springframework.stereotype.Component;

// <bean id="nl" class="spring.di.log.NormalLog"/>
@Component("nl")
public class NormalLog implements Log {
	@Override
	public void printLog(String msg) {
		System.out.println("[Log]" + msg);
	}
}
