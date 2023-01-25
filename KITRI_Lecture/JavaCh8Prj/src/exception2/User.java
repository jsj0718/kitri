package exception2;

public class User {

	static Account myAccount = new Account();
	public static void main(String[] args) {
		/*
		 * 1. 카드를 ATM에 넣기
		 * 2. 인출버튼
		 * 3. 금액입력
		 * 4. 비밀번호 입력
		 * 	(yes) 4-1. 5번으로 넘어감
		 * 	 (no) 4-2. "비밀번호가 잘못 입력되었습니다." 출력
		 * 
		 * 	5. 계좌에 돈이 있는지 확인 
		 * 	(yes) 5-1-1. 계좌에서 인출금액 차감
		 *        5-1-2. 돈을 현금입출기에서 받기	// 예외 발생 (ATM에 돈이 없음)
		 * 	 (no) 5-2-1. "돈이 없습니다." 출력
		 * 6. 카드 돌려받기
		 */
		
		int money = 1000;
		try {
			System.out.println("카드를 ATM기에 넣기");
			System.out.println("인출버튼 클릭");
			System.out.println("금액 입력");
			System.out.println("비밀번호 입력");
			System.out.println("계좌에서 인출금액 차감");
			User user = new User();
			user.withdraw(money);	// 계좌에서 차감
			
			System.out.println("돈을 현금인출기에서 받기");
			int myMoney = user.getMoney(money);
			System.out.println("내 돈 : " + myMoney);
		} catch(Exception e) {
			System.out.println("예외 발생");
		myAccount.money = myAccount.money + money;
			System.out.println("내 계좌 : "+myAccount.money);
		} finally {
			System.out.println("카드 돌려받기");				
		}
		
	}
	
	public void withdraw(int money) {
		myAccount.money -= money;
		System.out.println("내 계좌: " + myAccount.money);
	}
	
	int atmMoney = 10000;
	public int getMoney(int money) throws Exception {
		atmMoney -= money;
		if (atmMoney < 0) {
			throw new Exception();
		}
		System.out.println("ATM: " + atmMoney);
		return money;
	}
}
