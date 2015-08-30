package shifan.service.impl;

import java.util.List;
import shifan.dao.DomitoryDAO;
import shifan.dao.HygieneDAO;
import shifan.dao.TeacherDAO;
import shifan.pojo.Hygiene;
import shifan.service.HygieneService;
public class HygieneServiceImpl implements HygieneService {
	private HygieneDAO hygieneDao;
	public void setHygieneDao(HygieneDAO hygieneDao) {
		this.hygieneDao = hygieneDao;
	}
	private TeacherDAO teacherDao;
	public void setTeacherDao(TeacherDAO teacherDao) {
		this.teacherDao = teacherDao;
	}
	private DomitoryDAO domitoryDao;
	public void setDomitoryDao(DomitoryDAO domitoryDao) {
		this.domitoryDao = domitoryDao;
	}
	@Override
	public List<Hygiene> findAllHygiene() throws Exception {
		List<Hygiene> all_BuildingScore = hygieneDao.findAll(1);
		System.out.println("all_BuildingScore:"+all_BuildingScore.size());
		for (Hygiene h : all_BuildingScore) {
			int id = h.getDomitory_ID();// ��������id����������
			int t_id = h.getTeacher_ID();// ������ʦid����ʦ����
			String Domitory_Name = domitoryDao.findById(id).getDomitory_Name();
			System.out.println("t_id:"+t_id);
			String Teacher_Name;
			try{
			 Teacher_Name = teacherDao.findById(t_id).getTeacher_Name();
			}catch(Exception e){
				Teacher_Name = "�ס��ý�ʦ�Ѿ���ɾ����!";
			}
			h.setDomitory_Name(Domitory_Name);
			h.setTeacher_Name(Teacher_Name);
		}
		return all_BuildingScore;
	}
	@Override
	//���һ�����ᵱ���Ѿ���\,.���ˡ���ʾ�޸ľͿ����ˡ����ܽ��в������
	public boolean save(Hygiene hygiene) throws Exception {
		Hygiene h = hygieneDao.findByDor(hygiene.getDomitory_ID());
		if(h == null){
			//ִ�в������
			hygieneDao.insert(hygiene);
			return true;
		}
		return false;
	}

}
