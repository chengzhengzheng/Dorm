package shifan.action;
import shifan.dao.StudentDAO;
import shifan.dao.TeacherDAO;
import shifan.pojo.Admin;
import shifan.pojo.Student;
import shifan.pojo.Teacher;
import shifan.util.Constants;

public class PasswordManager extends BaseAction {
	private StudentDAO studentDao;
	private TeacherDAO teacherDao;
	private String password;// 原来的密码
	private String password2;// 新密码

	public String update() {
		Object obj = httpSession.getAttribute(Constants.USER);
		try {
			if (obj instanceof Admin) {
				Admin admin = (Admin) httpSession.getAttribute(Constants.USER);
				teacherDao.updatePassword(admin, password2);
			}
			if (obj instanceof Teacher) {
				Teacher t = (Teacher) httpSession.getAttribute(Constants.USER);
				teacherDao.updatePassword(t,password2);
			}
			if (obj instanceof Student) {
				Student s = (Student) httpSession.getAttribute(Constants.USER);
				studentDao.upatePassword(s,password2);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "update";
	}
	private boolean ok;
	public void setOk(boolean ok) {
		this.ok = ok;
	}
	public boolean getOk(){
		return ok;
	}
	
	public String check() {
		Object obj = httpSession.getAttribute(Constants.USER);
		try {
			ok = studentDao.checkPasswor(obj,password);
			
			System.out.println("ok:"+ok);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "check";
	}

	public void setStudentDao(StudentDAO studentDao) {
		this.studentDao = studentDao;
	}

	public void setTeacherDao(TeacherDAO teacherDao) {
		this.teacherDao = teacherDao;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

}





