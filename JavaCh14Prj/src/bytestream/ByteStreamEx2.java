package bytestream;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ByteStreamEx2 {
	public static void main(String[] args) throws IOException {
		// read()	- 1바이트 읽어서 실제 1바이트 데이터를 반환
		// 예) 1234  --> read() 결과값은 1 / 2 / 3 / 4
		
		// read(바이트배열)	- 바이트배열 크기만큼 읽어서 읽은 실제 데이터의 크기를 반환
		// 예) 4444  --> (바이트배열의 크기가 3이면) read 결과값은 크기인 3이 반환
		// 또한 바이트배열이 byte[] b라고하면 b = {4, 4, 4}인 상태
		
		// read(바이트배열, 시작위치, 읽을크기)	- 바이트배열을 시작위치에서 읽을크기만큼 읽어서 실제 데이터 크기를 반환
		// 예) 1235  --> (바이트배열의 크기가 4, 시작위치 0, 읽을 크기 2)
		// read 결과값은 읽을 크기의 실제 데이터 크기를 반환
		// 바이트 배열이 byte[] b라고 하면 b = {1, 2}가 실려있음
		
		byte[] bArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		ByteArrayInputStream bis = new ByteArrayInputStream(bArr);
		
		byte[] buf = new byte[4];
//		System.out.println(bis.read(buf));	// 바이트배열 크기 출력(4)
//		System.out.println(bis.read(buf));	// 바이트배열 크기 출력(4)
//		System.out.println(bis.read(buf));	// 바이트배열 크기 출력(2)
//		System.out.println(bis.read());		// 바이트배열 값 출력
		
		int size = 0;
//		while((size = bis.read(buf)) != -1) {
//			for(int i=0; i<buf.length; i++) {
//				System.out.println(buf[i]);				
//			}
//		}
		
//		System.out.println(bis.read(buf, 0, 4));	// buf = {1234}
//		System.out.println(bis.read(buf, 0, 4));	// buf = {5678}
//		System.out.println(bis.read(buf, 0, 2));	// buf = {9 10}
//		System.out.println(bis.read(buf, 0, ));		// buf = {10}
		
		size = buf.length;
		
		// 값이 실린만큼만 반복
		while((size = bis.read(buf, 0, size)) != -1) {
			for(int i=0; i < size; i++) {
				System.out.println(buf[i]);
			}
		}
		
		
		
		
	}
}
