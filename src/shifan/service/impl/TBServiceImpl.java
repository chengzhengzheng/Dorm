package shifan.service.impl;

import java.util.ArrayList;
import java.util.List;
import shifan.dao.TBDAO;
import shifan.dao.TeacherDAO;
import shifan.pojo.Teacher;
import shifan.service.TBService;
public class TBServiceImpl implements TBService {
	private TBDAO tbDao;
	public void setTbDao(TBDAO tbDao) {
		this.tbDao = tbDao;
	}
	public TBDAO getTbDao() {
		return tbDao;
	}
	private TeacherDAO teacherDao;
	public void setTeacherDao(TeacherDAO teacherDao) {
		this.teacherDao = teacherDao;
	}
	public TeacherDAO getTeacherDao() {
		return teacherDao;
	}
	@Override
	public List<Teacher> findTeachersByBuildingID(int building_ID)
			throws Exception {
		List<Integer> list = tbDao.find_TeacherID(building_ID);
		List<Teacher> teachers = new ArrayList<Teacher>();
		if(list != null){
			for(Integer i : list){
				teachers.add(teacherDao.findById(i));
			}
			return teachers;
		}
		return null;
	}

}
