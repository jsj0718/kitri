package substream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedStreamEx {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			fis = new FileInputStream("C:\\Users\\kitri\\Desktop\\수업\\java 수업 내용\\JAVA 14.pdf");			
			fos = new FileOutputStream("src\\substream\\JAVA 14.pdf");

			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			
			int data = 0;
			long start = System.currentTimeMillis();
			while ((data = bis.read()) != -1) {
//				System.out.print((char) data);
				bos.write(data);
			}
			bos.flush();
			long end = System.currentTimeMillis();
			
			System.out.println();
			System.out.println("소요시간: " + (end - start));
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			if (fis != null) fis.close();
			if (fos != null) fos.close();
			if (bis != null) bis.close();
			if (bos != null) bos.close();
		}
	}
}
