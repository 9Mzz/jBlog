package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.BlogDao;
import com.javaex.dao.CategoryDao;
import com.javaex.vo.BlogVo;
import com.javaex.vo.CategoryVo;
import com.javaex.vo.PostVo;

@Service
public class BlogService {

	@Autowired
	BlogDao blogDao;
	@Autowired
	CategoryDao categoryDao;

	// 블로그 메인
	public Map<String, Object> getBlog(String id) {
		System.out.println("[BlogService.getBlog]");
		Map<String, Object> bMap = new HashMap<String, Object>();

		// 블로그
		BlogVo blogVo = blogDao.getBlog(id);
		bMap.put("blogVo", blogVo);

		// 카테고리
		List<CategoryVo> categoryList = categoryDao.getCategory(id);
		bMap.put("categoryList", categoryList);

		return bMap;
	}

	// 카테고리 리스트 가져오기
	public List<CategoryVo> getList(String id) {
		System.out.println("[BlogService.getList]");
		return categoryDao.getCategory(id);
	}

	// 카테고리 선택시 포스트
	public List<PostVo> getPost(CategoryVo categoryVo) {
		System.out.println("[BlogService.getPost]");

		// postDao.getPostList();
		return null;
	}

	// 블로그 헤더 정보
	public BlogVo getHeader(String id) {
		System.out.println("[BlogService.getHeader]");
		return blogDao.getBlog(id);
	}

	// 블로그 정보 수정
	public void updateBlog(BlogVo blogVo, MultipartFile file) {
		System.out.println("[BlogService.updateBlog]");
		String saveDir = "/Users/hs/JavaStudy/upload/";

		// 원본파일이름
		String orgName = file.getOriginalFilename();

		// 확장자
		String exName = orgName.substring(orgName.lastIndexOf("."));

		// 저장파일이름
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;

		// 파일패스 생성
		String filePath = saveDir + saveName;

		// 파일 사이즈
		long fileSize = file.getSize();// long

		// 파일 저장
		try {
			byte[] fileData = file.getBytes();
			OutputStream out = new FileOutputStream(filePath);// 어떤 경로에 파일을 저장할건지?
			BufferedOutputStream bout = new BufferedOutputStream(out);

			bout.write(fileData);
			bout.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		blogVo.setLogoFile(saveName);

		blogDao.update(blogVo);
	}

	// 카테고리 관리
	public List<CategoryVo> getCategory(String id) {
		System.out.println("[BlogService.getCategory]");

		// 카테고리
		List<CategoryVo> categoryList = categoryDao.getCategoryDesc(id);

		return categoryList;
	}

	// 카테고리 등록
	public int addCategory(CategoryVo categoryVo) {
		System.out.println("[BlogService.addCategory]");

		return categoryDao.addCategory(categoryVo);
	}

}