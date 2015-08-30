package shifan.action.building;
import java.util.List;
import shifan.action.BaseAction;
import shifan.dao.TBDAO;
import shifan.dao.TeacherDAO;
import shifan.pojo.Teacher;
import shifan.service.TBService;

public class TBManagerAction extends BaseAction {
	// �г�����Ա
	private TBDAO tbDao;
	private TBService tbService;
	private TeacherDAO teacherDao;

	public void setTeacherDao(TeacherDAO teacherDao) {
		this.teacherDao = teacherDao;
	}

	public TeacherDAO getTeacherDao() {
		return teacherDao;
	}

	public void setTbService(TBService tbService) {
		this.tbService = tbService;
	}

	public TBService getTbService() {
		return tbService;
	}
	public void setTbDao(TBDAO tbDao) {
		this.tbDao = tbDao;
	}
	public TBDAO getTbDao() {
		return tbDao;
	}
	// ��list_BuildingManager.jsp����
	private int building_ID;
	public void setBuilding_ID(int building_ID) {
		this.building_ID = building_ID;
	}
	public int getBuilding_ID() {
		return building_ID;
	}
	// ��ĳ��¥���¥��
	private List<Teacher> teachers;
	// ���е���ʦ
	private List<Teacher> list;
	public void setList(List<Teacher> list) {
		this.list = list;
	}
	public List<Teacher> getList() {
		return list;
	}
	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
	public List<Teacher> getTeachers() {
		return teachers;
	}
	public String list() {
		try {
			Object obj = session.get("current");
			if (obj != null) {
				building_ID = (Integer) obj;
			}
			//ֱ�Ӵ������������http://localhost:8080/dorm/building/list_TBManager.action
			if(building_ID == 0){
				return "listError";
			}
			teachers = tbService.findTeachersByBuildingID(building_ID);
			log.info("teacher:" + teachers);
			list = teacherDao.findAll();
			session.put("current", null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "list";
	}
	/**
	 * ���¥�����Ա
	 * 
	 * @return
	 */
	// ��list_TBManager.jsp������ʦ��idֵ
	private int tB_TeacherID;
	public void setTB_TeacherID(int tB_TeacherID) {
		this.tB_TeacherID = tB_TeacherID;
	}
	public int getTB_TeacherID() {
		return tB_TeacherID;
	}
	/**
	 * ����¥�����Ա
	 * 
	 * @return
	 */
	public String addsave() {
		try {
			log.info("��ӹ���Ա..." + tB_TeacherID);
			boolean flag = tbDao.add(building_ID, tB_TeacherID);
			log.info("building_ID:" + building_ID + ",tB_TeacherID:"
					+ tB_TeacherID + ",flag:" + flag);
			if (flag) {
				// �������
				tbDao.insert(building_ID, tB_TeacherID);
				session.put("current", building_ID);
			} else
				// ��������ӡ������Ի��򲻿�������Ѿ�
				// ��ʾ���������
				return "addFail";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "addsave";
	}
	//�Ƴ�
	//tB_TeacherID   building_ID
	public String del(){
		try {
			log.info("ɾ����"+tB_TeacherID+","+building_ID);
			tbDao.delete(tB_TeacherID,building_ID);
			httpSession.setAttribute("current", building_ID);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "del";
	}
}
