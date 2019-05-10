package com.sunmnet.bigdata.web.model.entity.student;


import com.sunmnet.bigdata.commons.model.BaseModel;

/**
 * @ClassName StudentIndexDisplayInfo
 * @Description 
 * @author wm
 * @date 2017-12-13 16:51:07
 * @version 1.0 
 */
public class StudentIndexDisplayInfo extends BaseModel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 150980563824444288L;
	private Long id;
    //指标
    private String indexCode;
    //指标名称
    private String indexName;
    //权重
    private Double weight;
    //基数
    private Double base;
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
    public String getIndexCode() {
        return indexCode;
    }
    public void setIndexCode(String indexCode) {
        this.indexCode = indexCode == null ? null : indexCode.trim();
    }
    public String getIndexName() {
        return indexName;
    }
    public void setIndexName(String indexName) {
        this.indexName = indexName == null ? null : indexName.trim();
    }
    public Double getWeight() {
        return weight;
    }
    public void setWeight(Double weight) {
        this.weight = weight;
    }
    public Double getBase() {
        return base;
    }
    public void setBase(Double base) {
        this.base = base;
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