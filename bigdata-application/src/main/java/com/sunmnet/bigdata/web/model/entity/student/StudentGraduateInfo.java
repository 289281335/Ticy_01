package com.sunmnet.bigdata.web.model.entity.student;


import com.sunmnet.bigdata.commons.model.BaseModel;

/**
 * @ClassName GraduateInfo
 * @Description 
 * @author wm
 * @date 2017-12-11 16:11:09
 * @version 1.0 
 */
public class StudentGraduateInfo extends BaseModel {

    /**
	 * 
	 */
	private static final long serialVersionUID = -9055633246773573673L;
	//主键
    private Long id;
    //毕业年份  格式 yyyy
    private String graduationDate;
    //学号
    private String StudentNo;
    //分类   读研 READ   就业 WORK 
    private String type;
    //学校编码
    private String schoolCode;
    //行业编码
    private String industryCode;
    //职位编码
    private String positionCode;
    //创建时间 格式：yyyyMMddHHmmssSSS
    private String createTime;
    //最后修改时间 格式：yyyyMMddHHmmssSSS
    private String modifyTime;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getGraduationDate() {
        return graduationDate;
    }
    public void setGraduationDate(String graduationDate) {
        this.graduationDate = graduationDate == null ? null : graduationDate.trim();
    }
    public String getStudentNo() {
        return StudentNo;
    }
    public void setStudentNo(String StudentNo) {
        this.StudentNo = StudentNo == null ? null : StudentNo.trim();
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
    public String getSchoolCode() {
        return schoolCode;
    }
    public void setSchoolCode(String schoolCode) {
        this.schoolCode = schoolCode == null ? null : schoolCode.trim();
    }
    public String getIndustryCode() {
        return industryCode;
    }
    public void setIndustryCode(String industryCode) {
        this.industryCode = industryCode == null ? null : industryCode.trim();
    }
    public String getPositionCode() {
        return positionCode;
    }
    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode == null ? null : positionCode.trim();
    }
    public String getCreateTime() {
        return createTime;
    }
    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }
    public String getModifyTime() {
        return modifyTime;
    }
    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime == null ? null : modifyTime.trim();
    }

}