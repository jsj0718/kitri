package date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateClass {
	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf = new SimpleDateFormat("yy³â MM¿ù ddÀÏ HH:mm:ss");
		System.out.println(sdf.format(now));
		
	}
}
