package com.kitri.mini.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.kitri.mini.board.service.ImgBoardService;
import com.kitri.mini.board.vo.ImgBoardVO;

@RequestMapping("/main")
@Controller
public class MainController {
	@Autowired
	ImgBoardService ibservice;
	
	@RequestMapping("")
	public String main(Model model, Map<String, String> map) {
		
		map.put("start", "1");
		map.put("end", "9");
		
		List<ImgBoardVO> ibList = ibservice.searchImgBoards(map);
		model.addAttribute("ibList", ibList);
		
		return "main";
	}
	
	@RequestMapping("/imgboard-regist-page")
	public String imgboardRegist() {
		
		return "imgboard-regist";
	}
	
	// MultipartFile의 변수명은 form에서 넘어오는 파라미터와 같아야 한다.
	@RequestMapping("/imgboard-regist")
	public String fileUpload(MultipartFile uploadfile, String content, HttpServletRequest req, HttpSession session) {
		// uploadPath는 배포하는 환경마다 달라지므로 realPath를 이용하는 것이 좋다.
//			String uploadPath = "C:\\java_study\\spring_workspace\\fileupload-download-prj\\src\\main\\webapp\\uploadfolder";
		String id = (String) session.getAttribute("id");
		String uploadPath = req.getRealPath("uploadfolder");	// web 경로로 보기 때문에 webapp 바로 아래부터 경로가 시작된다.
		String saveName = uploadfile.getOriginalFilename();
		String uploadUniquePath = uploadPath + File.separator + id;
		
		boolean uploadConfirm = false;
		boolean registFlag = false;
		try {
			File idFile = new File(uploadUniquePath);
			
			if(!idFile.exists()) {
				idFile.mkdir();
			}
			File saveFile = new File(idFile, saveName);
			
			uploadfile.transferTo(saveFile);
			uploadConfirm = true;
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (uploadConfirm) {
			ImgBoardVO ibvo = new ImgBoardVO();
			
			ibvo.setUserid(id);
			ibvo.setContent(content);
			
			// upload/id/file명 (upload/admin/a.jpg)
			String insertImgPath = File.separator + "upload" + File.separator + id + File.separator + saveName;
			
			ibvo.setImg(insertImgPath);
			
			registFlag = ibservice.registImgBoard(ibvo);
		}
		
		if (registFlag) {
			return "redirect:/main";
		}
		
		return "redirect:/main/imgboard-regist";
	}
	
	@RequestMapping("/morelist")
	@ResponseBody
	public List<ImgBoardVO> moreList(String start, String end, Map<String, String> map) {
		map.put("start", start);
		map.put("end", end);
		
		List<ImgBoardVO> ibList = ibservice.searchImgBoards(map);
		
		return ibList;
	}
}
