package interf;

public class BusinessUser extends UserClass implements InfoMenu {

	@Override
	public void userInfo() {
		System.out.println("사업자 계정 정보");
	}

}
