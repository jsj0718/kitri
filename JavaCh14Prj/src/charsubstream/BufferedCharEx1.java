package charsubstream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedCharEx1 {
	public static void main (String[] args) {
		FileReader fr = null;
		FileWriter fw = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader("src\\charstream\\book.txt");
			br = new BufferedReader(fr);

//			fw = new FileWriter("src\\charstream\\book.txt");
			
			String str = "";
			while ((str = br.readLine()) != null) {
				System.out.println(str);				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
