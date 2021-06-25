package bytestream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class ByteStreamEx1 {
	public static void main(String[] args) {
		byte[] bArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
//		콘솔용 스트림
//		System.out.println(bArr[0]);
//		System.out.println(bArr[1]);
		
		ByteArrayInputStream bis = new ByteArrayInputStream(bArr);
		
		int data = 0;
//		while ((data = bis.read()) != -1) {
//			System.out.println(data);			
//		}

		byte[] bOutArr = new byte[10];	// 다른 PC
		
		// 1byte out
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		int outData = bOutArr[0];
		bos.write(outData);
		
		bOutArr = bos.toByteArray();
		System.out.println(bArr[0]);
		
//		pc output --> input pc1   output --> input pc2
		
		for(int i=0; i<bArr.length; i++) {
			outData = bArr[i];
			bos.write(outData);
		}
		
		bOutArr = bos.toByteArray();
		
		System.out.println(bOutArr[0]);
		for (int i=0; i<bOutArr.length; i++) {
			System.out.println(bOutArr[i]);
		}
	}
}
