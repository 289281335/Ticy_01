package com.sunmnet.bigdata.web.model.entity.student;


import com.sunmnet.bigdata.commons.model.BaseModel;

/**
 * @ClassName StatisticsLabelInfo
 * @Description 
 * @author wm
 * @date 2017-12-12 15:29:03
 * @version 1.0 
 */
public class StudentStatisticsLabelInfo extends BaseModel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 7277709625489859945L;
	//主键，自增
    private Long id;
    //对应表（毕业生标签数据统计表graduate_label_info）实体的字段名称
    private String labelField;
    //要统计的标签 唯一约束
    private String label;
    //状态  是不是要统计 YES统计   NO 不统计
    private String status;
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
    public String getLabelField() {
        return labelField;
    }
    public void setLabelField(String labelField) {
        this.labelField = labelField == null ? null : labelField.trim();
    }
    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label == null ? null : label.trim();
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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