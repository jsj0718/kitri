package kr.re.kitri.memo.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import kr.re.kitri.memo.dao.MemoDAO;
import kr.re.kitri.memo.vo.MemoJson;
import kr.re.kitri.memo.vo.MemoVO;

@WebServlet("/index")
public class IndexController extends HttpServlet {       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		if (id == null) {
			// 로그인 안한 상태
			response.sendRedirect(request.getContextPath() + "/member/login");
		} else {
			// 로그인 상태
			MemoDAO mdao = new MemoDAO();
			ArrayList<MemoVO> mlist = mdao.allMemo(id);
			ArrayList<MemoJson> mjlist = new ArrayList<>();
			
			for (MemoVO mvo : mlist) {
				MemoJson mj = new MemoJson();
				mj.setId(mvo.getNo());
				mj.setTitle(mvo.getTitle());
				mj.setStart(String.valueOf(mvo.getMdate()));
				mj.setDescription(mvo.getMemo());
				
				mjlist.add(mj);
			}
			
			// List를 JSON 형태로 바꿔주는 라이브러리
			Gson gson = new Gson();		
			String json = gson.toJson(mjlist);
			
			request.setAttribute("mjson", json);
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/index.jsp");
			rd.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
