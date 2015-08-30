package shifan.action.hygiene;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import shifan.action.BaseAction;
import shifan.dao.BuildingDAO;
import shifan.dao.DomitoryDAO;
import shifan.dao.HygieneDAO;
import shifan.dao.TBDAO;
import shifan.dao.TeacherDAO;
import shifan.pojo.Admin;
import shifan.pojo.Building;
import shifan.pojo.Hygiene;
import shifan.pojo.Teacher;
import shifan.util.Constants;

/**
 * ��������
 */
public class HygieneManagerAction extends BaseAction {
	private BuildingDAO buildingDao;// setter
	private HygieneDAO hygieneDao;

	public void setHygieneDao(HygieneDAO hygieneDao) {
		this.hygieneDao = hygieneDao;
	}

	private List<Building> all_Buildings = new ArrayList<Building>();// ���е�¥��
	// �����洢��ǰ������
	private List<Integer> week = new ArrayList<Integer>();

	public void setWeek(List<Integer> week) {
		this.week = week;
	}

	public List<Integer> getWeek() {
		return week;
	}

	private List<Hygiene> all_Domitorys;

	// ���ݵ�ǰ��������������ǵڼ��ܡ������ӵ�һ�ܵ�����
	public String list() {
		// Ĭ���г���һ�ܵ��������
		// �г���ǰ������
		try {
			all_Buildings = buildingDao.findAll();
			Date date = new Date();
			Calendar c = new GregorianCalendar();
			c.setFirstDayOfWeek(Calendar.MONDAY);
			c.setMinimalDaysInFirstWeek(7);
			c.setTime(date);
			int week = c.get(Calendar.WEEK_OF_YEAR) - 7;
			for (int i = 1; i <= week; i++) {
				this.week.add(i);
			}
			// �г���ǰ�����е����� Ĭ���г���һ���ܵ��������
			String zhou = (String) httpSession.getAttribute("currentWeek");

			if (zhou != null) {
				week_Number = zhou;
			}
			if (null == week_Number)
				week_Number = "1";
			if (httpSession.getAttribute("all_Domitorys") != null){
				all_Domitorys = (List<Hygiene>) httpSession
						.getAttribute("all_Domitorys");
			}else{
				if (domitory_ID == 0) {
					all_Domitorys = hygieneDao.findAll(Integer
							.parseInt(week_Number));
				} else {
					all_Domitorys = hygieneDao.findByWeekAndD(
							Integer.parseInt(week_Number), domitory_ID);
				}
			}
			
			// all_Domitorys =
			// hygieneDao.findAll(Integer.parseInt(week_Number));
			for (Hygiene h : all_Domitorys) {

				h.setBuilding_Name(buildingDao.findBuildingById(
						h.getBuilding_ID()).getBuilding_Name());
				if (h.getTeacher_Type() == 0) {
					// ��������Ա
					Admin admin = (Admin) httpSession
							.getAttribute(Constants.USER);
					h.setTeacher_Name(admin.getAdmin_Name());
				} else {
					Teacher admin = (Teacher) teacherDao.findById(h
							.getTeacher_ID());
					h.setTeacher_Name(admin.getTeacher_Name());
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		httpSession.setAttribute("all_Domitorys",null);
		return "admin";
	}

	private TBDAO tbDao;

	public void setTbDao(TBDAO tbDao) {
		this.tbDao = tbDao;
	}

	public String listMyHygiene() {
		// �г���ǰ������
		try {
			List<Building> all = buildingDao.findAll();
			// �ҳ��ù���Ա�����¥��
			List<Integer> list = null;

			Teacher t = (Teacher) httpSession.getAttribute(Constants.USER);

			list = tbDao.find_BuildingByID(t.getTeacher_ID());
			for (Building b : all) {
				if (list.contains(b.getBuilding_ID())) {
					all_Buildings.add(b);
				}
			}

			Date date = new Date();
			Calendar c = new GregorianCalendar();
			c.setFirstDayOfWeek(Calendar.MONDAY);
			c.setMinimalDaysInFirstWeek(7);
			c.setTime(date);
			int week = c.get(Calendar.WEEK_OF_YEAR) - 7;
			for (int i = 1; i <= week; i++) {
				this.week.add(i);
			}

			// �г���ǰ�����е����� Ĭ���г���һ���ܵ��������
			if (httpSession.getAttribute("all_Domitorys") == null) {
				all_Domitorys = hygieneDao.findAll(1);// Ĭ�ϲ�ѯ��һ�ܵ�
			}

			for (Hygiene h : all_Domitorys) {
				h.setBuilding_Name(buildingDao.findBuildingById(
						h.getBuilding_ID()).getBuilding_Name());

				Teacher tt = (Teacher) httpSession.getAttribute(Constants.USER);
				h.setTeacher_Name(tt.getTeacher_Name());

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "list";
	}

	private String week_Number;
	private int domitory_ID;
	private String grade;

	public String submit() {
		// ��������������id�������ж��ǲ���һ�����ֻ����޸�����
		int w = Integer.parseInt(week_Number);
		httpSession.setAttribute("currentWeek", week_Number);

		try {
			boolean flag = hygieneDao.findByWeekAndDomitory(w, domitory_ID);
			if (flag) {// ˵�������ݡ�������еĸ���
				Hygiene h = new Hygiene();
				h.setWeek(w);
				h.setDomitory_ID(domitory_ID);
				h.setScore(Integer.parseInt(grade));
				hygieneDao.updatesave(h);
				return "submit";
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		Hygiene hy = new Hygiene();
		hy.setDomitory_ID(domitory_ID);
		hy.setScore(Integer.parseInt(grade));
		hy.setWeek(Integer.parseInt(week_Number));
		String type = (String) httpSession.getAttribute("loginType");
		if (type.equals(Constants.ADMIN)) {
			Admin admin = (Admin) httpSession.getAttribute(Constants.USER);
			hy.setTeacher_ID(admin.getAdmin_ID());
			hy.setTeacher_Type(0);// ��ʾ��������Ա
		} else {
			Teacher t = (Teacher) httpSession.getAttribute(Constants.USER);
			hy.setTeacher_ID(t.getTeacher_ID());
			hy.setTeacher_Type(1);// ��ʾ¥��
		}
		try {
			hygieneDao.insert(hy);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "submit";
	}

	private Hygiene hygiene;

	public void setHygiene(Hygiene hygiene) {
		this.hygiene = hygiene;
	}

	public Hygiene getHygiene() {
		return hygiene;
	}

	private int Building_ID;

	/**
	 * ����������¥�������ѯ
	 * 
	 * @return
	 */
	public String query() {
		try {
			httpSession.setAttribute("currentWeek", week_Number);
			all_Buildings = buildingDao.findAll();
			Date date = new Date();
			Calendar c = new GregorianCalendar();
			c.setFirstDayOfWeek(Calendar.MONDAY);
			c.setMinimalDaysInFirstWeek(7);
			c.setTime(date);
			int week = c.get(Calendar.WEEK_OF_YEAR) - 7;
			for (int i = 1; i <= week; i++) {
				this.week.add(i);
			}

			if (Building_ID == 0) {
				// ��ѯȫ��¥��
				int we = Integer.parseInt(week_Number);
				all_Domitorys = hygieneDao.findAll(we);
				System.out.println("all_Domitorys:length:"
						+ all_Domitorys.size());
				if (null != all_Domitorys) {
					for (Hygiene h : all_Domitorys) {
						h.setBuilding_Name(buildingDao.findBuildingById(
								h.getBuilding_ID()).getBuilding_Name());
						if (h.getTeacher_Type() == 0) {
							// ��������Ա
							Admin admin = (Admin) httpSession
									.getAttribute(Constants.USER);
							h.setTeacher_Name(admin.getAdmin_Name());
						} else {
							Teacher admin = (Teacher) teacherDao.findById(h
									.getTeacher_ID());
							h.setTeacher_Name(admin.getTeacher_Name());
						}
					}
				}
				return "query";
			}
			// ��ѯָ��¥��
			if (week_Number == null) {
				week_Number = "1";// Ĭ�ϵ�һ�ܣ�
			}
			int w = Integer.parseInt(week_Number);
			all_Domitorys = hygieneDao.findByWeekAndD(w, Building_ID);
			if (null != all_Domitorys) {
				for (Hygiene h : all_Domitorys) {
					h.setBuilding_Name(buildingDao.findBuildingById(
							h.getBuilding_ID()).getBuilding_Name());
					if (h.getTeacher_Type() == 0) {
						// ��������Ա
						Admin admin = (Admin) httpSession
								.getAttribute(Constants.USER);
						h.setTeacher_Name(admin.getAdmin_Name());
					} else {
						Teacher admin = (Teacher) teacherDao.findById(h
								.getTeacher_ID());
						h.setTeacher_Name(admin.getTeacher_Name());
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		httpSession.setAttribute("all_Domitorys", all_Domitorys);
		System.out.println("ע��dos�Ĵ�С��" + all_Domitorys.size());
		return "query";
	}

	private DomitoryDAO domitoryDao;

	public void setDomitoryDao(DomitoryDAO domitoryDao) {
		this.domitoryDao = domitoryDao;
	}

	public DomitoryDAO getDomitoryDao() {
		return domitoryDao;
	}

	private TeacherDAO teacherDao;

	public void setTeacherDao(TeacherDAO teacherDao) {
		this.teacherDao = teacherDao;
	}

	public TeacherDAO getTeacherDao() {
		return teacherDao;
	}

	public void setBuildingDao(BuildingDAO buildingDao) {
		this.buildingDao = buildingDao;
	}

	public void setAll_Buildings(List<Building> all_Buildings) {
		this.all_Buildings = all_Buildings;
	}

	public List<Building> getAll_Buildings() {
		return all_Buildings;
	}

	public void setWeek_Number(String week_Number) {
		this.week_Number = week_Number;
	}

	public String getWeek_Number() {
		return week_Number;
	}

	public void setDomitoryID(int domitoryID) {
		this.domitory_ID = domitoryID;
	}

	public int getDomitoryID() {
		return domitory_ID;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getGrade() {
		return grade;
	}

	public void setAll_Domitorys(List<Hygiene> all_Domitorys) {
		this.all_Domitorys = all_Domitorys;
	}

	public List<Hygiene> getAll_Domitorys() {
		return all_Domitorys;
	}

	public int getBuilding_ID() {
		return Building_ID;
	}

	public void setBuilding_ID(int building_ID) {
		Building_ID = building_ID;
	}

}
