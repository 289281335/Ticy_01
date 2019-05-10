package com.sunmnet.bigdata.web.model.response.student;

import java.io.Serializable;

public class StudentSocialRES implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String stuName;
	
	private String stuNo;
	
	private String socialNo;
	
	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getSocialNo() {
		return socialNo;
	}

	public void setSocialNo(String socialNo) {
		this.socialNo = socialNo;
	}

	public String getStuNo() {
		return stuNo;
	}

	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((socialNo == null) ? 0 : socialNo.hashCode());
		result = prime * result + ((stuNo == null) ? 0 : stuNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentSocialRES other = (StudentSocialRES) obj;
		if (socialNo == null) {
			if (other.socialNo != null)
				return false;
		} else if (!socialNo.equals(other.socialNo))
			return false;
		if (stuNo == null) {
			if (other.stuNo != null)
				return false;
		} else if (!stuNo.equals(other.stuNo))
			return false;
		return true;
	}
	
}
