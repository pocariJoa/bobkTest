package com.hanul.study;

import java.io.Serializable;

public class MemberDTO implements Serializable{
	//멤버변수(필드) 선언
	private String memberName;
	private String memberId;
	private String memberPw;
	private int memberAge;
	private String memberAddr;
	private String memberTel;
	
	//디폴트 생성자 메소드
	public MemberDTO() {}

	//생성자 메소드 초기화
	public MemberDTO(String memberName, String memberId, String memberPw, int memberAge, String memberAddr,
			String memberTel) {
		super();
		this.memberName = memberName;
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberAge = memberAge;
		this.memberAddr = memberAddr;
		this.memberTel = memberTel;
	}

	//getters & setters 메소드
	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public int getMemberAge() {
		return memberAge;
	}

	public void setMemberAge(int memberAge) {
		this.memberAge = memberAge;
	}

	public String getMemberAddr() {
		return memberAddr;
	}

	public void setMemberAddr(String memberAddr) {
		this.memberAddr = memberAddr;
	}

	public String getMemberTel() {
		return memberTel;
	}

	public void setMemberTel(String memberTel) {
		this.memberTel = memberTel;
	}
	
	
}
