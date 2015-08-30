package shifan.service.impl;

import java.util.ArrayList;
import java.util.List;

import shifan.dao.TeacherDAO;
import shifan.pojo.Teacher;
import shifan.service.TeacherService;

public class TeacherServiceImpl implements TeacherService {

	private TeacherDAO teacherDao;

	public void setTeacherDao(TeacherDAO teacherDao) {
		this.teacherDao = teacherDao;
	}

	@Override
	public List<Teacher> findTeachersByBuildingID(int buildingID)
			throws Exception {
		List<Integer> list = teacherDao.findTeachersByBuildingID(buildingID);
		for(Integer i : list){
			System.out.println("ceshi£º"+i);
		}
		if (list != null) {
			List<Teacher> teachers = new ArrayList<Teacher>();
			for (Integer i : list) {
				Teacher t = teacherDao.findById(i);
				teachers.add(t);
			}
			return teachers;
		}
		return null;
	}

}
