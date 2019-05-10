package com.sunmnet.bigdata.web.dao.student;

import com.sunmnet.bigdata.web.model.entity.student.StudentConsumePlace;
import com.sunmnet.bigdata.web.model.request.student.WholePortraitREQ;
import com.sunmnet.bigdata.web.model.response.student.WholePortraitRES;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 学生消费场所mapper
 * @author
 *
 */
public interface IStudentConsumePlaceDAO {
	
	/**
	 * 学生餐饮消费场所信息统计
	 * @param studentNo
	 * @return
	 */
	public List<StudentConsumePlace> getDietPlace(@Param(value = "studentNo") String studentNo,
														 @Param(value = "consumeStartDate") String consumeStartDate,
														 @Param(value = "consumeEndDate") String consumeEndDate);

	/**
	 * 学生全部消费场所信息统计
	 * @param studentNo
	 * @return
	 */
	public List<Map<String, Object>> getAllConsumePlace(@Param(value = "studentNo") String studentNo,
                                                            @Param(value = "consumeStartDate") String consumeStartDate,
                                                            @Param(value = "consumeEndDate") String consumeEndDate);
	
    /**
     * 根据条件查询三餐热门消费地点
     * @param wholePortraitREQ
     * @return
     */
    public List<Map<String, Object>> getWholeDietPlaceByCondition(WholePortraitREQ wholePortraitREQ);

}