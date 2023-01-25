package ioexample;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ScannerExT {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		FileOutputStream fos = null;
		
		try {
			fos = new FileOutputStream("src\\ioexample\\test", true);
			
			while(true) {
				String str = sc.next();
				if (str.equals("0")) {
					break;
				}
				fos.write(str.getBytes());
				fos.flush();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fos != null)
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if (sc != null) sc.close();
		}
	}

}
