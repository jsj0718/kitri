package com.kitri.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class FileController {

	@RequestMapping("/fileuploadpage")
	public String fileUploadPage() {
		
		return "file-upload-page";
	}
	
	@RequestMapping("/multifileuploadpage")
	public String multiFileUploadPage() {
		
		return "multifile-upload-page";
	}
	
	@RequestMapping("/filedownloadpage")
	public String fileDownloadPage() {
		
		return "download";
	}
	
	// MultipartFile의 변수명은 form에서 넘어오는 파라미터와 같아야 한다.
	@RequestMapping("/fileupload")
	public void fileUpload(MultipartFile uploadfile, HttpServletRequest req) {
		// uploadPath는 배포하는 환경마다 달라지므로 realPath를 이용하는 것이 좋다.
//		String uploadPath = "C:\\java_study\\spring_workspace\\fileupload-download-prj\\src\\main\\webapp\\uploadfolder";
		String uploadPath = req.getRealPath("uploadfolder");	// web 경로로 보기 때문에 webapp 바로 아래부터 경로가 시작된다.
		System.out.println(uploadPath);
		String saveName = uploadfile.getOriginalFilename();
		System.out.println("파일명: " + saveName);
		
		File saveFile = new File(uploadPath, saveName);
//		File saveFile = new File(uplaodPath + "/" + saveName);
		
		
		try {
			uploadfile.transferTo(saveFile);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping("/multifileupload")
	public void multiFileUpload(MultipartHttpServletRequest multipart, HttpServletRequest req) {
		List<MultipartFile> fileList = multipart.getFiles("uploadfile");
		String uploadPath = req.getRealPath("uploadfolder");
		for (MultipartFile file : fileList) {
			// input file에서 선택한 파일명
			String originalFileName = file.getOriginalFilename();
			
			File saveFile = new File(uploadPath, System.currentTimeMillis() + "_" + originalFileName);
			
			try {
				file.transferTo(saveFile);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@RequestMapping("filedownload")
	public void fileDownload(String filename, HttpServletRequest req, HttpServletResponse res) {
		String uploadFolder = req.getRealPath("uploadfolder");
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			// response 응답 설정
			res.setContentType("application/octet-stream");
			res.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(filename, "utf-8"));	// filename 한글 깨짐을 방지하여 encoding 진행
			
			// stream을 이용한 서버 -> 클라이언트 file 다운
			bis = new BufferedInputStream(new FileInputStream(uploadFolder+File.separator+filename));
			bos = new BufferedOutputStream(res.getOutputStream());
			
			byte[] b = new byte[4096];
			int num = 0;
			
			while ((num = bis.read(b, 0, b.length)) != -1) {
				bos.write(b, 0, num);
			}
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bos.close();
				bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		

	}
	
}
