package file;

import java.io.File;

public class FileEx1 {
	public static void main(String[] args) {
//		File file = new File("C:\\Users\\kitri\\Desktop\\filetest\\String문제.txt");		
//		File file = new File("src"+File.separator+"file"+File.separator+"String문제.txt");	// File.separator는 각 경로의 구분자를 추가함
		
//		File file = new File("src\\file\\test2.txt");
//		System.out.println("파일명: " + file.getName());
//		System.out.println("파일 경로: " + file.getPath());
//		System.out.println("파일 절대 경로: " + file.getAbsolutePath());
//		System.out.println("파일의 부모 디렉토리 경로: " + file.getParent());
		
		try {
//			// 파일 유무 확인 
//			if (file.exists()) {
//				System.out.println("파일 존재 여부: 파일 존재");
//			} else {				
//				// 파일 생성
//				file.createNewFile();
//			}
			
			File dir = new File("C:\\Users\\kitri\\Desktop\\filetest");
			if(!dir.isFile()) {
				System.out.println("파일 X");
			} else if (dir.isDirectory()) {
				System.out.println("디렉토리이다.");
			}
			
			File[] files = dir.listFiles();
			
			for(File file : files) {
				if(file.isFile()) {
					System.out.println("파일명: " + file.getName());					
				} else {
					System.out.println("디렉토리명: " + file.getName());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
