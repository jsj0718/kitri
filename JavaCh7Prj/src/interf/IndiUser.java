package interf;

public class IndiUser extends UserClass implements InfoMenu {

	// @Override는 오버라이딩이 제대로 되었는지 확인
	@Override
	public void userInfo() {
		System.out.println("개인 계정 정보");
	}

}
