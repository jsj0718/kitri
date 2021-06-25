package ioexample;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ScannerEx {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		FileOutputStream fos = new FileOutputStream("src\\ioexample\\test", true);
		
		String str = sc.nextLine();
		fos.write(str.getBytes());
		
		sc.close();	
		fos.close();
	}
}
