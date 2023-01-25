package bytestream;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ByteStreamEx2 {
	public static void main(String[] args) throws IOException {
		// read()	- 1����Ʈ �о ���� 1����Ʈ �����͸� ��ȯ
		// ��) 1234  --> read() ������� 1 / 2 / 3 / 4
		
		// read(����Ʈ�迭)	- ����Ʈ�迭 ũ�⸸ŭ �о ���� ���� �������� ũ�⸦ ��ȯ
		// ��) 4444  --> (����Ʈ�迭�� ũ�Ⱑ 3�̸�) read ������� ũ���� 3�� ��ȯ
		// ���� ����Ʈ�迭�� byte[] b����ϸ� b = {4, 4, 4}�� ����
		
		// read(����Ʈ�迭, ������ġ, ����ũ��)	- ����Ʈ�迭�� ������ġ���� ����ũ�⸸ŭ �о ���� ������ ũ�⸦ ��ȯ
		// ��) 1235  --> (����Ʈ�迭�� ũ�Ⱑ 4, ������ġ 0, ���� ũ�� 2)
		// read ������� ���� ũ���� ���� ������ ũ�⸦ ��ȯ
		// ����Ʈ �迭�� byte[] b��� �ϸ� b = {1, 2}�� �Ƿ�����
		
		byte[] bArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		ByteArrayInputStream bis = new ByteArrayInputStream(bArr);
		
		byte[] buf = new byte[4];
//		System.out.println(bis.read(buf));	// ����Ʈ�迭 ũ�� ���(4)
//		System.out.println(bis.read(buf));	// ����Ʈ�迭 ũ�� ���(4)
//		System.out.println(bis.read(buf));	// ����Ʈ�迭 ũ�� ���(2)
//		System.out.println(bis.read());		// ����Ʈ�迭 �� ���
		
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
		
		// ���� �Ǹ���ŭ�� �ݺ�
		while((size = bis.read(buf, 0, size)) != -1) {
			for(int i=0; i < size; i++) {
				System.out.println(buf[i]);
			}
		}
		
		
		
		
	}
}
