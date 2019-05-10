package com.sunmnet.bigdata.web.model.entity.student;

import java.math.BigDecimal;

public class PovertyStudentAnalyse {
    private Integer id;

    //学号
    private String studentNo;

    //性别
    private String gender;

    //民族
    private String nation;

    //户口类型
    private String residenceType;

    //月刷卡次数
    private BigDecimal monthCashCount;

    //月消费金额
    private BigDecimal monthAmount;

    //恩格尔系数
    private BigDecimal egQuotient;

    //餐饮总额
    private BigDecimal eatAmount;

    //月早餐次数
    private BigDecimal monthBreakfastCount;

    //月早餐金额
    private BigDecimal breakfastAmount;

    //月早餐方差
    private BigDecimal breakfastFc;

    //月午餐次数
    private BigDecimal monthLunchCount;

    //月午餐金额
    private BigDecimal lunchAmount;

    //午餐方差
    private BigDecimal lunchFc;

    //月晚餐次数
    private BigDecimal monthDinnerCount;

    //月晚餐金额
    private BigDecimal dinnerAmount;

    //月晚餐方差
    private BigDecimal dinnerFc;

    //月超市次数
    private BigDecimal monthSupermarketCount;

    //月超市金额
    private BigDecimal supermarketAmount;

    //月洗澡次数
    private BigDecimal monthWashCount;

    //pos机种类
    private Integer postClass;

    //预测结果
    private String anyResult;

    //贫困概率
    private BigDecimal povertyProbability;

    //贫困等级
    private String povertyLevel;

    //是否关注
    private String isfocus;

    //关注原因
    private String reason;
    
    //学院
    private String collegeName;

    //学院代码
    private String collegeCode;

    //专业
    private String majorName;

    //专业代码
    private String majorCode;
    
    //资助类型
    private String supportType;
    
    //年级
    private Integer grade;
    
    //学年
    private String schoolYear;

    //学期
    private String schoolTerm;
    
    //操作结果
    private String handleResult;
    
    //姓名
    private String studentName;
    
    //资助金额
    private BigDecimal supportAmount;
    
    //建议资助金额
    private BigDecimal avgMonthAmountAdd;

    public BigDecimal getAvgMonthAmountAdd() {
		return avgMonthAmountAdd;
	}

	public void setAvgMonthAmountAdd(BigDecimal avgMonthAmountAdd) {
		this.avgMonthAmountAdd = avgMonthAmountAdd;
	}

	public BigDecimal getSupportAmount() {
		return supportAmount;
	}

	public void setSupportAmount(BigDecimal supportAmount) {
		this.supportAmount = supportAmount;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo == null ? null : studentNo.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }

    public String getResidenceType() {
        return residenceType;
    }

    public void setResidenceType(String residenceType) {
        this.residenceType = residenceType == null ? null : residenceType.trim();
    }

    public BigDecimal getMonthCashCount() {
        return monthCashCount;
    }

    public void setMonthCashCount(BigDecimal monthCashCount) {
        this.monthCashCount = monthCashCount;
    }

    public BigDecimal getMonthAmount() {
        return monthAmount;
    }

    public void setMonthAmount(BigDecimal monthAmount) {
        this.monthAmount = monthAmount;
    }

    public BigDecimal getEgQuotient() {
        return egQuotient;
    }

    public void setEgQuotient(BigDecimal egQuotient) {
        this.egQuotient = egQuotient;
    }

    public BigDecimal getEatAmount() {
        return eatAmount;
    }

    public void setEatAmount(BigDecimal eatAmount) {
        this.eatAmount = eatAmount;
    }

    public BigDecimal getMonthBreakfastCount() {
        return monthBreakfastCount;
    }

    public void setMonthBreakfastCount(BigDecimal monthBreakfastCount) {
        this.monthBreakfastCount = monthBreakfastCount;
    }

    public BigDecimal getBreakfastAmount() {
        return breakfastAmount;
    }

    public void setBreakfastAmount(BigDecimal breakfastAmount) {
        this.breakfastAmount = breakfastAmount;
    }

    public BigDecimal getBreakfastFc() {
        return breakfastFc;
    }

    public void setBreakfastFc(BigDecimal breakfastFc) {
        this.breakfastFc = breakfastFc;
    }

    public BigDecimal getMonthLunchCount() {
        return monthLunchCount;
    }

    public void setMonthLunchCount(BigDecimal monthLunchCount) {
        this.monthLunchCount = monthLunchCount;
    }

    public BigDecimal getLunchAmount() {
        return lunchAmount;
    }

    public void setLunchAmount(BigDecimal lunchAmount) {
        this.lunchAmount = lunchAmount;
    }

    public BigDecimal getLunchFc() {
        return lunchFc;
    }

    public void setLunchFc(BigDecimal lunchFc) {
        this.lunchFc = lunchFc;
    }

    public BigDecimal getMonthDinnerCount() {
        return monthDinnerCount;
    }

    public void setMonthDinnerCount(BigDecimal monthDinnerCount) {
        this.monthDinnerCount = monthDinnerCount;
    }

    public BigDecimal getDinnerAmount() {
        return dinnerAmount;
    }

    public void setDinnerAmount(BigDecimal dinnerAmount) {
        this.dinnerAmount = dinnerAmount;
    }

    public BigDecimal getDinnerFc() {
        return dinnerFc;
    }

    public void setDinnerFc(BigDecimal dinnerFc) {
        this.dinnerFc = dinnerFc;
    }

    public BigDecimal getMonthSupermarketCount() {
        return monthSupermarketCount;
    }

    public void setMonthSupermarketCount(BigDecimal monthSupermarketCount) {
        this.monthSupermarketCount = monthSupermarketCount;
    }

    public BigDecimal getSupermarketAmount() {
        return supermarketAmount;
    }

    public void setSupermarketAmount(BigDecimal supermarketAmount) {
        this.supermarketAmount = supermarketAmount;
    }

    public BigDecimal getMonthWashCount() {
        return monthWashCount;
    }

    public void setMonthWashCount(BigDecimal monthWashCount) {
        this.monthWashCount = monthWashCount;
    }

    public Integer getPostClass() {
        return postClass;
    }

    public void setPostClass(Integer postClass) {
        this.postClass = postClass;
    }

    public String getAnyResult() {
        return anyResult;
    }

    public void setAnyResult(String anyResult) {
        this.anyResult = anyResult == null ? null : anyResult.trim();
    }

    public BigDecimal getPovertyProbability() {
        return povertyProbability;
    }

    public void setPovertyProbability(BigDecimal povertyProbability) {
        this.povertyProbability = povertyProbability;
    }

    public String getPovertyLevel() {
        return povertyLevel;
    }

    public void setPovertyLevel(String povertyLevel) {
        this.povertyLevel = povertyLevel == null ? null : povertyLevel.trim();
    }

    public String getIsfocus() {
        return isfocus;
    }

    public void setIsfocus(String isfocus) {
        this.isfocus = isfocus == null ? null : isfocus.trim();
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getCollegeCode() {
		return collegeCode;
	}

	public void setCollegeCode(String collegeCode) {
		this.collegeCode = collegeCode;
	}

	public String getMajorName() {
		return majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public String getMajorCode() {
		return majorCode;
	}

	public void setMajorCode(String majorCode) {
		this.majorCode = majorCode;
	}

	public String getSupportType() {
		return supportType;
	}

	public void setSupportType(String supportType) {
		this.supportType = supportType;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public String getSchoolYear() {
		return schoolYear;
	}

	public void setSchoolYear(String schoolYear) {
		this.schoolYear = schoolYear;
	}

	public String getSchoolTerm() {
		return schoolTerm;
	}

	public void setSchoolTerm(String schoolTerm) {
		this.schoolTerm = schoolTerm;
	}

	public String getHandleResult() {
		return handleResult;
	}

	public void setHandleResult(String handleResult) {
		this.handleResult = handleResult;
	}
}