package com.sunmnet.bigdata.web.dao.student;


import com.sunmnet.bigdata.web.model.entity.student.StudentGraduationTarget;

import java.util.List;

public interface IStudentGraduationTargetDAO {

    public int deleteByPrimaryKey(Long id);

    public int insertSelective(StudentGraduationTarget studentGraduationTarget);

    public StudentGraduationTarget selectByPrimaryKey(Long id);

    public int updateByPrimaryKeySelective(StudentGraduationTarget studentGraduationTarget);
    /**
	 * 查询成长目标设定根据学号
	 * @return
	 */
	public List<StudentGraduationTarget> listStudentArgetInfoByStudentNo(String studentNo);
    /**
     * 查询成长目标设定根据学号
     * @return
     */
    public StudentGraduationTarget getStudentArgetInfoByStudentNo(String studentNo);

    /**
     * 根据序学号,查询学生读研类成长目标
     * @param studentNo
     */
    public List<String> getStudentArgetReadInfoByStudentNo(String studentNo);

    /**
     * 删除原有的目标标签，根据序学号
     * @param studentNo
     */
    public void deleteByStudentNo(String studentNo);

}