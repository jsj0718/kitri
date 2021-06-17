package forandwhile;

import java.util.Scanner;

public class RandomEx1 {

	public static void main(String[] args) {
		
		// 랜덤값 하나를 받고, 그 값을 맞추는 게임
		int random = (int)(Math.random() * 30) + 1;	// 1~30
		Scanner sc = new Scanner(System.in);
		
		int count = 0;
		System.out.println("랜덤값을 맞추세요!");
		while (true) {
			System.out.print("입력: ");
			int input = sc.nextInt();
			
			count++;
			if (input < random) {
				System.out.println("up");
			} else if (input > random) {
				System.out.println("down");
			} else {
				System.out.println(input + " 값을 찾았습니다.");
				break;
			}
		}
		
		System.out.println(count + "번만에 찾았습니다.");
		
		sc.close();
	}

}
