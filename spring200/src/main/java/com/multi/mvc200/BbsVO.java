package com.multi.mvc200;

public class BbsVO {
	
	private int no;
	private String title;
	private String writer;
	private String content;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
//	@Override
//	public String toString() {
//		return "BbsVO [no=" + no + ", title=" + title + ", writer=" + writer + ", content=" + content + "]";
//	}
	
}
