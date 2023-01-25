package mybatis.main;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import mybatis.dao.MemberDAO;
import mybatis.vo.MemberVO;

public class MainClass {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("mybatis/config/context.xml");
		MemberDAO mdao = ctx.getBean("memberDAO", MemberDAO.class);
		
//		MemberDAO mdao = new MemberDAO();

		// 전체 유저 조회
		List<MemberVO> mlist = mdao.selectMembers();
		
		for (MemberVO mvo : mlist) {
//			System.out.println(mvo.getUserId() + ", " + mvo.getUserPw() + ", " + mvo.getEmail());
			System.out.println(mvo.getId() + ", " + mvo.getPw() + ", " + mvo.getEmail());
		}
		
		ctx.close();
		
		// 한 유저 조회
//		MemberVO vo = new MemberVO();
//		vo.setId("admin");
//		vo.setPw("qwer1");
//		MemberVO mvo = mdao.selectMember(vo);
//		System.out.println(mvo.getUserId() + ", " + mvo.getUserPw() + ", " + mvo.getEmail());
//		System.out.println(mvo.getId() + ", " + mvo.getPw() + ", " + mvo.getEmail());

		
		// 유저 정보 insert
//		MemberVO mvo = new MemberVO();
//		mvo.setUserId("qwer12345");
//		mvo.setUserPw("123");
//		mvo.setEmail("qwer1234@naver.com");
//		System.out.println(mdao.insertMember(mvo));
		
		// 유저 정보 update
//		MemberVO mvo = new MemberVO();
//		mvo.setUserId("admin");
//		mvo.setUserPw("test");
//		mvo.setEmail("test@naver.com");
//		System.out.println(mdao.updateMember(mvo));
		
		// HashMap으로 정보를 받아서 update 진행 (db와 컬럼명이 다른 경우 사용)
//		HashMap<String, String> map = new HashMap<>();
//		map.put("id", "admin");
//		map.put("pw", "qwer");
//		map.put("email", "admin@gmail.com");
//		System.out.println(mdao.updateMember(map));
		
		// 유저 정보 delete
//		System.out.println(mdao.deleteMember("qwer1234"));
	}
}
