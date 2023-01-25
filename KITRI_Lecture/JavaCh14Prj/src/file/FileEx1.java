package file;

import java.io.File;

public class FileEx1 {
	public static void main(String[] args) {
//		File file = new File("C:\\Users\\kitri\\Desktop\\filetest\\String����.txt");		
//		File file = new File("src"+File.separator+"file"+File.separator+"String����.txt");	// File.separator�� �� ����� �����ڸ� �߰���
		
//		File file = new File("src\\file\\test2.txt");
//		System.out.println("���ϸ�: " + file.getName());
//		System.out.println("���� ���: " + file.getPath());
//		System.out.println("���� ���� ���: " + file.getAbsolutePath());
//		System.out.println("������ �θ� ���丮 ���: " + file.getParent());
		
		try {
//			// ���� ���� Ȯ�� 
//			if (file.exists()) {
//				System.out.println("���� ���� ����: ���� ����");
//			} else {				
//				// ���� ����
//				file.createNewFile();
//			}
			
			File dir = new File("C:\\Users\\kitri\\Desktop\\filetest");
			if(!dir.isFile()) {
				System.out.println("���� X");
			} else if (dir.isDirectory()) {
				System.out.println("���丮�̴�.");
			}
			
			File[] files = dir.listFiles();
			
			for(File file : files) {
				if(file.isFile()) {
					System.out.println("���ϸ�: " + file.getName());					
				} else {
					System.out.println("���丮��: " + file.getName());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
