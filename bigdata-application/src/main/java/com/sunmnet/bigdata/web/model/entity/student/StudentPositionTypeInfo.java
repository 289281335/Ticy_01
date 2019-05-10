package com.sunmnet.bigdata.web.model.entity.student;


import com.sunmnet.bigdata.commons.model.BaseModel;

/**
 * @ClassName PositionTypeInfo
 * @Description 
 * @author wm
 * @date 2017-12-07 11:55:51
 * @version 1.0 
 */
public class StudentPositionTypeInfo extends BaseModel {

    /**
	 * 
	 */
	private static final long serialVersionUID = -6633875010134129L;
	//主键，自增
    private Long id;
    //行业编码 （职位所属行业，关联表industry_type_info）
    private String industryCode;
    //职位名称
    private String positionName;
    //职位编码  
    private String positionCode;
    //显示排序
    private Integer sort;
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
    public String getIndustryCode() {
        return industryCode;
    }
    public void setIndustryCode(String industryCode) {
        this.industryCode = industryCode == null ? null : industryCode.trim();
    }
    public String getPositionName() {
        return positionName;
    }
    public void setPositionName(String positionName) {
        this.positionName = positionName == null ? null : positionName.trim();
    }
    public String getPositionCode() {
        return positionCode;
    }
    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode == null ? null : positionCode.trim();
    }
    public Integer getSort() {
        return sort;
    }
    public void setSort(Integer sort) {
        this.sort = sort;
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