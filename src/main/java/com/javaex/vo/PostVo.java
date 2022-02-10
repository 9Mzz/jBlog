package com.javaex.vo;

public class PostVo {

	// 필드
	private int postNO;
	private int cateNo;
	private String postTitle;
	private String postContent;
	private String regDate;
	private int count;

	// 생성자
	public PostVo() {
	}

	public PostVo(int postNO, int cateNo, String postTitle, String postContent, String regDate) {
		this.postNO = postNO;
		this.cateNo = cateNo;
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.regDate = regDate;
	}

	public PostVo(int postNO, int cateNo, String postTitle, String postContent, String regDate, int count) {
		this.postNO = postNO;
		this.cateNo = cateNo;
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.regDate = regDate;
		this.count = count;
	}

	// 메소드
	public int getPostNO() {
		return postNO;
	}

	public void setPostNO(int postNO) {
		this.postNO = postNO;
	}

	public int getCateNo() {
		return cateNo;
	}

	public void setCateNo(int cateNo) {
		this.cateNo = cateNo;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	// 메소드 일반
	@Override
	public String toString() {
		return "PostVo [postNO=" + postNO + ", cateNo=" + cateNo + ", postTitle=" + postTitle + ", postContent="
				+ postContent + ", regDate=" + regDate + ", count=" + count + "]";
	}

}
