package com.xiaoshu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaoshu.dao.StudentMapper;
import com.xiaoshu.entity.Student;
import com.xiaoshu.entity.StudentVo;

@Service
public class StudentService {

	@Autowired
	private StudentMapper sm;
	
	public PageInfo<StudentVo> findList(StudentVo sv,Integer pageNum,Integer pageSize)
	{
		PageHelper.startPage(pageNum, pageSize);
		List<StudentVo> list=sm.findList(sv);
		return new PageInfo<>(list);
	}
	public Student findByName(String name)
	{
		Student s=new Student();
		s.setSname(name);
		return sm.selectOne(s);
	}
	public void updateStu(Student s)
	{
		sm.updateByPrimaryKeySelective(s);
	}
	public void addStu(Student s)
	{
		sm.insert(s);
	}
	public void delStu(Integer id)
	{
		sm.deleteByPrimaryKey(id);
	}
	public List<StudentVo> findList(StudentVo sv)
	{
		return sm.findList(sv);
	}
}
