package abs;

public class Main {

	public static void main(String[] args) {
		BusinessUser bu = new BusinessUser();
		IndiUser iu = new IndiUser();
		Guest guest = new Guest();
		
		bu.setName("키트리");
		bu.setAddress("구로");
		bu.setEmail("daeman@naver.com");
		bu.setBusinessNumber("123456789");
		
		iu.setName("키트리");
		iu.setAddress("구로");
		iu.setEmail("daeman@naver.com");
		iu.setRegisterNumber("122122-2133345");
		
		guest.setName("키트리");
		guest.setAddress("구로");
		guest.setEmail("daeman@naver.com");
		guest.setNickName("자바 강사");
	}

}
