package kr.re.kitri.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@WebServlet("/ajax-server")
public class AjaxServer extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청에 대한 응답 (데이터 보내는 중)
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("ajax를 통한 통신 데이터");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		
		// {id : "admin", name : "name"}
		JsonObject json1 = new JsonObject();
		json1.addProperty("id", id);
		json1.addProperty("name", name);
		
		// {id : "user", name : "정대만"} 
		JsonObject json2 = new JsonObject();
		json2.addProperty("id", "user");
		json2.addProperty("name", "정대만");
		
		// [{id : "admin", name : "name"}, {id : "user", name : "정대만"}]
		JsonArray jsonArr = new JsonArray();
		jsonArr.add(json1);
		jsonArr.add(json2);
		
		Gson gson = new Gson();
		String jsonResponse = gson.toJson(jsonArr);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(jsonResponse);
		
	}

}
