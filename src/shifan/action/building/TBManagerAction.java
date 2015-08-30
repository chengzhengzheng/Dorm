package shifan.action.building;
import java.util.List;
import shifan.action.BaseAction;
import shifan.dao.TBDAO;
import shifan.dao.TeacherDAO;
import shifan.pojo.Teacher;
import shifan.service.TBService;

public class TBManagerAction extends BaseAction {
	// 列出管理员
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
	// 从list_BuildingManager.jsp来的
	private int building_ID;
	public void setBuilding_ID(int building_ID) {
		this.building_ID = building_ID;
	}
	public int getBuilding_ID() {
		return building_ID;
	}
	// 给某个楼层的楼管
	private List<Teacher> teachers;
	// 所有的老师
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
			//直接从浏览器中输入http://localhost:8080/dorm/building/list_TBManager.action
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
	 * 添加楼宇管理员
	 * 
	 * @return
	 */
	// 从list_TBManager.jsp来的老师的id值
	private int tB_TeacherID;
	public void setTB_TeacherID(int tB_TeacherID) {
		this.tB_TeacherID = tB_TeacherID;
	}
	public int getTB_TeacherID() {
		return tB_TeacherID;
	}
	/**
	 * 增加楼宇管理员
	 * 
	 * @return
	 */
	public String addsave() {
		try {
			log.info("添加管理员..." + tB_TeacherID);
			boolean flag = tbDao.add(building_ID, tB_TeacherID);
			log.info("building_ID:" + building_ID + ",tB_TeacherID:"
					+ tB_TeacherID + ",flag:" + flag);
			if (flag) {
				// 可以添加
				tbDao.insert(building_ID, tB_TeacherID);
				session.put("current", building_ID);
			} else
				// 不可以添加、跳出对话框不可以添加已经
				// 表示不可以添加
				return "addFail";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "addsave";
	}
	//移除
	//tB_TeacherID   building_ID
	public String del(){
		try {
			log.info("删除："+tB_TeacherID+","+building_ID);
			tbDao.delete(tB_TeacherID,building_ID);
			httpSession.setAttribute("current", building_ID);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "del";
	}
}
