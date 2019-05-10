

package com.sunmnet.bigdata.web.dao.student;

import com.sunmnet.bigdata.web.model.entity.student.StudentConsumptionIndex;
import com.sunmnet.bigdata.web.model.request.student.WholePortraitREQ;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

public interface IStudentConsumeRegularDAO {

    /**
     * 根据学号查询三餐规律度
     * @param studentNo
     * @return
     */
    public BigDecimal getDietRegularByStudentNo(String studentNo);

    /**
     * 根据专业代码查询三餐规律度
     * @param majorCode
     * @return
     */
    public BigDecimal getDietRegularByMajorCode(String majorCode);

    /**
     * 查询三餐规律度总条数
     * @return
     */
    public Integer countDietRegular();

    /**
     * 查询指定行号的三餐规律度
     * @param lineNo
     * @return
     */
    public StudentConsumptionIndex getDietRegularByLineNo(@Param(value = "lineNo") int lineNo);

    /**
     * 根据条件查询对应三餐规律度人数
     * @param wholePortraitREQ
     * @return
     */
    public Integer countDietRegularByCondition(WholePortraitREQ wholePortraitREQ);


}
