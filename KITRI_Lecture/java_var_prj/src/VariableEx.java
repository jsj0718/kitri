
public class VariableEx {

	public static void main(String[] args) {
		String name = "정세진";
		int age = 27;
		int height = 176;
		String univercity = "한국산업기술대";
		String address = "경기도 시흥";
		String phone = "01092878039";
		
		System.out.printf("자기 소개 \n"
				+ "- 이름 \t: %s \n"
				+ "- 나이 \t: %d \n"
				+ "- 키 \t: %d \n"
				+ "- 학교 \t: %s \n"
				+ "- 주소 \t: %s \n"
				+ "- 번호 \t: %s \n"
				+ "- 인사말 \t: 안녕하세요.",
				name, age, height, univercity, address, phone);
	}

}
