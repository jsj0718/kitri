package interf;

public class IndiUser extends UserClass implements InfoMenu {

	// @Override�� �������̵��� ����� �Ǿ����� Ȯ��
	@Override
	public void userInfo() {
		System.out.println("���� ���� ����");
	}

}
