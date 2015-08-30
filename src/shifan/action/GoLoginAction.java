package shifan.action;


import shifan.dao.StudentDAO;
import shifan.dao.TeacherDAO;
import shifan.pojo.Admin;
import shifan.pojo.Teacher;
import shifan.util.Constants;

public class GoLoginAction extends BaseAction {
	private String Username;
	private String Password;
	private String type;
	private StudentDAO studentDao;
	private String message;
	private TeacherDAO teacherDao;
	private String url;

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setTeacherDao(TeacherDAO teacherDao) {
		this.teacherDao = teacherDao;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setStudentDao(StudentDAO studentDao) {
		this.studentDao = studentDao;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		this.Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		this.Password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String execute() {
		// 超级管理员用户
		
		try {
			if (Constants.ADMIN.equals(type)){
				Admin admin = studentDao.checkLogin(Username, Password);
				if (null == admin) {
					// 登陆失败
					message = Constants.LOGIN_ERROR;
					return "fail";
				} else {
					// 登陆成功
					httpSession.setAttribute(Constants.USER, admin);// 将当前用户放入session当中
					httpSession.setAttribute("loginType", type);// 将当前用户的种类放入session当中
					String url1 = (String) httpSession.getAttribute("url");
					if (url1 != null) {
						url = url1;
						return "review";
					} 
					return "admin";
				}
			} else if (Constants.TEACHER.equals(type)) {
				Teacher teacher = teacherDao.checkLogin(Username, Password);
				if (null == teacher){
					// 登录失败
					message = Constants.LOGIN_ERROR;
					return "fail";
				}
				else {
					// 登录成功,将当前用户和用户类型放入session当中
					httpSession.setAttribute(Constants.USER, teacher);
					httpSession.setAttribute("loginType", type);
					return "teacher";
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		return "error";
	}

}
