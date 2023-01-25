package mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import mybatis.vo.MemberVO;

public class MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
//	private SqlSessionFactory factory = null;		
//	private static MybatisConnector mc = null;
	
//	public MemberDAO() {
//		mc = new MybatisConnector();
//		factory = mc.getFactory();		
//	}
	
	public List<MemberVO> selectMembers() {
//		SqlSession sqlSession = factory.openSession();
		List<MemberVO> list = sqlSession.selectList("member.selectMembers");
		
//		sqlSession.close();
		
		return list;
	}
	
//	public MemberVO selectMember(String userId) {
//		SqlSession sqlSession = factory.openSession();
//		MemberVO mvo = sqlSession.selectOne("member.selectMember", userId);	// member-mapper에서 사용하는 파라미터와 동일해야 한다.
//		
//		sqlSession.close();
//		
//		return mvo;
//	}
	
	public MemberVO selectMember(MemberVO vo) {
//		SqlSession sqlSession = factory.openSession();
		MemberVO mvo = sqlSession.selectOne("member.selectMember", vo);	// member-mapper에서 사용하는 파라미터와 동일해야 한다.
		
//		sqlSession.close();
		
		return mvo;
	}
	
	public int insertMember(MemberVO mvo) {
//		SqlSession sqlSession = factory.openSession(false);	// auto commit을 진행하기 위해 true로 설정 (default는 false)
		int result = sqlSession.insert("member.insertMember", mvo);
		
//		sqlSession.commit();	// auto commit 해제 후 수동으로 commit 진행
//		sqlSession.close();
		
		return result;
	}
	
//	public int updateMember(MemberVO mvo) {
//		SqlSession sqlSession = factory.openSession(true);	// auto commit을 진행하기 위해 true로 설정 (default는 false)
//		int result = sqlSession.update("member.updateMember", mvo);
//		
//		sqlSession.close();
//		
//		return result;
//	}
	
	// type이 맞지 않는 경우 map 사용
	public int updateMember(Map<String, String> map) {
//		SqlSession sqlSession = factory.openSession(true);	// auto commit을 진행하기 위해 true로 설정 (default는 false)
		int result = sqlSession.update("member.updateMember", map);
		
//		sqlSession.close();
		
		return result;
	}
	
	public int deleteMember(String userId) {
//		SqlSession sqlSession = factory.openSession(true);
		int result = sqlSession.delete("member.deleteMember", userId);	// member-mapper에서 사용하는 파라미터와 동일해야 한다.
		
//		sqlSession.close();
		
		return result;
	}
}
