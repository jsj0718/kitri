package spring.di.log;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

// <bean id="tsl" class="spring.di.log.TimeStampLog"/>
@Component("tsl")
public class TimeStampLog implements Log {
	@Override
	public void printLog(String msg) {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = sdf.format(now);
		
		System.out.println("[Log]"+time+"-"+msg);
	}
}
