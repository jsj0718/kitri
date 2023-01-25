package bytestream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamEx3 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("src\\bytestream\\test");
		FileOutputStream fos = new FileOutputStream("src\\byteStream\\test1", true);
//		System.out.println((char)fis.read());
		
//		int data = 0;
		int size = 0;
		byte[] buf = new byte[8];
		
		while ((size = fis.read(buf)) != -1) {
			fos.write(buf, 0, size);
		}
		
		fis.close();
		fos.close();
	}
}
