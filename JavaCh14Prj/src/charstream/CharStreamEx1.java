package charstream;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharStreamEx1 {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileReader fr = null;
		FileWriter fw = null;
		
		try {
			fis = new FileInputStream("src\\charstream\\book.txt");
			fr = new FileReader("src\\charstream\\book.txt");
			fw = new FileWriter("C:\\Users\\kitri\\Desktop\\book.txt");
			
			int len = 0;
			byte[] buf = new byte[1024];	// buffer에 실으면 한글을 읽을 수 있다. (단 크기가 넘어가면 다시 깨진다.)
			while((len = fis.read(buf)) != -1) {
				System.out.print(new String(buf, 0, len));
			}
			System.out.println("\n------------------------");
			
			int data = 0;
			while ((data = fr.read()) != -1) {
				fw.write((char) data);
			}
			
			fw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
}
